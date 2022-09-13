package com.khushalmajoka.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private SudokuBoard gameBoard;
    private Solver gameBoardSolver;
    private Button solveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.SudokuBoard);
        gameBoardSolver = gameBoard.getSolver();

        solveBtn = findViewById(R.id.solveBtn);
    }

    public void btnOnePress(View view){
        gameBoardSolver.setNumberPos(1);
        gameBoard.invalidate();
    }
    public void btnTwoPress(View view){
        gameBoardSolver.setNumberPos(2);
        gameBoard.invalidate();
    }
    public void btnThreePress(View view){
        gameBoardSolver.setNumberPos(3);
        gameBoard.invalidate();
    }
    public void btnFourPress(View view){
        gameBoardSolver.setNumberPos(4);
        gameBoard.invalidate();
    }
    public void btnFivePress(View view){
        gameBoardSolver.setNumberPos(5);
        gameBoard.invalidate();
    }
    public void btnSixPress(View view){
        gameBoardSolver.setNumberPos(6);
        gameBoard.invalidate();
    }
    public void btnSevenPress(View view){
        gameBoardSolver.setNumberPos(7);
        gameBoard.invalidate();
    }
    public void btnEightPress(View view){
        gameBoardSolver.setNumberPos(8);
        gameBoard.invalidate();
    }
    public void btnNinePress(View view){
        gameBoardSolver.setNumberPos(9);
        gameBoard.invalidate();
    }

    public void solve(View view){
        if(solveBtn.getText().toString().equals(getString(R.string.solve))){
            solveBtn.setText(getString(R.string.clear));
            gameBoardSolver.getEmptyBoxIndexes();
            SolveBoardThread solveBoardThread = new SolveBoardThread();
            new Thread(solveBoardThread).start();
            gameBoard.invalidate();
        }else{
            solveBtn.setText(getString(R.string.solve));
            gameBoardSolver.resetBoard();
            gameBoard.invalidate();
        }
    }

    class SolveBoardThread implements Runnable{

        @Override
        public void run() {
            gameBoardSolver.solve(gameBoard);
        }
    }
}