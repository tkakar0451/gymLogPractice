package com.example.gymlogpractice.viewHolders;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gymlogpractice.database.GymLogRepository;
import com.example.gymlogpractice.database.entities.GymLog;

import java.util.List;

public class GymLogViewModel extends AndroidViewModel {
    private final GymLogRepository repository;

    public GymLogViewModel(Application application){
        super(application);
        repository = GymLogRepository.getRepository(application);
    }

    public LiveData<List<GymLog>> getAllLogsById(int id) {
        return repository.getAllLogsByUserIdLiveData(id);
    }

    public void insert(GymLog log){
        repository.insertGymLog(log);
    }
}
