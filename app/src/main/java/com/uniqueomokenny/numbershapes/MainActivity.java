package com.uniqueomokenny.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Number {
        int number;

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number){
                x++;
                triangularNumber += x;
            }

            if (triangularNumber == number){
                return true;
            }
            else {
                return false;
            }

        }
    }

    public void makeToast(String string){
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    public void testNumber(View view){
        EditText usersNumber = findViewById(R.id.usersNumber);
        String message = "";


        if (usersNumber.getText().toString().isEmpty()){
            message = "You must enter a number";
        }

        else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(usersNumber.getText().toString());

            if (myNumber.isSquare()) {
                if (myNumber.isTriangular()) {
                    message = "Wow! " + myNumber.number + " is both Square and Triangular!";
                }
                else {
                    message = myNumber.number + " is a Square number!";
                }
            }
            else {
                if (myNumber.isTriangular()) {
                    message = myNumber.number + " is a Triangular number";
                }
                else {
                    message = myNumber.number + " is neigher Square number nor Triangular number";
                }
            }
        }
        makeToast(message);


    }

}
