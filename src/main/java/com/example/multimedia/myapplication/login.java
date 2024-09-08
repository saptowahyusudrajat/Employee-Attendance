package com.example.multimedia.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class login extends AppCompatActivity {

    static EditText UsernameEt,PasswordEt;
    String penampildata;
    ProgressBar loading;
    Button btnlogin;
    static String[] quotes;
    String[] separated;

    ListView lv;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin =(Button)findViewById(R.id.lgn_button);
        UsernameEt = (EditText)findViewById(R.id.lgn_uname);
        PasswordEt = (EditText)findViewById(R.id.lgnpword);
        loading = (ProgressBar)findViewById(R.id.pb_loadingnew);
        loading.setVisibility(View.GONE);
        btnlogin.setEnabled(false);

        UsernameEt.setText("");
        PasswordEt.setText("");
        UsernameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!UsernameEt.getText().toString().equals("")&&!PasswordEt.getText().toString().equals("")){
                    btnlogin.setEnabled(true);

                }
                else{
                    btnlogin.setEnabled(false);
                }

            }
        });

        PasswordEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!PasswordEt.getText().toString().equals("")&&!UsernameEt.getText().toString().equals("")){
                    btnlogin.setEnabled(true);

                }
                else{
                    btnlogin.setEnabled(false);
                }
            }
        });
    }




    public void daftar(View view) {
        startActivity(new Intent(this,frmregis.class));
    }

    public void cekuserrpas(View view) {
        String username = UsernameEt.getText().toString();
        String password = PasswordEt.getText().toString();
        String type ="loginnyar";
        loading.setVisibility(View.VISIBLE);
        btnlogin.setVisibility(View.GONE);
        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {
                //tampildata.setText(output+"hayo apaan nih");
                loading.setVisibility(View.GONE);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                //separated = output.split(" ");
                //Toast.makeText(context,String.valueOf(separated.length), duration).show();
                //tampil();

                quotes=output.split("#");

               if(quotes[0].equals("login sukses!")){
                    //if(output.equals("")){
                    Intent i = new Intent(getApplicationContext(), absensi.class);
                    startActivity(i);
                    btnlogin.setVisibility(View.VISIBLE);
                }
                else{
                    btnlogin.setVisibility(View.VISIBLE);
                }


                //Toast.makeText(context,separated[4], duration).show();
                Toast.makeText(context,quotes[0], duration).show();

            }
        }).execute(type,username,password);
    }
    public void tampil(){
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.,separated);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,separated);
        AlertDialog.Builder builder = new AlertDialog.Builder(login.this);
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
}
