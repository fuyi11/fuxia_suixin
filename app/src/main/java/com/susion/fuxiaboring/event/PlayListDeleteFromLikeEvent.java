package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.music.mvp.model.PlayList;

/**
 * Created by susion on 17/4/4.
 */
public class PlayListDeleteFromLikeEvent {
    public PlayList playList;
    public PlayListDeleteFromLikeEvent(PlayList mPlayList) {
        playList = mPlayList;
    }
}
