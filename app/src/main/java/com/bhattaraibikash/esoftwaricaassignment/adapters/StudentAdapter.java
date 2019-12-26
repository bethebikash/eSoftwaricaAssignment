package com.bhattaraibikash.esoftwaricaassignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bhattaraibikash.esoftwaricaassignment.R;
import com.bhattaraibikash.esoftwaricaassignment.models.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context context;
    List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_student_card, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        final Student student = studentList.get(position);
        holder.tvName.setText(student.getName());
        holder.tvAge.setText(Integer.toString(student.getAge()));
        holder.tvAddress.setText(student.getAddress());
        holder.tvGender.setText(student.getGender());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    public class StudentViewHolder extends RecyclerView.ViewHolder {
//        ImageView ivProfile;
        TextView tvName, tvAge, tvAddress, tvGender;
        ImageButton btnDelete;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
//            ivProfile = itemView.findViewById(R.id.ivProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvGender = itemView.findViewById(R.id.tvGender);
            btnDelete = itemView.findViewById(R.id.btnDelete);

        }
    }
}