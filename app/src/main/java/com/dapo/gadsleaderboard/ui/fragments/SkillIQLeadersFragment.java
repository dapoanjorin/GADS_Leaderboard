package com.dapo.gadsleaderboard.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.dapo.gadsleaderboard.adapters.LeaderBoardRecyclerAdapter;
import com.dapo.gadsleaderboard.databases.LeaderBoard;
import com.dapo.gadsleaderboard.databinding.FragmentSkillIqLeadersBinding;
import com.dapo.gadsleaderboard.network.APIClient;
import com.dapo.gadsleaderboard.other.LeaderModel;
import com.dapo.gadsleaderboard.other.Result;
import com.dapo.gadsleaderboard.viewmodels.LeaderBoardViewModel;
import com.dapo.gadsleaderboard.viewmodels.ViewModelFactory;

import java.util.List;


public class SkillIQLeadersFragment extends Fragment {

    private LeaderBoardRecyclerAdapter mRecyclerAdapter;

    private FragmentSkillIqLeadersBinding binding;

    public SkillIQLeadersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSkillIqLeadersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setupRecyclerView();

        LeaderBoardViewModel viewModel = new ViewModelProvider(this, new ViewModelFactory(getActivity().getApplication()))
                .get(LeaderBoardViewModel.class);

        viewModel.loadSkillIQList();

        viewModel.skillsIQResult.observe(getViewLifecycleOwner(), new Observer<Result>() {
            @Override
            public void onChanged(Result result) {
                if(result instanceof Result.Success) {
                    Log.i("Okay", "working now");
                    List<LeaderModel> list = ((Result.Success<List<LeaderModel>>) result).data;
                    mRecyclerAdapter.setLeaderModelData(list, 1);
                } else {
                    loadFromDatabase(viewModel);
                }
            }
        });
        return view;
    }

    private void loadFromDatabase(LeaderBoardViewModel viewModel) {
        viewModel.databaseList.observe(getViewLifecycleOwner(), new Observer<List<LeaderBoard>>() {
            @Override
            public void onChanged(List<LeaderBoard> leaderBoards) {
                List<LeaderModel> list = leaderBoards.get(0).getSkillIQLeaderBoard();
                mRecyclerAdapter.setLeaderModelData(list, 1);
            }
        });
    }

    private void setupRecyclerView() {
        mRecyclerAdapter = new LeaderBoardRecyclerAdapter(getActivity(), getActivity().getSupportFragmentManager().getFragments().get(0));
        binding.listSkillIqLeaders.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listSkillIqLeaders.setAdapter(mRecyclerAdapter);
    }

}
