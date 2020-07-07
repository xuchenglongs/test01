package test;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        String [] strs = {"sss","ssd","ssx"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i==strs[j].length()||ch!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix1(String[] strs){
        String s = "";
        if (strs==null||strs.length==0){
            return s;
        }
        if (strs.length==1&&strs[0].equals("")){
            return s;
        }
        //先取出最短的字符串
        String minLen = strs[0];
        for(int i=1;i<strs.length;i++){
            if(minLen.length()>strs[i].length()){
                strs[0] = strs[i];
                strs[i] = minLen;
            }
            minLen = strs[0];
        }
        //比较每个字符串字符是否相等，相等继续比较，不相等返回
        for (int i = 0; i < minLen.length(); i++) {
            char ch = minLen.charAt(i);
            System.out.println(ch);
            for (int j = 1; j < strs.length; j++) {
                if (ch!=strs[j].charAt(i)){
                    return s;
                }
                s+= ch;
            }
        }
        return s;
    }

}
