package com.coolweather.app.coolweather.application;

import android.app.Application;

/**
 * mark a signal to decide to whether should skip the welcome view or not
 * Created by SharingWoo on 2017/1/25.
 */

public class MarkApplication extends Application {
    public static boolean SKIP_WELCOME;
    @Override
    public void onCreate() {
        // the first time we decide to show the welcome view
        SKIP_WELCOME = false;
        super.onCreate();
    }

}
