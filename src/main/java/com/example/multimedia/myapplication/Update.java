package com.example.multimedia.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText UsernameEt,PasswordEt,EmailEt,GenderEt,IdEt;
    TextView tampildata;
    ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        UsernameEt = (EditText)findViewById(R.id.et_username);
        PasswordEt = (EditText)findViewById(R.id.et_password);
        EmailEt =  (EditText)findViewById(R.id.et_email);
        GenderEt =  (EditText)findViewById(R.id.et_gender);
        IdEt = (EditText) findViewById(R.id.et_id);
        tampildata = (TextView)findViewById(R.id.et_dataupdate);
        loading = (ProgressBar)findViewById(R.id.pb_loading);
        loading.setVisibility(View.GONE);
    }

    public void update(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String email = EmailEt.getText().toString();
        String gender = GenderEt.getText().toString();
        String id = IdEt.getText().toString();
        String type ="update";
        loading.setVisibility(View.VISIBLE);
        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {
                loading.setVisibility(View.GONE);
                //tampildata.setText(output);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, output, duration);
                toast.show();
            }
        }).execute(type,username,password,email,gender,id);

    }
}
