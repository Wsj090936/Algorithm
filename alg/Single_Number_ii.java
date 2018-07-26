package com.company.alg;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Single_Number_ii {
    public static int singleNumber(int[] A) {
        int cur = 0;
        int ptr = cur + 1;
        int len = A.length;
        int times = 2;
        while(ptr < len){
            if(A[ptr] == A[cur]){
                swap(A,++cur,ptr);
                ptr = cur + 1;
                times--;
            } else if(times == 0){//记录次数
                cur++;
                ptr++;
                times = 2;
            }else{
                ptr++;
            }

        }
        return A[cur];
    }
    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args){
        int[] arr = new int[]{2,2,4,5,6,3,4,6,5,3,1};
        int i = singleNumber(arr);
        System.out.println(i);
    }
}
