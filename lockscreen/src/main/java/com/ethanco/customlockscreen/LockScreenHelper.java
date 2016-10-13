package com.ethanco.customlockscreen;

import android.content.Context;
import android.content.Intent;

/**
 * @Description 锁屏帮助类
 * Created by YOLANDA on 2016-02-15.
 */
public class LockScreenHelper {
    private LockScreenHelper() {
    }

    public static LockScreenHelper sInstance = new LockScreenHelper();

    public static LockScreenHelper getInstance() {
        return sInstance;
    }

    public Class getCurrLockScreenActivityClass() {
        return currLockScreenActivityClass;
    }

    /**
     * 设置锁屏时启动的Activity
     *
     * @param currLockScreenActivityClass
     */
    public void setCurrLockScreenActivityClass(Class currLockScreenActivityClass) {
        this.currLockScreenActivityClass = currLockScreenActivityClass;
    }

    private Class currLockScreenActivityClass;

    /**
     * 启动锁屏服务
     *
     * @param context
     */
    public void startLockScreenService(Context context) {
        Intent intent = new Intent(context, LockScreenGuardService.class);
        context.startService(intent);
    }
}
