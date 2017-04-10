package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.music.mvp.model.SimpleSong;
import com.susion.fuxiaboring.music.mvp.model.Song;

/**
 * Created by susion on 17/4/3.
 */
public class AddToNextPlayEvent {

    public Song song;

    public AddToNextPlayEvent(SimpleSong data) {
        song = data.translateToSong();
    }

    public AddToNextPlayEvent(Song data) {
        song = data;
    }
}
