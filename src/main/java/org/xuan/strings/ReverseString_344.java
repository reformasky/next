package org.xuan.strings;

/**
 * Created by xzhou2 on 1/22/17.
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        int low = 0, high = arr.length - 1;
        while(low < high) {
            char tmp = arr[low];
            arr[low++] = arr[high];
            arr[high--] = tmp;
        }
        return new String(arr);
    }
}
