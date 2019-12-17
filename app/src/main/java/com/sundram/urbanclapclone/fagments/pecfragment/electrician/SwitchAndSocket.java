package com.sundram.urbanclapclone.fagments.pecfragment.electrician;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sundram.urbanclapclone.R;
import com.sundram.urbanclapclone.adapter.PECAdapter;
import com.sundram.urbanclapclone.datamodel.CarpenterDataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwitchAndSocket extends Fragment implements PECAdapter.OnServiceItemClick {

    private View electrician_fragment;
    private TextView view_section_heading;
    private RecyclerView recyclerView;
    private PECAdapter adapter;
    private ArrayList<CarpenterDataModel> mList;

    public SwitchAndSocket() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        electrician_fragment = inflater.inflate(R.layout.fragment_fragment_view_all_tab1, container, false);
        implementRecyclerview();
        return electrician_fragment;
    }
    public void implementRecyclerview() {
        view_section_heading = electrician_fragment.findViewById(R.id.view_section_heading);
        view_section_heading.setText("Switch and Socket");
        recyclerView = electrician_fragment.findViewById(R.id.fragment_tab_one_recycler);
        mList = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PECAdapter(getActivity(), mList, this);
        setDataToRecycler();
        recyclerView.setAdapter(adapter);
    }

    public void setDataToRecycler() {
        mList.add(new CarpenterDataModel("AC Switchbox Installation", "1254", "20"));
        mList.add(new CarpenterDataModel("Switchboard Installation(upto 6 switches)", "1254", "20"));
        mList.add(new CarpenterDataModel("Switchboard Repair(upto 6 switches)", "1254", "20"));
        mList.add(new CarpenterDataModel("Switch/Socket Replacement", "1254", "20"));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnClick(int position) {

    }
}
