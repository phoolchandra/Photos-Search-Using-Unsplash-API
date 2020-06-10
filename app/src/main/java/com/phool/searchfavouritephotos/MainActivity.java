package com.phool.searchfavouritephotos;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submited(View view) {

        EditText editText = findViewById(R.id.keyword);
        Button button = findViewById(R.id.submit);

        Intent replyIntent = new Intent(MainActivity.this, ImageActivity.class);
        replyIntent.putExtra("query",editText.getText().toString());
                startActivity(replyIntent);
//        Toast.makeText(this,editText.getText().toString(),Toast.LENGTH_SHORT).show();

    }
}
