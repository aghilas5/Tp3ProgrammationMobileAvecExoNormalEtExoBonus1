package com.example.tp3;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

class PlaneteAdapter extends BaseAdapter {
    private int Posi_Spineer = 2;
    private int Posi_Check = 1;

    private Activity context;
    private ArrayList<Planete> dataSet;
    private Button verifier;

    public PlaneteAdapter(Activity context, Data data) {
        this.context = context;
        this.dataSet = data.getDataSet();
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int arg0) {
        return dataSet.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }

        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);

        verifier = (Button) context.findViewById(R.id.button);

        nomPlanete.setText(dataSet.get(position).getNom());


        ArrayList planetSizes =TailleJuste();
        final ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, planetSizes);
        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinAdapter);

        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) (compoundButton, b) -> {
            CheckBox checkBox1 = (CheckBox) compoundButton.findViewById(R.id.checkbox);
            spinner.setEnabled(!checkBox1.isChecked());
            spinAdapter.notifyDataSetChanged();


            verifier.setEnabled(CheckBoxesChecked());
        });

        return itemView;
    }



    public ArrayList SelectionTaille() {
        ArrayList r = new ArrayList();
        for (int i = 0; i < getCount(); i++) {
            ViewGroup parent = context.findViewById(R.id.listView);
            LinearLayout listItem = (LinearLayout) parent.getChildAt(i);
            Spinner s = (Spinner) listItem.getChildAt(Posi_Spineer);
            int addedValue = Integer.parseInt(s.getSelectedItem().toString());
            r.add(addedValue);
        }
        return r;
    }


    private boolean CheckBoxesChecked() {
        Boolean flag = true;
        for (int i = 0; i < getCount(); i++) {

            ViewGroup parent = context.findViewById(R.id.listView);

            LinearLayout listItem = (LinearLayout) parent.getChildAt(i);

            CheckBox cb = (CheckBox) listItem.getChildAt(Posi_Check);
            if (!cb.isChecked()) {
                flag = false;
                break;
            }
        }
        return flag;
    };

    public ArrayList TailleJuste() {
        ArrayList b = new ArrayList();
        for (Planete planet :dataSet) {
            b.add(planet.getTaille());
        }
        return b;
    }
}
