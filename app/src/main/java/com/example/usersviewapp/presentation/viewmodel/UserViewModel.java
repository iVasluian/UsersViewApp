package com.example.usersviewapp.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.usersviewapp.domain.callback.RepositoryCallback;
import com.example.usersviewapp.domain.model.User;
import com.example.usersviewapp.domain.usecase.GetUsersUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserViewModel extends ViewModel {

    private final GetUsersUseCase getUsersUseCase;

    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    @Inject
    public UserViewModel(GetUsersUseCase getUsersUseCase) {
        this.getUsersUseCase = getUsersUseCase;
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public LiveData<Boolean> getLoading() {
        return loading;
    }

    public LiveData<String> getError() {
        return error;
    }

    public void loadUsers() {

        loading.setValue(true);

        getUsersUseCase.execute(new RepositoryCallback<List<User>>() {

            @Override
            public void onSuccess(List<User> data) {

                loading.postValue(false);
                users.postValue(data);

            }

            @Override
            public void onError(String message) {

                loading.postValue(false);
                error.postValue(message);

            }
        });

    }

}