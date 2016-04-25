package com.example.antou.trial_7;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText[]e;
    Query_Manager QM;
    static String User;
    static int Type; // 0: for students 1: Inst and admins

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User="";
        e=new EditText[2];
        e[0]=(EditText)findViewById(R.id.username_entry);
        e[1]=(EditText)findViewById(R.id.password_entry);
        QM=Query_Manager.Create_manager(this.getApplicationContext());
        QM.Backup();

    }
    
}
