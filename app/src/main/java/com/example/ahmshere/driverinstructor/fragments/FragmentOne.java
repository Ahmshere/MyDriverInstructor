package com.example.ahmshere.driverinstructor.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ahmshere.driverinstructor.R;

public class FragmentOne extends Fragment{
private static final int LAYOUT = R.layout.fragment_one;
private View view;
    public static FragmentOne getInstance(){
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(LAYOUT, container, false);



        return view;
    }
}
