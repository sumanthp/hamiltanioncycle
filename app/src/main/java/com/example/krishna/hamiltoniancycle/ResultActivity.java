package com.example.krishna.hamiltoniancycle;

/**
 * Created by Admin on 17-Nov-17.
 */

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String result = getIntent().getStringExtra("result");
        Log.v("Result",result);
        TextView result_text = (TextView)findViewById(R.id.result);
        result_text.setText("Result : "+result);
    }

}