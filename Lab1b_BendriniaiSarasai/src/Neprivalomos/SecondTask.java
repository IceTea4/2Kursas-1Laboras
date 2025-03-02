package Neprivalomos;   

import java.util.ArrayList;

public class SecondTask {

    public static void main(String[] args) {
        int k = 4;
        int[] row = {2, 7, 3, 1, 5, 2, 6, 2};

        ArrayList<Integer> result = findMaxInRanges(row, k);
        System.out.println(result); // [7, 7, 5, 6, 6]
    }

    public static ArrayList<Integer> findMaxInRanges(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length - k + 1; i++) {
            result.add(findMax(arr, i, i + k - 1));
        }

        return result;
    }

    public static int findMax(int[] arr, int from, int to) {
        int result = Integer.MIN_VALUE;

        for (int i = from; i <= to; i++) {
            if (arr[i] > result) {
                result = arr[i];
            }
        }

        return result;
    }

    /*public static ArrayList<Integer> findMaxInRanges(int[] arr, int k){
        ArrayQueue<Integer> deque = new ArrayQueue<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            if (!deque.isEmpty() && deque.peak() <= i - k) {
                deque.dequeue();
            }

            while (!deque.isEmpty() && (arr[deque.peak()] <= arr[i] || findMax(k, arr, deque) != arr[deque.peak()])) {
                deque.dequeue();
            }

            deque.enqueue(i);

            if (i >= k - 1) {
                result.add(arr[deque.peak()]);
            }
        }

        return result;
    }

    public static int findMax(int k, int[] arr, ArrayQueue<Integer> deque) {
        int result = -1;

        for (int i = 0; i <= deque.rear() - deque.front(); i++) {
            if (result <= arr[deque.peak() + i]) {
                result = arr[deque.peak() + i];
            }
        }

        return result;
    }*/
}
