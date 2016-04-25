package com.example.antou.trial_7;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class Comment_Adapter extends CursorAdapter {

    public Comment_Adapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.comment_item_view, viewGroup, false);

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView Ins_name = (TextView) view.findViewById(R.id.textView4);
        TextView Post_content = (TextView) view.findViewById(R.id.textView5);

        Ins_name.setText(cursor.getString(cursor.getColumnIndex("Name"))+": ");
        Post_content.setText(cursor.getString(cursor.getColumnIndex("_id")));
    }
}
