package com.example.fragmenttransaction25082020;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.Random;

public class AndroidFragment extends Fragment {

    RelativeLayout mBackground;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        mBackground = view.findViewById(R.id.relativeBackgroundAndroid);
        mBackground.setBackgroundColor(Color.rgb(randomColor(),randomColor(),randomColor()));
        return view;
    }
    private int randomColor(){
        return new Random().nextInt(255) + 1;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("BBB","onDestroyview");
    }
}