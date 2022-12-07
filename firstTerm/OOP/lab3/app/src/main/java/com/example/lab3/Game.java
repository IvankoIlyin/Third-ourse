package com.example.lab3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Game extends AppCompatActivity {
    private int[][] field = new int[4][4];
    private Button[][] field_buttons = new Button[4][4];
    private boolean win=false;

    private void exit_game(){
        Intent intent = new Intent();
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private void alert_exit_game(){
        AlertDialog.Builder alert_build = new AlertDialog.Builder(Game.this);
        if(win){
            alert_build.setTitle("Exit")
                    .setMessage("You WON!!! You won't be so lucky next time!!!")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            exit_game();
                        }
                    });
            AlertDialog alert = alert_build.create();
            alert.show();

        }
        if(!win){
            alert_build.setTitle("Exit")
                    .setMessage("Нou didn't WIN!!! Do you really want to leave???")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            exit_game();
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alert_build.create();
            alert.show();
        }
    }

    private void generate_field(){
        int curr=0;
        for(int i=0; i<field.length;i++){
            for(int j=0;j<field.length;j++){
                field[i][j]=curr;
                curr++;
            }
        }
        for(int i=0; i<field.length;i++){
            for(int j=0;j<field.length;j++){
                curr = field[i][j];
                int t_i=(int)(Math.random()*4);
                int t_j=(int)(Math.random()*4);
                field[i][j]=field[t_i][t_j];
                field[t_i][t_j]=curr;
            }
        }
        Button btn = findViewById(R.id.btn0);
        field_buttons[0][0]=btn;
        btn = findViewById(R.id.btn1);
        field_buttons[0][1]=btn;
        btn = findViewById(R.id.btn2);
        field_buttons[0][2]=btn;
        btn = findViewById(R.id.btn3);
        field_buttons[0][3]=btn;
        btn = findViewById(R.id.btn4);
        field_buttons[1][0]=btn;
        btn = findViewById(R.id.btn5);
        field_buttons[1][1]=btn;
        btn = findViewById(R.id.btn6);
        field_buttons[1][2]=btn;
        btn = findViewById(R.id.btn7);
        field_buttons[1][3]=btn;
        btn = findViewById(R.id.btn8);
        field_buttons[2][0]=btn;
        btn = findViewById(R.id.btn9);
        field_buttons[2][1]=btn;
        btn = findViewById(R.id.btn10);
        field_buttons[2][2]=btn;
        btn = findViewById(R.id.btn11);
        field_buttons[2][3]=btn;
        btn = findViewById(R.id.btn12);
        field_buttons[3][0]=btn;
        btn = findViewById(R.id.btn13);
        field_buttons[3][1]=btn;
        btn = findViewById(R.id.btn14);
        field_buttons[3][2]=btn;
        btn = findViewById(R.id.btn15);
        field_buttons[3][3]=btn;
    }

    private void setField_buttons(){
        for(int i=0;i<field.length;i++){
            for(int j=0;j<field.length;j++){
                field_buttons[i][j].setText(Integer.toString(field[i][j]));
                if(field[i][j]==0){field_buttons[i][j].setBackgroundColor(Color.WHITE);}
            }
        }
    }

    private void field_buttons_listeners(){
        field_buttons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(0,0);
            }
        });
        field_buttons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(0,1);
            }
        });
        field_buttons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(0,2);
            }
        });
        field_buttons[0][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(0,3);
            }
        });
        field_buttons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(1,0);
            }
        });
        field_buttons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(1,1);
            }
        });
        field_buttons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(1,2);
            }
        });
        field_buttons[1][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(1,3);
            }
        });
        field_buttons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(2,0);
            }
        });
        field_buttons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(2,1);
            }
        });
        field_buttons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(2,2);
            }
        });
        field_buttons[2][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(2,3);
            }
        });
        field_buttons[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(3,0);
            }
        });
        field_buttons[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(3,1);
            }
        });
        field_buttons[3][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(3,2);
            }
        });
        field_buttons[3][3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make_move(3,3);
            }
        });
    }

    private void start_game(){
        generate_field();
        //test_generate_field();
        setField_buttons();
        field_buttons_listeners();
    }

    private boolean check_win(){
        win=true;
        int count=0;
        for(int i=0; i<field.length;i++){
            for(int j=0;j<field.length;j++){
                if(field[i][j]!=count){win=false;}
                count++;
            }
        }
        return win;
    }

    private void make_move(int button_i,int button_j){
        if(field[button_i][button_j]!=0){
            int zero_i=20,zero_j=20;
            for(int i=0;i<field.length;i++){
                for(int j=0;j<field.length;j++){
                    if(field[i][j]==0){zero_i=i;zero_j=j;}
                }
            }
            if(Math.abs(button_i-zero_i)==1 && Math.abs(button_j-zero_j)==0){
                field[zero_i][zero_j]=field[button_i][button_j];
                field[button_i][button_j]=0;
            }
            if(Math.abs(button_i-zero_i)==0 && Math.abs(button_j-zero_j)==1){
                field[zero_i][zero_j]=field[button_i][button_j];
                field[button_i][button_j]=0;
            }
            setField_buttons();
            if(check_win()){
               alert_exit_game();
            }
        }
    }

    private void test_generate_field(){
        int curr=0;
        for(int i=0; i<field.length;i++){
            for(int j=0;j<field.length;j++){
                field[i][j]=curr;
                curr++;
            }
        }
        field[0][0]=1;
        field[0][1]=0;
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Button exit = findViewById(R.id.exitButton);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert_exit_game();
            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();
        start_game();

    }


}