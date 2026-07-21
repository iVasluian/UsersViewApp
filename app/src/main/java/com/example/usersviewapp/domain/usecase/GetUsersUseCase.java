package com.example.usersviewapp.domain.usecase;

import com.example.usersviewapp.domain.callback.RepositoryCallback;
import com.example.usersviewapp.domain.model.User;
import com.example.usersviewapp.domain.repository.UserRepository;

import java.util.List;

import javax.inject.Inject;


public class GetUsersUseCase {

    private final UserRepository repository;

    @Inject
    public GetUsersUseCase(UserRepository repository) {
        this.repository = repository;
    }

    public void execute(RepositoryCallback<List<User>> callback) {
        repository.getUsers(callback);
    }

}
