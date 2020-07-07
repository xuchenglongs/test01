package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestSum {

    public static void main(String[] args) {

//        for (int i = 1; i <50 ; i++) {
//            testSum(i);
//        }
//
        int []nums = {2,7,3,6,4,5};int target = 9;
//        int[] ints = twoSum(nums, 9);
//        for (int i:ints) {
//            System.out.print(","+i);
//        }

        int index = 2;
        System.arraycopy(nums,index+1,nums,index,nums.length-index-1);
        int [] s = new int [nums.length-1];
        System.arraycopy(nums,0,s,0,s.length);
        nums = s;
        for (int i:nums){
            System.out.println(i+"、");
        }
    }
    static void print(int start,int end){
        for (int j=start;j<=end;j++){
            System.out.print(j+",");
        }
    }
    public static void testSum(int start){
        int num = 0;
        int end = 0;
//        for (int i = start; i < 100; i++) {
//            num+=i;
//            if (num==100){
//                end = i;
//                print(start,end);
//                System.out.println();
//                break;
//            }else if(num>100){
//                break;
//            }
//        }

        int k = start;
        while (start<100){
            num+=start;
            if (num==100){
                end=start;
                print(k,end);
                System.out.println();
                break;
            }else if(num>100){
                break;
            }
            start++;
        }
    }

    public static int [] twoSum(int[]sum,int target){
        for (int i = 0; i < sum.length-1; i++) {
            for (int j = i+1; j < sum.length; j++) {
                if (sum[i] == target-sum[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
}
