package com.example.antou.trial_7;


import android.app.DownloadManager;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class Info_Frags extends Fragment {
    Query_Manager QM;
    Cursor C;
    ListView LV;
    public Info_Frags() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QM=Query_Manager.Create_manager(Home.X);
        C=QM.Select_info(MainActivity.getUser());
        View view = inflater.inflate(R.layout.fragment_info__frags, container, false);
        LV=(ListView)view.findViewById(R.id.listView);
        //Create the adapter
        C.moveToFirst();
        Information_adapter I=new Information_adapter(Home.X,C,0);
        LV.setAdapter(I);



        // Inflate the layout for this fragment
        return view;
    }


}
