package com.dtlim.recyclerviewanimations

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import java.util.*

/**
 * Created by dalelim on 11/23/17.
 */
class MainActivity: AppCompatActivity() {

    private val toolbar: Toolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    private val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerview) };
    private val fab: FloatingActionButton by lazy { findViewById<FloatingActionButton>(R.id.fab) };
    private val adapter: FeedAdapter by lazy { FeedAdapter(this) }

    val rand: Random = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = FeedItemAnimator()

        adapter.setFeedItems(getDummyData())

        fab.setOnClickListener {
            appendItemToSecond()
        }
    }

    fun appendItemToSecond() {
        val item: FeedItem = FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "${rand.nextInt(60)}m")
        item.imageUrl = "http://i.imgur.com/esLt02I.jpg"
        item.location = "Philippines"
        adapter.appendItemToSecond(item)
    }

    private fun getDummyData(): MutableList<FeedItem> {
        val items = ArrayList<FeedItem>()

        var item = FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m")
        item.imageUrl = "http://i.imgur.com/esLt02I.jpg"
        item.location = "Philippines"
        items.add(item)

        item = FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m")
        item.imageUrl = "http://starecat.com/content/wp-content/uploads/you-had-one-job-pikachu-tail-ears-fail.jpg"
        item.location = "Japan"
        items.add(item)

        item = FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m")
        item.imageUrl = "https://i.imgur.com/uZQghgm.jpg"
        item.location = "USA"
        items.add(item)

        item = FeedItem("Juan Dela Cruz",
                "@jdc",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "30m")
        item.location = "Australia"
        items.add(item)

        return items
    }
}