package com.example.fragmenttransaction25082020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager mFragmentManager;
    Button mBtnAddAndroid, mBtnAddIos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();

        mBtnAddIos = findViewById(R.id.buttonAddios);
        mBtnAddAndroid = findViewById(R.id.buttonAddAndroid);

        mBtnAddIos.setOnClickListener(onClickListener);
        mBtnAddAndroid.setOnClickListener(onClickListener);
    }
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            Fragment fragment = null;
            switch (v.getId()){
                case R.id.buttonAddAndroid :
                    fragment = new AndroidFragment();
                    break;
                case R.id.buttonAddios :
                    fragment = new IosFragment();
                    break;
            }
            fragmentTransaction.add(R.id.liearlayoutContainer,fragment);
            fragmentTransaction.commit();
        }
    };
}