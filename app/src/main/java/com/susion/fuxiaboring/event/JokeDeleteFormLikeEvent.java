package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.read.mvp.entity.Joke;

/**
 * Created by susion on 17/3/29.
 */
public class JokeDeleteFormLikeEvent {
    public Joke joke;

    public JokeDeleteFormLikeEvent(Joke data) {
        joke = data;
    }
}
