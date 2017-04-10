package com.susion.fuxiaboring.read.adapter;

import android.app.Activity;

import com.susion.fuxiaboring.base.adapter.BaseRVAdapter;
import com.susion.fuxiaboring.base.ui.ItemHandler;
import com.susion.fuxiaboring.base.ui.ItemHandlerFactory;
import com.susion.fuxiaboring.read.itemhandler.DailyNewsDateIH;
import com.susion.fuxiaboring.read.itemhandler.DailyNewsIH;
import com.susion.fuxiaboring.read.itemhandler.TopNewsIH;
import com.susion.fuxiaboring.read.mvp.entity.DailyNewsDate;
import com.susion.fuxiaboring.read.mvp.entity.NewsDetail;

import java.util.List;

/**
 * Created by susion on 17/3/9.
 */
public class ZhiHuDailyAdapter extends BaseRVAdapter {

    private static final int TYPE_NEWS = 1;
    private static final int TYPE_DATE = 2;
    private static final int TYPE_TOP_NEWS = 3;

    public ZhiHuDailyAdapter(Activity activity, List<?> data) {
        super(activity, data);
    }

    @Override
    protected void initHandlers() {
        registerItemHandler(TYPE_TOP_NEWS, new ItemHandlerFactory() {
            @Override
            public ItemHandler newInstant(int viewType) {
                return new TopNewsIH();
            }
        });

        registerItemHandler(TYPE_NEWS, new ItemHandlerFactory() {
            @Override
            public ItemHandler newInstant(int viewType) {
                return new DailyNewsIH();
            }
        });

        registerItemHandler(TYPE_DATE, new ItemHandlerFactory() {
            @Override
            public ItemHandler newInstant(int viewType) {
                return new DailyNewsDateIH();
            }
        });
    }

    @Override
    protected int getViewType(int position) {

        Object item = getItem(position);

        if (item instanceof List) {
            return TYPE_TOP_NEWS;
        }

        if (item instanceof NewsDetail) {
            return TYPE_NEWS;
        }

        if (item instanceof DailyNewsDate) {
            return TYPE_DATE;
        }

        return 0;
    }
}
