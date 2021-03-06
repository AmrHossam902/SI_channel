package com.example.antou.trial_7;

import android.content.ContentValues;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteStatement;
import android.os.Environment;
import android.widget.Toast;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.sql.SQLData;

/**
 * Created by antou on 11/30/2015.
 */


public class DataBase_Manager extends SQLiteOpenHelper {
    private static String DB_Name = "SI_Channel.sqlite";
    private Context mContext;
    public String Path;
    private SQLiteDatabase Bookawy;

    public DataBase_Manager(Context context) {
        super(context, DB_Name, null, 1);
        this.mContext = context;
        ContextWrapper cw = new ContextWrapper(mContext.getApplicationContext());
        Path = context.getApplicationInfo().dataDir + "/databases/";


        create_DB();
        open_DB();
        Bookawy.execSQL("PRAGMA foreign_keys=ON;");
    }
    public void create_DB() {
        File f = new File(Path + DB_Name);
        if (!check_database(f)) {
            f.getParentFile().mkdirs();
            copy_DB();
        }
    }
    public void open_DB() {
        Bookawy = SQLiteDatabase.openDatabase(Path + DB_Name, null, SQLiteDatabase.OPEN_READWRITE);
        Bookawy.execSQL("PRAGMA foreign_keys=ON;");
    }
    public void close_DB() {

        if (Bookawy != null) Bookawy.close();
    }
    public void copy_DB() {
        try {
            InputStream is = mContext.getAssets().open(DB_Name);
            String ou_filename = Path + DB_Name;

            OutputStream mystream = new FileOutputStream(ou_filename);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                mystream.write(buffer, 0, length);
            }
            mystream.flush();
            mystream.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private boolean check_database(File f) {

        return f.exists();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void Backup() {
        try {

            File sd = Environment.getExternalStorageDirectory();
            File data = Environment.getDataDirectory();

            if (sd.canWrite()) {
                String currentDBPath = Path + DB_Name;
                String backupDBPath = "backupname.db";
                File currentDB = new File(currentDBPath);
                File backupDB = new File(sd, backupDBPath);

                if (currentDB.exists()) {
                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();

                }
            }
        } catch (Exception e) {

        }
    }

    ////////////////////////////////////////////EXECUTORS///////////////////////////////////////////

    public long ExecuteInsert(String sql)
    {
        long x;
        try {
            SQLiteStatement ss = Bookawy.compileStatement(sql);


            x= ss.executeInsert();
        }
        catch(Exception e)
        {
            x= -1;
        }
        return x;
    }

    public Cursor ExecuteSelect(String Sql)
    {

        Cursor c=Bookawy.rawQuery(Sql,null);


       return c;

    }


    @Override
    protected void finalize() throws Throwable {
        close_DB();
        super.finalize();
    }

    public long ExecuteDelete(String Table_name, String where) {

        //Bookawy.execSQL("PRAGMA foreign_keys=Off;");

        long x=0;
        try
        {
             x=Bookawy.delete(Table_name,where,null);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return x;
    }
}