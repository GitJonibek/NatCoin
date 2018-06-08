package com.example.jack.adamant.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jack.adamant.R;

public class SellCoinFragment extends Fragment {

    public static SellCoinFragment newInstance(int arg) {

        Bundle args = new Bundle();
        args.putInt("ARG", arg);

        SellCoinFragment fragment = new SellCoinFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sel_coin, container, false);
    }

}
