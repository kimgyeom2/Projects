package com.gy25m.ex38floatingactionbutton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ExtendedFloatingActionButton extfab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this,"Click",Toast.LENGTH_SHORT).show();
                // Toast 대체 SnackBar
                Snackbar.make(view,"Clicked fab", BaseTransientBottomBar.LENGTH_SHORT).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
            }
        });

        extfab=findViewById(R.id.ext_fab);
        extfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(extfab.isExtended()){
                    CoordinatorLayout layout=findViewById(R.id.snackbar_container);
                    Snackbar.make(layout,"Click Click",Snackbar.LENGTH_INDEFINITE).setAction("확인", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
                            extfab.shrink();
                        }
                    }).show();
                }else {
                    extfab.extend();
                }
            }
        });
    }
}