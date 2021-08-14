package com.example.a24_kom52_11802339;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class RateUs extends AppCompatActivity {

    RelativeLayout layout;
    ImageView iv;
    RatingBar rb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_us);
        rb = findViewById(R.id.rb);
        iv = findViewById(R.id.result);
        layout = findViewById(R.id.feedback);
    }

    public void rateApp(View view) {
        Toast t1 = Toast.makeText(getApplicationContext(),rb.getRating()+"/"+rb.getNumStars(),Toast.LENGTH_LONG);
        t1.setGravity(Gravity.CENTER,0,-200);
        t1.show();

        float rating = rb.getRating();
        String text = "";
        if (rating >= 4.5){
            iv.setImageResource(R.drawable.very_happy);
            text = "Thank you for your feedback!";

        }
        else if(rating<4.5 && rating>=3) {
            iv.setImageResource(R.drawable.satisfied);
            text = "Your feedback is valuable to improve our app";
        }
        else if(rating<3) {
            iv.setImageResource(R.drawable.very_sad);
            text = "Sorry for the inconvinience";
        }Snackbar snackbar = Snackbar.make(layout, text+"", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RateUs.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        snackbar.show();


    }

    public void goBack(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
}