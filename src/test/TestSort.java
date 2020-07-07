package test;

public class TestSort {

    public static void main(String[] args) {
        int [] a ={20,2,57,44,7,3,99};
//        int[] sort = selSort(a);
//        int[] sort = bubbleSort(a);
        int[] sort = selectSort(a);
        for (int s:sort) {
            System.out.print(s+" ");
        }
    }


    public static int [] selSort(int [] x){
        for (int i = 0; i < x.length-1; i++) {
            for (int j = i+1; j >0 ; j--) {
                if (x[j]<x[j-1]){
                    int temp = x[j-1];
                    x[j-1] = x[j];
                    x[j] = temp;
                }
            }
        }
        return x;
    }

    public static int [] bubbleSort(int [] x){
        for (int i = 0; i < x.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < x.length-1; j++) {
                if (x[j]>x[j+1]){
                    int temp = x[j];
                    x[j]=x[j+1];
                    x[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        return x;
    }

    public static int [] selectSort(int x[]){
        for (int i = 0; i < x.length-1; i++) {
            int v = x[i];
            for (int j = i+1; j < x.length; j++) {
                if (x[i]>x[j]){
                    int temp = x[j];
                    x[j] = x[i];
                    x[i] = temp;
                }
            }
        }
        return x;
    }
}
