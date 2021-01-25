package net.islbd.filterablerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    MediaPlayer mp;
    @Override
    public void onReceive(Context context, Intent intent) {

        mp=MediaPlayer.create(context, R.raw.alarmsounds);
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "notifyme")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("Remind me")
                .setContentText("Hey This is a student")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(200, builder.build());

    }
}
