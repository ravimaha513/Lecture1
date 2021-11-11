package com.coderpad.student.twodimensions;

public class TwoDimensionPath {

    public static void main(String[] args) {

        System.out.println(optimalPath(new Integer[][]{
                {0,0,0,0,5},
                {0,1,1,1,0},
                {2,0,0,0,0}}));

    // 2,0 -> 1, 0 -> 1, 1 -> 1,2 -> 1,3 -> 1,4 -> 0,4
    }

    public static Integer optimalPath(Integer[][] grid)
    {
        // Todo: Implement optimalPath
        int rowLen = grid.length;
        int colLen = grid[0].length;

        int start = grid[rowLen - 1][ 0];
        int end = grid[0][ colLen - 1];

        int sum = 0;

        int rowStart = rowLen - 1;
        int colStart = 0;

        sum = sum + start + end;
        while( rowStart >=0 && colStart < colLen ){
            if((rowStart - 1) >= 0 ){

                if(colStart + 1 <= colLen){
                    int element = Math.max(grid[rowStart - 1][colStart ], grid[rowStart][colStart + 1]);
                    if(grid[rowStart - 1][ colStart] >=  grid[rowStart ][colStart + 1]){
                        rowStart--;
                    }else{
                        colStart++;
                    }
                    sum += element;
                }


            }else{
                colStart++;
            }


        }
       /* for(int row  = rowLen - 1; row >= 0; row--){

            if(row <= rowLen){

                for(int col = 0; col < grid[row].length; col++){

                    if(col <= colLen){
                        if(grid[row][col] != end){

                            int element = Math.max(grid[row - 1][col ], grid[row][col + 1]);
                            sum += element;
                        }else{
                            break;
                        }
                    }
                }
            }
        }*/

      //  return sum;

        return sum;
    }
}
