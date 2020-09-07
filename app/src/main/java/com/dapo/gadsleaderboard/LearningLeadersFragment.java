package com.dapo.gadsleaderboard;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LearningLeadersFragment extends Fragment {


    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        List<LeaderModel> leaderModels = new ArrayList<>();
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));
        leaderModels.add(new LeaderModel(LeaderModel.LEARNING_TYPE, "Dapo", "223 learning hours", "Lagos"));

        RecyclerView recyclerView = view.findViewById(R.id.list_learning_leaders);
        LearningLeaderRecyclerAdapter recyclerAdapter = new LearningLeaderRecyclerAdapter(getActivity(), leaderModels, getActivity().getSupportFragmentManager().getFragments().get(0));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerAdapter);

        return view;

    }


}
