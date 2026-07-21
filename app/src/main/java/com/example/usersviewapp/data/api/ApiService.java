package com.example.usersviewapp.data.api;

import com.example.usersviewapp.data.model.UserDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Call<List<UserDto>> getUsers();

}
