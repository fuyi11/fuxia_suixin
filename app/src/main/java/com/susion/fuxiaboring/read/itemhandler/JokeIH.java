package com.susion.fuxiaboring.read.itemhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.susion.fuxiaboring.R;
import com.susion.fuxiaboring.base.adapter.ViewHolder;
import com.susion.fuxiaboring.base.ui.SimpleItemHandler;
import com.susion.fuxiaboring.db.operate.DbBaseOperate;
import com.susion.fuxiaboring.event.JokeDeleteFormLikeEvent;
import com.susion.fuxiaboring.http.APIHelper;
import com.susion.fuxiaboring.http.CommonObserver;
import com.susion.fuxiaboring.read.mvp.entity.Joke;
import com.susion.fuxiaboring.utils.ToastUtils;
import com.susion.fuxiaboring.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by susion on 17/3/16.
 */
public class JokeIH extends SimpleItemHandler<Joke> {

    private ImageView mIvLove;
    private boolean mIsLove;
    private DbBaseOperate<Joke> mDbOperator;

    public JokeIH(DbBaseOperate<Joke> mDbOperator) {
        this.mDbOperator = mDbOperator;
    }

    @Override
    public void onCreateItemHandler(ViewHolder vh, ViewGroup parent) {
        super.onCreateItemHandler(vh, parent);
        mIvLove = vh.getImageView(R.id.item_joke_iv_like);
        mIvLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIsLove) {
                    APIHelper.subscribeSimpleRequest(mDbOperator.delete(mData), new CommonObserver<Boolean>() {
                        @Override
                        public void onNext(Boolean flag) {
                            ToastUtils.showShort(flag ? "已经从喜欢列表移除" : "从喜欢列表移除失败");
                            mIsLove = flag ? false : true;
                            UIUtils.refreshLikeStatus(mIvLove, mIsLove);
                            if (!mIsLove) {
                                EventBus.getDefault().post(new JokeDeleteFormLikeEvent(mData));
                            }
                        }
                    });
                } else {
                    APIHelper.subscribeSimpleRequest(mDbOperator.add(mData), new CommonObserver<Boolean>() {
                        @Override
                        public void onNext(Boolean flag) {
                            ToastUtils.showShort(flag ? "已喜欢" : "喜欢失败");
                            mIsLove = flag ? true : false;
                            UIUtils.refreshLikeStatus(mIvLove, mIsLove);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onBindDataView(ViewHolder vh, Joke data, int position) {
        vh.getTextView(R.id.item_joke_tv_content).setText(data.getContent());

        APIHelper.subscribeSimpleRequest(mDbOperator.query(mData.getHashId()), new CommonObserver<Joke>() {
            @Override
            public void onNext(Joke joke) {
                mIsLove = joke != null ? true : false;
                UIUtils.refreshLikeStatus(mIvLove, mIsLove);
            }
        });
    }

    @Override
    public int getLayoutResId() {
        return R.layout.item_joke;
    }

    @Override
    public void onClick(View v) {

    }
}
