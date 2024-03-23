package array;

import java.util.*;
import java.util.stream.IntStream;

public class 모의고사 {

    public static int[] solution(int[] answers) {

        if (answers == null || answers.length < 1) { // 유효하지 않은 조건 제외
            return null;
        }

        int[][] pattern = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) { // 3명의 수포자 정답 여부 판별
            int currentAnswer = answers[i];

            for (int j = 0; j < pattern.length; j++) {
                int[] currentPattern = pattern[j];

                if (currentAnswer == currentPattern[i % currentPattern.length]) {
                    scores[j]++;
                }
            }
        }

        int maxScore = Arrays.stream(scores).max().getAsInt(); // 최대 점수 산출

        return IntStream.range(0, scores.length)
                .filter(i -> scores[i] == maxScore)
                .map(score -> score + 1)
                .toArray();
    }

    public static void main(String[] args) {
        /**
         * 조건
         *   1. 1번 수포자는 1, 2, 3, 4, 5 순으로 반복(5번)
         *   2. 2번 수포자는 2, 1, 2, 3, 4, 2, 5 순으로 반복(7번)
         *   3. 3번 수포자는 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 순으로 반복(10번)
         */

        int[] answer1 = {1, 2, 3, 4, 5};
        int[] answer2 = {1, 3, 2, 4, 2};

        System.out.println(Arrays.toString(solution(answer1)));
//        System.out.println(Arrays.toString(solution(answer2)));

    }
}
