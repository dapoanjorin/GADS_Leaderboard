package com.dapo.gadsleaderboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class SkillIQLeadersFragment extends Fragment {

    private DataManager mDm;
    private RecyclerView mRecyclerView;
    private LearningLeaderRecyclerAdapter mRecyclerAdapter;

    public SkillIQLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        mRecyclerView = view.findViewById(R.id.list_skill_iq_leaders);
        //mDm = DataManager.getInstance();
       // setupRecyclerView();
//        List<LeaderModel> leaderModels = new ArrayList<>();
//        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LeaderMeaderodel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));
//        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", 300, "Lagos"));

        return view;
    }

    private void setupRecyclerView() {
        List<LeaderModel> leaderModels = mDm.getSkillsIQLeaderBoard();
        mRecyclerAdapter = new LearningLeaderRecyclerAdapter(getActivity(), leaderModels, getActivity().getSupportFragmentManager().getFragments().get(1));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

}
