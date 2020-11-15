package com.dapo.gadsleaderboard.repositories;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import com.dapo.gadsleaderboard.other.RepositoryCallback;
import com.dapo.gadsleaderboard.other.Result;
import com.dapo.gadsleaderboard.databases.LeaderBoard;
import com.dapo.gadsleaderboard.databases.LeaderBoardDao;
import com.dapo.gadsleaderboard.databases.LeaderBoardRoomDatabase;
import com.dapo.gadsleaderboard.network.APIClient;
import com.dapo.gadsleaderboard.network.APIClientInterface;
import com.dapo.gadsleaderboard.other.LeaderModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class ListRepository {


    private static APIClientInterface mAPIClientInterface;

    private LeaderBoardDao mLeaderBoardDao;

    public ListRepository(Application application) {

        LeaderBoardRoomDatabase db = LeaderBoardRoomDatabase.getDatabase(application);
        mLeaderBoardDao = db.leaderBoardDao();

    }

    public void getLearningLeaderBoard(RepositoryCallback<List<LeaderModel>> callback) {

        mAPIClientInterface = APIClient.getClient(0).create(APIClientInterface.class);

        Call<List<LeaderModel>> call = mAPIClientInterface.getLearningHoursLeaderBoard();

        call.enqueue(new Callback<List<LeaderModel>>() {
            @Override
            public void onResponse(Call<List<LeaderModel>> call, Response<List<LeaderModel>> response) {

                if(response.isSuccessful()) {
                    Result<List<LeaderModel>> result = new Result.Success<>(response.body());
                    LeaderBoard leaderBoard = new LeaderBoard();
                    leaderBoard.setLearningLeaderBoard(response.body());
                    LeaderBoardRoomDatabase.databaseWriteExecutor.execute(() -> mLeaderBoardDao.insert(leaderBoard));
                    callback.onComplete(result);
                }
            }

            @Override
            public void onFailure(Call<List<LeaderModel>> call, Throwable t) {

                Exception exception = new Exception(t.getLocalizedMessage(), t);
                Result<List<LeaderModel>> result = new Result.Error<>(exception);
                callback.onComplete(result);

            }
        });


    }

    public void getSkillIQLeaderBoard(RepositoryCallback<List<LeaderModel>> callback) {

        mAPIClientInterface = APIClient.getClient(0).create(APIClientInterface.class);

        Call<List<LeaderModel>> call = mAPIClientInterface.getSkillIQLeaderBoard();

        call.enqueue(new Callback<List<LeaderModel>>() {
            @Override
            public void onResponse(Call<List<LeaderModel>> call, Response<List<LeaderModel>> response) {
                if(response.isSuccessful()) {
                    Log.d("Okay", "It worked");
                    Result<List<LeaderModel>> result = new Result.Success<>(response.body());
                    LeaderBoard leaderBoard = new LeaderBoard();
                    leaderBoard.setSkillIQLeaderBoard(response.body());
                    LeaderBoardRoomDatabase.databaseWriteExecutor.execute(() -> mLeaderBoardDao.insert(leaderBoard));
                    callback.onComplete(result);
                }
            }

            @Override
            public void onFailure(Call<List<LeaderModel>> call, Throwable t) {

                Exception exception = new Exception(t.getLocalizedMessage(), t);
                Result<List<LeaderModel>> error = new Result.Error<>(exception);
                callback.onComplete(error);

            }
        });

    }
}
