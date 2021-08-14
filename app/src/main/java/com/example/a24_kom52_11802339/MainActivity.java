package com.example.a24_kom52_11802339;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText user_name, pass_word;
    TextView results;
   /* TextView reg_num;
    EditText user_name;

    SharedPreferences sharedPreferences;
    public static final String Username = "username_key";
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sharedPreferences =getSharedPreferences("mypreference", Context.MODE_PRIVATE);

        /*user_name = findViewById(R.id.username);
        reg_num = findViewById(R.id.reg_num);
        sharedPreferences =getSharedPreferences("mypreference", Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Username))
        {
            reg_num.setText(sharedPreferences.getString(Username,""));
        }*/
    }

    public void storeCredentials()  {

        user_name = findViewById(R.id.username);
        pass_word = findViewById(R.id.password);

        String text1 = user_name.getText()+" ";
        String text2 = pass_word.getText()+"\n";


        File file = null;
        FileOutputStream fileOutputStream = null;
        try
        {
            file = getFilesDir();
            fileOutputStream = openFileOutput("Credentials.txt",Context.MODE_APPEND);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
                Toast.makeText(this, "Credentials stored at "+file, Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void onSignIn(View view) {
        storeCredentials();

        //Read Data
        try {
            FileInputStream fileInputStream = openFileInput("Credentials.txt");
            int i = -1;
            StringBuffer buffer = new StringBuffer();
            while((i=fileInputStream.read())!=-1){
                buffer.append((char)i);

            }
            Log.d("VIVZ",buffer.toString());
            results = findViewById(R.id.results);
            results.setText(buffer.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Saving the data.
        /*String n = user_name.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Username, n);
        editor.commit();


        sharedPreferences = getSharedPreferences("myPreference",
                Context.MODE_PRIVATE);


        if (sharedPreferences.contains(Username)) {
            reg_num.setText(sharedPreferences.getString(Username, ""));
        }

*/
        //Launching Home Screen
        Intent i = new Intent(getApplicationContext(),MainActivity2.class);
        i.putExtra("username",user_name.getText().toString()+"");

        startActivity(i);

    }
}