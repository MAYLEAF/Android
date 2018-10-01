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
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ContentActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    public static final String EXTRA_MESSAGE = "com.example.Wave.MESSAGE";


    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;

    List<MenuModel> headerList = new ArrayList<>();
    HashMap<MenuModel, List<MenuModel>> childList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
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

        prepareMenuData();
        populateExpandableList();
        showMenuData(message);
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

    private void showMenuData(String message) {
        List<MenuModel> childModelsList;
        MenuModel checkModel;
        for (int i = 0; i < headerList.size(); i++) {
            checkModel = headerList.get(i);
            childModelsList = childList.get(checkModel);
            assert childModelsList != null;
            for (int j = 0; j < childModelsList.size(); j++) {
                if(childModelsList.get(j).getMenuName().equals(message)){
                    TextView toolbar = findViewById(R.id.toolbar1);
                    TextView textView = findViewById(R.id.content);

                    if (message.equals(getString(R.string.wood_property))) {
                        toolbar.setText(R.string.wood_property);
                        textView.setText(R.string.content_wood);
                    }
                    if (message.equals(getString(R.string.body_shape))) {
                        toolbar.setText(R.string.body_shape);
                        textView.setText(R.string.content_shape);
                    }
                    if (message.equals(getString(R.string.maintenance_humidity))) {
                        toolbar.setText(R.string.maintenance_humidity);
                        textView.setText(R.string.content_humid);
                    }
                    if (message.equals(getString(R.string.maintenance_temperature))) {
                        toolbar.setText(R.string.maintenance_temperature);
                        textView.setText(R.string.content_thermo);
                    }
                    if (message.equals(getString(R.string.style_strum))) {
                        toolbar.setText(R.string.style_strum);
                        textView.setText(R.string.content_strum);
                    }
                    if (message.equals(getString(R.string.style_arpezio))) {
                        toolbar.setText(R.string.style_arpezio);
                        textView.setText(R.string.content_fingerstyle);
                    }
                    if (message.equals(getString(R.string.djembe_natural))) {
                        toolbar.setText(R.string.djembe_natural);
                        textView.setText(R.string.content_natural);
                    }
                    if (message.equals(getString(R.string.djembe_artificial))) {
                        toolbar.setText(R.string.djembe_artificial);
                        textView.setText(R.string.content_artificial);
                    }

                }
            }
        }


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


}
