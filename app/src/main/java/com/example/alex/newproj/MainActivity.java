package com.example.alex.newproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize here

        final String currentText;

        final EditText mainBox = (EditText) (findViewById(R.id.editText));
        final Evaluate_Class ec = new Evaluate_Class();

        final CheckedTextView ctv = (CheckedTextView) (findViewById(R.id.checkedExpView)); // make this scrollable to allow for infinite input

        ctv.setText("", TextView.BufferType.EDITABLE);

        Button num1 = (Button) (findViewById(R.id.button1));
        num1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                if(ec.getClear()) {
                    mainBox.setText(mainBox.getText().toString() + "1", TextView.BufferType.EDITABLE);
                }

                if(!ec.getClear()){
                    mainBox.setText("1", TextView.BufferType.EDITABLE);
                }
                ec.concatNum(1);
                ec.setClear(true);
//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);



            }

        });

        Button num2 = (Button) (findViewById(R.id.button2));
        num2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("2", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "2", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(2);
                ec.setClear(true);

 //               mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);


            }

        });

        Button num3 = (Button) (findViewById(R.id.button3));
        num3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("3", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "3", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(3);
                ec.setClear(true);


//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }

        });

        Button num4 = (Button) (findViewById(R.id.button4));
        num4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("4", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "4", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(4);
                ec.setClear(true);


//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }

        });

        Button num5 = (Button) (findViewById(R.id.button5));
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("5", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "5", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(5);
                ec.setClear(true);


//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }
        });

        Button num6 = (Button) (findViewById(R.id.button6));
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("6", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "6", TextView.BufferType.EDITABLE);
                }


                ec.concatNum(6);
                ec.setClear(true);

//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }
        });

        Button num7 = (Button) (findViewById(R.id.button7));
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("7", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "7", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(7);
                ec.setClear(true);
//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }
        });

        Button num8 = (Button) (findViewById(R.id.button8));
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("8", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "8", TextView.BufferType.EDITABLE);
                }
                ec.concatNum(8);
                ec.setClear(true);


//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }
        });

        Button num9 = (Button) (findViewById(R.id.button9));
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("9", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "9", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(9);
                ec.setClear(true);


//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }
        });

        Button num0 = (Button) (findViewById(R.id.button0));
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(!ec.getClear()) {
                    mainBox.setText("0", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "0", TextView.BufferType.EDITABLE);
                }

                ec.concatNum(0);
                ec.setClear(true);

//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }
        });

        Button plus = (Button) (findViewById(R.id.buttonPlus));
        plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.concatOp('+');

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                mainBox.setText(String.valueOf(ec.evalCurrentExp()), TextView.BufferType.EDITABLE);

                ec.setClear(false);

            }

        });

        Button minus = (Button) (findViewById(R.id.buttonMinus));
        minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.concatOp('-');

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                Log.d("my exp","EXPESSION: " + ec.getFullExpression());
                mainBox.setText(String.valueOf(ec.evalCurrentExp()), TextView.BufferType.EDITABLE); // going to add ec.evalCurrentExp()

                ec.setClear(false);

            }

        });

        Button smallMinus = (Button) (findViewById(R.id.buttonSmallMinus));
        smallMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.smallMinusOp();

                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }

        });

        Button period = (Button) (findViewById(R.id.buttonPeriod));
        period.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.period();

//                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);
//                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);


                if(ec.getClear()) {
                    mainBox.setText(mainBox.getText().toString() + ".", TextView.BufferType.EDITABLE);
                } else {
                    mainBox.setText(mainBox.getText().toString() + "0.", TextView.BufferType.EDITABLE);
                }



                ec.setClear(true);

            }

        });

        Button equals = (Button) (findViewById(R.id.buttonEquals));
        equals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);
                mainBox.setText(String.valueOf(ec.equals()), TextView.BufferType.EDITABLE);

                ec.setClear(false);

            }

        });

        Button multiply = (Button) (findViewById(R.id.buttonMultiply));
        multiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.concatOp('*');

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                mainBox.setText(String.valueOf(ec.evalCurrentExp()), TextView.BufferType.EDITABLE);

                ec.setClear(false);

            }

        });

        Button divide = (Button) (findViewById(R.id.buttonDivide));
        divide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.concatOp('/');

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                mainBox.setText(String.valueOf(ec.evalCurrentExp()), TextView.BufferType.EDITABLE);

                ec.setClear(false);

            }

        });

        Button openP = (Button) (findViewById(R.id.buttonOpen));
        openP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.concatOp('(');

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                mainBox.setText(String.valueOf(ec.getFullExpression()), TextView.BufferType.EDITABLE);

                ec.setClear(false);

            }

        });

        Button closeP = (Button) (findViewById(R.id.buttonClose));
        closeP.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.concatOp(')');

                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                mainBox.setText(String.valueOf(ec.getFullExpression()), TextView.BufferType.EDITABLE);

                ec.setClear(false);

            }

        });

        Button clear = (Button) (findViewById(R.id.buttonClear));
        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                ec.clear();
                ctv.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

                mainBox.setText(ec.getFullExpression(), TextView.BufferType.EDITABLE);

            }

        });

    }


}
