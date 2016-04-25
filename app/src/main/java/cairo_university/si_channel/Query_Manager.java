package com.example.antou.trial_7;

import android.content.Context;
import android.database.Cursor;


public class Query_Manager {

    static Query_Manager _instance;
    public static Query_Manager Create_manager(Context C)
    {
        if(!clones)
        {
            clones=true;
            _instance=new Query_Manager(C);
        }
        return _instance;
    }
	
    protected Query_Manager(Context C) {
        this.DBM =new DataBase_Manager(C);
    }



    public Cursor Select_info(String ID)
    {
        Sql="Select INS_ADM.NAME as _id,Content,Date_time from Stud,Info_Post,INS_ADM where Stud.id='"+ID+"' and Stud.AC_YEAR=Info_Post.Grade and INS_ADM.ID=Info_Post.Inst_ID";
        return DBM.ExecuteSelect(Sql);
    }
    public Cursor Select_Disc()
    {
        Sql = "SELECT Name as _id,Disc_Post.ID,Content,Date_time FROM Disc_Post ,Stud where Maker_id=Stud.ID order by Date_time DESC";
        return DBM.ExecuteSelect(Sql);
    }


    public Cursor isUser(String USER,String PASS)
    {
        Sql="SELECT  * FROM Stud where ID = '"+USER+"' AND Pass = '"+PASS+"'";
        return DBM.ExecuteSelect(Sql);
    }

    public void Backup()
    {
        DBM.Backup();
    }

    public Cursor isInst(String user, String pass) {
        Sql="SELECT  * FROM INS_ADM where ID = '"+user+"' AND Password = '"+pass+"'";
        return DBM.ExecuteSelect(Sql);

    }


    public long InsertPost(String content, long Time, String user) {
        Sql="insert into Disc_Post(Content,Date_time,Maker_id) values('"+content+"','"+Time+"','"+user+"')";
        return DBM.ExecuteInsert(Sql);
    }


	
}
