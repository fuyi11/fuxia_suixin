package com.susion.fuxiaboring.music.itemhandler;

import android.view.View;
import android.view.ViewGroup;

import com.susion.fuxiaboring.base.adapter.ViewHolder;
import com.susion.fuxiaboring.event.AddToNextPlayEvent;
import com.susion.fuxiaboring.music.mvp.view.PlayMusicActivity;
import com.susion.fuxiaboring.music.mvp.model.Song;
import com.susion.fuxiaboring.utils.ToastUtils;
import com.susion.fuxiaboring.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by susion on 17/1/20.
 */
public class SearchMusicResultIH extends SimpleMusicIH<Song> {

    public SearchMusicResultIH(boolean showNextPlay) {
        super(showNextPlay);
    }

    @Override
    public void onCreateItemHandler(ViewHolder vh, ViewGroup parent) {
        super.onCreateItemHandler(vh, parent);
        mTvDuration.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onAddToNextPlayClick() {
        ToastUtils.showShort("已经添加下一首播放");
        EventBus.getDefault().post(new AddToNextPlayEvent(mData));
    }

    @Override
    protected void onItemClick() {
        PlayMusicActivity.start(mContext, mData, false);
    }

    @Override
    protected void bindData(ViewHolder vh, Song data, int position) {
        mTvTile.setText(data.name);
        if (!data.artists.isEmpty()) {
            mTvSecondTile.setText(data.artists.get(0).name + "-" + data.album.name);
        }
        UIUtils.loadSmallPicture(mSdvAlbum, data.album.picUrl);
    }

}
