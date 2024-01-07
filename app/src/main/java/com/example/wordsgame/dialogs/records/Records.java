package com.example.wordsgame.dialogs.records;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.wordsgame.GameActivity;
import com.example.wordsgame.R;
import com.example.wordsgame.database.PlayerViewModel;
import com.example.wordsgame.database.entity.PlayerEntity;


public class Records extends AppCompatActivity {

    private PlayerViewModel playerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.records_page);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final PlayerListAdapter adapter = new PlayerListAdapter(new PlayerListAdapter.WordDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        playerViewModel = new ViewModelProvider(this).get(PlayerViewModel.class);

        playerViewModel.getAllPlayers().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
    }

}