package com.chrisyin.leetcode.problem;

/**
 * 二进制求和
 *
 * @author Chris Yin
 * @date 2020-05-10
 * @see <a href="https://leetcode-cn.com/problems/add-binary/">add-binary</a>
 */
public class P0067 {
    String addBinary(String a, String b) {
        StringBuilder rst = new StringBuilder();
        int cursor = 0;
        int acc = 0;
        while (cursor < a.length() || cursor < b.length()) {
            int ia = 0, ib = 0;
            if (cursor < a.length()) {
                ia = Integer.valueOf(String.valueOf(a.charAt(a.length() - 1 - cursor)));
            }
            if (cursor < b.length()) {
                ib = Integer.valueOf(String.valueOf(b.charAt(b.length() - 1 - cursor)));
            }
            int bit = ia ^ ib;
            if (acc > 0) {
                if (bit == 0) {
                    acc--;
                }
                bit = 1 - bit;
            }
            rst.insert(0, bit);
            if (ia == 1 && ib == 1) {
                acc++;
            }

            cursor++;
        }
        while (acc > 0) {
            if (acc > 1) {
                rst.insert(0, 0);
                acc -= 2;
            } else {
                rst.insert(0, 1);
                acc--;
            }
        }

        return rst.toString();
    }

    public static void main(String[] args) {
        //        String a = "11", b = "1";
        String a = "1010", b = "1011";
        String rst = new P0067().addBinary(a, b);
        System.out.println(a);
        System.out.println(b);
        System.out.println(rst);
    }
}
