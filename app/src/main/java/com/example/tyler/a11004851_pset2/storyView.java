package com.example.tyler.a11004851_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class storyView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);

        getStory();
    }

    public void getStory() {
        Story receivedStory = (Story) getIntent().getExtras().getSerializable("story");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(receivedStory.toString());
    }
}
