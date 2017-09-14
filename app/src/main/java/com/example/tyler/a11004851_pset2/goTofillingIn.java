package com.example.tyler.a11004851_pset2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.Random;

public class goTofillingIn extends AppCompatActivity {

    private Story story;
    private EditText editWord;
    public int spinner_data;
    public int integer;
    public int chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_tofilling_in);
        editWord =  (EditText) findViewById(R.id.EditText);
        getDropDown();
        try {
            getStory();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        editWord.setText(story.getNextPlaceholder());
    }


    public void getDropDown(){
        Intent intent = getIntent();
        spinner_data = intent.getIntExtra("data", 0);
    }
    public void goToStoryView(View view) throws IOException {
        Intent intent = new Intent(this, storyView.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("story", story);
        intent.putExtras(bundle);

        startActivity(intent);
        finish();
    }

    public void getStory() throws IOException {

        InputStream targetStream = null;
        Random rand = new Random();
        int random = rand.nextInt(5);
        if(spinner_data == 0){
            integer = 0;
        }
        else if (spinner_data == 1) {
            integer = 1;
        }
        else if (spinner_data == 2) {
            integer = 2;
        }
        else if (spinner_data == 3) {
            integer = 3;
        }
        else if (spinner_data == 4){
            integer = 4;
        }
        else {
            integer = random;
        }
        switch(integer) {
            case (0):{
                targetStream = getAssets().open("madlibs_android/madlib0_simple.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case (1): {
                targetStream = getAssets().open("madlibs_android/madlib1_tarzan.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case (2): {
                targetStream = getAssets().open("madlibs_android/madlib2_university.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case (3): {
                targetStream = getAssets().open("madlibs_android/madlib3_clothes.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
            case (4):{
                targetStream = getAssets().open("madlibs_android/madlib4_dance.txt", AssetManager.ACCESS_UNKNOWN);
                break;
            }
        }
        story = new Story(targetStream);
    }

    public void goToNextWord(View view) throws IOException {

        story.fillInPlaceholder(editWord.getText().toString());
        editWord.setText(story.getNextPlaceholder());

        if(story.isFilledIn()) {
            goToStoryView(view);
        }
    }


}
