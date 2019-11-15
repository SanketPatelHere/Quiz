package com.example.quiz;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    TextView tvresult;
    Button btnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvresult = (TextView)findViewById(R.id.tvresult);
        btnhome = (Button) findViewById(R.id.btnhome);
        String result = getIntent().getExtras().getString("result");
        //int wrong = 5-Integer.parseInt(result);
        Toast.makeText(ResultActivity.this, "Right Answers = "+MathsActivity.myscore, Toast.LENGTH_SHORT).show();
        tvresult.setText("Right Answers = "+result);

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
