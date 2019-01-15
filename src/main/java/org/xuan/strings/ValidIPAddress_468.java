package org.xuan.strings;

/**
 * Created by xzhou2 on 3/6/17.
 */
public class ValidIPAddress_468 {
    public String validIPAddress(String IP) {
        if (IP.contains(".")) {
            return validV4(IP);
        }  else {
            return validV6(IP);
        }
    }

    private String validV4(String IP) {
        IP = IP + ".";
        int count = 0;
        int begin = 0;
        for(int i = 0; i < IP.length(); i++) {
            char c = IP.charAt(i);
            if (c == '.') {
                int curr;
                try {
                    curr = Integer.parseInt(IP.substring(begin, i));
                } catch(Exception ex) {
                    curr = 256;
                }
                //System.out.println(IP.substring(begin, i)  + " " + curr);
                if (curr >= 256 || curr < 0|| String.valueOf(curr).length() != i - begin) {
                    return "Neither";
                }
                count++;
                begin = i + 1;
            }
        }
        return count == 4 ? "IPv4" : "Neither";
    }

    private String validV6(String IP) {
        IP = IP + ":";
        int count = 0;
        int begin = 0;
        for(int i = 0; i < IP.length(); i++) {
            char c = IP.charAt(i);
            if (c == ':') {
                //System.out.println(i - begin);
                if (i - begin > 4 || i - begin == 0) {
                    return "Neither";
                }
                begin = i +1;
                count++;
            } else if (! ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) {
                return "Neither";
            }
        }
        return count == 8 ? "IPv6" : "Neither";
    }
}
