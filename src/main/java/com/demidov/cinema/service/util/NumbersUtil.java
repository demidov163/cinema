package com.demidov.cinema.service.util;

import java.util.Arrays;

public class NumbersUtil {
    public static Integer[][] matrixConvertToInteger(int[][] matrix){
        if (matrix == null || matrix.length == 0) {
             throw new IllegalArgumentException("Matrix is null");
        }

        Integer[][] res = new Integer[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            res[i] = Arrays.stream(matrix[i]).boxed().toArray(Integer[]::new);
        }
        return res;
    }
}
