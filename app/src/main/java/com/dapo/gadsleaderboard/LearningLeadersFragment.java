package com.dapo.gadsleaderboard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class LearningLeadersFragment extends Fragment {

    private static final String TAG = "LearningLeader";
    private DataManager mDm;
    private RecyclerView mRecyclerView;
    private LearningLeaderRecyclerAdapter mRecyclerAdapter;
    private APIClient mApiClient;


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
        View view = inflater.inflate(R.layout.fragment_learning_leaders, container, false);

        Log.d(TAG, "onResponse: in learning leaders fragment");

        mDm = DataManager.getInstance();
        mApiClient = new APIClient(mDm);
        mRecyclerView = view.findViewById(R.id.list_learning_leaders);
        setupRecyclerView();
        mApiClient.setupLearningHoursLeaderBoard(mRecyclerAdapter);

        return view;

    }

    private void setupRecyclerView() {
        List<LeaderModel> leaderModels = mDm.getLearningHoursLeaderBoard();

        Log.d(TAG, "onResponse: " + leaderModels.size());
        mRecyclerAdapter = new LearningLeaderRecyclerAdapter(getActivity(), getActivity().getSupportFragmentManager().getFragments().get(0));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }


}
