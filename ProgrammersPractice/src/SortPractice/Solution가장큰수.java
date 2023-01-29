package SortPractice;

import java.util.Comparator;
import java.util.Arrays;

class Solution가장큰수 {
    public String solution(int[] numbers) {
        String[] strNums = new String[numbers.length];
        for(int i = 0; i< numbers.length; i++){
            strNums[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if (strNums[0].equals("0")) {
           return "0";
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i< numbers.length; i++){
            sb.append(strNums[i]);
        }
        
        return sb.toString();
    }
}