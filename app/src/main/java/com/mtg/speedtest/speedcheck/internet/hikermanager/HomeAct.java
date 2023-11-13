package com.mtg.speedtest.speedcheck.internet.hikermanager;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeAct extends AppCompatActivity implements OnClickListener {
    private ListView listView;
    private ListAdapter listAdapter;
    private DatabaseHelper databaseHelper;
    private List<CommonsModel> commonsModelList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_act);
        databaseHelper = new DatabaseHelper(this);
        initData();
        initViews();
        initEvents();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initData() {
        commonsModelList = new ArrayList<>();
        commonsModelList = databaseHelper.getAllModel();
    }

    private void initViews() {
        listView = findViewById(R.id.listView);
        listAdapter = new ListAdapter(this, R.layout.item_listview, commonsModelList);
        listAdapter.setOnClickListener(this);
        listView.setAdapter(listAdapter);

    }

    private void initEvents() {
        findViewById(R.id.tvAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.tvDeleteAll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseHelper.deleteAll();
                listAdapter.clear();
                listAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDeleteItem(CommonsModel commonsModel) {
        databaseHelper.deleteModel(commonsModel);
        listAdapter.remove(commonsModel);
        listAdapter.notifyDataSetChanged();
    }
}
