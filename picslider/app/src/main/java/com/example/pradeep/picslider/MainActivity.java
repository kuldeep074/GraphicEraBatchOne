package com.example.pradeep.picslider;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pradeep.picslider.dummy.DummyContent;

import static android.R.attr.name;
import static android.R.attr.password;
import static android.R.attr.y;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener,BlankFragment.OnFragmentInteractionListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.activity_main,new ItemFragment());
        ft.commit();
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public void onThumbNailClicked() {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.activity_main,new BlankFragment());
        ft.addToBackStack(null);//use to go back to previous fragment window(home) when pressed back button
        ft.commit();
    }

    @Override
    public void blankFragmentInteraction(Uri uri) {

    }
}
