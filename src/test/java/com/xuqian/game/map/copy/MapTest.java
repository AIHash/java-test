package com.xuqian.game.map.copy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

	
	public static void main(String[] args) {
		/* ��ʼ��map */
		Map<String,Integer> map = new HashMap<String,Integer>();
		System.out.println("Hashmap�ĳ�ʼ��ֵ" + map.size());
		System.out.println("HashMap�Ƿ�Ϊ��:" + (map.isEmpty() ? "��" : "��")); 
		
		/* ��map�����Ԫ�� */  
        map.put("erqing", 1);  
        map.put("niuniu", 2);  
        map.put("egg", 3);  
        System.out.println(map.size());  
        ;  
        System.out.println("HashMap�Ƿ�Ϊ��:" + (map.isEmpty() ? "��" : "��"));  
  
        /* ����HashMap�е�Ԫ�� */
        Set<String> set = map.keySet();
        for (String s: set) {
        	System.out.println(s + " " + map.get(s) + " " + "hashcode:"  
                    + s.hashCode());
        }
        /*����Ƿ���ĳ��Key*/  
        System.out.println(map.containsKey("egg")); 
        /*����Ƿ���ĳ��Value*/
        System.out.println(map.containsValue(2));
        /*��ӡhashCode*/
        System.out.println(map.hashCode());  
	}
}
