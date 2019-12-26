package com.bhattaraibikash.esoftwaricaassignment.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bhattaraibikash.esoftwaricaassignment.MainActivity;
import com.bhattaraibikash.esoftwaricaassignment.R;
import com.bhattaraibikash.esoftwaricaassignment.adapters.StudentAdapter;
import com.bhattaraibikash.esoftwaricaassignment.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rvStudentList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvStudentList = view.findViewById(R.id.rvStudentList);


        if (MainActivity.studentList.isEmpty()) {

            MainActivity.studentList.add(new Student("Dipesh Dhakal", 22, "Balaju", "Male"));
            MainActivity.studentList.add(new Student("Jenifer Sharma", 26, "Baneshwor", "Female"));
            StudentAdapter studentAdapter = new StudentAdapter(getContext(), MainActivity.studentList);
            rvStudentList.setAdapter(studentAdapter);
            rvStudentList.setLayoutManager(new LinearLayoutManager(getContext()));

        } else {

            StudentAdapter studentAdapter = new StudentAdapter(getContext(), MainActivity.studentList);
            rvStudentList.setAdapter(studentAdapter);
            rvStudentList.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        return view;
    }
}
