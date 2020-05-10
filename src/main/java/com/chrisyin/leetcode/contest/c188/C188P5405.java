package com.chrisyin.leetcode.contest.c188;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 第188场周赛
 * 5405. 形成两个异或相等数组的三元组数目
 *
 * @author Chris Yin
 * @date 2020-05-10
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-188">weekly-contest-188</a>
 * @see <a href="https://leetcode-cn.com/contest/weekly-contest-188/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">5405</a>
 */
public class C188P5405 {
    public int countTriplets(int[] arr) {
        // TODO: 待优化，超时了
        int count = 0;
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    int[] arrA = Arrays.copyOfRange(arr, i, j);
                    int a = xor(arrA);
                    int[] arrB = Arrays.copyOfRange(arr, j, k + 1);
                    int b = xor(arrB);
                    if (a == b) {
                        //                        System.out.println("xor a: " + JSON.toJSONString(arrA));
                        //                        System.out.println("xor b: " + JSON.toJSONString(arrB));
                        System.out.println(i + ", " + j + ", " + k + " : a=" + a + " b=" + b);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int xor(int[] ii) {
//        System.out.println("xor: " + JSON.toJSONString(ii));
        int rst = 0;
        boolean finished = false;
        int count = 1;
        while (!finished) {
            int tmpRst = 0;
            finished = true;
            for (int idx = 0; idx < ii.length; idx++) {
                tmpRst ^= ii[idx] % 2;
                ii[idx] = ii[idx] >>> 1;
                if (finished && ii[idx] > 0) {
                    finished = false;
                }
            }
            //            System.out.println("XXX: " + JSON.toJSONString(ii));
            rst += tmpRst << count;
            count++;
        }
        return rst;
    }

    public static void main(String[] args) {
        //        new C188P5405().xor(new int[]{3,1,6});
        int[] arr =
            new int[] {808, 874, 66, 212, 150, 827, 941, 951, 26, 906, 912, 332, 732, 319, 995, 119, 916, 890, 238, 385,
                367, 806, 585, 451, 906, 699, 305, 476, 237, 823, 986, 794, 192, 237, 45, 671, 690, 100, 726, 936, 382,
                610, 796, 674, 446, 486, 88, 433, 489, 319, 214, 117, 163, 148, 55, 735, 744, 92, 692, 611, 215, 519,
                720, 620, 188, 477, 353, 6, 359, 896, 743, 490, 781, 743, 490, 9, 483, 815, 716, 71, 651, 65, 714, 207,
                517, 124, 633, 623, 22, 768, 790, 296, 574, 289, 799, 186, 933, 514, 423, 301, 138, 99, 233, 910, 871,
                48, 855, 532, 323, 168, 491, 914, 633, 124, 517, 258, 775, 326, 577, 127, 574, 770, 316, 835, 639, 828,
                323, 177, 498, 366, 156, 644, 536, 920, 384, 133, 261, 181, 432, 951, 519, 903, 384, 93, 477, 400, 77,
                647, 714, 645, 79, 451, 396, 959, 563, 332, 895, 81, 814, 31, 817, 702, 399};
        //        int[] arr = new int[]{2,3,1,6,7};
        //        int[] arr = new int[]{7,11,12,9,5,2,7,17,22};
        System.out.println(new C188P5405().countTriplets(arr));
    }
}
