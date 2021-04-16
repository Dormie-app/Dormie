package com.example.dormieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    private RecyclerView rvUsers;
    protected UserAdapter adapter;
    protected List<UserAttributes> allUsers;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        rvUsers.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rvUsers.setAdapter(new UserAdapter(getContext(), allUsers));
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvUsers = view.findViewById(R.id.rvUsers);
        allUsers = new ArrayList<>();
        adapter = new UserAdapter(getContext(), allUsers);
        rvUsers.setAdapter(adapter);
        rvUsers.setLayoutManager(new LinearLayoutManager(getContext()));
        queryUsers();
    }

    private void queryUsers() {
        ParseQuery<UserAttributes> query = ParseQuery.getQuery(UserAttributes.class);
        query.findInBackground(new FindCallback<UserAttributes>() {
            @Override
            public void done(List<UserAttributes> objects, ParseException e) {
                if(e!=null){
                    Log.e("PROFILE FRAGMENT", "Error getting users", e);
                    return;
                }
                allUsers.addAll(objects);
                adapter.notifyDataSetChanged();
            }
        } );
    }
}