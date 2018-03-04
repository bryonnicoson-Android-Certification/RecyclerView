package com.bryonnicoson.recyclerview;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    //private int mCount = 0;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 20; i++) {
            mWordList.add("Word" + i);
            Log.d("WordList", mWordList.getLast());
        }

        // Get a handle to the RecyclerView
        mRecyclerView = findViewById(R.id.recyclerview);
        // Create an adapter and supply the data to be displayed
        mAdapter = new WordListAdapter(this, mWordList);
        // Connect the adapter with the RecyclerView
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add a floating action click handler for creating new entries
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                // Add a new word to the end of the wordList.
                mWordList.addLast("+ Word " + wordListSize);
                // Notify the adapter of data change, update RecyclerView
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to bottom
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });
    }

}
