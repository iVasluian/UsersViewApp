package com.example.usersviewapp.presentation.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.usersviewapp.databinding.ItemUserBinding;
import com.example.usersviewapp.domain.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private final List<User> users = new ArrayList<>();

    private final UserClickListener listener;

    private int expandedPosition = RecyclerView.NO_POSITION;

    public UserAdapter(UserClickListener listener) {
        this.listener = listener;
    }

    public void setUsers(List<User> list) {

        users.clear();

        if (list != null)
            users.addAll(list);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        ItemUserBinding binding = ItemUserBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );

        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(
            @NonNull UserViewHolder holder,
            @SuppressLint("RecyclerView") int position) {

        holder.bind(
                users.get(position),
                position == expandedPosition,
                listener
        );

        holder.itemView.setOnClickListener(v -> {

            int previous = expandedPosition;

            if (expandedPosition == position)
                expandedPosition = RecyclerView.NO_POSITION;
            else
                expandedPosition = position;

            if (previous != RecyclerView.NO_POSITION)
                notifyItemChanged(previous);

            notifyItemChanged(position);

        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

}
