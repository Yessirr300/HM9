package app;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int sumEvenRows = 0;
        int sumOddRows = 0;
        for (int i = 0; i < 4; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 4; j++) {
                    sumEvenRows += matrix[i][j];
                }
            } else {
                for (int j = 0; j < 4; j++) {
                    sumOddRows += matrix[i][j];
                }
            }
        }

        long productEvenCols = 1;
        long productOddCols = 1;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (j % 2 == 0) {
                    productEvenCols *= matrix[i][j];
                } else {
                    productOddCols *= matrix[i][j];
                }
            }
        }

        System.out.println("\nСума елементів у парних рядках (рядок 0, 2): " + sumEvenRows);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + productEvenCols);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + productOddCols);

        boolean isMagicSquare = isMagicSquare(matrix);
        if (isMagicSquare) {
            System.out.println("\nМатриця є магічним квадратом.");
        } else {
            System.out.println("\nМатриця не є магічним квадратом.");
        }
    }

    public static boolean isMagicSquare(int[][] matrix) {
        int n = matrix.length;
        int sumDiagonal1 = 0, sumDiagonal2 = 0;

        for (int i = 0; i < n; i++) {
            sumDiagonal1 += matrix[i][i];
            sumDiagonal2 += matrix[i][n - i - 1];
        }

        if (sumDiagonal1 != sumDiagonal2) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            int sumRow = 0, sumCol = 0;
            for (int j = 0; j < n; j++) {
                sumRow += matrix[i][j];
                sumCol += matrix[j][i];
            }
            if (sumRow != sumDiagonal1 || sumCol != sumDiagonal1) {
                return false;
            }
        }

        return true;
    }
}
