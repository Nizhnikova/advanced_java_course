package edu.technopolis.homework;

/**
 * Matrix multiplication home task.
 * <br/>
 * Matrix dimension and elements are passed as CLI arguments.
 */
public class MatrixMultiplication {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try{
            int it = 0;
            int N = Integer.parseInt(args[it++]);
            int M = Integer.parseInt(args[it++]);
            int X = Integer.parseInt(args[it++]);
            int Y = Integer.parseInt(args[it++]);

            int [][] mat1 = new int [N][M];
            for (int i = 0; i < N; i++){
                for (int j = 0; j < M; j++){
                    mat1[i][j] = Integer.parseInt(args[it++]);
                }
            }
            int [][] mat2 = new int [X][Y];
            for (int i = 0; i < X; i++){
                for (int j = 0; j < Y; j++){
                    mat2[i][j] = Integer.parseInt(args[it++]);
                }
            }
            new Homework1().runMult(mat1, mat2, N, M, X, Y);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBoundsException");
            System.out.println("Недостаточно данных для формирования матриц, проверьте введенные данные");
        }
        catch (NumberFormatException e){
            System.out.println("NumberFormatException");
            System.out.println("Программа работает только с целыми числами, проверьте введенные данные");
        }
        catch (Exception e){
            System.out.println("StrangeException");
            System.out.println("Вы совершили непредсказуемый ввод, проверьте введенные данные на смысл");
        }

    }

    public void runMult(int[][] mat1, int [][] mat2, int N, int M, int X, int Y){
        PrintMat(mat1);
        PrintMat(mat2);
        //проверка
        if (N != X){
            System.out.println("Число столбцов первой матрицы не совпадает с числом строк второй");
        }

        int [][] res = new int [N][Y];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < Y; j++){
                res[i][j] = 0;
                for (int ii = 0; ii< N; ii++) {
                    res[i][j] = res[i][j] + mat1[i][ii] * mat2[ii][j];
                }
            }
        }
        PrintMat(res);
    }

    public void PrintMat(int[][] mat){
        System.out.println("***PrintMat***");
        String s;
        for (int i = 0; i < mat.length; i++){
            s = "";
            for(int j = 0; j < mat[i].length; j++){
                s = s+(mat[i][j]+"\t");
            }
            System.out.println(s);
        }
    }
}
