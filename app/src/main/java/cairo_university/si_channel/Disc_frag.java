package com.example.antou.trial_7;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Disc_frag extends Fragment {

    Query_Manager QM;
    Cursor C;
    ListView LV;
    EditText ET;
    Button B;

    public Disc_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment

        QM=Query_Manager.Create_manager(Home.X);
        C=QM.Select_Disc();
        View view = inflater.inflate(R.layout.fragment_disc_frag, container, false);
        LV=(ListView)view.findViewById(R.id.listView2);
        ET=(EditText)view.findViewById(R.id.editText);
        B=(Button)view.findViewById(R.id.button);
        //Create the adapter
        C.moveToFirst();
        Information_adapter I=new Information_adapter(Home.X,C,0);
        LV.setAdapter(I);


        return view;
    }
}
