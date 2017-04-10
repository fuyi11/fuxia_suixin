package com.susion.fuxiaboring.music.itemhandler;

import android.view.View;

import com.susion.fuxiaboring.R;
import com.susion.fuxiaboring.base.ui.SimpleItemHandler;
import com.susion.fuxiaboring.base.adapter.ViewHolder;
import com.susion.fuxiaboring.music.mvp.model.PlayList;

/**
 * Created by susion on 17/3/6.
 */
public class PLayListIH extends SimpleItemHandler<PlayList> {
    @Override
    public void onBindDataView(ViewHolder vh, PlayList data, int position) {

    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_like_play_list;
    }

    @Override
    public void onClick(View v) {

    }
}
