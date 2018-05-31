package com.heima.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyHashMap {
	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
		
		//ģ�⶷����ϴ�ƺͷ��ƣ���û������
		String[] num={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] color={"��Ƭ","÷��","����","����"};
		ArrayList<String> poker = new ArrayList<>();
		
		for(String s1:color){
			for(String s2:num){
				poker.add(s1.concat(s2));
			}
		}
		
		poker.add("С��");
		poker.add("����");
		
		//ϴ��
		Collections.shuffle(poker);
		
		//����
		
		
	}

	private static void demo5() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("g");
		list.add("f");
		list.add("e");
		Collections.sort(list);
		int i=Collections.binarySearch(list, "n");
		System.out.println(Collections.max(list));
		System.out.println(i);
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	private static void demo4() {
		//ͳ���ַ�����ÿ���ַ����ֵĴ���
		String str="aaaaaabbbbbcccccdddddddddddddddd";
		char[] c=str.toCharArray();
		HashMap<Character, Integer> hm=new HashMap<>();
		for(char ch:c){
			/*if(hm.containsKey(ch)){
				hm.put(ch,hm.get(ch)+1 );
			}else {
				hm.put(ch, 1);
			}*/
			hm.put(ch, hm.containsKey(ch)?hm.get(ch)+1:1);
		}
		for(Map.Entry<Character, Integer> entry : hm.entrySet()){
			System.out.println(entry.getKey()+"  =  "+entry.getValue());
		}
	}

	private static void demo3() {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		map.put("֣��", 27);
		
		//Map.Entry˵��Entry��Map���ڲ��ӿڣ�������ֵ��װ����Entry���󣬲��Ҵ洢��Set������
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		
		/*//��������ȡÿһ��Set�����Entry����
		Iterator<Map.Entry<String, Integer>> it = set.iterator();
		while(it.hasNext()){
			Map.Entry<String, Integer> entry =it.next();
			String key=entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key+"  =  "+value);
		}*/
		
		//ʹ����ǿforѭ��
		/*Map.Entry<String, Integer> 
		  Entry<String, Integer>
		  �˴�����Map.Entry��Entry������
		  Entryʵ����Map.Entry�ӿ�
		  Map.Entry�������import java.util.Map;  ��������ָ���������
		  Entry�������import java.util.Map.Entry;ֱ�ӻ�ȡ����*/
	}

	private static void demo2() {
		//map�������ݼ���ȡֵ
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		map.put("֣��", 27);
		
		/*//map�ĵ���������
		Set<String> keySet = map.keySet();
		Iterator<String> keyit = keySet.iterator();
		while (keyit.hasNext()) {
			String key=keyit.next();
			Integer value = map.get(key);
			System.out.println(key+"  = "+value);
		}*/
		
		
		/*//map����ǿforѭ������
		for(String key :map.keySet()){//map.keySet()�����е�key����
			System.out.println(key+"������"+map.get(key));
		}*/
	}

	private static void demo1() {
		Map<String, Integer> map = new HashMap<>();
		map.put("����", 23);
		map.put("����", 24);
		map.put("����", 25);
		map.put("����", 26);
		map.put("֣��", 27);
		//��ȡmap������ֵ�ü���
		Collection<Integer> c=map.values();
		System.out.println(c);
		
		//��ȡmap�����еļ�
		Set<String> s = map.keySet();
		System.out.println(s);
		
		
		System.out.println(map);
	}
}