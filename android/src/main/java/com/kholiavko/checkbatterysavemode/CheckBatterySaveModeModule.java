package com.kholiavko.checkbatterysavemode;

import android.content.Context;
import android.os.PowerManager;
import android.os.Build;
import android.os.Bundle;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

class CheckBatterySaveModeModule extends ReactContextBaseJavaModule {
    private Context context;

    public CheckBatterySaveModeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    /**
     * @return the name of this module. This will be the name used to {@code require()} this module
     * from javascript.
     */

    public String getName() {
        return "CheckBatterySaveMode";
    }

    @ReactMethod
    public void isPowerSaveModeEnabled(Callback onSuccess, Callback onFailure) {
        try {
            PowerManager powerManager = (PowerManager)
                CheckBatterySaveModeModule.this.context.getSystemService(Context.POWER_SERVICE);

            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && powerManager.isPowerSaveMode()) {
                onSuccess.invoke(true);
            } else {
                onSuccess.invoke(false);
            }
        } catch(Throwable t) {
            onSuccess.invoke(false);
        }
    }
}
