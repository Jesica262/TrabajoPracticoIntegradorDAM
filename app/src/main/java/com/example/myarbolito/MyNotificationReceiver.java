package com.example.myarbolito;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyNotificationReceiver extends BroadcastReceiver {
    private static final int NOTIFICACION_ID = 1000;
    public static String  noti ="com.example.myarbolito";
    public static String  regar ="regar";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(noti)) {


            Intent i= new Intent(context, FragmentRegistro.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,i,0);



            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context, MainActivity.CANAL_MENSAJES_ID_1)
                            .setSmallIcon(R.drawable.baseline_message_24)
                            .setContentTitle("Bienvenido a MyArbolito")
                            .setContentText("Es hora de plantar arboles. Ya puede iniciar sesion")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setAutoCancel(true)
                            .setDefaults(NotificationCompat.DEFAULT_ALL)
                            .setContentIntent(pendingIntent);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManagerCompat.notify(NOTIFICACION_ID, mBuilder.build());
        }
        if(intent.getAction().equals(regar)) {


            Intent i= new Intent(context, FragmentRegistro.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,i,0);



            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context, MainActivity.CANAL_MENSAJES_ID_1)
                            .setSmallIcon(R.mipmap.ic_arbol)
                            .setContentTitle("HORA DE REGAR")
                            .setContentText("A regar tus arbolitos")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .setAutoCancel(true)
                            .setDefaults(NotificationCompat.DEFAULT_ALL)
                            .setContentIntent(pendingIntent);

            NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
            notificationManagerCompat.notify(NOTIFICACION_ID, mBuilder.build());
        }
    }
}