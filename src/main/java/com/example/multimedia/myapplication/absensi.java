package com.example.multimedia.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Output;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import android.widget.AdapterView.OnItemSelectedListener;


public class absensi extends AppCompatActivity implements OnItemSelectedListener {
String kesamaan;
String darispiner;
String item;
ProgressBar loading;
    TextView sapa;
    Button input;
    EditText keterangan;
    Spinner spinner;
    List<String> categories = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);
        sapa = (TextView) findViewById(R.id.sapa);
        sapa.setText("Hallo " + login.UsernameEt.getText()+ "!");
        //sapa.setText(login.quotes[1]);
        keterangan = (EditText)findViewById(R.id.keterangan);
        spinner = (Spinner)findViewById(R.id.spinner);
        loading = (ProgressBar)findViewById(R.id.progressBar);
        loading.setVisibility(View.GONE);
        String type ="loadabsen";
        String namasheet,ijin,kesamaan;
        namasheet= login.UsernameEt.getText().toString();
        kesamaan=namasheet;
        input = (Button) findViewById(R.id.inputs);
       // input.setEnabled(false);


// Spinner click listener

        // Spinner Drop down elements








        keterangan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
if(keterangan.getText().toString().length()>0){
   // input.setEnabled(true);
}
else{
    //input.setEnabled(false);
}
            }
        });


        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {






                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
               // Toast.makeText(context,output, duration).show();

                if(output.equals("1")){


                    categories.add("Masuk");
                    categories.add("Istirahat");
                    categories.add("Kembali");
                    categories.add("Pulang");
                    categories.add("Ijin");
                    categories.add("Sakit");
                    set();




                }
                else if(output.equals("2")){


                    categories.add("Istirahat");
                    categories.add("Kembali");
                    categories.add("Pulang");
                    categories.add("Ijin");
                    categories.add("Sakit");
                    set();

                }
                else if(output.equals("3")){

                    categories.add("Kembali");
                    categories.add("Pulang");
                    categories.add("Ijin");
                    categories.add("Sakit");
                    set();
                }
                else if(output.equals("4")){

                    categories.add("Pulang");
                    categories.add("Ijin");
                    categories.add("Sakit");
                    set();
                }

            }
        }).execute(type,namasheet);




    }


    public void inpt(View view) {



/*
        String namasheet= login.UsernameEt.getText().toString();
        String type = "inpt";
        String inpt = keterangan.getText().toString();
        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context,kesamaan, duration).show();

            }
        }).execute(type,namasheet,inpt);
*/

    }




    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();





    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    private void set(){



        //ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        spinner.setOnItemSelectedListener(this);
        //categories.add("mobil");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }


    public void inputs(final View view) {


        AlertDialog.Builder builder = new AlertDialog.Builder(absensi.this);
        builder.setTitle("Konfirmasi");
        builder.setMessage("Yakin input "+item+" ?");

        //Button One : Yes
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //Toast.makeText(absensi.this, login.quotes[1], Toast.LENGTH_LONG).show();
                quotes();
            }
        });


        //Button Two : No
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(absensi.this, "No button Clicked!", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });

/*
        //Button Three : Neutral
        builder.setNeutralButton("Can't Say!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(absensi.this, "Neutral button Clicked!", Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        }); */


        AlertDialog diag = builder.create();
        diag.show();



/*

        loading.setVisibility(View.VISIBLE);
        input.setVisibility(View.GONE);

        String namasheet= login.UsernameEt.getText().toString();
        String drspiner = item;
        String type = "spiner";
        String inpt = keterangan.getText().toString();
        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {
               // inputs.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
                input.setVisibility(View.VISIBLE);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, output, duration).show();
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);

            }
        }).execute(type,namasheet,inpt,drspiner);
        */
    }
    void gaweinput(){
        loading.setVisibility(View.VISIBLE);
        input.setVisibility(View.GONE);

        String namasheet= login.UsernameEt.getText().toString();
        String drspiner = item;
        String type = "spiner";
        String inpt = keterangan.getText().toString();
        new BackgroundWorker(this, new connectBack() {
            @Override
            public void processFinish(String output) {
                //inputs.setVisibility(View.GONE);
                loading.setVisibility(View.GONE);
                input.setVisibility(View.VISIBLE);
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_LONG;
                //Toast.makeText(context, output, duration).show();
                Toast.makeText(context, "Sukses input "+item+" pada "+ (DateFormat.getDateTimeInstance().format(new Date())).toString(), duration).show(); //buat finish absen
                Intent i = new Intent(getApplicationContext(), login.class);
                startActivity(i);

            }
        }).execute(type,namasheet,inpt,drspiner);
    }
    void quotes(){
        AlertDialog.Builder tampilquotes = new AlertDialog.Builder(absensi.this);
        //tampilquotes.setTitle("Konfirmasi");
        tampilquotes.setMessage(login.quotes[1]);

        //Button One : Yes
        tampilquotes.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gaweinput();

            }
        });
        AlertDialog diag2 = tampilquotes.create();
        diag2.show();
    }

}
