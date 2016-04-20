package com.epicodus.boggletair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {
    @Bind(R.id.generatedString) TextView mGeneratedString;
    @Bind(R.id.userWord) EditText mUserWord;
    @Bind(R.id.submitWordButton) TextView mSubmitWordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        final String randomLetters = intent.getStringExtra("randomLettersString");
        mGeneratedString.setText(randomLetters);

        mSubmitWordButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String userWord = mUserWord.getText().toString();
                if (userWord.length() < 3){
                    Toast.makeText(GameActivity.this, "NOT a BOGGLE word", Toast.LENGTH_SHORT).show();
                } else if (userWord.length() >= 3){


                    List<String> rightWords = new ArrayList<String>();
                    String[] userStringArray = userWord.split("");
                    String[] randomLetterStringArray = randomLetters.split("");

                    List<String> userArrayList = new ArrayList<String>(Arrays.asList(userStringArray));
                    List<String> randomLetterArrayList = new ArrayList<String>(Arrays.asList(randomLetterStringArray));
                    int counter = 0;
                    for (int i = 0; i < userArrayList.size(); i++) {
                        for (int j = 0; j < randomLetterArrayList.size(); j++) {
                            if (userArrayList.get(i).toString().equals(randomLetterArrayList.get(j).toString())) {
                                randomLetterArrayList.remove(j);
                                counter++;

                            }
                        }
                    }
                    if (counter == userArrayList.size()) {
                        rightWords.add(userWord);
                        Toast.makeText(GameActivity.this, "great word choice", Toast.LENGTH_SHORT).show();

                    }  else {
                        Toast.makeText(GameActivity.this, "NOT a BOGGLE word", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(GameActivity.this, "UNEXPECTED ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
