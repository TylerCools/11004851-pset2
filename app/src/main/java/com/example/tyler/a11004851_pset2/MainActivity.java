package com.example.tyler.a11004851_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public int spinner_dat;
    public Spinner spinnerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void goToNextPage(View view) {
        Intent intent = new Intent(this, goTofillingIn.class);
        pickStory();;
        intent.putExtra("data", spinner_dat);
        startActivity(intent);
    }

    private void pickStory()
    {
        spinnerData = (Spinner) findViewById(R.id.spinner);
        String data_from_spinner= spinnerData.getSelectedItem().toString();

        switch(data_from_spinner) {
            case ("Random"): {
                spinner_dat = 5;
                break;
            }
            case ("Simple"): {
                spinner_dat = 0;
                break;
            }
            case ("Tarzan"): {
                spinner_dat = 1;
                break;
            }
            case ("University"): {
                spinner_dat = 2;
                break;
            }
            case ("Clothes"): {
                spinner_dat = 3;
                break;
            }
            case ("Dance"): {
                spinner_dat = 4;
                break;
            }
        }
    }
}

