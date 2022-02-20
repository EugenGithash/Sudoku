/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

/**
 *
 * @author plesa
 */
public class SudokuSolver {

   private static final int GridSize=9;
    public static void main(String[] args) {
        int[][] board={
            {6,2,0,0,0,0,5,0,0},
            {1,3,5,8,0,0,9,0,0},
            {0,0,8,6,7,0,0,0,2},
            {0,9,0,0,8,0,0,0,0},
            {8,0,0,4,2,3,0,0,9},
            {0,0,0,0,1,0,0,8,0},
            {7,0,0,0,9,1,6,0,0},
            {0,0,9,0,0,8,2,1,4},
            {0,0,2,0,0,0,0,9,7}
        };
        printBoard(board);
        if(solver(board))
            System.out.println("OK");
        else
            System.out.println("nu e ok!!");
        
        printBoard(board);
    }
    private static boolean IsNumberR(int[][] board,int n,int row){
        for(int i=0;i<GridSize;i++){
            if(board[row][i]==n)
                return true;
        }
        return false;
    
} 
    private static boolean IsNumberC(int[][] board,int n,int col){
        for(int i=0;i<GridSize;i++){
            if(board[i][col]==n)
                return true;
        }
        return false;
    }
    private static boolean isBox(int[][] board,int n,int row,int col){
        int localRowBox=row-row%3;
        int localBoxCol=col-col%3;
        
        for(int i=localRowBox;i<localRowBox+3;i++){
            for(int j=localBoxCol;j<localBoxCol+3;j++){
                if(board[i][j]==n)
                    return true;
            }
        }
        return false;
    }
    private static boolean validare(int[][] board,int n,int row,int col){
        {
            return !IsNumberR(board,n,row)&&
                    !IsNumberC(board,n,col)&&
                    !isBox(board,n,row,col);
        }
        
}
    private static boolean solver(int[][] board){
        for(int row=0;row<GridSize;row++){
            for(int col=0;col<GridSize;col++){
                if(board[row][col]==0){
                    for(int num=1;num<=GridSize;num++){
                        if(validare(board,num,row,col)){
                            board[row][col]=num;
                            
                            if(solver(board)){
                                return true;
                            }
                            else{
                                board[row][col]=0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for(int row=0;row<GridSize;row++){
            if(row%3==0 && row!=0){
                System.out.println("---------------");
            }
            for(int col=0;col<GridSize;col++){
                if(col%3==0 && col!=0){
                //System.out.println("|");
            }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
         }
}