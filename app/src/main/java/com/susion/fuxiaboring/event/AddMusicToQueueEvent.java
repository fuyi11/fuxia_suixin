package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.music.mvp.model.Song;

/**
 * Created by susion on 17/4/1.
 */
public class AddMusicToQueueEvent {
    public Song song;
    public AddMusicToQueueEvent(Song song) {
        this.song = song;
    }
}
