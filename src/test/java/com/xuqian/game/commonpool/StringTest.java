package com.xuqian.game.commonpool;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;

public class StringTest {
	public static void main(String[] args) throws Exception {
		//创建一个对象池
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
		
		//添加对象到池，重复的不会重复入池
		pool.addObject("a");
		pool.addObject("b");
		pool.addObject("c");
		pool.addObject("d");
		pool.addObject("e");
		pool.addObject("f");
		
		//获取并输出对象 
        System.out.println(pool.borrowObject("a")); 
        System.out.println(pool.borrowObject("b")); 
        System.out.println(pool.borrowObject("c")); 
        System.out.println(pool.borrowObject("c")); 
        System.out.println(pool.borrowObject("a")); 

        //输出池状态 
        System.out.println(pool.getMaxIdlePerKey()); 
        System.out.println(pool.getNumActive()); 
	}
}
