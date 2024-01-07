package com.example.wordsgame.dialogs.records;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.wordsgame.database.entity.PlayerEntity;

public class PlayerListAdapter extends ListAdapter<PlayerEntity, PlayerViewHolder> {

    public PlayerListAdapter(@NonNull DiffUtil.ItemCallback<PlayerEntity> diffCallback) {
        super(diffCallback);
    }

    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return PlayerViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(PlayerViewHolder holder, int position) {
        PlayerEntity current = getItem(position);
        holder.bind(current.getName(), current.getScore());
    }

    static class WordDiff extends DiffUtil.ItemCallback<PlayerEntity> {

        @Override
        public boolean areItemsTheSame(@NonNull PlayerEntity oldItem, @NonNull PlayerEntity newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull PlayerEntity oldItem, @NonNull PlayerEntity newItem) {
            return (oldItem.getName().equals(newItem.getName()) && oldItem.getScore() == newItem.getScore());
        }
    }
}
