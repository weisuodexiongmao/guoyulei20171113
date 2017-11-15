package com.bawei.greendao.activity;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.bawei.greendao.gen.DaoMaster;
import com.bawei.greendao.gen.DaoSession;

/**单列设计模式
 * Created by 猥琐的熊猫 on 2017/11/15.
 */

public class App extends Application {
    private static App mInstance;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
       mInstance=this;
        setDB();
    }


    public static App getinstance(){
return mInstance;
    }

    private void setDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "bw.db", null);
        SQLiteDatabase writableDatabase = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(writableDatabase);
        daoSession= daoMaster.newSession();
    }
public DaoSession getdaoSession(){
    return daoSession;
}
}
