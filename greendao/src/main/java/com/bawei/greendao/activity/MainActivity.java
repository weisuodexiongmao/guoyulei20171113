package com.bawei.greendao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bawei.greendao.Bean.User;
import com.bawei.greendao.R;
import com.bawei.greendao.gen.DaoSession;
import com.bawei.greendao.gen.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.but1);
        Button button2= (Button) findViewById(R.id.but2);
        Button button3= (Button) findViewById(R.id.but3);
        Button button4= (Button) findViewById(R.id.but4);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
       DaoSession daoSession = App.getinstance().getdaoSession();
       userDao = daoSession.getUserDao();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //增
            case R.id.but1:
                User user=new User(Long.valueOf(1),"李四");
                 userDao.insert(user);
                Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
            //删
            case R.id.but2:
              userDao.delete(userDao.load(Long.valueOf(1)));
                break;
            //改
            case R.id.but3:
                User useUpdata = userDao.load(Long.valueOf(1));
                useUpdata.setName("马七");
                userDao.update(useUpdata);
                break;
            //查
            case R.id.but4:
                //查询单个
                User user1 = userDao.load(Long.valueOf(1));
                String name = user1.getName();
                Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
                  //查询集合
                List<User> users = userDao.loadAll();
                break;
        }
    }
}
