package org.xuan.strings;

/**
 * Created by xzhou2 on 1/22/17.
 */
public class ReverseVowles_345 {
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while(true) {
            while(low <= high && !isVowel(arr[low])) {
                low++;
            }
            while(low <= high && !isVowel(arr[high])) {
                high--;
            }
            if (low < high) {
                char tmp = arr[low];
                arr[low++] = arr[high];
                arr[high--] = tmp;
            } else {
                break;
            }
        }
        return new String(arr);
    }

    private boolean isVowel(char c) {

        return  (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') ;
    }
}
