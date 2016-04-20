package com.epicodus.boggletair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.startButton) Button mStartButton;
    String[] vowels= {"a", "e", "i", "o", "u"};
    String[] consonants= {"q","w","r","t","y","u","p","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
    ArrayList<String> randomLetters = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> randomConsonants = new ArrayList<>(Arrays.asList(consonants));
                Collections.shuffle(randomConsonants);

                ArrayList<String> randomVowels = new ArrayList<>(Arrays.asList(vowels));
                Collections.shuffle(randomVowels);

                for (int i = 0; i < 6; i++) {
                    randomLetters.add(randomConsonants.get(i));
                }
                for (int i = 0; i < 2; i++) {
                    randomLetters.add(randomVowels.get(i));
                }

                String randomLettersString = new String();
                for(String s: randomLetters){
                    randomLettersString+= s + " , ";
                }
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("randomLettersString", randomLettersString);
                startActivity(intent);
            }
        });

    }
}
