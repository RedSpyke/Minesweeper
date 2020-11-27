import java.util.Scanner;

public class Minesweeper {


    public static void main(String[] args) {

        int m, n, k;

        Scanner input  = new Scanner(System.in);
        System.out.println("enter value for m, n , k");
        m = input.nextInt();
        n = input.nextInt();
        k = input.nextInt();

        char [][] matrix = new char[m][n]; // generate the board game

        // print the matrix
//        for (int i = 0; i <  m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix [i][j] = '_';
//                System.out.print(matrix[i][j]+ " ");
//            }
//            System.out.println();
//        }
        // populate with mines

        int mines = 0;
        totalMines:
        while (mines <= k){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n ; j++) {
                    if(mines == k){
                        break totalMines;
                    }
                    double r = Math.random();
                    if(matrix[i][j] != '*'){
                        if(r < k * 0.01){
                            matrix[i][j] = '*';
                            mines++;
                        }
                    }
                }
            }
        }
        //   System.out.println(mines);
        // matrix sides
        int iMin = 0;
        int iMax = m - 1;
        int jMin = 0;
        int jMax = n - 1;

        // count the mines
        for (int i = 0; i <  m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != '*') {
                    int mineCount = 0;
                    //  neighboring cells
                    if (i == 0){
                        if(j != jMax){
                            if(matrix[i][j+1] == '*'){
                                mineCount++;
                            }
                            if(matrix[i+1][j+1] == '*'){
                                mineCount++;
                            }
                        }

                        if(matrix[i+1][j] == '*'){
                            mineCount++;
                        }
                        if(j != 0){
                            if(matrix[i+1][j-1] == '*'){
                                mineCount++;
                            }
                            if(matrix[i][j-1] == '*'){
                                mineCount++;
                            }
                        }

                    } else if(i == m -1){
                        if(j != 0){
                            if(matrix[i-1][j-1] == '*'){
                                mineCount++;
                            }
                            if(matrix[i][j-1] == '*'){
                                mineCount++;
                            }
                        }
                        if(matrix[i-1][j] == '*'){
                            mineCount++;
                        }
                        if( j != jMax){
                            if(matrix[i-1][j+1] == '*'){
                                mineCount++;
                            }
                            if(matrix[i][j+1] == '*'){
                                mineCount++;
                            }
                        }

                    } else if (j == 0){
                        if(matrix[i-1][j] == '*'){
                            mineCount++;
                        }
                        if(matrix[i-1][j+1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i][j+1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i+1][j+1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i+1][j] == '*'){
                            mineCount++;
                        }
                    } else if(j == n-1) {
                        if (matrix[i - 1][j - 1] == '*') {
                            mineCount++;
                        }
                        if (matrix[i - 1][j] == '*') {
                            mineCount++;
                        }
                        if (matrix[i + 1][j] == '*') {
                            mineCount++;
                        }
                        if (matrix[i + 1][j - 1] == '*') {
                            mineCount++;
                        }
                        if (matrix[i][j - 1] == '*') {
                            mineCount++;
                        }
                    }
                        // interior
                    if(i != 0 && i != m-1 && j != 0 && j != n-1 ){
                        if(matrix[i-1][j-1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i-1][j] == '*'){
                            mineCount++;
                        }
                        if(matrix[i-1][j+1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i][j+1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i+1][j+1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i+1][j] == '*'){
                            mineCount++;
                        }
                        if(matrix[i+1][j-1] == '*'){
                            mineCount++;
                        }
                        if(matrix[i][j-1] == '*'){
                            mineCount++;
                        }
                    }

                    matrix[i][j] = (char) (mineCount + '0');
                }
            }
        }
        // print the matrix
        for (int i = 0; i <  m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
