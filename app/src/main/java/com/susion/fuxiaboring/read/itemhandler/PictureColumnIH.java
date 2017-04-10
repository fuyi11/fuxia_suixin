package com.susion.fuxiaboring.read.itemhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.susion.fuxiaboring.R;
import com.susion.fuxiaboring.base.adapter.ViewHolder;
import com.susion.fuxiaboring.base.ui.SimpleItemHandler;
import com.susion.fuxiaboring.event.PictureCategorySelectedEvent;
import com.susion.fuxiaboring.read.mvp.entity.PictureCategoryResult;
import com.susion.fuxiaboring.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by susion on 17/3/26.
 */
public class PictureColumnIH extends SimpleItemHandler<PictureCategoryResult.CategoryList.PictureCategory.Column> {

    private TextView mTvTitle;

    @Override
    public void onCreateItemHandler(ViewHolder vh, ViewGroup parent) {
        super.onCreateItemHandler(vh, parent);
        mTvTitle = vh.getTextView(R.id.item_picture_category_tv_name);
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mTvTitle.getLayoutParams();
        layoutParams.leftMargin = UIUtils.dp2Px(25);
    }

    @Override
    public void onBindDataView(ViewHolder vh, PictureCategoryResult.CategoryList.PictureCategory.Column data, int position) {
        mTvTitle.setText(data.getName());
        mTvTitle.setTextColor(UIUtils.getColor(mContext, R.color.colorAccent));
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_picture_category;
    }

    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new PictureCategorySelectedEvent(mData.getId()));
    }
}
