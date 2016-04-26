package com.example.antou.trial_7;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class Information_adapter extends CursorAdapter {

    public Information_adapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }


    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.discussion_item_view, viewGroup, false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView Ins_name = (TextView) view.findViewById(R.id.I_name);
        TextView Post_content = (TextView) view.findViewById(R.id.P_content);
        TextView Creation_date = (TextView) view.findViewById(R.id.Date);

        double d=cursor.getDouble(cursor.getColumnIndexOrThrow("Date_time"));
        double x=System.currentTimeMillis();
        int Creation= (int) ((x-d)/60000);


        Ins_name.setText(cursor.getString(cursor.getColumnIndexOrThrow("_id")));  //name of ins_name column
        Post_content.setText(cursor.getString(cursor.getColumnIndexOrThrow("Content")));  //name of post_content column
        Creation_date.setText(Creation+" minutes ago");  //name of  creation_date column

    }
}
