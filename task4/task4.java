import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class task4 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide path to input file!");
        }

        int[] nums = processInput(args);
        // System.out.println(Arrays.toString(nums));
        
        /*
         * Привет тому, кто это читает!
         * 
         * Тут на ваше усмотрение, я не уверен на 100% в своей реализации
         * quickSelect, поэтому чтобы наверняка - Arrays.Sort(), хоть он в среднем медленнее
         */
        Arrays.sort(nums); // O(n log n)
        int median = nums[nums.length / 2];
        // int median = quickSelect(nums, nums.length / 2); // O(n), worst case O(n^2)
        
        int steps = 0;
        System.out.println("Median element: " + median);
        for (int num : nums) {
            steps += Math.abs(num - median);
        }

        System.out.println(steps);
    }

    public static int[] processInput(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(args[0]));
            return lines.stream().mapToInt(Integer::parseInt).toArray();
        } catch (IOException e) {
            System.out.println("Error parsing file: " + args[0]);
        }

        return null;
    }

    public static int quickSelect(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivotIndex = partition(nums, left, right);
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
