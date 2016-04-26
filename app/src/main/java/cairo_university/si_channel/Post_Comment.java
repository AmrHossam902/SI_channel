package com.example.antou.trial_7;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Post_Comment extends AppCompatActivity {

    Query_Manager QM;
    Cursor C;
    Cursor C2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post__comment);
        Intent I=this.getIntent();
        final int id =I.getIntExtra("POST_ID",0);
        QM=Query_Manager.Create_manager(getApplicationContext());
        C=QM.selectDiscByID(id);
        C2=QM.selectCommentsByDiscID(id);
        initializepost();
        initializeComments();

        Button b=(Button)findViewById(R.id.button2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ET=(EditText)findViewById(R.id.editText2);
                if (ET.getText().toString().isEmpty())
                    return;

                QM.insertComment(ET.getText().toString(),id);
                C2=QM.selectCommentsByDiscID(id);
                initializeComments();
                ET.setText("");
            }
        });
    }

    private void initializeComments() {
        ListView LV=(ListView)findViewById(R.id.listView3);
        Comment_Adapter I=new Comment_Adapter(getApplicationContext(),C2,0);
        LV.setAdapter(I);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post__comment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
 
        return super.onOptionsItemSelected(item);
    }
}
