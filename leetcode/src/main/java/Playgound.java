import java.util.Arrays;

/**
 * 练习场地
 *
 * @author 李俊秋(龙泽)
 */
public class Playgound {

    public static void main(String[] args) {
        Playgound solution = new Playgound();

//        [2,3] [4,5,100] 18 expect:17
        int[] baseCosts = new int[]{2,3};
        int[] toppingCosts = new int[]{4,5,100};
        int target = 18;
        int ans = solution.closestCost(baseCosts, toppingCosts, target);
        System.out.println(ans);


        // 在这儿练习吧～


    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Arrays.stream(baseCosts).min().getAsInt();
        if (min >= target) {
            return min;
        }

        int max = target + target - min;
        int diff = min;
        int len = max - min;
        boolean[] dp = new boolean[len];

        for (int cost : baseCosts) {
            if (cost < max) {
                dp[cost - diff] = true;
            }
        }

        int next;
        for (int t : toppingCosts) {
            for (int j = len - 1; j >= 0; --j) {
                if (dp[j]) {
                    if ((next = j +  t) < len) {
                        dp[next] = true;
                    }
                    if ((next += t) < len) {
                        dp[next] = true;
                    }
                }
            }
        }


        for (int i = target - diff, j = target - diff; i >= 0 & j < len; --i, ++j) {
            if (dp[i]) {
                return i + diff;
            }
            if (dp[j]) {
                return j + diff;
            }
        }

        return min;
    }

}
