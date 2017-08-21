package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;

class IntroHashMap
{
	public static void main(String[] args)
	{
		TreeMap<Integer, String> hMap=new TreeMap<Integer, String>();

		hMap.put(new Integer(3), "나삼번");		
		hMap.put(5, "윤오번");	
		hMap.put(8, "김팔번");	
		
		System.out.println("6학년 3반 8번 학생: "+hMap.get(new Integer(8)));
		System.out.println("6학년 3반 5번 학생: "+hMap.get(5));
		System.out.println("6학년 3반 3번 학생: "+hMap.get(3));
		
//		hMap.remove(5);		/* 5번 학생 전학 감 */
//		System.out.println("6학년 3반 5번 학생: "+hMap.get(5));
		
		NavigableSet<Integer> keys = hMap.navigableKeySet();
		Iterator<Integer> itr = keys.descendingIterator();
		while(itr.hasNext()){
			System.out.println(hMap.get(itr.next()));
		}
		
		if(hMap.containsValue("나삼변"))
		System.out.println("1");
	}
}
