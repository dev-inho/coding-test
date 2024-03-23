package array;

import java.util.*;

public class 두_개_뽑아서_더하기 {

    public static int[] solution(int[] numbers) {
        if (numbers == null || numbers.length < 1) { // 유효하지 않은 데이터 처리
            return null;
        }

        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int previousNumber = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                int nextNumber = numbers[j];

                result.add(previousNumber + nextNumber);
            }
        }

        return result.stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 1, 3, 4, 1};
        int[] arr2 = {5, 0, 2, 7};

        System.out.println(Arrays.toString(solution(arr1)));;
        System.out.println(Arrays.toString(solution(arr2)));;
    }

}
