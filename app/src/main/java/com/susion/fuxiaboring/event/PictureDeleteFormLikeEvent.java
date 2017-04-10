package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.read.mvp.entity.SimplePicture;

/**
 * Created by susion on 17/3/29.
 */
public class PictureDeleteFormLikeEvent {
    public SimplePicture picture;

    public PictureDeleteFormLikeEvent(SimplePicture data) {
        picture = data;
    }
}
