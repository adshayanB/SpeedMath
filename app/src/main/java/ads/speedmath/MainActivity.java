package ads.speedmath;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView result;
    TextView pointView;
    TextView sumview;
    RelativeLayout game;
    MediaPlayer mplayer;
    ArrayList <Integer> answers = new ArrayList<Integer>();
    int location;
    int score = 0;
    int numQ = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
 TextView timerView;
 Button playAgain;

 public void playAgain (View view){

     score= 0;
     numQ=0;
     timerView.setText("30s");
     pointView.setText("0/0");
     result.setText("");
     playAgain.setVisibility(View.INVISIBLE);
     questionGenerate();
     button0.setEnabled(true);
     button1.setEnabled(true);
     button2.setEnabled(true);
     button3.setEnabled(true);
     new CountDownTimer(30100,1000){

         @Override
         public void onTick(long sec) {

             timerView.setText(String.valueOf(sec/1000)+"s");

         }

         @Override
         public void onFinish() {
             playAgain.setVisibility(View.VISIBLE);
             button0.setEnabled(false);
             button1.setEnabled(false);
             button2.setEnabled(false);
             button3.setEnabled(false);
             timerView.setText("0s");
             result.setText("Your score: " + Integer.toString(score)+ "/" + Integer.toString(numQ));
             mplayer = (MediaPlayer) MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
             mplayer.start();

         }
     }.start();



 }


    public void questionGenerate (){

        Random rand = new Random();


        int a = rand.nextInt(51);
        int b = rand.nextInt(51);

        sumview.setText(Integer.toString(a) + " + " + Integer.toString(b));

        location = rand.nextInt(4);
        answers.clear();

        int wrongchoice;

        for (int i = 0; i < 4; i++) {

            if (i == location) {
                answers.add(a + b);

            } else {
                wrongchoice = rand.nextInt(101);

                while (wrongchoice == (a + b)) {

                    wrongchoice = rand.nextInt(101);
                }
                answers.add(wrongchoice);
            }


        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));



    }

    public void chooseAnswer (View view ) {

        if (view.getTag().toString().equals(Integer.toString(location))) {

            score++;
            result.setText("Correct!");

        } else {
            result.setText("Wrong!");

        }
        numQ ++;
        pointView.setText(Integer.toString(score)+ "/" + Integer.toString(numQ));
        questionGenerate();
    }

    public void start (View view){

        startButton.setVisibility(View.INVISIBLE);
        game.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainbutton));


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        pointView = findViewById(R.id.pointView);

        button0= findViewById(R.id.button0);
         button1= findViewById(R.id.button1);
         button2= findViewById(R.id.button2);
        button3= findViewById(R.id.button3);
        startButton = findViewById(R.id.startButton);
        sumview = findViewById(R.id.sumView);
        timerView = findViewById(R.id.timerView);
        playAgain=findViewById(R.id.playAgainbutton);
        game = findViewById(R.id.game);




    }



}
