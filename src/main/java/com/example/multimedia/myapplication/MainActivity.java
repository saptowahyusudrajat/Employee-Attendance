package com.example.multimedia.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {// implements connectBack{
EditText UsernameEt,PasswordEt,EmailEt,GenderEt;
String penampildata;
ProgressBar loading;
Button register,tampilin;
String[] separated;
ListView lv;
ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register =(Button)findViewById(R.id.btn_login);
        UsernameEt = (EditText)findViewById(R.id.et_username);
        PasswordEt = (EditText)findViewById(R.id.et_password);
        EmailEt =  (EditText)findViewById(R.id.et_email);
        GenderEt =  (EditText)findViewById(R.id.et_gender);
        //tampildata = (TextView)findViewById(R.id.main_tv_1);
        loading = (ProgressBar)findViewById(R.id.pb_loading);
        loading.setVisibility(View.GONE);
    }



    public void OnLogin(View view) {
       String username = UsernameEt.getText().toString();
       String password = PasswordEt.getText().toString();
       String email = EmailEt.getText().toString();
       String gender = GenderEt.getText().toString();
       String type ="login";
       loading.setVisibility(View.VISIBLE);
        UsernameEt.setEnabled(false);
        PasswordEt.setEnabled(false);
        EmailEt.setEnabled(false);
        PasswordEt.setEnabled(false);
        GenderEt.setEnabled(false);
        register.setEnabled(false);
      new BackgroundWorker(this, new connectBack() {
          @Override
          public void processFinish(String output) {
              //tampildata.setText(output+"hayo apaan nih");
              loading.setVisibility(View.GONE);
              register.setVisibility(View.VISIBLE);
              register.setEnabled(true);
              UsernameEt.setEnabled(true);
              PasswordEt.setEnabled(true);
              EmailEt.setEnabled(true);
              PasswordEt.setEnabled(true);
              GenderEt.setEnabled(true);
              Context context = getApplicationContext();
              int duration = Toast.LENGTH_SHORT;
              separated = output.split(" ");
              //Toast.makeText(context,String.valueOf(separated.length), duration).show();
              tampil();

              //Toast.makeText(context,separated[4], duration).show();
          }
      }).execute(type,username,password,email,gender);
    }

    public void tampil(){
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.,separated);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,separated);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setPositiveButton("OK",null);
        builder.setTitle("Daftar Tabel");
        //builder.setView(dataku);
        //builder.setView(dataku);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.layout, null);
        builder.setView(convertView);
        lv = (ListView) convertView.findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        AlertDialog dialog=builder.create();
        dialog.show();
    }
    public void OpenUpdate(View view){
        startActivity(new Intent(this,Update.class));
    }


    public void delete(View view) {
        startActivity(new Intent(this,delete.class));
    }





    public void masukin(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String email = EmailEt.getText().toString();
        String gender = GenderEt.getText().toString();
        String type ="masukin";
        loading.setVisibility(View.VISIBLE);
        UsernameEt.setEnabled(false);
        PasswordEt.setEnabled(false);
        EmailEt.setEnabled(false);
        PasswordEt.setEnabled(false);
        GenderEt.setEnabled(false);
        register.setEnabled(false);
        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {
                //tampildata.setText(output+"hayo apaan nih");
                loading.setVisibility(View.GONE);
                register.setVisibility(View.VISIBLE);
                register.setEnabled(true);
                UsernameEt.setEnabled(true);
                PasswordEt.setEnabled(true);
                EmailEt.setEnabled(true);
                PasswordEt.setEnabled(true);
                GenderEt.setEnabled(true);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                //Toast.makeText(context,String.valueOf(separated.length), duration).show();

                Toast.makeText(context,output, duration).show();
            }
        }).execute(type,username,password,email,gender);
    }
}


