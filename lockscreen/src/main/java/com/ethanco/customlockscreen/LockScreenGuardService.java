package com.ethanco.customlockscreen;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @Description 锁屏守护服务
 * Created by YOLANDA on 2016-02-15.
 */
public class LockScreenGuardService extends Service {

    Intent startIntent = null;
    private LockScreenReceiver receiver;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //upgradeLevelByForeground();
        Utils.disableKeyguard(this);
        registerLockScreenReceiver();
    }

    //Service 提高级别 (Service 通知)
    private void upgradeLevelByForeground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Notification.Builder builder = new Notification.Builder(this);
            PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                    new Intent(this, LockScreenGuardService.class), 0);
            builder.setContentIntent(contentIntent);
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setContentTitle("Lock");
            builder.setContentText("Lock正在运行");

            startForeground(1, builder.build());
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("Z-LockScreenGuard", "onStartCommand: ");

        startIntent = intent;
        return super.onStartCommand(intent, flags, startId);
    }

    private void registerLockScreenReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        filter.setPriority(Integer.MAX_VALUE);
        receiver = new LockScreenReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Z-LockScreenGuard", "onDestroy: ");
        unregisterReceiver(receiver);
        //常驻内存
        if (startIntent != null) {
            Log.i("Z-LockScreenGuard", "serviceIntent not null");
            startService(startIntent);
        }
    }
}
