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

    private void initializepost() {

        C.moveToFirst();
        TextView TV[];
        TV=new TextView[3];

        TV[0]=(TextView)findViewById(R.id.textView);
        TV[1]=(TextView)findViewById(R.id.textView2);
        TV[2]=(TextView)findViewById(R.id.textView3);
        TV[0].setText(C.getString(C.getColumnIndex("Name")));
        TV[1].setText(C.getString(C.getColumnIndex("_id")));

        double d=C.getDouble(C.getColumnIndexOrThrow("Date_time"));
        double x=System.currentTimeMillis();
        int Creation= (int) ((x-d)/60000);
        TV[2].setText(Creation+" minutes ago.");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post__comment, menu);
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
