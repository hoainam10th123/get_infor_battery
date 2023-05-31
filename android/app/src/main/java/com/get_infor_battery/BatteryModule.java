package com.get_infor_battery;

import static android.content.Context.BATTERY_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;


public class BatteryModule extends ReactContextBaseJavaModule {
    Context context;
    BatteryModule(ReactApplicationContext context) {
        super(context);
        this.context = context.getApplicationContext();
    }

    @NonNull
    @Override
    public String getName() {
        return "BatteryModule";
    }

    @ReactMethod
    public void getBatteryEvent(Callback callback) {
        try {
            BatteryManager bm = (BatteryManager) this.context.getSystemService(BATTERY_SERVICE);
            int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            callback.invoke(null, batLevel);
            Log.d("BatteryModule", "Battery "+batLevel);
        }catch (Exception e){
            callback.invoke(e, null);
        }
    }
}
