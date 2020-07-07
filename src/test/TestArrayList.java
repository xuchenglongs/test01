package test;

import java.util.*;

public class TestArrayList {
    public static void main(String[] args) {
//        ArrayList<Object> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
////        int[] a = {1, 3, 5, 7, 9, 11, 13};
////        list.add(a);
//        list.add(2,9);
//
////        System.out.println(list.toString());
//        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
//        int a = 0,b=0,c=0,d=0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i]==1){
//                 a +=1;
//            }else if (arr[i]==3){
//                b+=1;
//            }else if (arr[i]==8){
//                c+=1;
//            }else if (arr[i]==2){
//                d+=1;
//            }
//        }
//        System.out.println("1出现："+a+"次");
//        System.out.println("3出现："+b+"次");
//        System.out.println("8出现："+c+"次");
//        System.out.println("2出现："+d+"次");
//        String s1="eeerr";
//        String s2="rreee";
//        System.out.println(s1.equals(s2));
//        boolean b1 = checkPermutation(s1, s2);
//        System.out.println(b1);
        List<String> list = new ArrayList<>();
        list.add("csdn");
        list.add("博客园");
        list.add("掘金");
        Iterator<String> iterator = list.iterator();
       while (iterator.hasNext()){
           String platform = iterator.next();
           if (platform.equals("csdn")){
               iterator.remove();
           }
       }
        for (String str:list) {
            System.out.println(str);
        }

    }
    public static boolean checkPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        char[] str1 = str(c1);
        char[] str2 = str(c2);

        if (s1.length()==s2.length()&&String.valueOf(str1).equals(String.valueOf(str2))){
            return true;
        }else {
            return false;
        }

    }

    public static  char [] str(char []c){
        for (int i = 0; i < c.length-1; i++) {
            for (int j = i+1; j < c.length; j++) {
                if (c[i]>c[j]){
                    char temp = c[i];
                    c[i] = c[j];
                    c[j] = temp;
                }
            }
        }
       return c;
    }


}
