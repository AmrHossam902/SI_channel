package cairo_university.si_channel2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import org.json.JSONArray;


/**
 * A simple {@link Fragment} subclass.
 */
public class IA_Survey_frag extends Fragment {

    Query_Manager QM;
    ListView LV;
    Button B;
    Spinner Sp;

    public IA_Survey_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_survey_frag, container, false);
        QM=Query_Manager.Create_QM();
        LV=(ListView)v.findViewById(R.id.listView5);
        B=(Button)v.findViewById(R.id.button7);
        Sp=(Spinner)v.findViewById(R.id.spinner4);


        Integer []arr = new Integer[4];
        for (int i=0;i<4;i++)
            arr[i]=i+1;
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(Home.X, android.R.layout.simple_spinner_dropdown_item, arr);

        Sp.setSelection(0);
        Sp.setAdapter(adapter);



        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gradeyear=(int)(long)(Sp.getSelectedItemId()+1);
                //// TODO: 5/22/2016 : Insert Survey with Grader year

       //         Intent I=new Intent(Home.X ,Add_Survey.class);
       //         startActivity(I);
            }
        });

        String id=MainActivity.getUser();
        //// TODO: 5/22/2016 : Add function to return json of survey by maker id == id
/*change1*/ JSONArray JA = QM.select_surveys_IA(Integer.parseInt(id));

            survey_list_adapter SL_adapter = new survey_list_adapter(JA, Home.X);
            LV.setAdapter(SL_adapter);

        //// TODO: 5/22/2016 : Add implementation of the adapter and the layout then assign it to the ListView
        //LV.setAdapter(your new adapter);
        return v;
    }


}
