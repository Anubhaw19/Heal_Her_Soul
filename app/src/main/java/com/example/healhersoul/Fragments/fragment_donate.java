package com.example.healhersoul.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healhersoul.R;


public class fragment_donate extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle("Donate");
        return inflater.inflate(R.layout.fragment_donate, container, false);
    }
}
