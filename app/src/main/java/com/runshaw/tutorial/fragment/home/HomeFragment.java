package com.runshaw.tutorial.fragment.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.runshaw.tutorial.NotesModel;
import com.runshaw.tutorial.R;
import com.runshaw.tutorial.adapter.NotesRecyclerAdapter;
import com.runshaw.tutorial.data.DbHelper;

import java.util.List;


public class HomeFragment extends Fragment {

    DbHelper dbHelper;
    RecyclerView recyclerView;
    NotesRecyclerAdapter notesRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    private static final String TAG = "HomeFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        dbHelper = new DbHelper(getContext());

        List<NotesModel> notesModelList = dbHelper.getAllNotes();
        for (NotesModel notesmodel: notesModelList) {
            Log.d(TAG, "onViewCreated: -----------------------");
            Log.d(TAG, "onViewCreated: title ->" + notesmodel.getTitle());
            Log.d(TAG, "onViewCreated: desc ->" + notesmodel.getDesc());
            Log.d(TAG, "onViewCreated: Date ->" + notesmodel.getDate());
            Log.d(TAG, "onViewCreated: Time ->" + notesmodel.getTime());
        }
        recyclerView = view.findViewById(R.id.recyclerView);
        notesRecyclerAdapter = new NotesRecyclerAdapter();
        linearLayoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(notesRecyclerAdapter);

        notesRecyclerAdapter.setNotes(notesModelList);
    }
}