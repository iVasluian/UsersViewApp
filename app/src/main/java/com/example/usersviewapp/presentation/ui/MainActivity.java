package com.example.usersviewapp.presentation.ui;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.usersviewapp.R;
import com.example.usersviewapp.databinding.ActivityMainBinding;
import com.example.usersviewapp.presentation.adapter.UserAdapter;
import com.example.usersviewapp.presentation.viewmodel.UserViewModel;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private UserViewModel viewModel;

    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        adapter = new UserAdapter(user -> {

            UserDetailsDialogFragment
                    .newInstance(user)
                    .show(getSupportFragmentManager(), "details");

        });

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        observeViewModel();

        viewModel.loadUsers();
    }

    private void observeViewModel() {

        viewModel.getLoading().observe(this, loading -> {

            binding.progressBar.setVisibility(
                    loading ? View.VISIBLE : View.GONE
            );

            binding.recyclerView.setVisibility(
                    loading ? View.GONE : View.VISIBLE
            );

        });

        viewModel.getUsers().observe(this, users -> {

            adapter.setUsers(users);

        });

        viewModel.getError().observe(this, error -> {

            Snackbar.make(binding.getRoot(),
                    error,
                    Snackbar.LENGTH_LONG).show();

        });

    }
}