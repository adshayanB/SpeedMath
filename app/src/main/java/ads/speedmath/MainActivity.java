package ads.speedmath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView result;
    TextView pointView;
    TextView sumview;

    ArrayList <Integer> answers = new ArrayList<Integer>();
    int location;
    int score = 0;
    int numQ = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;



    public void questionGenerate (){

        Random rand = new Random();


        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumview.setText(Integer.toString(a) + " + " + Integer.toString(b));

        location = rand.nextInt(4);
        answers.clear();

        int wrongchoice;

        for (int i = 0; i < 4; i++) {

            if (i == location) {
                answers.add(a + b);

            } else {
                wrongchoice = rand.nextInt(41);

                while (wrongchoice == (a + b)) {

                    wrongchoice = rand.nextInt(41);
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
        questionGenerate();

    }



}
