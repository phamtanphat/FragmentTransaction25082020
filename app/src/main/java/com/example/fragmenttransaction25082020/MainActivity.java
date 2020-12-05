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
    Button mBtnAddAndroid, mBtnAddIos, mBtnReplaceAndroid, mBtnReplaceIos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();

        mBtnAddIos = findViewById(R.id.buttonAddios);
        mBtnAddAndroid = findViewById(R.id.buttonAddAndroid);
        mBtnReplaceAndroid = findViewById(R.id.buttonReplaceAndroid);
        mBtnReplaceIos = findViewById(R.id.buttonReplaceios);

        mBtnAddIos.setOnClickListener(onClickListener);
        mBtnAddAndroid.setOnClickListener(onClickListener);
        mBtnReplaceAndroid.setOnClickListener(onClickListener);
        mBtnReplaceIos.setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
            Fragment fragment = null;
            switch (v.getId()) {
                case R.id.buttonAddAndroid:
                    fragment = new AndroidFragment();
                    fragmentTransaction.add(R.id.liearlayoutContainer, fragment);
                    break;
                case R.id.buttonAddios:
                    fragment = new IosFragment();
                    fragmentTransaction.add(R.id.liearlayoutContainer, fragment);
                    break;
                case R.id.buttonReplaceAndroid:
                    fragment = new AndroidFragment();
                    fragmentTransaction.replace(R.id.liearlayoutContainer, fragment);
                    break;
                case R.id.buttonReplaceios :
                    fragment = new IosFragment();
                    fragmentTransaction.replace(R.id.liearlayoutContainer, fragment);
                    break;
            }
            fragmentTransaction.commit();
        }
    };
}