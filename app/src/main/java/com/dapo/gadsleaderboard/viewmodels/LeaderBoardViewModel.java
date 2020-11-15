package com.dapo.gadsleaderboard.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.dapo.gadsleaderboard.other.LeaderModel;
import com.dapo.gadsleaderboard.repositories.ListRepository;
import com.dapo.gadsleaderboard.other.Result;
import com.dapo.gadsleaderboard.databases.LeaderBoard;
import com.dapo.gadsleaderboard.databases.LeaderBoardDao;
import com.dapo.gadsleaderboard.databases.LeaderBoardRoomDatabase;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LeaderBoardViewModel extends AndroidViewModel {

    ListRepository mListRepository;



    public LiveData<Result> learningListResult;
    public MutableLiveData<Result> _learningResult;
    public LiveData<Result> skillsIQResult;
    public MutableLiveData<Result> _skillsIQResult;
    public LiveData<List<LeaderBoard>> databaseList;
    private final LeaderBoardRoomDatabase mDb;
    private final LeaderBoardDao mLeaderBoardDao;

    public LeaderBoardViewModel(@NonNull @NotNull Application application) {
        super(application);
        mListRepository = new ListRepository(application);
        mDb = LeaderBoardRoomDatabase.getDatabase(application);
        mLeaderBoardDao = mDb.leaderBoardDao();
        databaseList = mLeaderBoardDao.getList();

        _learningResult = new MutableLiveData<>();
        learningListResult = _learningResult;

        _skillsIQResult = new MutableLiveData<>();
        skillsIQResult = _skillsIQResult;

    }

    private MutableLiveData<List<LeaderModel>> skillList;


    public void loadLearningList() {

        mListRepository.getLearningLeaderBoard(result -> {
            _learningResult.postValue(result);

        });


    }

    public void loadSkillIQList() {
        mListRepository.getSkillIQLeaderBoard(result -> {
            _skillsIQResult.postValue(result);
        });
    }


}
