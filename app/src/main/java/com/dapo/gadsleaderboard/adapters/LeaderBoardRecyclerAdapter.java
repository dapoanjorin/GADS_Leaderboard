package com.dapo.gadsleaderboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.dapo.gadsleaderboard.other.LeaderModel;
import com.dapo.gadsleaderboard.R;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardRecyclerAdapter extends RecyclerView.Adapter {

    private static final String TAG = "LearningLeader";

    private List<LeaderModel> leaderModelData;
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    Fragment mFragment;

    public LeaderBoardRecyclerAdapter(Context context, Fragment fragment) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mFragment = fragment;
        leaderModelData = new ArrayList<>();

    }

    public void setLeaderModelData(List<LeaderModel> leaderModelData, int viewType) {
        this.leaderModelData = leaderModelData;
        for(LeaderModel model : this.leaderModelData) {
            if(viewType == 0) {
                model.setType(0);
            } else if(viewType == 1) {
                model.setType(1);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //View viewItem = mLayoutInflater.inflate(R.layout.item_learning_leader_list, parent, false);
        View view;
        switch(viewType) {
            case LeaderModel.LEARNING_TYPE:
                view = mLayoutInflater.inflate(R.layout.item_learning_leader_list, parent, false);
                return new LearningTypeViewHolder(view);
            case LeaderModel.SKILL_IQ_TYPE:
                view = mLayoutInflater.inflate(R.layout.item_skill_iq_leader_list, parent, false);
                return new SkillIQTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (leaderModelData.get(position).getType()) {
            case 0:
                return LeaderModel.LEARNING_TYPE;
            case 1:
                return LeaderModel.SKILL_IQ_TYPE;
            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        LeaderModel leaderModel = leaderModelData.get(position);
        if(leaderModel != null) {
            switch (leaderModel.getType()) {
                case LeaderModel.LEARNING_TYPE:
                    ((LearningTypeViewHolder) holder).mLeaderName.setText(leaderModel.getName());
                    ((LearningTypeViewHolder) holder).mLeaderHours.setText(leaderModel.getHours() + " learning hours, " + leaderModel.getCountry());
                    ((LearningTypeViewHolder) holder).mImageView.setImageResource(R.drawable.top_learner);
                    break;
                    case LeaderModel.SKILL_IQ_TYPE:
                        ((SkillIQTypeViewHolder) holder).mLeaderName.setText(leaderModel.getName());
                        ((SkillIQTypeViewHolder) holder).mLeaderScore.setText(leaderModel.getHours() + " skill IQ Score, " + leaderModel.getCountry());;
                        ((SkillIQTypeViewHolder) holder).mImageView.setImageResource(R.drawable.skill_iq);
                        break;
            }
        }

    }


    @Override
    public int getItemCount() {
        return leaderModelData.size();
    }

    public class LearningTypeViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLeaderName;
        public final TextView mLeaderHours;
        public final ImageView mImageView;

        public LearningTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            mLeaderName = itemView.findViewById(R.id.text_leader_name);
            mLeaderHours = itemView.findViewById(R.id.text_leader_hours);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }

    public class SkillIQTypeViewHolder extends RecyclerView.ViewHolder {

        public final TextView mLeaderName;
        public final TextView mLeaderScore;
        public final ImageView mImageView;

        public SkillIQTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            mLeaderName = itemView.findViewById(R.id.text_leader_name);
            mLeaderScore = itemView.findViewById(R.id.text_leader_score);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }


}
