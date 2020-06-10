package com.moblieprogramming.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class CustomButton extends FrameLayout {
    int row;
    int col;
    int value;
    int born;
    TextView[] hints;
    TextView textView;


    public CustomButton(@NonNull Context context, int row, int col) {
        super(context);

        this.setClickable(true);
        setBackgroundResource(R.drawable.button_selector);
        textView = new TextView(context);

        hints = new TextView[9];

        this.col = col;
        this.row = row;
        born =0;
        addView(textView);

        LayoutInflater layoutInflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TableLayout tableLayout =
                (TableLayout)layoutInflater.inflate(R.layout.hint_layout, null);

        for(int i=0, k=0; i<3; i++){
            TableRow r = (TableRow)tableLayout.getChildAt(i);
            for(int j=0; j<3; j++,k++){
                hints[k] = (TextView)r.getChildAt(j);
                hints[k].setVisibility(View.INVISIBLE);
            }
        }
        addView(tableLayout);
    }
    public void set(int a){
        if(a!=0) {
            value = a;
            textView.setText(String.valueOf(value));
        }else{
            value =0;
            textView.setText(" ");
        }
    }

    public void setConflict(){
        setBackgroundColor(Color.parseColor("red"));
    }
    public void unsetConflict(){
        setBackgroundColor(Color.parseColor("white"));
    }
}
