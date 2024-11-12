import java.io.*;
public class Main {
    public static void main(String[] args) {
        Matrix matrix = Matrix.readMatrixFromFile("input.txt");
        int rowMaxSums = matrix.calculateMaxSum();
        System.out.println("Максимальная сумма строки с нечетными элементами: " + rowMaxSums);
        int colUnique = matrix.countUniqueColumns();
        System.out.println("Количество столбцов матрицы из попарно различных чисел: " + colUnique);
        System.out.println("Упорядоченные по неубыванию наибольших элементов строки матрицы:");
        matrix.print();
    }
}