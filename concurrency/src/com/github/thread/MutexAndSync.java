package com.github.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexAndSync {
	public static void main(String[] args) {
		/**ͬ���ؼ���  synchronized(JVMʵ�ֵ�)
			ͬ��һ�������  synchronized(this){} ������ͬһ����������������������ϵ�ͬ������飬�Ͳ������ͬ����
			ͬ��һ������ public synchronized void func(){} ��ͬ�������һ����ֻ��������ͬһ������
			ͬ��һ���� synchronized(Student.class)�����������࣬Ҳ����˵�������̵߳���ͬһ����Ĳ�ͬ�����ϵ�����ͬ����䣬Ҳ��Ҫ����ͬ����
			ͬ��һ����̬���� public synchronized static void func(){} ������������
		*/
		
		/**ReentrantLock(JDKʵ�ֵ�)    java.util.concurrent���е����������synchronized���������µĸ߼����ܡ�
		 * 1���ȴ����ж�
		 * 2����ʵ�ֹ�ƽ��
		 * 3�����󶨶������
		 * 
		 * 
		 * 
		 * */
		
		/**
		 * synchronized��ReentrantLock������
		 * 	1������ʵ��
		 * 		synchronized��JVMʵ�֣���ReentrantLock��JDKʵ�ֵ�
		 *  2������
		 *  	���������������°汾��java��synchronized�����˺ܶ��Ż��������������ȡ�Ŀǰ������ReentrantLock�����ܲ�࣬��ʹ��ʱһ�������ѡ��synchronized
		 *  3������
		 *  	ReentrantLock����һЩ�߼�����
		 *  4��ʹ��ѡ��
		 *  	������Ҫʹ��ReentrantLock�ĸ߼����ܣ���������ʹ��synchronized��������Ϊsynchronized��JVMʵ�ֵ�һ�������ƣ�JVMԭ����֧������
		 *  	��ReentrantLock�������е�JDK�汾��֧�֡�����ʹ��synchronized���õ���û���ͷ����������������⣬��ΪJVM��ȷ�������ͷ�
		 * */
		final LockExample le = new LockExample();
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				le.fun();
			}
		});
		
		es.execute(new Runnable() {
			
			@Override
			public void run() {
				le.fun();
			}
		});
		
	}
}

class LockExample{
	private Lock lock = new ReentrantLock();
	public void fun(){
		lock.lock();
		try {
			for(int i=0;i<10;i++){
				System.out.println(i+" ");
			}
		} finally {
			lock.unlock();//ȷ���ͷ������Ӷ����ⷢ������
		}
	}
}