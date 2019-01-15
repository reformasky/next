package org.xuan.strings;

/**
 * Created by xzhou2 on 2/21/17.
 */


/**
 * The most difficult part of this problem is how to handle deletions when the length greater than 20.
 * The other two situations, validated length and length less than 6 can be solved using just replacing and insertion.
 * Therefore, I will focus on how to take care of deletions here.
 * By considering replacing a letter only when there are three repeating characters, such as "...", we MUST resolve
 * it by replacing last one with "?", resulting "..?".
 * Here, "?" represents a "wild card", which can be any letter. In this case, we increase change_count by 1. At the
 * same time, decrease the type_count by 1 since "?" is a "wild card".
 * type_count is initially set to 3 to count those three type of characters needed for the password. One trick is to
 * allow type_count less than 0 so we would know how many "extra" wild cards exist.
 * <p>
 * Another key idea is that there are three kinds of repeating patterns to exchange "?" for deletions:
 * (1) "..?" => delete the last "?"
 * (2) "..?." => delete the last 2 "?."
 * (3) "..?.." => delete the last 3 "?.."
 * We peek the following two characters to find out to which pattern of a set of repeating characters belongs and use
 * delete_sets[3] to record how many of these patterns presenting in the password.
 * Therefore, when we need to do deletions, should_delete = len-20 characters, we should pick case (1) first since it
 * exchanges one deletion with one needed "?", so change_count--.
 * Next, case (2) exchanges two deletions with one "?" and then case (3) exchanges three deletions with one "?".
 * Meanwhile, every time change_count--, we do type_count++ because we remove one wild card.
 * However, when type_count >= 0, we can NOT use the "exchange" strategy because it is required to have at least
 * three types of characters.
 * At the end, if type_count >= 0, we need to use type_count of wild cards to replace other characters so the total
 * change is type_count + change_count, plus the delete count len-20 if len > 20.
 */
public class StrongPassword_420 {
    public int strongPasswordChecker(String s) {
        int len = s == null ? 0 : s.length();
        if (len <= 2) return 6 - len;
        char[] s_array = s.toCharArray();
        boolean cap = false, low = false, digit = false;
        char pre_char = 0;
        int pre_char_count = 0, type_count = 3, change_count = 0;
        int[] delete_sets = new int[3];
        for (int i = 0; i < len; i++) {
            char c = s_array[i];
            char c_ = i + 1 >= len ? 0 : s_array[i + 1];
            char c__ = i + 2 >= len ? 0 : s_array[i + 2];
            if (c >= '0' && c <= '9' && !digit) {
                digit = true;
                type_count--;
            } else if (c >= 'a' && c <= 'z' && !low) {
                low = true;
                type_count--;
            } else if (c >= 'A' && c <= 'Z' && !cap) {
                cap = true;
                type_count--;
            }
            if (c == pre_char) {
                if (pre_char_count == 2) {
                    change_count++;
                    type_count--;
                    if (c != c_) {
                        delete_sets[0]++;
                    } else if (c != c__) {
                        delete_sets[1]++;
                    } else {
                        delete_sets[2]++;
                    }
                    pre_char_count = 0;
                    pre_char = 0;
                } else {
                    pre_char_count++;
                }
            } else {
                pre_char_count = 1;
                pre_char = c;
            }
        }
        if (len < 6) {
            type_count = Math.max(type_count, 0);
            return Math.max(type_count + change_count, (6 - len));
        } else if (len > 20) {
            int should_delete = len - 20;
            for (int i = 0; i < 3; i++) {
                while (should_delete > i && delete_sets[i] > 0 && type_count < 0) {
                    should_delete -= (i + 1);
                    delete_sets[i]--;
                    type_count++;
                    change_count--;
                }
            }
            type_count = Math.max(type_count, 0);
            return len - 20 + type_count + change_count;
        }
        type_count = Math.max(type_count, 0);
        return type_count + change_count;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        StrongPassword_420 strongPassword_420 = new StrongPassword_420();
        strongPassword_420.strongPasswordChecker(s);
    }
}
