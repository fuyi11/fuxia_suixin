package com.susion.fuxiaboring.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.susion.fuxiaboring.base.service.BaseService;
import com.susion.fuxiaboring.utils.FileUtils;
import com.susion.fuxiaboring.utils.ImagePipelineConfigFactory;

/**
 * Created by susion on 17/1/17.
 */
public class SAppApplication extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this, ImagePipelineConfigFactory.getImagePipelineConfig(this));
        FileUtils.initAppDir();

        Intent intent = new Intent(this, BaseService.class);
        startService(intent);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        sContext = base;
    }

    public static Context getAppContext() {
        return sContext;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        stopService(new Intent(BaseService.SERVICE_ACTION));
    }
}
