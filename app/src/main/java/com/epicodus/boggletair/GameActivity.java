package com.epicodus.boggletair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {
    @Bind(R.id.generatedString) TextView mGeneratedString;
    @Bind(R.id.userWord) EditText mUserWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        String randomLetters = intent.getStringExtra("randomLettersString");
        mGeneratedString.setText(randomLetters);


//        for (int i = 0; i < randomLetters.size(); i++) {
//            mGeneratedString.setText(randomLetters.get(i));
//        }
    }
}
