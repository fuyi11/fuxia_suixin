package com.susion.fuxiaboring.event;

import com.susion.fuxiaboring.read.mvp.entity.NewsDetail;

/**
 * Created by susion on 17/3/31.
 */
public class EssayDeleteFromLikeEvent {
    public NewsDetail newsDetail;
    public EssayDeleteFromLikeEvent(NewsDetail detail) {
        newsDetail = detail;
    }
}
