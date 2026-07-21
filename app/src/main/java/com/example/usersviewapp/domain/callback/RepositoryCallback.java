package com.example.usersviewapp.domain.callback;

public interface RepositoryCallback<T> {

    void onSuccess(T data);

    void onError(String error);

}
