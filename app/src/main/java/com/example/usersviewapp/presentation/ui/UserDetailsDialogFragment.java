package com.example.usersviewapp.presentation.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.usersviewapp.databinding.DialogUserDetailsBinding;
import com.example.usersviewapp.domain.model.User;

public class UserDetailsDialogFragment extends DialogFragment {

    private DialogUserDetailsBinding binding;

    public static UserDetailsDialogFragment newInstance(User user) {

        Bundle bundle = new Bundle();

        bundle.putString("name", user.getName());
        bundle.putString("username", user.getUsername());
        bundle.putString("email", user.getEmail());
        bundle.putString("phone", user.getPhone());
        bundle.putString("website", user.getWebsite());
        bundle.putString("address", user.getFullAddress());
        bundle.putString("company", user.getCompany());

        UserDetailsDialogFragment fragment =
                new UserDetailsDialogFragment();

        fragment.setArguments(bundle);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = DialogUserDetailsBinding.inflate(getLayoutInflater());

        Bundle args = getArguments();

        if (args != null) {

            binding.tvName.setText(args.getString("name"));

            binding.tvUsername.setText(
                    "Username: " + args.getString("username"));

            binding.tvEmail.setText(
                    "Email: " + args.getString("email"));

            binding.tvPhone.setText(
                    "Phone: " + args.getString("phone"));

            binding.tvWebsite.setText(
                    "Website: " + args.getString("website"));

            binding.tvAddress.setText(
                    "Address: " + args.getString("address"));

            binding.tvCompany.setText(
                    "Company: " + args.getString("company"));
        }

        binding.btnClose.setOnClickListener(v -> dismiss());

        androidx.appcompat.app.AlertDialog dialog =
                new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                        .setView(binding.getRoot())
                        .create();

        dialog.setOnShowListener(dialogInterface -> {
            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(
                        new ColorDrawable(Color.TRANSPARENT)
                );
                dialog.getWindow().setClipToOutline(false);
            }
        });

        return dialog;
    }

}
