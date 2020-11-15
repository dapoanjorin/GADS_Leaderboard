package com.dapo.gadsleaderboard.databases;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LeaderBoardDao {

    @Insert
    void insert(LeaderBoard leaderBoard);

    @Query("SELECT * FROM leader_board")
    LiveData<List<LeaderBoard>> getList();
}
