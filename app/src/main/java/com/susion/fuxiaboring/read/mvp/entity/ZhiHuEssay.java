package com.susion.fuxiaboring.read.mvp.entity;

import com.susion.fuxiaboring.base.entity.FavoriteMark;

import java.util.Date;
import java.util.List;

/**
 * Created by susion on 17/3/28.
 */
public class ZhiHuEssay extends FavoriteMark {
    public String id;
    public int type;
    public String ga_prefix;
    public String title;
    public List<String> images;
    public Date date;
}
