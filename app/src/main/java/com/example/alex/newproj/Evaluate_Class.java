package com.example.alex.newproj;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Evaluate_Class {

    private String fullExpression, lastOp;
    private double lastAnswer, lastEvaluated;

    private boolean setNull = false;                        // if false then clear, if not just concat
    private boolean leadingOp = false;
    private boolean lastButtonPressEquals = false;
    private boolean totalReset = false;

    Pattern p = Pattern.compile("[+,\\-,*,/,.]");

    public Evaluate_Class() {

        fullExpression = "";

    }

    public double equals() {

        lastAnswer = eval(fullExpression);

        Log.d("EQUALS: ", fullExpression + ", EVAL'D: " + eval(fullExpression));

        lastButtonPressEquals = true;

        return lastAnswer;

    }

    public double evalCurrentExp() {

        int offset;


        Log.d("CURRENT EXP", fullExpression.substring(0, fullExpression.length() - 1));

        StringBuilder sb = new StringBuilder();
        sb.append(fullExpression.substring(0, fullExpression.length() - 1));
        sb.insert(0, "(");
        sb.insert(sb.length(), ")");

        Log.d("STRING BUILDER: ", sb.toString() + "EVAL STRING BUILDER: " + eval(sb.toString()) + ", PASSING FULL EXP: " + fullExpression);

//        return eval(fullExpression.substring(0, fullExpression.length() - 1));   //this needs to actually run from the front
           return eval(sb.toString());                                                                          //of the string back and stop at the first operator
                                                                                                     //because if there is a sine op then it is more than one character
                                                                                                     //possibly use a mutable regex pattern
    }

    public String getFullExpression() {
        return fullExpression;
    }

    public void clear() {

        fullExpression = "";
        lastAnswer = 0;
        totalReset = true;
        lastButtonPressEquals = false;

    }

    public void period() {

        if(fullExpression.length() > 0) {
            if (!previousCharSym()) {
                fullExpression = fullExpression + ".";
            } else {
                setClear(true);
                StringBuilder sb = new StringBuilder();
                sb.append(fullExpression);

                sb.insert(sb.length(), "0.");
                fullExpression = sb.toString();

            }

        } else {
            fullExpression = fullExpression + "0.";
        }

    }

    public boolean getClear() {
        return setNull;
    }

    public void setClear(boolean val) {
        setNull = val;
    }

    public void concatNum(int num) {

        leadingOp = true;
        fullExpression = fullExpression + String.valueOf(num);

    }

    public void concatOp(char op) {

        if(!previousCharSym()) {

            if(lastButtonPressEquals) {

                fullExpression = String.valueOf(lastAnswer);
                lastButtonPressEquals = false;
            }

            fullExpression = fullExpression + op;
            lastOp = "+";

        } else {

            StringBuilder sb = new StringBuilder();
            sb.append(fullExpression);

            sb.setCharAt(sb.length() - 1, op);
            fullExpression = sb.toString();
            lastOp = String.valueOf(op);
        }
        leadingOp = true;


    }

    public void smallMinusOp() {                  // currently the same as subtractOp() without input checking
                                                  // should eventually work like a regular plus/minus button

        fullExpression = fullExpression + "-";

    }

    private boolean previousCharSym() {

        int length;

        length = fullExpression.length();

        Matcher m = p.matcher(fullExpression.substring(length - 1));

        if(m.matches()) {

            return true;

        } else {
            return false;
        }

    }

    private static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}

