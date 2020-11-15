package com.dapo.gadsleaderboard.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.dapo.gadsleaderboard.adapters.LeaderBoardRecyclerAdapter;
import com.dapo.gadsleaderboard.viewmodels.LeaderBoardViewModel;
import com.dapo.gadsleaderboard.other.LeaderModel;
import com.dapo.gadsleaderboard.other.Result;
import com.dapo.gadsleaderboard.databinding.FragmentLearningLeadersBinding;
import com.dapo.gadsleaderboard.viewmodels.ViewModelFactory;

import java.util.List;


public class LearningLeadersFragment extends Fragment {

    private LeaderBoardRecyclerAdapter mRecyclerAdapter;

    private FragmentLearningLeadersBinding binding;

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
        binding = FragmentLearningLeadersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        setupRecyclerView();

        LeaderBoardViewModel viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication()))
                .get(LeaderBoardViewModel.class);

        viewModel.loadLearningList();
        viewModel.learningListResult.observe(getViewLifecycleOwner(), result -> {
            if(result instanceof Result.Success) {
                List<LeaderModel> list = ((Result.Success<List<LeaderModel>>) result).data;
                mRecyclerAdapter.setLeaderModelData(list, 0);
            } else {
                loadFromDatabase(viewModel);
            }
        });


        return view;

    }

    private void loadFromDatabase(LeaderBoardViewModel viewModel) {
        viewModel.databaseList.observe(getViewLifecycleOwner(), leaderBoards -> {
            List<LeaderModel> list = leaderBoards.get(leaderBoards.size() - 1).getLearningLeaderBoard();
            mRecyclerAdapter.setLeaderModelData(list, 0);
        });
    }

    private void setupRecyclerView() {
        mRecyclerAdapter = new LeaderBoardRecyclerAdapter(getActivity(), getActivity().getSupportFragmentManager().getFragments().get(0));
        binding.listLearningLeaders.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listLearningLeaders.setAdapter(mRecyclerAdapter);
    }


}
