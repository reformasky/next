package org.xuan.array;

/**
 * Created by xzhou2 on 2/7/17.
 */
public class UFTF8Validation_393 {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length;i++) {
            int count = getCount(data[i]);
            if (count == 1 || count > 4) {
                return false;
            }
            for(int j = 0; j < count - 1; j++) {
                int index = j + i + 1;
                if (index >= data.length || ((data[index] & 0xc0) >> 6 != 2)) {
                    return false;
                }
            }
            i += count == 0 ? 0 : count - 1;
        }
        return true;
    }

    private int getCount(int i) {
        int result = 0;
        int mask = 0x80;
        while(mask > 0 && (mask & i) != 0) {
            result++;
            mask >>= 1;
        }
        return result;
    }
}
