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

    public Cursor selectDiscByID(int id) {
        Sql="select Content as _id,Date_time,Name from Disc_Post,Stud where Disc_Post.ID='"+id+"'and Maker_id=Stud.ID";
        return DBM.ExecuteSelect(Sql);
    }

    public Cursor selectCommentsByDiscID(int id) {
        Sql="Select Content as _id,Name from Comment,Stud where Post_id=\"1\" and Maker_id=Stud.ID";
        return DBM.ExecuteSelect(Sql);

    }

    public long insertComment(String x,int id) {
        Sql="insert into Comment(Content,Post_id,Maker_id) values('"+x+"',"+id+","+MainActivity.getUser()+")";
        return DBM.ExecuteInsert(Sql);
    }

    public Cursor Select_info_of_id(String user) {
        Sql="Select Content as _id ,Date_time,Grade from Info_Post,INS_ADM where INS_ADM.ID=Info_Post.Inst_ID and INS_ADM.ID='"+user+"'";
        return DBM.ExecuteSelect(Sql);
    }

    public Long Add_info(String s,int Grade) {
        Sql="insert into Info_Post(Content,Date_time,Inst_ID,Grade) Values ('"+s+"','"+System.currentTimeMillis()+"','"+MainActivity.getUser()+"','"+Grade+"');";
        return DBM.ExecuteInsert(Sql);

    }

    public long Delete_Instructor(String id) {

        return DBM.ExecuteDelete("INS_ADM", "ID = '" + id + "'");
    }

    public long Delete_Student(String s) {
        return DBM.ExecuteDelete("Stud", "ID = '" + s + "'");
    }

    public long insertStudent(String id, String s, String s1, int selectedItem) {
        Sql="insert into Stud values('"+id+"','"+s+"','"+s1+"','"+selectedItem+"')";
        return DBM.ExecuteInsert(Sql);

    }
	
}
