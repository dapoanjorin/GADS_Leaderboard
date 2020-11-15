package com.dapo.gadsleaderboard.databases;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.dapo.gadsleaderboard.other.TypeConverter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@TypeConverters(TypeConverter.class)
@Database(entities = {LeaderBoard.class}, version = 1, exportSchema = true)
public abstract class LeaderBoardRoomDatabase extends RoomDatabase {

    public abstract LeaderBoardDao leaderBoardDao();

    private static volatile LeaderBoardRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static LeaderBoardRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LeaderBoardRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LeaderBoardRoomDatabase.class, "leader_board")
                            .build();
                }
            }
        }
        return INSTANCE;
    }






}
