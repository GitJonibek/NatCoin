package com.example.jack.adamant.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jack.adamant.R;

public class PaymentFragment extends Fragment {

    public static PaymentFragment newInstance(int arg) {

        Bundle args = new Bundle();
        args.putInt("ARG", arg);

        PaymentFragment fragment = new PaymentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pdeals, container, false);
    }

}
