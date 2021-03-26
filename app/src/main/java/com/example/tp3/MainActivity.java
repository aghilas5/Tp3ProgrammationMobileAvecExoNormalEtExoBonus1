package com.example.tp3;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    PlaneteAdapter planeteadapter;
    Data data;
    Button verifier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        verifier = (Button) findViewById(R.id.button);
        verifier.setEnabled(false);
        verifier.setOnClickListener(verifierLaTaille);
        data = new Data();
        planeteadapter = new PlaneteAdapter(this, data);
        listView.setAdapter(planeteadapter);
    }

    private View.OnClickListener verifierLaTaille = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            ArrayList sizes = planeteadapter.SelectionTaille();
            ArrayList realSizes = planeteadapter.TailleJuste();


            boolean c = true;
            for (int i = 0; i < sizes.size(); i++) {
                int size = (int) sizes.get(i);
                int realSize = (int) realSizes.get(i);
                if (size != realSize) {
                    c = false;
                    break;
                }
            }
            if (c == true) {
                Toast.makeText(MainActivity.this, "Trés bien ", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Il ya une erreur quelque part", Toast.LENGTH_SHORT).show();
            }
        }
    };
}


