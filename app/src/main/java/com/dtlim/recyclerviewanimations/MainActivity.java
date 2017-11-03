package com.dtlim.recyclerviewanimations;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FeedAdapter adapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        adapter = new FeedAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // TODO 3: set the RecyclerView's item animator to FeedItemAnimator
        adapter.setFeedItems(getDummyData());

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                appendItemToSecond();
            }
        });
    }

    private void appendItemToSecond() {
        FeedItem item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                rand.nextInt(60) + "m");
        item.setImageUrl("http://i.imgur.com/esLt02I.jpg");
        item.setLocation("Philippines");
        adapter.appendItemToSecond(item);
    }

    private List<FeedItem> getDummyData() {
        List<FeedItem> items = new ArrayList<>();

        FeedItem item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setImageUrl("http://i.imgur.com/esLt02I.jpg");
        item.setLocation("Philippines");
        items.add(item);

        item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setImageUrl("http://starecat.com/content/wp-content/uploads/you-had-one-job-pikachu-tail-ears-fail.jpg");
        item.setLocation("Japan");
        items.add(item);

        item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setImageUrl("https://i.imgur.com/uZQghgm.jpg");
        item.setLocation("USA");
        items.add(item);

        item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setLocation("Australia");
        items.add(item);

        return items;
    }
}
