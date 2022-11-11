package com.example.bai1;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView total, ques;
    Button a, b, c, d, submit;
    int currentques = 0;
    List<QuestionAnswer> list = QuestionAnswer.Getlist();
    String selectedAns = "";
    Integer Score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //anh xa view
        total = findViewById(R.id.socauhoi);
        ques = findViewById(R.id.cauhoi);
        a = findViewById(R.id.button1);
        b = findViewById(R.id.button2);
        c = findViewById(R.id.button3);
        d = findViewById(R.id.button4);
        submit = findViewById(R.id.button5);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        submit.setOnClickListener(this);

        loadQues();
    }

    private void loadQues() {

        if (currentques == list.size()) {
            new AlertDialog.Builder(this)
                    .setTitle("Kết quả")
                    .setMessage(String.format("Trả lời đúng : %d/%s", Score + 1, list.size()))
                    .setCancelable(false)
                    .setPositiveButton("Chơi lại", ((dialogInterface, i) -> restarQA()))
                    .show();
            return;
        }

        total.setText(String.format("Câu hỏi : %d/%d", currentques + 1, list.size()));
        QuestionAnswer que = list.get(currentques);
        ques.setText(que.Question);
        a.setText(que.Answer1);
        b.setText(que.Answer2);
        c.setText(que.Answer3);
        d.setText(que.Answer4);
    }

    private void restarQA() {
        Score = 0;
        currentques = 0;
        loadQues();
    }

    @Override
    public void onClick(View view) {
        a.setBackgroundColor(Color.WHITE);
        b.setBackgroundColor(Color.WHITE);
        c.setBackgroundColor(Color.WHITE);
        d.setBackgroundColor(Color.WHITE);

        Button click = (Button) view;
        if (click.getId() == R.id.button5) {

            QuestionAnswer q = list.get(currentques);
            if (q.CorrectA == 1 && selectedAns.equals(q.Answer1)
                    || q.CorrectA == 1 && selectedAns.equals(q.Answer2)
                    || q.CorrectA == 1 && selectedAns.equals(q.Answer3)
                    || q.CorrectA == 1 && selectedAns.equals(q.Answer4))
                currentques++;
            loadQues();
        } else {
            selectedAns = click.getText().toString().trim();
            click.setBackgroundColor(Color.MAGENTA);
        }
    }


}