package com.example.pradeep.chatscreendemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pradeep.chatscreendemo.dbattributes.UserPojo;
import com.example.pradeep.chatscreendemo.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    DBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmajor);

        db = new DBHandler(this);

        new DBWriter().execute();//call doinbackground dbwriter

        new DBReader().execute();//call doinbackground dbreader

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.root,new ItemFragment());
        fragmentTransaction.commit();
    }


    public class DBWriter extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            UserPojo user1 = new UserPojo();
            user1.setUsername("anil");
            user1.setEmailid("pradeep.chauhan79.pc@gmail.com");
            user1.setPassword("hello");
            db.addUserData(user1);

            UserPojo user2 = new UserPojo();
            user2.setUsername("rohit");
            user2.setEmailid("rohit.saxena80.rs@gmail.com");
            user2.setPassword("heyyy");
            db.addUserData(user2);
            return null;
        }
    }


    public class DBReader extends AsyncTask<Void,Void,UserPojo> {

        @Override
        protected UserPojo doInBackground(Void... params) {
            UserPojo user = db.fetchUserData(1);
            return user;
        }

        @Override
        protected void onPostExecute(UserPojo user) {
            super.onPostExecute(user);
            Toast.makeText(MainActivity.this,user.getUsername()+ " " + user.getEmailid()+" "+user.getPassword(),Toast.LENGTH_LONG).show();

        }
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}