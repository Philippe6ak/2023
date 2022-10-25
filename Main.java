import Jama.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int [][] BalanceTable = {
                {   0,100000000,1100000,0,200000000,100000,0,0,0 },
                {   22000,0,14500000,6000000,0,0,0,0,0 },
                {   275341,0,0,3346500,112200,0,0,6685000,0},
                {   0,0,0,0,0,3150000,0,15000000,86750000},
                {   0,0,0,1450000,300000,0,23200000,0,28225000},
                {   0,0,0,0,0,0,45000000,0,101500000},
                {   0,0,0,0,0,350000,0,0,1150000100},
                {   0,0,0,0,0,0,0,0,55000000},
        };

        double[][] Y_ = {{1},{7},{9},{8},{9},{8},{9},{8}};

        int [][] E = {
                {   1,0,0,0,0,0,0,0,0},
                {   0,1,0,0,0,0,0,0,0},
                {   0,0,1,0,0,0,0,0,0},
                {   0,0,0,1,0,0,0,0,0},
                {   0,0,0,0,1,0,0,0,0},
                {   0,0,0,0,0,1,0,0,0},
                {   0,0,0,0,0,0,1,0,0},
                {   0,0,0,0,0,0,0,1,0},
                {   0,0,0,0,0,0,0,0,1},
        };
        //System.out.print(BalanceTable[7][9]);

        long sum = 0;
        long X [] = new long[8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                sum = sum + BalanceTable[i][j];
                //System.out.print(sum + " ");
            }
            X[i] = sum;
            sum = 0;
        }


        //System.out.println(Arrays.toString(X));



        double A [][] = new double [8][9];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                A [i][j] = (float) BalanceTable[i][j] / X[i];
            }
        }

        double Temp [][] = new double [8][9];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                Temp [i][j] = E[i][j] - A[i][j];
            }

        }

        Matrix NewX = new Matrix (Temp);
        NewX.inverse();
        Matrix MY_ = new Matrix(Y_);
        Matrix MX_ = NewX.times(MY_);


            System.out.println(MX_);
        }
    }