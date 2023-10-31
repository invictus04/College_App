package com.example.collegeapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class facultyFragment extends Fragment {
    private RecyclerView CsDepartment,ItDepartment,MechDepartment,CivilDepartment,ElecDepartment,EleoDepartment;
    private LinearLayout CsNoData,ItNoData,MechNoData,CivilNoData,ElecNoData,EleoNoData;
    private List<TeacherData> list1, list2, list3, list4, list5, list6;
    private TeacherAdapter adapter;
    private DatabaseReference reference,DbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculty, container, false);
        CsDepartment = view.findViewById(R.id.CsDepartment);
        ItDepartment = view.findViewById(R.id.ItDepartment);
        MechDepartment = view.findViewById(R.id.MechDepartment);
        CivilDepartment = view.findViewById(R.id.CivilDepartment);
        ElecDepartment = view.findViewById(R.id.ElecDepartment);
        EleoDepartment = view.findViewById(R.id.EleoDepartment);

        CsNoData = view.findViewById(R.id.CsNoData);
        ItNoData = view.findViewById(R.id.ItNoData);
        MechNoData = view.findViewById(R.id.MechNoData);
        CivilNoData = view.findViewById(R.id.CivilNoData);
        ElecNoData = view.findViewById(R.id.ElecNoData);
        EleoNoData = view.findViewById(R.id.EleoNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("Teacher");

        CsDepartment();
        ItDepartment();
        MechDepartment();
        CivilDepartment();
        ElecDepartment();
        return view;
    }

    private void CsDepartment() {
        DbRef = reference.child("Computer Science Department");
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if(!snapshot.exists()) {
                    CsNoData.setVisibility(View.VISIBLE);
                    CsDepartment.setVisibility(View.GONE);
                } else {
                    CsNoData.setVisibility(View.GONE);
                    CsDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot s: snapshot.getChildren()) {
                        TeacherData data = s.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    CsDepartment.setHasFixedSize(true);
                    CsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    CsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ItDepartment() {
        DbRef = reference.child("IT Department");
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if(!snapshot.exists()) {
                    ItNoData.setVisibility(View.VISIBLE);
                    ItDepartment.setVisibility(View.GONE);
                } else {
                    ItNoData.setVisibility(View.GONE);
                    ItDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot s: snapshot.getChildren()) {
                        TeacherData data = s.getValue(TeacherData.class);
                        list2.add(data);
                    }

                    ItDepartment.setHasFixedSize(true);
                    ItDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    ItDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void MechDepartment() {
        DbRef = reference.child("Mechanical Department");
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if(!snapshot.exists()) {
                    MechNoData.setVisibility(View.VISIBLE);
                    MechDepartment.setVisibility(View.GONE);
                } else {
                    MechNoData.setVisibility(View.GONE);
                    MechDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot s: snapshot.getChildren()) {
                        TeacherData data = s.getValue(TeacherData.class);
                        list3.add(data);
                    }

                    MechDepartment.setHasFixedSize(true);
                    MechDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    MechDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void CivilDepartment() {
        DbRef = reference.child("Civil Department");
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if(!snapshot.exists()) {
                    CivilNoData.setVisibility(View.VISIBLE);
                    CivilDepartment.setVisibility(View.GONE);
                } else {
                    CivilNoData.setVisibility(View.GONE);
                    CivilDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot s: snapshot.getChildren()) {
                        TeacherData data = s.getValue(TeacherData.class);
                        list4.add(data);
                    }

                    CivilDepartment.setHasFixedSize(true);
                    CivilDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    CivilDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void ElecDepartment() {
        DbRef = reference.child("Electrical Department");
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list5 = new ArrayList<>();
                if(!snapshot.exists()) {
                    ElecNoData.setVisibility(View.VISIBLE);
                    ElecDepartment.setVisibility(View.GONE);
                } else {
                    ElecNoData.setVisibility(View.GONE);
                    ElecDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot s: snapshot.getChildren()) {
                        TeacherData data = s.getValue(TeacherData.class);
                        list5.add(data);
                    }

                    ElecDepartment.setHasFixedSize(true);
                    ElecDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list5, getContext());
                    ElecDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void EleoDepartment() {
        DbRef = reference.child("Electronics Department");
        DbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list6 = new ArrayList<>();
                if(!snapshot.exists()) {
                    EleoNoData.setVisibility(View.VISIBLE);
                    EleoDepartment.setVisibility(View.GONE);
                } else {
                    EleoNoData.setVisibility(View.GONE);
                    EleoDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot s: snapshot.getChildren()) {
                        TeacherData data = s.getValue(TeacherData.class);
                        list6.add(data);
                    }

                    EleoDepartment.setHasFixedSize(true);
                    EleoDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list6, getContext());
                    EleoDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
