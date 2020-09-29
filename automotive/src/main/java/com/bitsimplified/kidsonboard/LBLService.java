package com.bitsimplified.kidsonboard;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
//import com.bitsimplified.kidsonboard.App;

public class LBLService extends Service {
    //TODO:CHANNEL_ID shopuld be used from App after compilation error is resolved
    public static final String CHANNEL_ID = "lookbeforelockServiceChannel";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //String input = intent.getStringExtra()
        //Do we really want to recreate this service everytime ?
        //can be moved to OnCreate

        //TODO:Change MainActivity
        Intent notificationIntent = new Intent(this,MainActivity.class);
        PendingIntent penndingIntent = PendingIntent.getActivity(this,
                0/*used for cancel intent*/,
                notificationIntent,
                0/*What happens when we update pending Intent*/);

        Notification notification = new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle("LookBeforeLock Service")
                //.setContentText(input);
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(penndingIntent)/*Set Intent on Notification*/
                .build();/*To create Notification which returns Notification*/
        /*To display notification normally .notify is called on notification manager
        * but this is not required here bcz service started iteself instead belowapi is called*/
        startForeground(7/*id greater than zero , just identifier for notication if you later want to update it*/,
                notification);

        return START_NOT_STICKY;/*TODO:Can used STICKY*/
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
