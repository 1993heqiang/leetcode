package com.rookie.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ip_to_cidr {

    private static final long DOUBLE_INTEGER = 1L<<32;

    public static void main(String[] args) {
        ip_to_cidr ipToCidr = new ip_to_cidr();
        String ip = "255.225.225.224";
        int n = 2;
        System.out.println(ipToCidr.ipToCidr(ip, n));
    }

    public List<String> ipToCidr(String ip, int n) {
        long ipLong = ipToLong2(ip);
        String ipIntStr = Long.toBinaryString(ipLong+DOUBLE_INTEGER).substring(1);
        String arr = Integer.toBinaryString(n - 1);
        char[] bitArr = arr.toCharArray();
        int len = bitArr.length;
        TempResult temp = new TempResult("", 32);
        List<String> list = new ArrayList<>();
        list.add(ip+"/"+32);
        for (int i = 0; i < len; i++) {
            if (bitArr[i] == '1') {
                if(i==len-1&&ipIntStr.charAt(31)=='0'){
                    list.remove(0);
                    list.add(ip+"/"+31);
                }else {
                    temp = convertToCidr(ipIntStr,temp.getPosition(),i);
                    list.add(temp.getIp()+"/"+(32-(len-i-1)));
                }
            }
        }
        return list;
    }

    public TempResult convertToCidr(String ipIntStr, int start,int limit) {
        char[] arr = ipIntStr.toCharArray();
        for(int i=start;i<32;i++){
            arr[i] = '0';
        }
        TempResult temp = null;
        for(int i=start-1;i>=0;i--){
            if(arr[i]=='0'&&(32-i)>=limit){
                arr[i] = '1';
                temp = new TempResult(longToIp(bianary2Decimal(new String(arr))),i);
                break;
            }else {
                arr[i] = '0';
            }
        }
        return temp;
    }

    public  static  Integer bianary2Decimal(String radix){
        int x = 0;
        for(char c:radix.toCharArray())
            x = x*2 + (c=='1'?1:0);
        return x;
    }

    private static class TempResult {
        private String ip;
        private int position;

        public TempResult(String ip, int position) {
            this.ip = ip;
            this.position = position;
        }

        public String getIp() {
            return ip;
        }

        public int getPosition() {
            return position;
        }
    }

    public long ipToLong2(String ipAddress) {

        long result = 0;

        String[] ipAddressInArray = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {

            long ip = Long.parseLong(ipAddressInArray[3 - i]);

            // left shifting 24,16,8,0 and bitwise OR

            // 1. 192 << 24
            // 1. 168 << 16
            // 1. 1 << 8
            // 1. 2 << 0
            result |= ip << (i * 8);

        }
        return result;
    }

    public String longToIp(long i) {

        return ((i >> 24) & 0xFF) +
                "." + ((i >> 16) & 0xFF) +
                "." + ((i >> 8) & 0xFF) +
                "." + (i & 0xFF);

    }
}
