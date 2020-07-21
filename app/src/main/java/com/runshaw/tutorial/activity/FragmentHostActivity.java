package com.runshaw.tutorial.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.runshaw.tutorial.R;
import com.runshaw.tutorial.fragment.Test2Fragment;
import com.runshaw.tutorial.fragment.TestFragment;

public class FragmentHostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_host);

        FrameLayout frameLayout = findViewById(R.id.frameLayout);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        TestFragment testFragment = new TestFragment();
        ft.add(R.id.frameLayout, testFragment);
        ft.commit();
    }

    public void initFragment1(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        TestFragment testFragment = new TestFragment();
        ft.replace(R.id.frameLayout, testFragment);
        ft.commit();
    }

    public void initFragment2(View view) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Test2Fragment test2Fragment = new Test2Fragment();
        ft.replace(R.id.frameLayout, test2Fragment);
        ft.commit();
    }
}