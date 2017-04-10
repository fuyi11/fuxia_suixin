package com.susion.fuxiaboring.music.itemhandler;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.susion.fuxiaboring.R;
import com.susion.fuxiaboring.base.ui.SimpleItemHandler;
import com.susion.fuxiaboring.base.adapter.ViewHolder;
import com.susion.fuxiaboring.music.mvp.model.SimpleTitle;

/**
 * Created by susion on 17/2/23.
 */
public class MusicPageTitleIH extends SimpleItemHandler<SimpleTitle>{


    @Override
    public void onCreateItemHandler(ViewHolder vh, ViewGroup parent) {
        super.onCreateItemHandler(vh, parent);
        ViewGroup.LayoutParams layoutParams = vh.getConvertView().getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override
    public void onBindDataView(ViewHolder vh, SimpleTitle data, int position) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_simple_title;
    }

    @Override
    public void onClick(View v) {

    }

}
