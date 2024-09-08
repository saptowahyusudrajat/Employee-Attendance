package com.example.multimedia.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class delete extends AppCompatActivity {
    EditText IdEt;
    ProgressBar loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        IdEt = (EditText)findViewById(R.id.et_id);
        loading = (ProgressBar)findViewById(R.id.pb_loading);
        loading.setVisibility(View.GONE);

    }

    public void delete(View view) {
        String id = IdEt.getText().toString();
        String type ="delete";
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
        }).execute(type,id);
    }
}
