package array;

public class BinarySearch {
    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6 };
        int result = -1;

        BinarySearch bs = new BinarySearch();
        result = bs.binarySearchByRecursive(data, 3, 0, data.length - 1);
        System.out.println(result);
        result = bs.binarySearchByByIterative(data, 3);
        System.out.println(result);
    }

    // 递归方式
    private int binarySearchByRecursive(int[] data, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        if (data[mid] == key) {
            return mid;
        } else if (data[mid] > key) {
            return binarySearchByRecursive(data, key, left, mid - 1);
        } else {
            return binarySearchByRecursive(data, key, mid + 1, right);
        }
    }

    // 迭代方式
    private int binarySearchByByIterative(int[] data, int key) {
        int left = 0;
        int right = data.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (data[mid] == key) {
                return mid;
            } else if (data[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}