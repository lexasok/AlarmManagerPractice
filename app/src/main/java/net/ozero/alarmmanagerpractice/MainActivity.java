package net.ozero.alarmmanagerpractice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import net.ozero.alarmmanagerpractice.receivers.AlarmReceiver;

public class MainActivity extends AppCompatActivity {

    public static final int TIME_OUT = 30*1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void setAlarmButtonClicked(View view) {

        Log.i(getClass().getName(), "setAlarmButtonClicked");
    }

    private void setAlarm() {

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                getAlarmTime(),
                getPendingIntent()
        );
    }

    private Intent getAlarmIntent() {

        return new Intent(
                "net.ozero.alarmmanagerpractice.receivers.AlarmReceiver");
    }

    private PendingIntent getPendingIntent() {

        return  PendingIntent.getBroadcast(
                this,
                0,
                getAlarmIntent(),
                0
        );
    }

    private long getAlarmTime() {

        return System.currentTimeMillis() + TIME_OUT;
    }
}
