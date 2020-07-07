package test;

import java.util.Scanner;

public class TestBinarySearchRecursion {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11, 13};
        System.out.print("请输入要查找的元素：");
        int e = new Scanner(System.in).nextInt();
        int index = binarySearch(a, 0, a.length - 1, e);
        System.out.println(index!=-1?"查找的元素索引为："+index:"没有该元素");

    }

    private static int binarySearch(int[] a, int low, int high, int e) {
        int mid = 0;
        if (low <= high) {
            mid = (low + high) / 2;
            if (a[mid]==e){
                return mid;
            }else if (a[mid]<e){
                return binarySearch(a,mid+1,high,e);
            }else {
                return binarySearch(a,low,mid-1,e);
            }
        }

        return -1;
    }


}
