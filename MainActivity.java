package com.bk.ducnghia.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtInput;
    private TextView tvResult;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnPlus, btnSub, btnMulti, btnDivi, btnDot, btnTinh, btnC, btnAC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FindID();
        BatSuKien();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_0:
                edtInput.append("0");
                break;
            case R.id.btn_1:
                edtInput.append("1");
                break;
            case R.id.btn_2:
                edtInput.append("2");
                break;
            case R.id.btn_3:
                edtInput.append("3");
                break;
            case R.id.btn_4:
                edtInput.append("4");
                break;
            case R.id.btn_5:
                edtInput.append("5");
                break;
            case R.id.btn_6:
                edtInput.append("6");
                break;
            case R.id.btn_7:
                edtInput.append("7");
                break;
            case R.id.btn_8:
                edtInput.append("8");
                break;
            case R.id.btn_9:
                edtInput.append("9");
                break;
            case R.id.btn_Plus:
                edtInput.append("+");
                break;
            case R.id.btn_Sub:
                edtInput.append("-");
                break;
            case R.id.btn_Multi:
                edtInput.append("x");
                break;
            case R.id.btn_Divi:
                edtInput.append("/");
                break;
            case R.id.btn_Dot:
                edtInput.append(".");
                break;
            case R.id.btn_C:
                BaseInputConnection bienT = new BaseInputConnection(edtInput, true);
                bienT.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.btn_AC:
                edtInput.setText("");
                break;
            case R.id.btn_Tinh:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addNumber(edtInput.getText().toString());
                addOper(edtInput.getText().toString());
                if (arrOper.size()<1){
                    tvResult.setText(edtInput.getText().toString());
                }else if (arrOper.size()>=arrNumber.size()){
                    tvResult.setText("ERROR");
                }else {
                    for (int i = 0; i < arrNumber.size() - 1; i++) {
                        switch (arrOper.get(i)) {
                            case "+":
                                if (i == 0) result = arrNumber.get(0) + arrNumber.get(1);
                                else result = result + arrNumber.get(i + 1);
                                break;
                            case "-":
                                if (i == 0) result = arrNumber.get(0) - arrNumber.get(1);
                                else result = result - arrNumber.get(i + 1);
                                break;
                            case "x":
                                if (i == 0) result = arrNumber.get(0) * arrNumber.get(1);
                                else result = result * arrNumber.get(i + 1);
                                break;
                            case "/":
                                if (i == 0) result = arrNumber.get(0) / arrNumber.get(1);
                                else result = result / arrNumber.get(i + 1);
                                break;
                        }
                        tvResult.setText(df.format(result)+"");
                    }
                }
                break;
        }
    }

    public void FindID(){
        edtInput = findViewById(R.id.edt_Input);
        tvResult = findViewById(R.id.tv_Result);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnC = findViewById(R.id.btn_C);
        btnAC = findViewById(R.id.btn_AC);
        btnTinh = findViewById(R.id.btn_Tinh);
        btnDot = findViewById(R.id.btn_Dot);
        btnDivi = findViewById(R.id.btn_Divi);
        btnSub = findViewById(R.id.btn_Sub);
        btnMulti = findViewById(R.id.btn_Multi);
        btnPlus = findViewById(R.id.btn_Plus);
    }
    public void BatSuKien(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnDivi.setOnClickListener(this);
        btnDot.setOnClickListener(this);

        btnAC.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnTinh.setOnClickListener(this);
    }
    //    public void XoaKiTu(String chuoi){
//        int length = chuoi.length();
//        String tem = chuoi.substring(0,length-1);
//        edtInput.setText(tem);
//    }
    public ArrayList<String> arrOper;
    public ArrayList<Double> arrNumber;
    public void addOper(String x){          //thêm các phép toán vào mảng arrOper
        arrOper = new ArrayList<>();
        char[] arrChar = x.toCharArray();  //tham số x dc truyền vào sẽ đổi thành 1 array, mỗi phần tử là 1 char
        for (int i=0; i<arrChar.length; i++){
            switch (arrChar[i]){
                case '+' :
                    arrOper.add((arrChar[i]) + "");
                    break;
                case '-' :
                    arrOper.add((arrChar[i]) + "");
                    break;
                case 'x' :
                    arrOper.add((arrChar[i]) + "");
                    break;
                case '/' :
                    arrOper.add((arrChar[i]) + "");
                    break;
            }
        }
    }
    public void addNumber(String y){
        arrNumber = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(y);
        while (matcher.find()){
            arrNumber.add(Double.valueOf(matcher.group(1)));
        }
    }
}