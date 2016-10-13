package com.ethanco.customlockscreendemo;

import android.app.Activity;
import android.os.Bundle;

import com.ethanco.customlockscreen.LockScreenHelper;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.activity_main1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        LockScreenHelper.getInstance().startLockScreenService(this);
        LockScreenHelper.getInstance().setCurrLockScreenActivityClass(MyLockScreenPreActivity.class);
    }
}
