package com.example.usersviewapp.di;

import com.example.usersviewapp.data.repository.UserRepositoryImpl;
import com.example.usersviewapp.domain.repository.UserRepository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

import javax.inject.Singleton;

@Module
@InstallIn(SingletonComponent.class)
public abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract UserRepository bindRepository(
            UserRepositoryImpl repository
    );

}
