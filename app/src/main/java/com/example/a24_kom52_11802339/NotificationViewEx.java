package com.example.a24_kom52_11802339;
import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.app.RemoteInput;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationViewEx extends AppCompatActivity {

    TextView tv;
    NotificationManager nm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_view_ex);

        tv= findViewById(R.id.tv);

        Bundle b1 = RemoteInput.getResultsFromIntent(getIntent());
        if(b1 != null){
            tv.setText(b1.getString(MainActivity2.myKey));
        }

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(MainActivity2.notification_ID);

    }
}