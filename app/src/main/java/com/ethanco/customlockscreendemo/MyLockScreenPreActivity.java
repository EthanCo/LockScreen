package com.ethanco.customlockscreendemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.ethanco.customlockscreen.HomeListener;
import com.ethanco.customlockscreen.Utils;

/**
 * @Description 锁屏界面
 * Created by YOLANDA on 2016-02-15.
 */
public class MyLockScreenPreActivity extends Activity {
    private static final String TAG = "Z-LockScreen";
    public static boolean isShown = false;
    private HomeListener mHomeWatcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Z-BaseLockScreen", "onCreate: ");
        isShown = true;

        if (Utils.isScreenOn(this)) finish();

        //隐藏虚拟按键
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        //注册 Home键监听
        registerHomePressListener();

        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        //getWindow().addFlags(WindowManager.LayoutParams.TYPE_SYSTEM_ERROR);

        Intent intent = new Intent(this, MyLockScreenActivity.class);
        startActivity(intent);
    }

    private void registerHomePressListener() {
        mHomeWatcher = new HomeListener(this);
        mHomeWatcher.setOnHomePressedListener(new HomeListener.OnHomePressedListener() {
            @Override
            public void onHomePressed() {
                Log.i(TAG, "onHomePressed");
                finish();
            }

            @Override
            public void onHomeLongPressed() {
                Log.i(TAG, "onHomeLongPressed");
                finish();

            }
        });
        mHomeWatcher.startWatch();
    }

    @Override
    protected void onDestroy() {
        isShown = false;
        super.onDestroy();
        mHomeWatcher.stopWatch();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            Log.i(TAG, "onKeyDown KEYCODE_BACK: ");
            return false;
        }
        //这样的监听不能监听到HOME键，只能监听到BACK,MENU键
        /*if (keyCode == event.KEYCODE_HOME) {
            Log.i(TAG, "onKeyDown KEYCODE_HOME");
            finish();
            return true;
        }*/

        return super.onKeyDown(keyCode, event);
    }
}
