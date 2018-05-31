package com.heima.IO.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFile {
	public static void main(String[] args) throws IOException {
//		demo2();
//		demo3();
		
	}

	private static void demo3() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("yyy.txt");
		FileOutputStream fos = new FileOutputStream("xxx.txt");
		byte[] arr = new byte[1024];
		int len;
		while((len = fis.read(arr))!=-1){
			fos.write(arr);
		}
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		fis.close();
		fos.close();
	}

	private static void demo2() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("yyy.txt");
		int a = fis.read();
		System.out.println(a);
		int b = fis.read();
		System.out.println(b);
		int c = fis.read();
		System.out.println(c);
		int d = fis.read();
		System.out.println(d);
		int e = fis.read();
		System.out.println(e);
		int f = fis.read();
		System.out.println(Integer.toBinaryString(fis.read()));
	}

	private static File demo1() {
		File file = new File("aaa");		
		File file2 = new File("bbb.doc");
		System.out.println(file.isDirectory());
		System.out.println(file2.isFile());
		return file2;
	}
}