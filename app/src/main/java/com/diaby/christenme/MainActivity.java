package com.diaby.christenme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView vName;
    private Button vWhoAmI;
    private List<String> mNames;
    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNames = Arrays.asList(getResources().getStringArray(R.array.names));
        mRandom = new Random();

        // TODO: use butterknife to reduce boiler plate
        vWhoAmI = (Button) findViewById(R.id.who_am_i);
        vName = (TextView) findViewById(R.id.name);

        vWhoAmI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vName.setText(generateName());
            }
        });
    }


    private String generateName() {
        int randomInt = mRandom.nextInt(mNames.size());
        return mNames.get(randomInt);
    }
}
