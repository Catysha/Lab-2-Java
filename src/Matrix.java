import java.io.*;
import java.util.Scanner;
import java.util.Vector;
public class Matrix {
    private final int[][] data;

    public Matrix(int rows, int cols) {
        data = new int[rows][cols];
    }

    public Matrix(int[][] data) {
        this.data = data;
    }

    public int getRows() {
        return data.length;
    }

    public int getCols() {
        return data[0].length;
    }

    public int get(int row, int col) {
        return data[row][col];
    }

    public void set(int row, int col, int value) {
        data[row][col] = value;
    }

    public static Matrix readMatrixFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            Matrix matrix = new Matrix(rows, cols);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix.set(i, j, scanner.nextInt());
                }
            }

            scanner.close();
            return matrix;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void print() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Задание 1
    //Среди строк заданной матрицы, содержащих только нечетные элементы, найти строку с
    //максимальной суммой модулей элементов.
    public int calculateMaxSum() {
        int[] sums = new int[getRows()];
        for (int i = 0; i < getRows(); i++) {
            int sumOfRow = 0;
            for (int j = 0; j < getCols(); j++) {
                if (data[i][j] % 2 == 1) {
                    sumOfRow += Math.abs(data[i][j]);
                } else {
                    break;
                }
            }
            sums[i] = sumOfRow;
        }
        int max = sums[0];
        for (int i = 1; i < sums.length; i++) {
            max = Math.max(max, sums[i]);
        }
        return max;
    }

    // Задание 2
    // Подсчитать количество столбцов заданной матрицы, которые составлены из попарно
    //различных чисел.
    public int countUniqueColumns() {
        int uniqueColumnCount = 0;

        for (int j = 0; j < getCols(); j++) {
            Vector seenNumb = new Vector();
            boolean isUnique = true;

            for (int i = 0; i < getRows(); i++) {
                int currentValue = data[i][j];
                if (seenNumb.contains(currentValue)) {
                    isUnique = false;
                    break;
                }
                seenNumb.add(currentValue);
            }

            if (isUnique) {
                uniqueColumnCount++;
            }

        }
        return uniqueColumnCount;
    }

    // Задание 3
    // Упорядочить ее строки по неубыванию их наибольших элементов.
    private int findMax(int[] row) {
        int max = row[0];
        for (int i = 1; i < row.length; i++) {
            if (row[i] > max) {
                max = row[i];
            }
        }
        return max;
    }
    public void sortRowsByMaxElement() {
        for (int i = 0; i < getRows() - 1; i++) {
            for (int j = 0; j < getRows() - 1 - i; j++) {
                if (findMax(data[j]) > findMax(data[j + 1])) {
                    int[] temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }
}




