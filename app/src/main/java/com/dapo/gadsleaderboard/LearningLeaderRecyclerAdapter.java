package com.dapo.gadsleaderboard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LearningLeaderRecyclerAdapter extends RecyclerView.Adapter<LearningLeaderRecyclerAdapter.ViewHolder> {


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLeaderName;
        public final TextView mLeaderStats;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mLeaderName = itemView.findViewById(R.id.text_leader_name);
            mLeaderStats = itemView.findViewById(R.id.text_leader_stats);
        }
    }
}
