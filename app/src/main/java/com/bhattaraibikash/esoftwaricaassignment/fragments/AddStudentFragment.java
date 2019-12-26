package com.bhattaraibikash.esoftwaricaassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bhattaraibikash.esoftwaricaassignment.R;
import com.bhattaraibikash.esoftwaricaassignment.models.Students;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddStudentFragment extends Fragment {

    private Button btnSave;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale, rbOthers;
    private TextInputEditText etName, etAge, etAddress;


    public static List<Students> studentsList = new ArrayList<>();
    String name, address, gender;
    int age;

    public AddStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);

        etName = view.findViewById(R.id.etName);
        etAge = view.findViewById(R.id.etAge);
        etAddress = view.findViewById(R.id.etAddress);
        rgGender = view.findViewById(R.id.rgGender);
        rbMale = view.findViewById(R.id.rbMale);
        rbFemale = view.findViewById(R.id.rbFemale);
        rbOthers = view.findViewById(R.id.rbOthers);
        btnSave = view.findViewById(R.id.btnSave);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbMale) {
                    gender = "Male";
                }
                if (checkedId == R.id.rbFemale) {
                    gender = "Female";
                }
                if (checkedId == R.id.rbOthers) {
                    gender = "Others";
                }

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                address = etAddress.getText().toString();
                String ageSt = etAge.getText().toString();

                if(TextUtils.isEmpty(name))
                {
                    etName.setError("Enter a name");
                    return;
                }
                if(TextUtils.isEmpty(ageSt))
                {
                    etAge.setError("Enter a age");
                    return;
                }
                if(TextUtils.isEmpty(address))
                {
                    etAddress.setError("Enter a Address");
                    return;
                }
                if(TextUtils.isEmpty(gender))
                {
                    Toast.makeText(getActivity(), "Select a Gender", Toast.LENGTH_SHORT).show();
                    return;
                }

                age = Integer.parseInt(ageSt);

                studentsList.add(new Students(name,age,address,gender));
                Toast.makeText(getActivity(), "Student added", Toast.LENGTH_SHORT).show();

                etName.setText("");
                etAge.setText("");
                etAddress.setText("");
                rgGender.clearCheck();
            }
        });

        return view;
    }

}
