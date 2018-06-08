package com.example.jack.adamant.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jack.adamant.R;

public class BuyCoinFragment extends Fragment {

    public static BuyCoinFragment newInstance(int arg) {

        Bundle args = new Bundle();
        args.putInt("ARG", arg);

        BuyCoinFragment fragment = new BuyCoinFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_coin, container, false);
    }

}
