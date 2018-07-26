package com.company.alg;


import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 级别高的小孩子比他旁边的小孩得到的糖果多
 */
public class Candy {
    public static int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys,1);
        for(int i = 1;i < ratings.length;i++){// 从左到右发一次糖
            if(ratings[i] > ratings[i-1]){
                candys[i] = candys[i-1] + 1;
            }
        }
        //再从右往左发一次
        for(int j = ratings.length - 2;j >= 0;j--){
            if(ratings[j] > ratings[j+1] && candys[j] <= candys[j + 1]){
                candys[j] = candys[j + 1] + 1;
            }
        }
        int res = 0;
        for(int i = 0;i < candys.length;i++){
            res += candys[i];
        }
        return res;
    }
    public static void main(String[] args){
      int[] ranting = new int[]{5,3,1};
      System.out.println(candy(ranting));
    }
}
