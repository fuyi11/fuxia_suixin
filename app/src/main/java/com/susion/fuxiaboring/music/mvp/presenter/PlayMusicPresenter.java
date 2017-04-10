package com.susion.fuxiaboring.music.mvp.presenter;

import android.content.Context;

import com.susion.fuxiaboring.music.mvp.model.Song;
import com.susion.fuxiaboring.music.mvp.contract.MediaPlayerContract;
import com.susion.fuxiaboring.utils.SPUtils;

/**
 * Created by susion on 17/2/8.
 * <p/>
 * extension
 */
public class PlayMusicPresenter extends MediaPlayPresenter implements MediaPlayerContract.PlayMusicControlPresenter {

    public PlayMusicPresenter(MediaPlayerContract.MediaPlayerRefreshView mView, Context mContext) {
        super(mView, mContext);
    }

    @Override
    public void saveLastPlayMusic(Song song, Context c) {
        if (song != null && song.hasDown) {
            SPUtils.writeStringConfig(SPUtils.KEY_LAST_PLAY_MUSIC, song.id);
        }
    }
}
