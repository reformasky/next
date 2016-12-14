package org.xuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xzhou2 on 12/8/16.
 */
public class FullAdjustStrings_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        StringBuilder sb;
        if (words.length == 0) {
            return result;
        }
        int begin = 0, end = 0, len = words[0].length();
        for(int c = 1; c < words.length; c++) {
            String word = words[c];
            if(len + 1 + word.length() > maxWidth) {
                sb = new StringBuilder(maxWidth);
                if (begin == end) {
                    sb.append(words[begin]);
                    for(int i = 0; i < maxWidth - words[begin].length(); i++) {
                        sb.append(' ');
                    }
                    result.add(sb.toString());
                } else {
                    int space = maxWidth - len,
                            spaceCount = end - begin,
                            meanSpace = space / spaceCount,
                            extraCount = space - meanSpace * spaceCount;
                    for(int i = begin; i < extraCount + begin; i++) {
                        sb.append(words[i]);
                        sb.append(" ");
                        for(int j = 0; j < meanSpace + 1; j++) {
                            sb.append(' ');
                        }
                    }
                    for(int i = extraCount + begin; i < end; i++) {
                        sb.append(words[i]);
                        sb.append(" ");
                        for(int j = 0; j < meanSpace; j++) {
                            sb.append(' ');
                        }
                    }
                    sb.append(words[end]);
                    result.add(sb.toString());
                }
                begin = c;
                end = c;
                len = words[c].length();
            } else {
                end++;
                len += 1 + word.length();
            }
        }
        sb = new StringBuilder();
        for(int i = begin; i < end; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        sb.append(words[end]);
        for(int i = len; i < maxWidth; i++) {
            sb.append(" ");
        }
        result.add(sb.toString());
        return result;
    }
}
