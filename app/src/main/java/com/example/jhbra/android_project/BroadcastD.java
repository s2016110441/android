package com.example.jhbra.android_project;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadcastD extends BroadcastReceiver {
    String INTENT_ACTION = Intent.ACTION_BOOT_COMPLETED;



    @Override
    public void onReceive(Context context, Intent intent) {//알람 시간이 되었을때 onReceive를 호출함
        //NotificationManager 안드로이드 상태바에 메세지를 던지기위한 서비스 불러오고
        NotificationManager notificationmanager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, alram.class), PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setSmallIcon(R.drawable.on).setTicker("HETT").setWhen(System.currentTimeMillis())
                .setNumber(1).setContentTitle("출발할시간입니다").setContentText("출발!!")
                .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingIntent).setAutoCancel(true);

        notificationmanager.notify(1, builder.build());
    }


}
