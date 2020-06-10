package com.moblieprogramming.sudoku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static CustomButton[][] buttons = new CustomButton[9][9];
    TableLayout table;
    TableLayout numPad;
    TableLayout toglePad;
    int[][] values = new int[9][9];
    int[][] value = new int[3][3];
    Button[][] button = new Button[4][3];
    //Button[] hintnorButton = new Button[3];
    //ToggleButton[][] toggleButtons = new ToggleButton[3][3];
    static int r;
    static int c;
    boolean[][] flag;
    ToggleButton[] tb = new ToggleButton[9];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeView();
        InitializeNumView();
       // InitializeHintView();

        tb[0] = (ToggleButton)findViewById(R.id.toggleButton1);
        tb[0].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[0].isChecked()){
                    buttons[r][c].hints[0].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[0].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[1] = (ToggleButton)findViewById(R.id.toggleButton2);
        tb[1].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[1].isChecked()){
                    buttons[r][c].hints[1].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[1].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[2] = (ToggleButton)findViewById(R.id.toggleButton3);
        tb[2].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[2].isChecked()){
                    buttons[r][c].hints[2].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[2].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[3] = (ToggleButton)findViewById(R.id.toggleButton4);
        tb[3].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[3].isChecked()){
                    buttons[r][c].hints[3].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[3].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[4] = (ToggleButton)findViewById(R.id.toggleButton5);
        tb[4].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[4].isChecked()){
                    buttons[r][c].hints[4].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[4].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[5] = (ToggleButton)findViewById(R.id.toggleButton6);
        tb[5].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[5].isChecked()){
                    buttons[r][c].hints[5].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[5].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[6] = (ToggleButton)findViewById(R.id.toggleButton7);
        tb[6].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[6].isChecked()){
                    buttons[r][c].hints[6].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[6].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[7] = (ToggleButton)findViewById(R.id.toggleButton8);
        tb[7].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[7].isChecked()){
                    buttons[r][c].hints[7].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[7].setVisibility(View.INVISIBLE);
                }
            }
        });
        tb[8] = (ToggleButton)findViewById(R.id.toggleButton9);
        tb[8].setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(tb[8].isChecked()){
                    buttons[r][c].hints[8].setVisibility(View.VISIBLE);
                }else{
                    buttons[r][c].hints[8].setVisibility(View.INVISIBLE);
                }
            }
        });

        numPad.setVisibility(View.INVISIBLE);
        table.setVisibility(View.VISIBLE);
        toglePad.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View v) {

        r = ((CustomButton)v).row;
        c = ((CustomButton)v).col;

        button[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(1);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }

                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(2);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }

                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(3);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }


                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(4);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }


                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(5);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }

                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(6);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }


                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(7);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }


                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(8);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }

                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean success =true;
                buttons[r][c].set(9);
                for(int i=0; i<9; i++){
                    buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
                }
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            success =false;
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }


                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[3][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttons[r][c].set(0);
                ConflictCheck(r,c);
                for(int i=0; i<9; i++){
                    for(int j=0; j<9; j++){
                        if(flag[i][j]){
                            buttons[i][j].setConflict();
                        }else{
                            buttons[i][j].unsetConflict();
                        }
                    }
                }


                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        button[3][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numPad.setVisibility(View.INVISIBLE);
                table.setVisibility(View.VISIBLE);
            }
        });
        //클릭 가능한 버튼을 눌렀을 때만 numpad 활성화
        if(buttons[r][c].born==0) {
            numPad.setVisibility(View.VISIBLE);
            table.setVisibility(View.INVISIBLE);
        }

    }

    public void ConflictCheck(int row, int col){
        flag = new boolean[9][9];
        for(int i=0; i<9; i++){
            if(i!=row){
                if(buttons[i][col].value==buttons[row][col].value) {
                    if(buttons[i][col].value!=0) {
                        flag[i][col] = true;
                        flag[row][col] = true;
                    }
                }
            }
        }
        for(int j=0; j<9;j++){
            if(j!=col){
                if(buttons[row][col].value==buttons[row][j].value){
                    if(buttons[row][col].value!=0) {
                        flag[row][col] = true;
                        flag[row][j] = true;
                    }
                }
            }
        }
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9; j+=3){
                int[] che_red = new int[10];

                for(int c=0; c<3;c++){
                    for(int b=0; b<3; b++) {
                        che_red[buttons[i + c][j + b].value] += 1;
                    }
                }
                for(int g=1; g<9; g++){

                    if(che_red[g]>1) {
                        for(int c=0; c<3;c++){
                            for(int b=0; b<3; b++){
                               if(g==buttons[i+c][j+b].value) {
                                   flag[i + c][j + b] = true;
                               }
                            }
                        }
                    }
                }
            }
        }
    }
    //toggle 동적생성
    /*public void InitializeHintView(){
        int k = 1;
        for (int i = 0; i < 4; i++) {
            TableRow togleRow = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1.0f);
            layoutParams.setMargins(20, 0, 20, 0);
            if (i != 3) {
                for (int j = 0; j < 3; j++) {
                    toggleButtons[i][j] = new ToggleButton(this);
                    toggleButtons[i][j].setLayoutParams(layoutParams);
                    toggleButtons[i][j].setText(String.valueOf(k));
                    togleRow.addView(toggleButtons[i][j]);
                    k++;
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        hintnorButton[j] = new Button(this);
                        hintnorButton[j].setLayoutParams(layoutParams);
                        hintnorButton[j].setText("확인");
                        togleRow.addView(hintnorButton[j]);
                    } else if(j==1){
                        hintnorButton[j] = new Button(this);
                        hintnorButton[j].setLayoutParams(layoutParams);
                        hintnorButton[j].setText("취소");
                        togleRow.addView(hintnorButton[j]);
                    }else if(j==2){
                        hintnorButton[j] = new Button(this);
                        hintnorButton[j].setLayoutParams(layoutParams);
                        hintnorButton[j].setText("확인");
                        togleRow.addView(hintnorButton[j]);
                    }
                }
            }

            toglePad.addView(togleRow);
        }
    }*/


    public void InitializeNumView(){
        int k = 1;
        for (int i = 0; i < 4; i++) {
            TableRow numRow = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1.0f);
            layoutParams.setMargins(20, 0, 20, 0);
            if (i != 3) {
                for (int j = 0; j < 3; j++) {
                    button[i][j] = new Button(this);
                    button[i][j].setLayoutParams(layoutParams);
                    button[i][j].setText(String.valueOf(k));
                    value[i][j] = k;
                    numRow.addView(button[i][j]);
                    k++;
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    if (j == 0) {
                        button[i][j] = new Button(this);
                        button[i][j].setLayoutParams(layoutParams);
                        button[i][j].setText("clear");
                        numRow.addView(button[i][j]);
                    } else {
                        button[i][j] = new Button(this);
                        button[i][j].setLayoutParams(layoutParams);
                        button[i][j].setText("canceal");
                        numRow.addView(button[i][j]);
                    }
                }
            }

            numPad.addView(numRow);
        }
    }

    public void InitializeView() {
        numPad = (TableLayout) findViewById(R.id.numPad);
        toglePad = (TableLayout)findViewById(R.id.toglePad);
        table = (TableLayout) findViewById(R.id.tableLayout);
        TableLayout.LayoutParams talayoutParams = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT,
                1.0f);
        talayoutParams.setMargins(1, 10, 1, 0);

        BoardGenerator board = new BoardGenerator();
        // buttons = new CustomButton[9][9];

        for (int i = 0; i < 9; i++) {
            TableRow tableRow = new TableRow(this);
            TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT,
                    1.0f);
            layoutParams.setMargins(20, 0, 20, 0);

            for (int j = 0; j < 9; j++) {
                buttons[i][j] = new CustomButton(this, i, j);
                buttons[i][j].textView.setTextSize(35);
                buttons[i][j].setLayoutParams(layoutParams);
               // buttons[i][j].setPadding(17, 25, 17, 25);
                Random random = new Random();
                int data = random.nextInt(3);
                if (data == 1) {
                    buttons[i][j].set(0);
                } else {
                    int number = board.get(i, j);
                    buttons[i][j].set(number);
                    buttons[i][j].born =1;
                    values[i][j] = number;
                }

                buttons[i][j].setOnClickListener(this);
                buttons[i][j].setOnLongClickListener(new View.OnLongClickListener(){
                    @Override
                    public boolean onLongClick(View v){
                        r = ((CustomButton)v).row;
                        c = ((CustomButton)v).col;

                        if(buttons[r][c].born==0&&buttons[r][c].value==0){
                            toglePad.setVisibility(View.VISIBLE);
                            numPad.setVisibility(View.INVISIBLE);
                            table.setVisibility(View.INVISIBLE);
                        }

                        return true;
                    }
                });

                tableRow.addView(buttons[i][j]);

            }

            table.addView(tableRow, talayoutParams);
        }
    }

    public void onClickCanceal(View v){

        toglePad.setVisibility(View.INVISIBLE);
        numPad.setVisibility(View.INVISIBLE);
        table.setVisibility(View.VISIBLE);
    }
    public void onClickConfirm(View v){
        toglePad.setVisibility(View.INVISIBLE);
        numPad.setVisibility(View.INVISIBLE);
        table.setVisibility(View.VISIBLE);
    }
    public void onClickDelete(View v){
        for(int i=0; i<9; i++){
            buttons[r][c].hints[i].setVisibility(View.INVISIBLE);
        }
        toglePad.setVisibility(View.INVISIBLE);
        numPad.setVisibility(View.INVISIBLE);
        table.setVisibility(View.VISIBLE);
    }


}