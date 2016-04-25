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
    
	
    public void Sign_in(View view)
    {
        String USER=e[0].getText().toString();
        String Pass=e[1].getText().toString();

        Cursor C=QM.isUser(USER, Pass);


        if (C.moveToFirst())
        //change last time log in
        {
            Toast.makeText(this.getApplicationContext(), "Successfully signed in :D", Toast.LENGTH_LONG).show();
            User=USER;
            Type=0;
            Intent intent =new Intent(this.getApplicationContext(),Home.class);
            startActivity(intent);
        }
        else
        {
            Cursor c2 = QM.isInst(USER,Pass);
            if (c2.moveToFirst())
            {
                User=USER;
                Type=1;
                Toast.makeText(this.getApplicationContext(), "Successfully signed in :D", Toast.LENGTH_LONG).show();
                Intent intent =new Intent(this.getApplicationContext(),Home.class);
                startActivity(intent);
            }
            else
                Toast.makeText(this.getApplicationContext(), "User Name or password is wrong", Toast.LENGTH_LONG).show();
        }

		        C.close();
    }

    public static int getType() {return Type;}
    public static String getUser()
    {
        return User;
    }

}
