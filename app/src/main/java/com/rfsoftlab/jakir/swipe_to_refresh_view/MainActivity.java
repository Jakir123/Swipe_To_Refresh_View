package com.rfsoftlab.jakir.swipe_to_refresh_view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private RecyclerView mRecyclerView;
    private PersonsAdapter mPersonsAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private int mSwipeCount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializations();
        setupAdapter();

        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange,R.color.green,R.color.blue);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        mSwipeCount++;
                        setupAdapter();
                        mSwipeRefreshLayout.setRefreshing(false);
                        Toast.makeText(MainActivity.this, "Swipe No: "+mSwipeCount, Toast.LENGTH_SHORT).show();
                    }
                },2500);
            }
        });
    }

    private void setupAdapter() {
        mPersonsAdapter=new PersonsAdapter(this);
        mRecyclerView.setAdapter(mPersonsAdapter);
    }

    private void initializations() {

        mSwipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.activity_main_swipe_refresh_layout);
        mRecyclerView= (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        mLinearLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

    }

}
