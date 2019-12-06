package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ip_to_cidr_2 {

    private static final long DOUBLE_INTEGER = 1L << 32;

    public static void main(String[] args) {
        ip_to_cidr_2 ipToCidr = new ip_to_cidr_2();
        String ip = "223.24.23.34";
        int n = 100;
        //2 4 8 16 64 4 2
        System.out.println(Integer.toBinaryString(99));
        System.out.println(ipToCidr.ipToCIDR(ip, n));
    }


    public List<String> ipToCIDR(String ip, int range) {
        long x = 0;
        //获得一个ip地址每一部分
        String[] ips = ip.split("\\.");
        //将整ip地址看为一个整体，求出整体的int表示
        for (int i = 0; i < ips.length; ++i) {
            x = Integer.parseInt(ips[i]) + x * 256;
        }
        System.out.println(Long.toBinaryString(x));
        List<String> ans = new ArrayList<>();
        while (range > 0) {
            //求出二进制表示下的最低有效位的位数能表示的地址的数量
            //如果为奇数，则=1，即以原单个起始ip地址为第一块
            //如果为偶数，则二进制表示下的最低有效位的位数能表示的地址的数量
            long step = x & -x;
            //如果大于range，则需要缩小范围
            while (step > range) step /= 2;
            //不大于需要的range，开始处理
            //求出现在能表示的step个地址的地址块
            ans.add(longToIP(x, (int) step));
            //x加上以求出的地址块
            x += step;
            //range减去以表示的地址块
            range -= step;
        }//直到range<0
        return ans;
    }

    static String longToIP(long x, int step) {
        int[] ans = new int[4];
        //&255操作求出后8位十进制表示
        ans[0] = (int) (x & 255);
        //右移8位，即求下一个块
        x >>= 8;
        ans[1] = (int) (x & 255);
        x >>= 8;
        ans[2] = (int) (x & 255);
        x >>= 8;
        ans[3] = (int) x;
        int len = 33;
        //每一位就可以表示2个
        while (step > 0) {
            len--;
            step /= 2;
        }
        return ans[3] + "." + ans[2] + "." + ans[1] + "." + ans[0] + "/" + len;

    }
}

