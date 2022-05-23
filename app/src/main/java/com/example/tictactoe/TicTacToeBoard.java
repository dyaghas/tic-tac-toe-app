package com.example.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TicTacToeBoard extends View {

    private final int board_color;
    private final int x_color;
    private final int o_color;
    private final int winning_line_color;

    private final Paint paint = new Paint();

    private int cellSize = getWidth() / 3;

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.TicTacToeBoard, 0, 0);

        try{
            board_color = a.getInteger(R.styleable.TicTacToeBoard_board_color, 0);
            x_color = a.getInteger(R.styleable.TicTacToeBoard_x_color, 0);
            o_color = a.getInteger(R.styleable.TicTacToeBoard_o_color, 0);
            winning_line_color = a.getInteger(R.styleable.TicTacToeBoard_winning_line_color, 0);
        }finally{
            a.recycle();
        }

    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        //verifies which one is smaller, screen width or screen height.
        int dimension = Math.min(getMeasuredWidth(), getMeasuredHeight());

        cellSize = dimension/3;

        //sets the smaller value as the Tic tac toe width and height.
        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        drawGameBoard(canvas);
    }

    private void drawGameBoard(Canvas canvas) {
        paint.setColor(board_color);
        paint.setStrokeWidth(9);
        //draw columns
        for(int col=1; col<3; col++) {
            canvas.drawLine(
                    cellSize*col, 0, cellSize*col, canvas.getHeight(), paint
            );
        }
        //draw rows
        for(int row=1; row<3; row++) {
            canvas.drawLine(
                    0, cellSize*row, canvas.getWidth(), cellSize*row, paint
            );
        }
    }

}
