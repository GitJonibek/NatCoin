package com.example.jack.adamant.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jack.adamant.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnChartValueSelectedListener {

    public static HomeFragment newInstance(int arg) {

        Bundle args = new Bundle();
        args.putInt("ARG", arg);

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private PieChart pieChart;
    private List<PieEntry> yvalues;
    private PieDataSet dataSet;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pieChart = view.findViewById(R.id.pie_chart);
        pieChart.setUsePercentValues(true);

        yvalues = new ArrayList<>();
        yvalues.add(new PieEntry(8f, 0));
        yvalues.add(new PieEntry(15f, 1));
        yvalues.add(new PieEntry(12f, 2));
        yvalues.add(new PieEntry(25f, 3));
        yvalues.add(new PieEntry(23f, 4));
        yvalues.add(new PieEntry(17f, 5));

        dataSet = new PieDataSet(yvalues, "Election Results");

        ArrayList<String> xVals = new ArrayList<>();

        xVals.add("January");
        xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");

        PieData data = new PieData();
        data.setDataSet(dataSet);
        data.setValueFormatter(new PercentFormatter());

        pieChart.setData(data);
        pieChart.setDescription(new Description());
        pieChart.setDrawHoleEnabled(true);
        pieChart.setTransparentCircleRadius(58f);
        pieChart.setDrawSlicesUnderHole(true);
        pieChart.setCenterText("FalCoin");
        pieChart.setCenterTextSize(18);
        pieChart.animateXY(1400, 1400);
        pieChart.setTransparentCircleColor(Color.rgb(00, 60, 64));

        pieChart.setHoleRadius(45f);
        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        data.setValueTextSize(13f);
        data.setValueTextColor(Color.DKGRAY);

        pieChart.setOnChartValueSelectedListener(this);

    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null)
            return;
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }
}
