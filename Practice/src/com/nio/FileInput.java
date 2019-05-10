package com.nio;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class FileInput {
	public static void method2() {
		InputStream in = null;
		
		try {
			FileInputStream fis = new FileInputStream("test.txt");
			in = new BufferedInputStream(fis);
			byte[] buf = new byte[1024];
			int bytesRead = in.read(buf);
			while (bytesRead !=-1)
			{
				for (int i=0;i<bytesRead;i++)
				{
					System.out.println((char)buf[i]);
					bytesRead = in.read(buf);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (in !=null)
					in.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) {
		method2();
		HashMap<Integer, Integer>hashMap = new HashMap<>();
		
	}
}
