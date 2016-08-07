package com.example.android.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Stack;
//import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clrButton = (Button)findViewById(R.id.buttonC);
        clrButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        TextView tvo = (TextView)findViewById(R.id.textView);
                        if(str.length()>0&&!(str.equals("ERROR"))&&!str.equals("Infinity")&&!str.equals("NaN")) {
                            str = str.substring(0, str.length() - 1);
                            tv = (TextView) findViewById(R.id.textView);
                            tv.setText(str);
                        }
                        else if(str.equals("ERROR")||!str.equals("Infinity")||!str.equals("NaN")){
                            str = "";
                            tv = (TextView) findViewById(R.id.textView);
                            tv.setText(str);
                        }
                    }
                }
        );

        clrButton.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        TextView tvo = (TextView) findViewById(R.id.textView);
                        if (str.length() > 0) {
                            str = "";
                            tv = (TextView) findViewById(R.id.textView);
                            tv.setText(str);
                        }
                        return true;
                    }
                }
        );

        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();

    }

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    private Button plus,minus,multiply,divide,modulus,equal;
    private TextView tv;
    private String str = "";
    public boolean error=false;
    public double result;
    public boolean isEq=false;
    public boolean isSync=false;

    public void but1pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("1");
            isEq=false;
        }
        else {
            insert("1");
        }
    }

    public void but2pressed(View v) {
        isSync=false;

        if(isEq){
            str="";
            insert("2");
            isEq=false;
        }
        else {
            insert("2");
        }
    }

    public void but3pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("3");
            isEq=false;
        }
        else {
            insert("3");
        }
    }

    public void but4pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("4");
            isEq=false;
        }
        else {
            insert("4");
        }
    }

    public void but5pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("5");
            isEq=false;
        }
        else {
            insert("5");
        }
    }

    public void but6pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("6");
            isEq=false;
        }
        else {
            insert("6");
        }
    }

    public void but7pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("7");
            isEq=false;
        }
        else {
            insert("7");
        }
    }

    public void but8pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("8");
            isEq=false;
        }
        else {
            insert("8");
        }
    }

    public void but9pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("9");
            isEq=false;
        }
        else {
            insert("9");
        }
    }

    public void but0pressed(View v) {
        isSync=false;
        if(isEq){
            str="";
            insert("0");
            isEq=false;
        }
        else {
            insert("0");
        }
    }

    public void butdecimalpressed(View v) {

        isSync=false;

        if(isEq){
            str="";
            insert(".");
            isEq=false;
        }
        else {
            int present = 0;
            int pos = str.length() - 1;
            if (pos >= 0) {
                while (pos != -1) {
                    {
                        if (str.charAt(pos) == '.') {
                            present = 1;
                            break;
                        } else if (str.charAt(pos) == '+' || str.charAt(pos) == '-' || str.charAt(pos) == '*' || str.charAt(pos) == '/' || str.charAt(pos) == '%') {
                            break;
                        }
                        pos--;
                    }
                }
            }
            if (present == 1) {
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else {
                insert(".");
            }
        }
    }

    public void showToast() {
        final Toast tost = Toast.makeText(getApplicationContext(), "Invalid, Enter an operand first", Toast.LENGTH_SHORT);
        tost.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tost.cancel();
            }
        }, 500);
    }

    public void butplusminuspressed(View v){

        if(str.length()==0)
        {
            str="-";
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);
        }
        else {
            if (str.charAt(0) == '-') {
                str = str.substring(1, str.length());
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else {
                str = "-" + str;
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            }
        }
    }

    public void butpluspressed(View v) {

        isEq=false;
        if(isSync){
            str="";
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);
            showToast();
        }
        else {
            if (str.length() == 0) {
                showToast();
            } else if (str.length() == 1 && str.charAt(0) == '-') {
                str = "";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else {
                int pos = str.length() - 1;

                if (pos > 0 && ((str.charAt(pos - 1) == '*' && str.charAt(pos) == '-') || (str.charAt(pos - 1) == '/' && str.charAt(pos) == '-')|| (str.charAt(pos - 1) == '%' && str.charAt(pos) == '-'))) {
                    str = str.substring(0, str.length() - 2);
                    str = str + "+";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else if ((str.charAt(pos) == '+' || str.charAt(pos) == '-' || str.charAt(pos) == '*' || str.charAt(pos) == '/' || str.charAt(pos) == '%')) {
                    str = str.substring(0, str.length() - 1);
                    str = str + "+";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else {
                    insert("+");
                }
            }
        }
        isSync=false;
    }

    public void butminuspressed(View v) {

        isEq=false;
        if(isSync){
            str="-";
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);
        }
        else {

            if (str.length() == 0) {
                insert("-");
            } else {
                int pos = str.length() - 1;
                if (str.charAt(pos) == '+' || str.charAt(pos) == '-') {
                    str = str.substring(0, str.length() - 1);
                    str = str + "-";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else {
                    insert("-");
                }
            }
        }
        isSync=false;
    }

    public void butmultiplypressed(View v) {

        isEq=false;
        if(isSync){
            str="";
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);
            showToast();
        }
        else {

            if (str.length() == 0) {
                showToast();
            } else if (str.length() == 1 && str.charAt(0) == '-') {
                str = "";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else {
                int pos = str.length() - 1;

                if (pos > 0 && ((str.charAt(pos - 1) == '*' && str.charAt(pos) == '-') || (str.charAt(pos - 1) == '/' && str.charAt(pos) == '-')|| (str.charAt(pos - 1) == '%' && str.charAt(pos) == '-'))) {
                    str = str.substring(0, str.length() - 2);
                    str = str + "*";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else if ((str.charAt(pos) == '+' || str.charAt(pos) == '-' || str.charAt(pos) == '*' || str.charAt(pos) == '/' || str.charAt(pos) == '%')) {
                    str = str.substring(0, str.length() - 1);
                    str = str + "*";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else {
                    insert("*");
                }
            }
        }
        isSync=false;
    }

    public void butdividepressed(View v) {

        isEq=false;
        if(isSync){
            str="";
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);
            showToast();
        }
        else {
            if (str.length() == 0) {
                showToast();
            } else if (str.length() == 1 && str.charAt(0) == '-') {
                str = "";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else {
                int pos = str.length() - 1;

                if (pos > 0 && ((str.charAt(pos - 1) == '*' && str.charAt(pos) == '-') || (str.charAt(pos - 1) == '/' && str.charAt(pos) == '-')|| (str.charAt(pos - 1) == '%' && str.charAt(pos) == '-'))) {
                    str = str.substring(0, str.length() - 2);
                    str = str + "/";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else if ((str.charAt(pos) == '+' || str.charAt(pos) == '-' || str.charAt(pos) == '*' || str.charAt(pos) == '/' || str.charAt(pos) == '%')) {
                    str = str.substring(0, str.length() - 1);
                    str = str + "/";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else {
                    insert("/");
                }
            }
        }
        isSync=false;
    }

    public void butmoduluspressed(View v) {

        isEq=false;
        if(isSync){
            str="";
            tv = (TextView) findViewById(R.id.textView);
            tv.setText(str);
            showToast();
        }
        else {
            if (str.length() == 0) {
                showToast();
            } else if (str.length() == 1 && str.charAt(0) == '-') {
                str = "";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else {
                int pos = str.length() - 1;

                if (pos > 0 && ((str.charAt(pos - 1) == '*' && str.charAt(pos) == '-') || (str.charAt(pos - 1) == '/' && str.charAt(pos) == '-')|| (str.charAt(pos - 1) == '%' && str.charAt(pos) == '-'))) {
                    str = str.substring(0, str.length() - 2);
                    str = str + "%";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else if ((str.charAt(pos) == '+' || str.charAt(pos) == '-' || str.charAt(pos) == '*' || str.charAt(pos) == '/' || str.charAt(pos) == '%')) {
                    str = str.substring(0, str.length() - 1);
                    str = str + "%";
                    tv = (TextView) findViewById(R.id.textView);
                    tv.setText(str);
                } else {
                    insert("%");
                }
            }
        }
        isSync=false;
    }

    public boolean checker(){

        if(str.length()>2)
        {
            int i=0;
            while(i!=(str.length()-1)){
                if(str.charAt(i)=='%'&&((str.charAt(i+1)<=57&&str.charAt(i+1)>=48)||str.charAt(i+1)=='.'))
                    return false;
                i++;
            }
        }
        if((str.length()==1&&str.charAt(0)=='.'))
            return false;
        if(str.length()>1&&str.charAt(0)=='.'&&!(str.charAt(1)>=48&&str.charAt(1)<=57))
            return false;

        if((str.charAt(str.length()-1)=='.'&&!(str.charAt(str.length()-2)>=48&&str.charAt(str.length()-2)<=57)))
            return false;
        if(!((str.charAt(str.length()-1)>=48&&str.charAt(str.length()-1)<=57)||(str.charAt(str.length()-1)=='.')||str.charAt(str.length()-1)=='%'))
            return false;
        if(!((str.charAt(0)>=48&&str.charAt(0)<=57)||str.charAt(0)=='.'||str.charAt(0)=='-'))
            return false;

        return true;
    }

    public void butequalpressed(View v) {

        isEq=true;
        int i = 0;
        String res = "";
        if(str.length()>0) {
            if (!checker()) {
                str = "ERROR";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
                isSync = true;
            } /**else if (zero() == 1) {
                str = "NaN";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            } else if (zero() == 2) {
                str = "Infinity";
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
            }**/
             else {

                while (i < str.length()) {
                    if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                        res = res + str.charAt(0);
                    } else if (i == str.length() - 1) {
                        res = res + str.charAt(i);
                    }  else if (((str.charAt(i) >= 48 && str.charAt(i) <= 57)||str.charAt(i)=='.') && (str.charAt(i + 1) == '+' || str.charAt(i + 1) == '-' || str.charAt(i + 1) == '*' || str.charAt(i + 1) == '/' || str.charAt(i + 1) == '%')) {
                        res = res + str.charAt(i) + " ";
                    } else if (str.charAt(i) == '-' && (str.charAt(i - 1) == '*' || str.charAt(i - 1) == '/'|| str.charAt(i - 1) == '%')) {
                        res = res + " " + str.charAt(i);
                    } else if ((str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '*' || str.charAt(i) == '/' || str.charAt(i) == '%') && ((str.charAt(i + 1) >= 48 && str.charAt(i + 1) <= 57) || str.charAt(i + 1) == '.')) {
                        res = res + str.charAt(i) + " ";
                    } else {
                        res = res + str.charAt(i);
                    }

                    i++;
                }
                str = res;
                String arr[] = str.split(" ");

                Stack<Double> operands = new Stack<Double>();
                Stack<String> operators = new Stack<String>();
                int j = 0;

                while (j < arr.length) {
                    if (j % 2 == 0) {
                        operands.push(Double.parseDouble(arr[j]));
                    } else if (arr[j].equals("+") || arr[j].equals("-") || arr[j].equals("*") || arr[j].equals("/") || arr[j].equals("%")) {


                        while (operators.empty() == false && precedence(arr[j], operators.peek())) {
                            double val2 = operands.pop();
                            double val1 = operands.pop();
                            String operation = operators.pop();

                            if (operation.equals("%")) {
                                operands.push(val1 % val2);
                            } else if (operation.equals("*")) {
                                operands.push(val1 * val2);
                            } else if (operation.equals("/")) {
                                /**if (val2 == 0) {
                                    //toast
                                    throw new
                                            UnsupportedOperationException("Cannot divide by zero");
                                } else**/ {
                                    operands.push(val1 / val2);
                                }
                            } else if (operation.equals("+")) {
                                operands.push(val1 + val2);
                            } else if (operation.equals("-")) {
                                operands.push(val1 - val2);
                            }

                        }
                        operators.push(arr[j]);
                    }
                    j++;
                }

                while (operators.empty() == false) {

                    double val4=operands.pop();
                    double val3=+1;
                    if(!operands.empty())
                        val3=operands.pop();


                    String operatio=operators.pop();


                    if(operatio.equals("%")) {
                        String prev="@";
                        if(!operators.empty())
                            prev=operators.pop();
                        if(prev.equals("+"))
                        {
                            operands.push(val3+(val4/100*val3));
                        }
                        else if(prev.equals("-"))
                        {
                            operands.push(val3-(val4/100*val3));
                        }
                        else if(prev.equals("*"))
                        {
                            operands.push(val3*val4/100);
                        }
                        else if(prev.equals("/"))
                        {
                            operands.push(val3/val4*100);
                        }
                        else
                        {
                            operands.push(0.0);
                        }

                    } else if (operatio.equals("*")) {
                        operands.push(val3 * val4);
                    } else if (operatio.equals("/")) {
                        /**if (val4 == 0) {
                            //toast
                            throw new
                                    UnsupportedOperationException("Cannot divide by zero");
                        } else **/{
                            operands.push(val3 / val4);
                        }
                    } else if (operatio.equals("+")) {
                        operands.push(val3 + val4);
                    } else if (operatio.equals("-")) {
                        operands.push(val3 - val4);
                    }
                }

                result = operands.pop();
                //   str=result.toString();
                str = String.valueOf(result);

                if (str.charAt(str.length() - 1) == '0' && str.charAt(str.length() - 2) == '.') {
                    str = str.substring(0, str.length() - 2);
                }
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(str);
                // str = "";
            }
        }
             else {
                tv = (TextView) findViewById(R.id.textView);
                 tv.setText(str);
           }

    }

    private int zero() {

        int j=1;
        while(j!=str.length())
        {
            if(str.charAt(j-1)=='0'&&str.charAt(j)=='/'&&str.charAt(j+1)=='0')
                return 1;
            else if(str.charAt(j)=='/'&&str.charAt(j+1)=='0')
                return 2;
            j++;
        }
        return 3;
    }

    public static boolean precedence(String op1,String op2) {
        if(op1.equals("%"))
            return false;
        if ((op1.equals("*")||op1.equals("/"))&&(op2.equals("+")||op2.equals("-")))
            return false;
        else
            return true;
    }

    /**
     public void butclearpressed(View v) {
     if(str.length()>0) {
     str = str.substring(0, str.length() - 1);
     tv = (TextView) findViewById(R.id.textView);
     tv.setText(str);
     }
     }
     **/


    private void insert(String t) {
        str = str+(t);
        tv = (TextView)findViewById(R.id.textView);
        tv.setText(str);
    }

    private void click1(View v) {
        insert("1");
    }

}
