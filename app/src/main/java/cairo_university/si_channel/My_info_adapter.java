rial_7;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class My_info_adapter extends CursorAdapter {

	    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView T1=(TextView)view.findViewById(R.id.textView7);
        TextView T2=(TextView)view.findViewById(R.id.textView8);
        TextView T3=(TextView)view.findViewById(R.id.textView9);
        double d=cursor.getDouble(cursor.getColumnIndexOrThrow("Date_time"));
        double x=System.currentTimeMillis();
        int Creation= (int) ((x-d)/60000);

        T1.setText(cursor.getString(cursor.getColumnIndex("_id")));
        T2.setText(Creation+" minute ago.");
        switch(cursor.getInt(cursor.getColumnIndex("Grade")))
        {
            case 1:
                T3.setText("First Grade");
                break;
            case 2:
                T3.setText("Second Grade");
                break;
            case 3 :
                T3.setText("Third Grade");
                break;
            case 4:
                T3.setText("Fourth Grade");
                break;
        }

    }


    public My_info_adapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.my_info_item_view, viewGroup, false);

    }