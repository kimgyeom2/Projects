package com.gy25m.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView star,msg,send,book,menu,big;
    ImageView dialog_iv;
    int p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        star=findViewById(R.id.star);
        msg=findViewById(R.id.message);
        send=findViewById(R.id.send);
        book=findViewById(R.id.book);
        menu=findViewById(R.id.menu);
        big=findViewById(R.id.big);


        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"star",Toast.LENGTH_SHORT).show();
            }
        });
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"message",Toast.LENGTH_SHORT).show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"send",Toast.LENGTH_SHORT).show();
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"book",Toast.LENGTH_SHORT).show();
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"menu",Toast.LENGTH_SHORT).show();
            }
        });

        big.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);

               builder.setView(R.layout.dialog);
                AlertDialog dialog=builder.create();
                dialog.show();
                dialog_iv=dialog.findViewById(R.id.dialog_iv);
                dialog_iv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog_iv.setImageResource(R.drawable.b2+p);
                        p++;
                        if (p==3)p=0;
                    }

                });
            }
        });


    }

}