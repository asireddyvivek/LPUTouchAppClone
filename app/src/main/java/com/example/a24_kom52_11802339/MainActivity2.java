package com.example.a24_kom52_11802339;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.view.MenuCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    NotificationManager notificationManager;
    TextView reg_num;

    public static final String channel_ID = "My Channel ID";
    public static final int notification_ID = 10;
    public static final String myKey = "Remote Key";


    Button logOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar= findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);




        logOut = findViewById(R.id.logOut);
       /* logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
*/

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener)this);




        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity2.this,
                drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        myNotificationChannel();
        showNotification();


        Intent i = getIntent();
        String str = i.getStringExtra("username");
        //reg_num.setText(str);
        Toast.makeText(this,"Logged in as "+str,Toast.LENGTH_LONG).show();
        /*Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+5:30"));
        for(int i=0;i<100;i--) {
            Date currentTime = calendar.getTime();
            DateFormat timeFormat = new SimpleDateFormat("HH:mm");
            timeFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30"));
            final String  crntTime = timeFormat.format(currentTime);
            System.out.println(currentTime);
            reg_num = findViewById(R.id.main_heading);
            reg_num.setText(timeFormat.format(currentTime));

            if (crntTime == "12:13"){
                showNotification();
            }


            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (crntTime == "12:13"){
                        showNotification();
                    }
                }
            },60000);



        }*/
    }

    public void showNotification() {
        myNotificationChannel();

        Intent i = new Intent(MainActivity2.this, NotificationViewEx.class);
        PendingIntent pi = PendingIntent.getActivity(MainActivity2.this, 1, i, PendingIntent.FLAG_ONE_SHOT);
        RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.small_notification);
        //RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(), R.layout.big_notification);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel_ID);
        builder.setSmallIcon(R.drawable.lpu_logo)
                .setContentTitle("Welcome to the App")
                .setContentText("You are logged in as"+reg_num)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(notificationLayout)
                //.setCustomBigContentView(notificationLayoutExpanded)
                .build();

        builder .setContentIntent(pi);


       /* if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            //RemoteInput ri = new RemoteInput.Builder(myKey).setLabel("Replying....").build();
            androidx.core.app.RemoteInput ri = new androidx.core.app.RemoteInput.Builder(myKey).setLabel("Replying.....").build();
            NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground, "Reply!", pi)
                    .addRemoteInput(ri).build();

            builder.addAction(action);
        }*/

        builder.setAutoCancel(true);
        notificationManager.notify(notification_ID, builder.build());
    }


    public void myNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            String name = "My Channel Name";
            String desc = "My Channel Description";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel notificationChannel = new NotificationChannel(channel_ID, name, importance);
            notificationChannel.setDescription(desc);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.canShowBadge();

            notificationManager.createNotificationChannel(notificationChannel);
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                break;
            case R.id.item2:
                Intent i1 = new Intent(getApplicationContext(),Announcements.class);
                startActivity(i1);
                break;
            case R.id.item3:
                Intent i2 = new Intent(getApplicationContext(),Assignments.class);
                startActivity(i2);
                break;
            case R.id.item4:
                Intent i3 = new Intent(getApplicationContext(),Attendance.class);
                startActivity(i3);
                break;
            case R.id.item8:
                Intent i4 = new Intent(getApplicationContext(),Result.class);
                startActivity(i4);

        }

        return true;
    }

    public void onSignOut(View view){
        showNotification();

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void viewTimeTable(View view) {
        Intent i = new Intent(this,TimeTable.class);
        startActivity(i);
    }
    public void onRate(View view){
        Intent i = new Intent(this,RateUs.class);
        startActivity(i);
    }



    public void vieMessages(View view) {
        Intent i = new Intent(getApplicationContext(),Messages.class);
        startActivity(i);
    }

    public void viewQuiz(View view) {

        Intent i = new Intent(getApplicationContext(),Quiz.class);
        startActivity(i);
    }

    public void viewHappenings(View view) {
        Intent i = new Intent(getApplicationContext(),Happenings.class);
        startActivity(i);
    }

    public void logComplaint(View view) {
        Intent i = new Intent(getApplicationContext(),Rms.class);
        startActivity(i);
    }

    public void viewAnnouncements(View view) {
        Intent i = new Intent(getApplicationContext(),Announcements.class);
        startActivity(i);
    }

    public void viewAttendance(View view) {
        Intent i = new Intent(getApplicationContext(),Attendance.class);
        startActivity(i);
    }

    public void viewAssignments(View view) {
        Intent i = new Intent(getApplicationContext(),Assignments.class);
        startActivity(i);
    }

    public void viewResult(View view) {
        Intent i = new Intent(getApplicationContext(),Result.class);
        startActivity(i);
    }

    public void viewTeacher(View view) {
        Intent i = new Intent(getApplicationContext(),TeacherOnLeave.class);
        startActivity(i);
    }
}