//s23001
//中央値を求めるようにした　
import java.util.Arrays;

public class d49Q6kadai02 {
    public static void main(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        Analyzer analyzer = new Analyzer();
        analyzer.setNums(nums);
        System.out.println("平均値：" + analyzer.getAverage());
        System.out.println("値の範囲：" + analyzer.getRange());
        int[] counts = analyzer.getHighLowCounts();
        System.out.println("平均より大きい値の個数：" + counts[0] + " 平均より小さい値の個数：" + counts[1]);
        System.out.println("中央値：" + analyzer.getMedian());
    }
}

class Analyzer {
    private int[] nums;

    void setNums(int[] nums) {
        this.nums = nums;
    }

    double getAverage() {
        double sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum / nums.length;
    }

    int getRange() {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        return sortedNums[sortedNums.length - 1] - sortedNums[0];
    }

    int[] getHighLowCounts() {
        double avg = getAverage();
        int high = 0, low = 0;
        for (int n : nums) {
            if (n < avg) {
                low++;
            }
            if (n > avg) {
                high++;
            }
        }
        return new int[]{high, low};
    }

    double getMedian() {
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int middleIndex = sortedNums.length / 2;
        if (sortedNums.length % 2 == 0) {
            return (sortedNums[middleIndex - 1] + sortedNums[middleIndex]) / 2.0;
        } else {
            return sortedNums[middleIndex];
        }
    }
}

