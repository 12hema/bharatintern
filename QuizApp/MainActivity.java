package com.example.quizapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView question,questionNumber;
    private Button option1,option2,option3,option4;
    private ArrayList<QuizModule> quizModuleArrayList;
    Random random;
    int currentScore=0,questionAttempted=1,currentPos;

    public MainActivity(TextView question) {
        this.question = question;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question=findViewById(R.id.Question);
        questionNumber=findViewById(R.id.QuestionAttempted);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        quizModuleArrayList=new ArrayList<>();
        random=new Random();
        getQuizQuestion(quizModuleArrayList);
        currentPos= random.nextInt(quizModuleArrayList.size());
        setDataToViews(currentPos);

        option1.setOnClickListener(v -> {
            if(quizModuleArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option1.getText().toString().trim())){
                currentScore++;
            }
            questionAttempted++;
            currentPos=random.nextInt(quizModuleArrayList.size());
            setDataToViews(currentPos);
        });

        option2.setOnClickListener(v -> {
            if(quizModuleArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option2.getText().toString().trim())){
                currentScore++;
            }
            questionAttempted++;
            currentPos=random.nextInt(quizModuleArrayList.size());
            setDataToViews(currentPos);
        });
        option3.setOnClickListener(v -> {
            if(quizModuleArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option3.getText().toString().trim())){
                currentScore++;
            }
            questionAttempted++;
            currentPos=random.nextInt(quizModuleArrayList.size());
            setDataToViews(currentPos);
        });
        option4.setOnClickListener(v -> {
            if(quizModuleArrayList.get(currentPos).getAnswer().trim().equalsIgnoreCase(option4.getText().toString().trim())){
                currentScore++;
            }
            questionAttempted++;
            currentPos=random.nextInt(quizModuleArrayList.size());
            setDataToViews(currentPos);
        });

    }
    @SuppressLint("SetTextI18n")
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(MainActivity.this);
        View bottomSheetView= LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom, findViewById(R.id.score));
        TextView scores=bottomSheetView.findViewById(R.id.score);
        Button restartQuizBtn=bottomSheetView.findViewById(R.id.Restart);
        scores.setText("Your score is \n"+currentScore+"/10");
        restartQuizBtn.setOnClickListener(v -> {
            currentPos=random.nextInt(quizModuleArrayList.size());
            setDataToViews(currentPos);
            questionAttempted=1;
            currentScore=0;
            bottomSheetDialog.dismiss();
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
    @SuppressLint("SetTextI18n")
    private void setDataToViews(int currentPos){
        questionNumber.setText("Questions Attempted: "+questionAttempted+"/10");
        if (questionAttempted == 10) {
            showBottomSheet();
        }
        else {
            question.setText(quizModuleArrayList.get(currentPos).getQuestion());
            option1.setText(quizModuleArrayList.get(currentPos).getOption1());
            option2.setText(quizModuleArrayList.get(currentPos).getOption2());
            option3.setText(quizModuleArrayList.get(currentPos).getOption3());
            option4.setText(quizModuleArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModule> quizModuleArrayList){
        quizModuleArrayList.add(new QuizModule("which one is the smallest ocean in the world?","India","Pacific","Atlantic","Arctic","Arctic"));
        quizModuleArrayList.add(new QuizModule("which country is known as the 'playground of Europe'?","Austria","Holland","Switzerland","Italy","Switzerland"));
        quizModuleArrayList.add(new QuizModule("Total number of oceans in the world?","3","7","5","20","5"));
        quizModuleArrayList.add(new QuizModule("Which country launch the first satellite into space?","India","America","Japan","Russia","Russia"));
        quizModuleArrayList.add(new QuizModule("Where was the kiwi fruit first grown?","New Zealand","China","Australia","Chile","China"));
        quizModuleArrayList.add(new QuizModule("Flower that have been called lion's-tooth, cankerwort, Irish daisy or clock flower?","Dandelions","Catsear","Sunflower","Tulip","Dandelions"));
        quizModuleArrayList.add(new QuizModule("Maiden Queen was the nickname of:","Queen Mary","Queen Diana","Queen Elizabeth-I","Queen Elizabeth-II","Queen Elizabeth"));
        quizModuleArrayList.add(new QuizModule("The ugliest fruit in the world is?","Yuzu","Durian","Ugli","Tangor","Durian"));
        quizModuleArrayList.add(new QuizModule("What is Harry's first spell?","Rictusempra","Expelliarmus","Expecto Patronum","None of the above","Rictusempra"));
        quizModuleArrayList.add(new QuizModule("What is the name of the newspaper where Peter Parker gets a job as a photographer?","The Daily Planet","The City Examiner","The Daily Bugle","The Saturday Time","The Daily Bugle"));
    }
}