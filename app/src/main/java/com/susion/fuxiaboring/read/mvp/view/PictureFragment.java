package com.susion.fuxiaboring.read.mvp.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.susion.fuxiaboring.R;
import com.susion.fuxiaboring.base.adapter.BaseRVAdapter;
import com.susion.fuxiaboring.base.ui.ItemHandler;
import com.susion.fuxiaboring.base.ui.ItemHandlerFactory;
import com.susion.fuxiaboring.base.ui.OnLastItemVisibleListener;
import com.susion.fuxiaboring.base.view.LoadMoreRecycleView;
import com.susion.fuxiaboring.base.view.ViewPageFragment;
import com.susion.fuxiaboring.event.CategoryPictureLoadErrorEvent;
import com.susion.fuxiaboring.event.PictureCategorySelectedEvent;
import com.susion.fuxiaboring.http.APIHelper;
import com.susion.fuxiaboring.http.CommonObserver;
import com.susion.fuxiaboring.read.itemhandler.SimplePictureIH;
import com.susion.fuxiaboring.read.mvp.entity.SimplePicture;
import com.susion.fuxiaboring.read.mvp.entity.SimplePictureList;
import com.susion.fuxiaboring.read.view.PictureCategoryWindow;
import com.susion.fuxiaboring.utils.PictureLoadHelper;
import com.susion.fuxiaboring.utils.RVUtils;
import com.susion.fuxiaboring.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by susion on 17/3/15.
 */
public class PictureFragment extends ViewPageFragment implements OnLastItemVisibleListener, SwipeRefreshLayout.OnRefreshListener {

    private FloatingActionButton mFlMenu;
    private LoadMoreRecycleView mRv;
    private List<SimplePicture> mData = new ArrayList<>();
    private int mPage = 0;
    private SwipeRefreshLayout mRefreshLayout;
    private boolean mIsRefresh;
    private PictureCategoryWindow mCategoryWindow;
    private String mTypeId;
    private static String TAG = "XX_LOG_TAG";
    @Override
    public View initContentView(LayoutInflater inflater, ViewGroup container) {
        mView = inflater.inflate(R.layout.fragment_picture_layout, container, false);
        EventBus.getDefault().register(this);
        return mView;
    }

    @Override
    protected void findView() {
        mFlMenu = (FloatingActionButton) mView.findViewById(R.id.float_button);
        mRv = (LoadMoreRecycleView) mView.findViewById(R.id.list_view);
        mRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.refresh_layout);
    }

    @Override
    protected void initView() {
        mRefreshLayout.setColorSchemeColors(new int[]{getResources().getColor(R.color.colorAccent)});
        mRefreshLayout.setOnRefreshListener(this);
        mRv.setLayoutManager(RVUtils.getStaggeredGridLayoutManager(2));
        mRv.setOnLastItemVisibleListener(this);
        mRv.setAdapter(new BaseRVAdapter(this, mData) {
            @Override
            protected void initHandlers() {
                registerItemHandler(0, new ItemHandlerFactory() {
                    @Override
                    public ItemHandler newInstant(int viewType) {
                        return new SimplePictureIH();
                    }
                });
            }

            @Override
            protected int getViewType(int position) {
                return 0;
            }
        });


        mCategoryWindow = new PictureCategoryWindow(getActivity());
//        mTypeId = "2004";  //中国男明星
        mTypeId = "1004";  //中国男明星

        Log.e(TAG,"mTypeId:"+ mTypeId);
    }

    @Override
    public void initListener() {
        mFlMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCategoryWindow.isShowing()) {
                    mCategoryWindow.dismiss();
                    return;
                }
                mCategoryWindow.showAsDropDown(mFlMenu, 0, UIUtils.dp2Px(10), Gravity.RIGHT);

                Log.e(TAG,"mTypeId:"+ mTypeId);
            }
        });
    }

    @Override
    public void initData() {
        mRefreshLayout.setRefreshing(true);
        mIsRefresh = true;
        onRefresh();
    }

    private void loadData() {
        int requestPage = mIsRefresh ? 1 : mPage + 1;
        APIHelper.subscribeSimpleRequest(APIHelper.getPictureService().getPicturesByType(mTypeId, String.valueOf(requestPage)),
                new CommonObserver<SimplePictureList>() {
                    @Override
                    public void onNext(SimplePictureList simplePictureList) {
                        if (simplePictureList == null) {
                            return;
                        }

                        List<SimplePictureList.ShowapiResBodyBean.PagebeanBean.ContentlistBean> contentList = simplePictureList.getShowapi_res_body().getPagebean().getContentlist();
                        if (mIsRefresh) {
                            mIsRefresh = false;
                            mRefreshLayout.setRefreshing(mIsRefresh);

                            mData.clear();
                            for (SimplePictureList.ShowapiResBodyBean.PagebeanBean.ContentlistBean bean : contentList) {
                                mData.addAll(bean.getList());
                            }
                            mRv.getAdapter().notifyDataSetChanged();
                        } else {
                            for (SimplePictureList.ShowapiResBodyBean.PagebeanBean.ContentlistBean bean : contentList) {
                                mData.addAll(bean.getList());
                            }

                            mRv.getAdapter().notifyDataSetChanged();
                            mPage++;
                        }
                    }
                });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PictureCategorySelectedEvent event) {
        mCategoryWindow.dismiss();
        mTypeId = event.id;
        onRefresh();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(CategoryPictureLoadErrorEvent event) {
        PictureLoadHelper.addLoadErrorTimeForType(mTypeId);
    }

    @Override
    public String getTitle() {
        return "图片精选";
    }

    @Override
    public void onLastItemVisible() {
        loadData();
    }


    @Override
    public void onRefresh() {
        mIsRefresh = true;
        loadData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
