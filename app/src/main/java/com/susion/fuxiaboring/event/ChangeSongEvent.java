package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.music.mvp.model.Song;

/**
 * Created by susion on 17/3/6.
 */
public class ChangeSongEvent {

    public  Song song;

    public ChangeSongEvent(Song mData) {
        song = mData;
    }
}
