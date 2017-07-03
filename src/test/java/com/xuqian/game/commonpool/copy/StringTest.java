package com.xuqian.game.commonpool.copy;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;

public class StringTest {
	public static void main(String[] args) throws Exception {
		//����һ�������
		GenericKeyedObjectPool pool = new GenericKeyedObjectPool(new BaseKeyedPooledObjectFactory() {

			@Override
			public Object create(Object arg0) throws Exception {
				return null;
			}

			@Override
			public PooledObject wrap(Object arg0) {
				return null;
			}
		});
		
		//��Ӷ��󵽳أ��ظ��Ĳ����ظ����
		pool.addObject("a");
		pool.addObject("b");
		pool.addObject("c");
		pool.addObject("d");
		pool.addObject("e");
		pool.addObject("f");
		
		//��ȡ��������� 
        System.out.println(pool.borrowObject("a")); 
        System.out.println(pool.borrowObject("b")); 
        System.out.println(pool.borrowObject("c")); 
        System.out.println(pool.borrowObject("c")); 
        System.out.println(pool.borrowObject("a")); 

        //�����״̬ 
        System.out.println(pool.getMaxIdlePerKey()); 
        System.out.println(pool.getNumActive()); 
	}
}
