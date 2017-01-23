package com.heqaing.test;

import java.io.*;

public class Test_clazz {

	public static void main(String[] args) throws IOException {
			try {
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\test\\origin.mkv"));
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\test\\cope2.mkv"));
				byte[] bytes = new byte[1870];
				long t1 = System.currentTimeMillis();
				int i;
				while ((i=bis.read(bytes,0,1870))!=-1){
					bos.write(bytes,0,i);
				}
				long t2 = System.currentTimeMillis();
				System.out.println(t2-t1);
				bis.close();
				bos.close();
			} catch (IOException e) {
				System.err.println("FileStreamsTest: " + e);
			}


	}
}
