package com.inputdemo;
import java.util.Scanner;

public class Inputdemo {

	public static void main(String[] args) {
       int[] claNum=new int[3];//三个班级
       int stuNum=4;
       int sum=0;
       int avg=0;
       Scanner input=new Scanner(System.in);
       for(int i=1;i<=claNum.length;i++){
    	   sum=0;
    	   System.out.println("请输入第"+i+"个班级学生成绩:");
    	   for(int j=1;j<=stuNum;j++){
    		   System.out.println("请输入第"+j+"个学生的成绩:");
    		   int score=input.nextInt();
    		   sum+=score;
    	   }
    	   avg=sum/stuNum;
    	   System.out.println("该班的平均成绩为："+avg);
       }
	}
    
}
