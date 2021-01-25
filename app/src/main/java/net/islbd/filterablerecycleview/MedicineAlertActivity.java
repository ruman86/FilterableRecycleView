package net.islbd.filterablerecycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class MedicineAlertActivity extends AppCompatActivity {
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;
    Button saveAlertBtn;
    private RadioGroup radioMealGroup;
    private RadioButton radioMealBtn;
    private Context context;
    private CheckBox cbBreakFast, cbLaunch, cbDinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_alert);

        createNotificationChannel();
       /* alarmMgr = (AlarmManager)MedicineAlertActivity.this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(MedicineAlertActivity.this, AlarmReceiver.class);
        alarmIntent = PendingIntent.getBroadcast(MedicineAlertActivity.this, 0, intent, 0);

// Set the alarm to start at 8:30 a.m.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 05);

// setRepeating() lets you specify a precise custom interval--in this case,
// 20 minutes.
        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 20, alarmIntent);*/
       saveAlertBtn = findViewById(R.id.btnSaveAlart);
       radioMealGroup = findViewById(R.id.radioMealtime);
        cbBreakFast = findViewById(R.id.cbBreakFast);
        cbLaunch = findViewById(R.id.cbLaunch);
        cbDinner = findViewById(R.id.cbDinner);

       saveAlertBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Toast.makeText(MedicineAlertActivity.this, "Reminder Set!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(MedicineAlertActivity.this, AlarmReceiver.class);
               PendingIntent pendingIntent = PendingIntent.getBroadcast(MedicineAlertActivity.this, 0, intent, 0);
               AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
               /*long timeAtButtonClick = System.currentTimeMillis();
               long tenSeconds = 1000*10;*/
               int selectMealtime = radioMealGroup.getCheckedRadioButtonId();
               radioMealBtn = findViewById(selectMealtime);

               if(cbBreakFast.isChecked() || cbLaunch.isChecked() || cbDinner.isChecked()){

               }

               Calendar calendar = Calendar.getInstance();
               calendar.setTimeInMillis(System.currentTimeMillis());
               calendar.set(Calendar.HOUR_OF_DAY, 12);
               calendar.set(Calendar.MINUTE, 00);


               alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);
           }
       });

    }

    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            CharSequence name = "ReminderChanel";
            String Description = "Chanel of Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("notifyme",name, importance);
            channel.setDescription(Description);

            NotificationManager notifincationManager = getSystemService(NotificationManager.class);
            notifincationManager.createNotificationChannel(channel);
        }
    }
}
