package array;

import java.util.Arrays;

public class 행렬의_곱셈 {

    public static int[][] solution(int[][] arr1, int[][] arr2) {

        // y가 새로 생길 행렬의 세로
        // x가 세로 생길 행렬의 가로
        int y = arr1.length;
        int x = arr2[0].length;

        int[][] answer = new int[y][x];

        for (int i = 0; i < y; i++) {
            int[] currentArr1 = arr1[i];

            for (int j = 0; j < x; j++) {
                for (int k = 0; k < currentArr1.length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        int[][] solution = solution(arr1, arr2);

        for (int i = 0; i < solution.length; i++) {
            System.out.println(Arrays.toString(solution[i]));
        }
    }
}
