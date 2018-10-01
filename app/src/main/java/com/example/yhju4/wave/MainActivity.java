package com.example.yhju4.wave;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        public static final String EXTRA_MESSAGE = "com.example.Wave.MESSAGE";

        ExpandableListAdapter expandableListAdapter;
        ExpandableListView expandableListView;
        List<MenuModel> headerList = new ArrayList<>();
        HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        expandableListView = findViewById(R.id.expandableListView);
        prepareMenuData();
        populateExpandableList();



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.



        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void prepareMenuData(){

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel;


        MenuModel menuModel = new MenuModel("기타의 이해", true, true);
        headerList.add(menuModel);
        childModel = new MenuModel("목재", false, false);
        childModelsList.add(childModel);
        childModel = new MenuModel("바디", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("기타 관리법", true, true);
        headerList.add(menuModel);
        childModel = new MenuModel("온도", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("습도", false, false);
        childModelsList.add(childModel);
        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("기타 연주법", true, true);
        headerList.add(menuModel);
        childModel = new MenuModel("스트로크", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("핑거스타일", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("젬베의 종류", true, true);
        headerList.add(menuModel);
        childModel = new MenuModel("원목", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("인조", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
    }


    private void populateExpandableList() {
        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener(){
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {return false; }
                });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                if (childList.get(headerList.get(groupPosition)) != null) {
                    MenuModel model = Objects.requireNonNull(childList.get(headerList.get(groupPosition))).get(childPosition);
                    Intent intent = new Intent(getApplicationContext(), ContentActivity.class);
                    String message = model.getMenuName();
                    intent.putExtra(EXTRA_MESSAGE, message);
                    startActivity(intent);
                }

                return false;
            }
        });

    }

    public void guitar(View view) {
        Intent intent = new Intent(this, DivisionActivity.class);
        String message = getString(R.string.category_guitar_comprehension);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void bath(View view) {
        Intent intent = new Intent(this, DivisionActivity.class);
        String message = getString(R.string.category_guitar_maintenance);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void pick(View view) {
        Intent intent = new Intent(this, DivisionActivity.class);
        String message = getString(R.string.category_guitar_style);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void djembe(View view) {
        Intent intent = new Intent(this, DivisionActivity.class);
        String message = getString(R.string.category_djembe);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void calendar(View view) {
        Intent intent = new Intent(this, calendarActivity.class);
        String message = getString(R.string.category_calendar);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void inform(View view) {
        Intent intent = new Intent(this, ShopListActivity.class);
        String message = getString(R.string.category_inform);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}


