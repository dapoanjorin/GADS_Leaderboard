package com.dapo.gadsleaderboard.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {


    @NonNull
    private final Application application;

    public ViewModelFactory(@NonNull Application application) {

        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {


        if(modelClass == LeaderBoardViewModel.class) {
            return (T) new LeaderBoardViewModel(application);
        }
        return  null;
    }
}
