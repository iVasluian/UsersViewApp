package com.example.usersviewapp.presentation.adapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.TransitionManager;

import com.example.usersviewapp.databinding.ItemUserBinding;
import com.example.usersviewapp.domain.model.User;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final ItemUserBinding binding;

    public UserViewHolder(ItemUserBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(
            User user,
            boolean expanded,
            UserClickListener listener) {

        binding.tvName.setText(user.getName());

        binding.tvEmail.setText("Email: " + user.getEmail());

        binding.tvAddress.setText(
                "Address: " + user.getFullAddress()
        );

        binding.tvPhone.setText(
                "Phone: " + user.getPhone()
        );

        TransitionManager.beginDelayedTransition(binding.cardUser);

        binding.layoutExpanded.setVisibility(
                expanded ? View.VISIBLE : View.GONE
        );

        binding.btnDetails.setOnClickListener(v ->
                listener.onDetailsClicked(user)
        );

    }

}
