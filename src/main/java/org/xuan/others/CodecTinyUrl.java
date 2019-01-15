package org.xuan.others;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xzhou2 on 3/27/17.
 */
public class CodecTinyUrl {
    Map<String, List<String>> shortToLong = new HashMap<>();
    Map<String, String> longToShort = new HashMap<>();

    private static final String PREFIX = "http://tinyurl.com/";
    private static final String SEPERATE = "_";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (longToShort.containsKey(longUrl)) {
            return longToShort.get(longUrl);
        }
        String encode = intToBase62(longUrl.hashCode());
        List<String> list;
        if (shortToLong.containsKey(encode)) {
            list = shortToLong.get(encode);
        } else {
             list = new ArrayList<>();
            shortToLong.put(encode, list);
        }
        encode += SEPERATE + list.size();
        list.add(longUrl);
        longToShort.put(longUrl, encode);
        return PREFIX + encode;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = shortUrl.lastIndexOf(SEPERATE);
        int pos = Integer.parseInt(shortUrl.substring(index+ 1));
        String encode = shortUrl.substring(PREFIX.length(), index);
        List<String> list = shortToLong.getOrDefault(encode, new ArrayList<>());
        if (list.size() <= pos) {
            throw new RuntimeException();
        }
        return list.get(pos);
    }

    private static String intToBase62(int i) {
        while(i <= 0) {
            i += Integer.MAX_VALUE;
        }
        StringBuilder sb = new StringBuilder();
        while(i > 0) {
            sb.append(getChar(i % 62));
            i /= 62;
        }
        return sb.toString();
    }

    private static char getChar(int i) {
        if (i  < 10) {
            return (char)(i + '0');
        } else if (i < 36) {
            return (char)(i - 10 + 'a');
        } else {
            return (char)(i - 36 + 'A');
        }
    }
}
