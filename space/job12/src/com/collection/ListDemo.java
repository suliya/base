package com.collection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;

class Employee {
	private String name;
	private String address;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}

public class ListDemo {
	public static void main(String[] args) {
		File file=new File("D:\\Ա��List.txt");
		List<Employee> employees=new ArrayList<Employee>();
		outfromfile(file, employees);	    
		Set<String> set=new TreeSet<String>();
		set=Account(employees);
		inputtofile(set);
	}

	private static void outfromfile(File file, List<Employee> employees) {
		try {
			file.createNewFile();
			Writer out=new FileWriter(file);
//			String input="����,����"+"\r\n"+"��ϣ,����"+"\r\n"+"��СС,����"+"\r\n"+"����,�ӱ�"+
//                           "\r\n"+"����,����"+"\r\n"+"����,����"+"\r\n"+"����,����"+"\r\n"+"����,����"+
//                           "\r\n"+"�Ӵ�,����"+"\r\n"+"����,�㽭";
//			out.write(input);
//			out.close();		
			RandomAccessFile raf=new RandomAccessFile(file, "r");
			String  line=raf.readLine();
			while (line!=null) {
				Employee employee=new Employee();
				String[] strings=line.split(",");
				employee.setName(transtr(strings[0]));
				employee.setAddress(transtr(strings[1]));
				employees.add(employee);
				line=raf.readLine();				
			}			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static Set Account(List<Employee> employees) {
		
		Set<String> setAddress =new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length()<=o2.length() &&!(o1.equals(o2))) return 1;
				return 0;
			}
		});
		for(int i=0;i<employees.size();i++) {
			String string=employees.get(i).getAddress()+" [";
			int count=0;
			for(Employee employee:employees){
				if(employees.get(i).getAddress().equals(employee.getAddress())){
					count++;
					string+=employee.getName()+" ";
				}
			}	
			string+="]";
			setAddress.add(string);
			
		}
		return setAddress;	
	
	}

	private static void inputtofile(Set<String> setAddress) {
		try {
			File file=new File("D:\\Ա��ͳ��List.txt");			
			file.createNewFile();
			Writer oWriter=new FileWriter(file);
			String string="";
			for(String string2:setAddress){
				string+=string2+"\r\n";				
			}
			System.out.println(string);
			oWriter.write(string);
			oWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String transtr(String oldstr) {
		String newstr = "";
	    try {
	      newstr = new String(oldstr.getBytes("ISO-8859-1"), "GBK");
	     } catch (UnsupportedEncodingException e) {
	     e.printStackTrace();
	     }
	     return newstr;
	}
	

}