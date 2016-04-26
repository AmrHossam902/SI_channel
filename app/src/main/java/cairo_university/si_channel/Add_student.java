package com.example.antou.trial_7;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_student extends AppCompatActivity {

    Query_Manager QM;
    EditText ET[];
    Button B;
    Spinner Sp;
    Context C;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        Intent I=this.getIntent();
        final String id=I.getStringExtra("ID");
        ET=new EditText[2];
        ET[0]=(EditText)findViewById(R.id.editText5);
        ET[1]=(EditText)findViewById(R.id.editText6);
        Sp=(Spinner)findViewById(R.id.spinner3);

        C=this.getApplicationContext();
        String[] X=new String[4];
        for (int i=1;i<5;i++)
            X[i-1]=""+i;

        Sp.setSelection(0);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, X);
        Sp.setAdapter(adapter);
        B=(Button)findViewById(R.id.button6);
        QM=Query_Manager.Create_manager(this.getApplicationContext());
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_student, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
