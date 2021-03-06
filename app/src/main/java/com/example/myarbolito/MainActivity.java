package com.example.myarbolito;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity{
    public static final String CANAL_MENSAJES_ID_1 ="1001" ;
    public static String  noti ="com.example.myarbolito";
    public static String  regar ="regar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FragmentManager fragm =getSupportFragmentManager();
        FragmentMenu fragmentMenu=new FragmentMenu();
        fragm.beginTransaction().replace(R.id.contenido,fragmentMenu).addToBackStack(null).commit();
        MyNotificationReceiver notificacion =new MyNotificationReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction(noti);
        intentFilter.addAction(regar);
        this.registerReceiver(notificacion,intentFilter);
        createNotificationChannel();
        cancelarAlarmRegar();

    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            int importance = NotificationManager.IMPORTANCE_HIGH;
            CharSequence name = getString(R.string.NOTIFICACION);
            NotificationChannel channel = new NotificationChannel(CANAL_MENSAJES_ID_1,name, importance);
            channel.setDescription("NOTIFICACIONES_1");
            NotificationManager notificationManager =getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }
        private void cancelarAlarmRegar() {
            AlarmManager alarmManager = (AlarmManager) getSystemService(this.ALARM_SERVICE);
            Intent intent = new Intent();
            Calendar calendar = Calendar.getInstance();
            intent.setAction(regar);
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
            alarmManager.cancel(pendingIntent);

        }

}

