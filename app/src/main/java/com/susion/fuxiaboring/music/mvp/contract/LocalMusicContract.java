package com.susion.fuxiaboring.music.mvp.contract;

import android.app.LoaderManager;
import com.susion.fuxiaboring.base.view.IView;
import com.susion.fuxiaboring.music.mvp.model.SimpleSong;

import java.util.List;

/**
 * Created with Android Studio.
 * User: ryan.hoo.j@gmail.com
 * Date: 9/13/16
 * Time: 8:32 PM
 * Desc: LocalMusicContract
 */
/* package */ public interface LocalMusicContract {

    interface View extends IView {
        LoaderManager getMyLoaderManager();

        void showScanResult(List<SimpleSong> songs);

        void showScanErrorUI();

        void hideScanLocalMusicUI();

        void startScanLocalMusic();
    }

    interface Presenter{
        void loadLocalMusic();
    }
}
