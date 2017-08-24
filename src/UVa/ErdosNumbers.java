package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class ErdosNumbers {

	public static void main(String[] args) {
		
		// nameList : �ϳ��� �� ���� ���ڵ��� �̸��� ����
		// ErdosList : Erdos, P.�� erdosList�� �����ϱ� ���� ��ü
		HashSet<String> nameList = new HashSet<String>();
		HashSet<String> ErdosList = new HashSet<String>();
		
		// < erdosList > : Erdos, P.�� ���谡 �ִ� ���ڵ��� �̸��� �̼����� ����
		// - key:0 -> Erdos, P.
		// - key:1 -> 1�� ������ ���ڵ�
		// - key:2 -> 2�� ������ ���ڵ�
		//
		// < isolatedList > : ���� ���� ���ڵ��� �� ���� ����
		HashMap<Integer, HashSet<String>> erdosList = new HashMap<Integer, HashSet<String>>();
		HashMap<Integer, HashSet<String>> isolatedList = new HashMap<Integer, HashSet<String>>();
		ErdosList.add("Erdos, P.");
		erdosList.put(0, ErdosList);

		Scanner sc = new Scanner(System.in);
		//int paperNum = sc.nextInt();
		//int phdNum = sc.nextInt();
		
		// degreeOfKinship : ���� ������ �̼��� ���� ����
		// minDegreeOfKinship : �� �� ���ڵ��� �̼� �� ���� ���� �̼��� ���� ����
		int degreeOfKinship;
		int minDegreeOfKinship = 0;
		
		for(int j=0; j<3; j++) {
			
			// nameList �ؽ��� ��ü�� �� �ϳ��� ���ڵ� �̸� ����
			String paper = sc.nextLine();
			String[] strArray = paper.split(":");
			StringTokenizer st = new StringTokenizer(strArray[0], ",");
			while(st.hasMoreTokens()) {
				nameList.add(st.nextToken().trim()+", "+st.nextToken().trim());
			}
			
			// �� �ϳ��� ���ڵ� �̸� �� �ϳ��� �����ͼ�,
			// erdosList�� ����� Erdos, P.�� ����� ���ڵ��� ����� �̼����� Ž��.
			// �ش� ���� �̹� ����� ���ڰ� �ִ� ���� �Ǻ�.
			// ������ �� ������ �̼��� degreeOfKinship ������ ����.
			// ���� ���� ������ �� ���� ��� ���ڵ�� �ݺ���, �ּ� �̼��� ���� ���ڸ� ã��.
			// �ش� ���ڸ� ������ ������ ���ڵ��� erdosList�� ����
			Iterator<String> it = nameList.iterator();
			String closestAuthor = null;
			degreeOfKinship = 1000000;
			minDegreeOfKinship = 1000000;
			
			while(it.hasNext()) {
				String name = it.next();

				Set<Integer> set2 = erdosList.keySet();
				Iterator<Integer> it2 = set2.iterator();
				while(it2.hasNext()) {
					int key = it2.next();
					HashSet<String> authorListByKinship = erdosList.get(key);
					
					if(authorListByKinship.contains(name)) {
						degreeOfKinship = key+1;
						closestAuthor = name;
						if(degreeOfKinship < minDegreeOfKinship) {
							minDegreeOfKinship = degreeOfKinship;
						}
						System.out.println(name+" : "+key+" : "+minDegreeOfKinship);
						break;
					}
				}
			}	
			if(closestAuthor != null) {
				nameList.remove(closestAuthor);
			}
			
			// � erdosList���� ���� nameList���� ���� �����ص״� �̼� Ž�� �� �Բ� Ž��
			if(minDegreeOfKinship == 1000000) {
				System.out.println(1);
				isolatedList.put(isolatedList.size(), nameList);
			} // 
			else if(minDegreeOfKinship == erdosList.size()) {
				System.out.println(2);
				erdosList.put(erdosList.size(), nameList);
			} 
			else {	// 
				System.out.println(3);
				HashSet<String> set = erdosList.get(minDegreeOfKinship);
				Iterator<String> it2 = nameList.iterator();
				while(it2.hasNext()) {
					String author = it2.next();
					set.add(author);

					// erdosList�� �� nameList��, �� �Ʒ� erdosList Ž���ؼ� �����ϸ� ����
					for(int i=minDegreeOfKinship+1; i<erdosList.size(); i++) {
						HashSet<String> authorList2 = erdosList.get(i);
						if(authorList2.contains(author)) {
							authorList2.remove(author);
						}
					}
				}
			}
		}
		
		//System.out.println("erdosList.size() : " +erdosList.size());
		
		while(true) {
			String name = sc.nextLine();
			
			for(int i=0; i<erdosList.size(); i++) {
				HashSet<String> set = erdosList.get(i);
				if(set.contains(name)) {
					System.out.println(name +" "+ (i));
					break;
				}
				/*Iterator<String> it = erdosList.get(i).iterator();
				while(it.hasNext()) {
					if(it.next().equals(name)) {
						System.out.println(name +" "+ (i));
					}
				}*/
			}
		}
	}
}