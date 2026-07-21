package com.example.usersviewapp.data.repository;

import com.example.usersviewapp.data.api.ApiService;
import com.example.usersviewapp.data.model.UserDto;
import com.example.usersviewapp.domain.callback.RepositoryCallback;
import com.example.usersviewapp.domain.model.User;
import com.example.usersviewapp.domain.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepositoryImpl implements UserRepository {

    private final ApiService apiService;

    @Inject
    public UserRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getUsers(RepositoryCallback<List<User>> callback) {

        apiService.getUsers().enqueue(new Callback<List<UserDto>>() {

            @Override
            public void onResponse(Call<List<UserDto>> call,
                                   Response<List<UserDto>> response) {

                if (!response.isSuccessful() || response.body() == null) {
                    callback.onError("Unable to fetch users.");
                    return;
                }

                List<User> users = new ArrayList<>();

                for (UserDto dto : response.body()) {

                    users.add(new User(
                            dto.getId(),
                            dto.getName(),
                            dto.getUsername(),
                            dto.getEmail(),
                            dto.getAddress().getStreet(),
                            dto.getAddress().getSuite(),
                            dto.getAddress().getCity(),
                            dto.getAddress().getZipcode(),
                            dto.getPhone(),
                            dto.getWebsite(),
                            dto.getCompany().getName()
                    ));
                }

                callback.onSuccess(users);
            }

            @Override
            public void onFailure(Call<List<UserDto>> call, Throwable t) {

                callback.onError(t.getLocalizedMessage());

            }

        });

    }
}
