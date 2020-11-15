package com.dapo.gadsleaderboard.databases;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.dapo.gadsleaderboard.other.LeaderModel;
import com.dapo.gadsleaderboard.other.TypeConverter;

import java.util.List;

@Entity(tableName = "leader_board")
public class LeaderBoard {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "learning")
    @TypeConverters(TypeConverter.class)
    public List<LeaderModel> learningLeaderBoard;

    @NonNull
    @ColumnInfo(name = "skillIQ")
    public List<LeaderModel> skillIQLeaderBoard;

    public LeaderBoard() {
    }

//    public LeaderBoard(List<LeaderModel> leaderBoard) {
//        if (leaderBoard.get(0).getType() == 0) {
//            this.learningLeaderBoard = leaderBoard;
//        } else {
//            this.skillIQLeaderBoard = leaderBoard;
//        }
//
//    }

    public List<LeaderModel> getLearningLeaderBoard() {
        return learningLeaderBoard;
    }

    public List<LeaderModel> getSkillIQLeaderBoard() {
        return skillIQLeaderBoard;
    }

    public void setLearningLeaderBoard(@NonNull List<LeaderModel> learningLeaderBoard) {
        this.learningLeaderBoard = learningLeaderBoard;
    }

    public void setSkillIQLeaderBoard(@NonNull List<LeaderModel> skillIQLeaderBoard) {
        this.skillIQLeaderBoard = skillIQLeaderBoard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
