package com.chrisyin.leetcode.contest.c188;

import java.util.LinkedList;
import java.util.List;

/**
 * 第188场周赛
 * 5404. 用栈操作构建数组 显示
 *
 * @author Chris Yin
 * @date 2020-05-10
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-188">weekly-contest-188</a>
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-188/problems/build-an-array-with-stack-operations/">5404</a>
 */
public class C188P5404 {
    public List<String> buildArray(int[] target, int n) {
        String push = "Push", pop = "Pop";
        List<String> result = new LinkedList<>();
        int cursor = 0;
        for (int i = 1; i <= n; i++) {
            if (cursor >= target.length) {
                break;
            }
            result.add(push);
            if (target[cursor] != i) {
                result.add(pop);
            } else {
                cursor++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] target = new int[] {2, 3, 4};
        int n = 4;
        System.out.println(new C188P5404().buildArray(target, n));
    }
}
