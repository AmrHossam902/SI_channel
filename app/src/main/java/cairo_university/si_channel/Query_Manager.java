package com.example.antou.trial_7;

import android.content.Context;

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

}
