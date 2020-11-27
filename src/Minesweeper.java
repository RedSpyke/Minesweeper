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

        System.out.println(mines);

        // count the mines
        for (int i = 0; i <  m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != '*') {
                    int mineCount = 0;

                    //  neighboring cells


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
            }
        }



        // print the matrix
        for (int i = 0; i <  m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] != '*'){
                    matrix[i][j] = '_';
                }
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
