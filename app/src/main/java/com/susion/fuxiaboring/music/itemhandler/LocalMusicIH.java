package com.susion.fuxiaboring.music.itemhandler;

import android.text.TextUtils;
import android.view.View;

import com.susion.fuxiaboring.base.adapter.ViewHolder;
import com.susion.fuxiaboring.event.AddMusicToQueueEvent;
import com.susion.fuxiaboring.event.AddToNextPlayEvent;
import com.susion.fuxiaboring.music.mvp.model.SimpleSong;
import com.susion.fuxiaboring.music.mvp.view.PlayMusicActivity;
import com.susion.fuxiaboring.utils.AlbumUtils;
import com.susion.fuxiaboring.utils.TimeUtils;
import com.susion.fuxiaboring.utils.ToastUtils;
import com.susion.fuxiaboring.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by susion on 17/3/6.
 */
public class LocalMusicIH extends SimpleMusicIH<SimpleSong> {


    public LocalMusicIH(boolean showNextPlay) {
        super(showNextPlay);
    }

    @Override
    protected void onAddToNextPlayClick() {
        ToastUtils.showShort("已经添加下一首播放");
        EventBus.getDefault().post(new AddToNextPlayEvent(mData));
    }

    @Override
    protected void onItemClick() {
        if (!mData.isFromPlayList() && mData.isHasDown()) {
            PlayMusicActivity.start(mContext, mData.translateToSong(), false);
        } else {
            PlayMusicActivity.start(mContext, mData.translateToSong(), true);
        }

        EventBus.getDefault().post(new AddMusicToQueueEvent(mData.translateToSong()));
    }

    @Override
    protected void bindData(ViewHolder vh, SimpleSong data, int position) {
        mTvTile.setText(data.getDisplayName() + "");
        String desc = data.getArtist();

        if (!TextUtils.isEmpty(data.getAlbum())) {
            desc += "-" + data.getAlbum();
        }

        mTvSecondTile.setText(desc);

        if (data.isHasDown()) {
            AlbumUtils.setAlbum(mSdvAlbum, data.getPath());
            String duration = TimeUtils.formatDuration(data.getDuration());
            mTvDuration.setText(duration.equals("00:00") ? "" : duration);
        } else {
            UIUtils.loadSmallPicture(mSdvAlbum, data.getPicPath());
            mTvDuration.setVisibility(View.GONE);
        }
    }
}
