package learn.challenges.dp.lv3;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12913
 * 제목: 땅따먹기
 *
 * Time Complexity: O(n^3)
 * Space Complexity: O(n)
 */
public class EatTheLand {

    int solution(int[][] land) {
        int answer = 0;
        for (int i = 1; i < land.length; i++) {
            // 이전 줄의 값중 가장 큰값(0,1,2,3)
            for (int j = 0; j < land[0].length; j++) {
                // 컬럼 각각에 대해서 포문 돌리기
                // 이번에 변경할 컬럼의 원본값
                int num = land[i][j];
                for (int k = 0; k < land[0].length; k++) {
                    // 위에랑 같은 컬럼은 패스
                    if(k == j) continue;
                    land[i][j] = Math.max(land[i][j], num + land[i-1][k]);
                }
            }
        }
        // 지금위치, 이전 선택한 col

        for (int i = 0; i < land[land.length-1].length; i++) {
            answer = Math.max(answer, land[land.length-1][i]);
        }
        return answer;
    }

    /**
     * dfs로 풀면 모든 풀이가 시간 초과됨.
     *  // 지금위치, 이전 선택한 col
     *         dfs(land, 0, -1,0);
     */
    private void dfs(int[][] land, int index, int prevCol, int sum) {
        int answer = 0;
        if(index == land.length) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < land[0].length; i++) {
            if (i == prevCol) continue;
            dfs(land, index + 1, i, sum + land[index][i]);
        }
    }

    public static void main(String[] args) {
        EatTheLand solution = new EatTheLand();
        System.out.println("solution = " + solution.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }
}
