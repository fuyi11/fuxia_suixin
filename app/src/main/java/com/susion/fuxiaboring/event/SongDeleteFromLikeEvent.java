package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.music.mvp.model.SimpleSong;

/**
 * Created by susion on 17/4/4.
 */
public class SongDeleteFromLikeEvent {
    public SimpleSong song;

    public SongDeleteFromLikeEvent(SimpleSong song) {
        this.song = song;
    }
}
