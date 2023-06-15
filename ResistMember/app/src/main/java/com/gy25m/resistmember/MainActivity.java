package com.gy25m.resistmember;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et,et1,et2,et3;
    RadioGroup rg1,rg2;
    CheckBox cb1,cb2,cb3,cb4;
    Button btn;
    TextView tv;
    RadioButton rb1,rb2;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=findViewById(R.id.et);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        rg1=findViewById(R.id.rg1);
        rg2=findViewById(R.id.rg2);
        cb1=findViewById(R.id.cb1);
        cb2=findViewById(R.id.cb2);
        cb3=findViewById(R.id.cb3);
        cb4=findViewById(R.id.cb4);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            tv.append(et.getText()+" "+rb1.getText()+" "+rb2.getText()+" "+et1.getText()+
                    "-"+et2.getText()+"-"+et3.getText()+s+"\n");
            }
        });
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb1=findViewById(i);
            }
        });
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                rb2=findViewById(i);
            }
        });
        CompoundButton.OnCheckedChangeListener listener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(cb1.isChecked()) s=s+cb1.getText();
                if(cb2.isChecked()) s=s+cb2.getText();
                if(cb3.isChecked()) s=s+cb3.getText();
                if(cb4.isChecked()) s=s+cb4.getText();

            }
        };

        cb1.setOnCheckedChangeListener(listener);
        cb2.setOnCheckedChangeListener(listener);
        cb3.setOnCheckedChangeListener(listener);
        cb4.setOnCheckedChangeListener(listener);



    }


}