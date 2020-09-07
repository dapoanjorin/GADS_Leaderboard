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

    public SkillIQLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        List<LeaderModel> leaderModels = new ArrayList<>();
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.SKILL_IQ_TYPE, "Dapo", "300 skill IQ Score", "Lagos"));

        RecyclerView recyclerView = view.findViewById(R.id.list_skill_iq_leaders);
        LearningLeaderRecyclerAdapter recyclerAdapter = new LearningLeaderRecyclerAdapter(getActivity(), leaderModels, getActivity().getSupportFragmentManager().getFragments().get(1));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);

        return view;
    }

}
