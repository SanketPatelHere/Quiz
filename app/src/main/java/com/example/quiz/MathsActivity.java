package com.example.quiz;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MathsActivity extends AppCompatActivity {
    TextView n1, question, score;
    Button btnOption1, btnOption2, btnOption3, btnOption4;
    Button btnnext, btnprevious;
    int min, max;
    int no1, no2;
    int answer;
    String finalQuestionType = "null";
    int countQuestionNumber = 1;
    static int myscore = 0;
    String questionType;
    String range;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
        n1 = (TextView)findViewById(R.id.n1);
        question = (TextView)findViewById(R.id.question);
        score = (TextView)findViewById(R.id.score);
        btnOption1 = (Button) findViewById(R.id.btnOption1);
        btnOption2 = (Button)findViewById(R.id.btnOption2);
        btnOption3 = (Button)findViewById(R.id.btnOption3);
        btnOption4 = (Button)findViewById(R.id.btnOption4);

        btnnext = (Button)findViewById(R.id.btnnext);
        btnprevious = (Button)findViewById(R.id.btnprevious);

        questionType = getIntent().getExtras().getString("questionType");
        range = getIntent().getExtras().getString("range");
        Toast.makeText(MathsActivity.this, "Question type = "+questionType+"\nselect name = "+range, Toast.LENGTH_SHORT).show();




        if(range.equalsIgnoreCase("0 - 10"))
        {   //Log.i("My","inside");
            min = 0;
            max = 10;
        }
        else if(range.equalsIgnoreCase("10 - 20"))
        {
            min = 10;
            max = 20;
        }
        else if(range.equalsIgnoreCase("20 - 30"))
        {
            min = 20;
            max = 30;
        }
        else if(range.equalsIgnoreCase("30 - 40"))
        {
            min = 30;
            max = 40;
        }
        else if(range.equalsIgnoreCase("40 - 50"))
        {
            min = 40;
            max = 50;
        }



        updateQuestion();  //first question
        if(myscore>=6)
        {
            myscore=0;
        }
        if(countQuestionNumber<=5) {
            btnOption1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.i("My an = ",btnOption1.getText().toString()+"");
                    //Log.i("My an = ",answer+"");
                    if (btnOption1.getText().toString().equalsIgnoreCase(answer + "")) {
                        myscore++;
                        updateScore(myscore);
                        updateQuestion();
                        Toast.makeText(MathsActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MathsActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });
            btnOption2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.i("My an = ",btnOption1.getText().toString()+"");
                    //Log.i("My an = ",answer+"");
                    if (btnOption2.getText().toString().equalsIgnoreCase(answer + "")) {
                        myscore++;
                        updateScore(myscore);
                        updateQuestion();
                        Toast.makeText(MathsActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MathsActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });
            btnOption3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.i("My an = ",btnOption1.getText().toString()+"");
                    //Log.i("My an = ",answer+"");
                    if (btnOption3.getText().toString().equalsIgnoreCase(answer + "")) {
                        myscore++;
                        updateScore(myscore);
                        updateQuestion();
                        Toast.makeText(MathsActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MathsActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });
            btnOption4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Log.i("My an = ",btnOption1.getText().toString()+"");
                    //Log.i("My an = ",answer+"");
                    if (btnOption4.getText().toString().equalsIgnoreCase(answer + "")) {
                        myscore++;
                        updateScore(myscore);
                        updateQuestion();
                        Toast.makeText(MathsActivity.this, "Correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MathsActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                        updateQuestion();
                    }
                }
            });

        }


        /*if(countQuestionNumber>=5)
        {
            countQuestionNumber = 0;
            btnnext.setVisibility(View.VISIBLE);
        }*/
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(countQuestionNumber>5)
                {
                    /*Intent i = new Intent(MathsActivity.this, ResultActivity.class);
                    i.putExtra("result", myscore);
                    startActivity(i);*/
                }

            }
        });

        /*btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MathsActivity.this, MathsActivity.class);
                i.putExtra("result", "totalmarks");
                startActivity(i);
            }
        });*/

    }

    public void updateQuestion()
    {
        question.setText("Question = "+countQuestionNumber+"");
        Log.i("My Score = ",myscore+"");
        if(myscore>=6)
        {
            //myscore=0;
            //score.setText("Score = "+myscore);
        }
        if(countQuestionNumber>=5)
        {   countQuestionNumber = 1;
            Intent i = new Intent(MathsActivity.this, ResultActivity.class);
            i.putExtra("result", String.valueOf(myscore));
            startActivity(i);
        }
        int num1 = new Random().nextInt((max-min)+1)+min; //(10-0+1)+0 = 11+0 = 11 = 0,10
        int num2 = new Random().nextInt((max-min)+1)+min; //(10-0+1)+0 = 11+0 = 11
        if(num1>num2)
        {
            no1 = num1;
            no2 = num2;

        }
        else if(num2>num1)
        {
            no1 = num2;
            no2 = num1;
        }
        Log.i("My Random"," Number1 = "+num1);
        Log.i("My Random"," Number2 = "+num2);
        if(questionType.equalsIgnoreCase("plus"))
        {
            n1.setText(no1+" + "+no2);
            finalQuestionType = "+";
            answer = no1+no2;
        }
        else if(questionType.equalsIgnoreCase("minus"))
        {
            n1.setText(no1+" - "+no2);
            finalQuestionType = "-";
            answer = no1-no2;
        }
        else if(questionType.equalsIgnoreCase("plusorminus"))
        {
            String type = "+-";
            Random random = new Random();
            StringBuilder sb = new StringBuilder(2);
            String s = "";
            for(int i=0;i<2;i++)
            {
                s = sb.append(type.charAt(random.nextInt(type.length()))).toString();
            }
            //finalQuestionType = s.getChars(0);
            //finalQuestionType = String.valueOf(random.nextInt(0));
            finalQuestionType = s.charAt(0)+"";
            n1.setText(no1+finalQuestionType+no2);
            if(finalQuestionType.equalsIgnoreCase("+"))
            {
                answer = no1+no2;
            }
            else
            {
                answer = no1-no2;
            }
        }
        //random answer
        Log.i("My answer = ",no1+finalQuestionType+no2+" = "+answer);
        ArrayList<Integer> list = new ArrayList();
        Random r = new Random();
        list.add(answer);
        list.add(answer+1);
        list.add(answer+2);
        list.add(answer+3);
        Log.i("My Random Answers",list.get(r.nextInt(list.size()))+"");
        Log.i("My Random Answers",list.get(0)+"");
        Log.i("My Random Answers",list.get(1)+"");
        Log.i("My Random Answers",list.get(2)+"");
        Log.i("My Random Answers",list.get(3)+"");

        ArrayList<Integer> newRandolAnswer = new ArrayList<>();
        //newRandolAnswer.add(new Random(list)+"");
        btnOption1.setText(answer+"");  //list.get(0);
        btnOption2.setText(list.get(1)+"");
        btnOption3.setText(list.get(2)+"");
        btnOption4.setText(list.get(3)+"");

        countQuestionNumber++;

    }

    public void updateScore(int myscore)
    {
        //score.setText("Score = "+myscore);
    }
}
