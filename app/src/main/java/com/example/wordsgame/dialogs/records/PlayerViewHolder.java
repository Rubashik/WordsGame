package com.example.wordsgame.dialogs.records;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wordsgame.R;

public class PlayerViewHolder extends RecyclerView.ViewHolder {

    private final TextView nameItemView;
    private final TextView scoreItemView;

    private PlayerViewHolder(@NonNull View itemView) {
        super(itemView);
        nameItemView = itemView.findViewById(R.id.name);
        scoreItemView = itemView.findViewById(R.id.score);
    }

    public void bind(String name, int score) {
        nameItemView.setText(name);
        scoreItemView.setText(String.valueOf(score));
    }

    static PlayerViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new PlayerViewHolder(view);
    }
}
