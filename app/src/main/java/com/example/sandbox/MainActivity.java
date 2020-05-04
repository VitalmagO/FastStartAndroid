package com.example.sandbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.debug(TAG, "OnCreate");

        mButton1 = findViewById(R.id.btn_1);
        mButton2 = findViewById(R.id.btn_2);
        mButton3 = findViewById(R.id.btn_3);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.btn_1:
                        switchFragment("one", R.color.red);
                        break;
                    case R.id.btn_2:
                        switchFragment("two", R.color.green);
                        break;
                    case R.id.btn_3:
                        switchFragment("three", R.color.blue);
                        break;
                }
            }
        };
        mButton1.setOnClickListener(onClickListener);
        mButton2.setOnClickListener(onClickListener);
        mButton3.setOnClickListener(onClickListener);
    }
    void switchFragment(String name, int color) {
        Fragment fragment;
        fragment = getSupportFragmentManager().findFragmentByTag(name);
        if (fragment == null) {
            fragment = SampleFragment.newInstance(name, ContextCompat.getColor(this, color));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment, name)
                    .commit();
        } else {
            Toast.makeText(this, "Не меняем", Toast.LENGTH_SHORT).show();
        }
    }
}