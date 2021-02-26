package leetcodetop.bytedance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        if (rowLen == 0) {
            return Collections.emptyList();
        }
        int rowStart = 0;
        int rowEnd = rowLen - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (rowStart < rowEnd && colStart < colEnd) {
            for (int i = colStart; i < colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
            for (int i = rowStart; i < rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
            for (int i = colEnd; i > colStart; i--) {
                list.add(matrix[rowEnd][i]);
            }
            for (int i = rowEnd; i > rowStart; i--) {
                list.add(matrix[i][colStart]);
            }
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        if (rowStart == rowEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                list.add(matrix[rowStart][i]);
            }
        } else if (colStart == colEnd) {
            for (int i = rowStart; i <= rowEnd; i++) {
                list.add(matrix[i][colStart]);
            }
        }
        return list;
    }
}
