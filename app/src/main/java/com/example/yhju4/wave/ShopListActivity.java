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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ShopListActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static final String EXTRA_MESSAGE = "com.example.Wave.MESSAGE";


    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;

    ExpandableListAdapter shopListAdapter;
    ExpandableListView shopListView;


    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    List<MenuModel> shopKind = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> shopList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        expandableListView = findViewById(R.id.expandableListView);
        shopListView = findViewById(R.id.shopListView);

        prepareShopData();
        prepareMenuData();
        populateExpandableList();
        populateShopList();
        setTitle(message);

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
        getMenuInflater().inflate(R.menu.content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.back_arrow) {

            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void prepareMenuData() {

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel;


        MenuModel menuModel = new MenuModel("기타의 이해", true, true); //
        headerList.add(menuModel);
        childModel = new MenuModel("목재", false, false);
        childModelsList.add(childModel);
        childModel = new MenuModel("바디", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("기타 관리법", true, true); //Menu of Java Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel("온도", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("습도", false, false);
        childModelsList.add(childModel);
        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("기타 연주법", true, true); //Menu of Python Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel("스트로크", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("핑거스타일", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("젬베의 종류", true, true); //Menu of Python Tutorials
        headerList.add(menuModel);
        childModel = new MenuModel("원목", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("인조", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            childList.put(menuModel, childModelsList);
        }
    }



    private void prepareShopData() {

        List<MenuModel> childModelsList = new ArrayList<>();
        MenuModel childModel;


        MenuModel menuModel = new MenuModel("리페어샵", true, true); //
        shopKind.add(menuModel);
        childModel = new MenuModel("원미사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("흑석사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("홍익사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("연세사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("중앙사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("국민사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("두정사운드", false, false);
        childModelsList.add(childModel);

        childModel = new MenuModel("와우사운드", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            shopList.put(menuModel, childModelsList);
        }

        Collections.sort(childModelsList, MenuModel.menuModelComparator);

        childModelsList = new ArrayList<>();
        menuModel = new MenuModel("기타 카페", true, true); //Menu of Java Tutorials
        shopKind.add(menuModel);

        childModel = new MenuModel("unPlugged", false, false);
        childModelsList.add(childModel);

        if (menuModel.hasChildren) {
            shopList.put(menuModel, childModelsList);
        }

        Collections.sort(childModelsList, MenuModel.menuModelComparator);


    }





    private void populateExpandableList() {
        expandableListAdapter = new ExpandableListAdapter(this, headerList, childList);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupClickListener(new
                                                           ExpandableListView.OnGroupClickListener() {
                                                               @Override
                                                               public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                                                                   return false;
                                                               }
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

    private void populateShopList() {
        shopListAdapter = new ExpandableListAdapter(this, shopKind, shopList);
        shopListView.setAdapter( shopListAdapter);
        shopListView.setOnGroupClickListener(new
                                                           ExpandableListView.OnGroupClickListener() {
                                                               @Override
                                                               public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                                                                   return false;
                                                               }
                                                           });


        shopListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                return false;
            }
        });

    }



}
