package com.example.usersviewapp.domain.repository;

import com.example.usersviewapp.domain.callback.RepositoryCallback;
import com.example.usersviewapp.domain.model.User;

import java.util.List;

public interface UserRepository {

    void getUsers(RepositoryCallback<List<User>> callback);

}
