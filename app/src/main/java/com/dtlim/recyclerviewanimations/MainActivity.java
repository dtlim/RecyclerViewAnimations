package com.dtlim.recyclerviewanimations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private FeedAdapter adapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        adapter = new FeedAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setFeedItems(getDummyData());
    }

    private List<FeedItem> getDummyData() {
        List<FeedItem> items = new ArrayList<>();

        FeedItem item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setImageUrl("http://i.imgur.com/esLt02I.jpg");
        items.add(item);

        item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setImageUrl("http://starecat.com/content/wp-content/uploads/you-had-one-job-pikachu-tail-ears-fail.jpg");
        items.add(item);

        item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        item.setImageUrl("https://i.imgur.com/uZQghgm.jpg");
        items.add(item);

        item = new FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m");
        items.add(item);

        return items;
    }
}
