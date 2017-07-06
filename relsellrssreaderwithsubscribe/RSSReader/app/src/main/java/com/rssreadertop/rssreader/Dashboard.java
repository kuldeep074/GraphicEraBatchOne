


package com.rssreadertop.rssreader;




import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.rssreadertop.R;
import com.rssreadertop.pojo.IRSSItem;
import com.rssreadertop.pojo.RSSItem;
import com.rssreadertop.rssreader.dummy.DummyContent;

import java.util.ArrayList;


public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,RSSFragment.OnListFragmentInteractionListener {

    FrameLayout contentLayout;


    EditText title,link,description;
    ArrayList<IRSSItem> mList;

    private NavigationView navigationView;
    private ArrayList<DummyContent.DummyItem> listForSubscribedItems;

    Handler mHandlerForRSSData = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1) {
                IRSSItem localObj = mList.get(0);   /// here we are getting the first element
                title.setText(localObj.getTitle());
                link.setText(localObj.getLink());
                description.setText(((RSSItem)localObj).getDescription());
            }

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        contentLayout = (FrameLayout)findViewById(R.id.contentLayout);

        navigationView = (NavigationView)findViewById(R.id.nav_view);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        RSSFragment rssFragment = new RSSFragment();
        fragmentTransaction.replace(contentLayout.getId(),rssFragment);
        fragmentTransaction.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listForSubscribedItems = new ArrayList<>();

        DummyContent.DummyItem dummyItem = new DummyContent.DummyItem("0","Android Development","xxx");

        listForSubscribedItems.add(dummyItem);


        refreshNavigationViewItems();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        for(DummyContent.DummyItem dummyItem : listForSubscribedItems) {
            if(dummyItem.id.equalsIgnoreCase(""+id)) {
                Log.v("TAG","Open "+id);
            }
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onListFragmentInteraction(IRSSItem item) {

        /*Log.v("TAG","Touched dummy Item");
        if(!listForSubscribedItems.contains(item)) {
            listForSubscribedItems.add(item);
        }
        // add this item to database as subscribed list
        refreshNavigationViewItems();*/


    }


    public void refreshNavigationViewItems() {

        Menu menu = navigationView.getMenu();
        menu.removeGroup(0);
        for(DummyContent.DummyItem dummyItem : listForSubscribedItems) {
            menu.add(0, Integer.parseInt(dummyItem.id), 100, dummyItem.content).setIcon(R.mipmap.app_icon);
        }
    }




}
