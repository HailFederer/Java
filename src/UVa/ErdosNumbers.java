package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class ErdosNumbers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int paperNum = sc.nextInt();
		int authorNum = sc.nextInt();
		
		// ErdosList : Erdos, P.�� erdosList�� �����ϱ� ���� ��ü
		HashSet<String> ErdosList = new HashSet<String>();
		
		// < erdosList > : Erdos, P.�� ���谡 �ִ� ���ڵ��� �̸��� �̼����� ����
		// - key:0 -> Erdos, P.
		// - key:1 -> 1�� ������ ���ڵ�
		// - key:2 -> 2�� ������ ���ڵ�
		//
		// < isolatedList > : ���� ���� ���ڵ��� �� ���� ����
		HashMap<Integer, HashSet<String>> erdosList = new HashMap<Integer, HashSet<String>>();
		HashMap<Integer, HashSet<String>> isolatedList = null;
		ErdosList.add("Erdos, P.");
		erdosList.put(0, ErdosList);
		
		// degreeOfKinship : ���� ������ �̼��� ���� ����
		// minDegreeOfKinship : �� �� ���ڵ��� �̼� �� ���� ���� �̼��� ���� ����
		int degreeOfKinship;
		int minDegreeOfKinship = 0;
		
		for(int j=0; j<paperNum; j++) {
			
			// nameList : �ϳ��� �� ���� ���ڵ��� �̸��� ����
			HashSet<String> nameList = new HashSet<String>();
			
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
					HashSet<String> authorListByKinship = erdosList.get(key);	// �̼��� ���ڸ���Ʈ�� authorListByKinship�� ����.
					
					if(authorListByKinship.contains(name)) {	
						degreeOfKinship = key+1;
						if(degreeOfKinship < minDegreeOfKinship) {
							minDegreeOfKinship = degreeOfKinship;
							closestAuthor = name;	// erdosList�� �̼��� ������������ Ž���ϴ� �ش� ������ �̸��� ������ Erdos�� ���� ����� ���ڷ� ����
						}
						break;
					}
				}
			}	
			if(closestAuthor != null) {
				nameList.remove(closestAuthor);
			}
			
			// � erdosList���� ���� nameList���� ���� �����ص״� �̼� Ž�� �� �Բ� Ž��
			if(minDegreeOfKinship == 1000000) {
				isolatedList = new HashMap<Integer, HashSet<String>>();
				isolatedList.put(isolatedList.size(), nameList);
			} // 
			else if(minDegreeOfKinship == erdosList.size()) {
				erdosList.put(erdosList.size(), nameList);
			} 
			else if(minDegreeOfKinship < erdosList.size()) {	// 
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
		
		if(isolatedList != null) {
			
			Set<Integer> set = isolatedList.keySet();
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				
				int key = it.next();
				
				HashSet<String> nameList = isolatedList.get(key);
			
				Iterator<String> it3 = nameList.iterator();
				String closestAuthor = null;
				degreeOfKinship = 1000000;
				minDegreeOfKinship = 1000000;
				
				while(it3.hasNext()) {
					String name = it3.next();
		
					Set<Integer> set2 = erdosList.keySet();
					Iterator<Integer> it2 = set2.iterator();
					while(it2.hasNext()) {
						int key2 = it2.next();
						HashSet<String> authorListByKinship = erdosList.get(key2);
						
						if(authorListByKinship.contains(name)) {
							degreeOfKinship = key2+1;
							closestAuthor = name;
							if(degreeOfKinship < minDegreeOfKinship) {
								minDegreeOfKinship = degreeOfKinship;
							}
							break;
						}
					}
				}	
				if(closestAuthor != null) {
					nameList.remove(closestAuthor);
				}
				
				if(minDegreeOfKinship == erdosList.size()) {
					erdosList.put(erdosList.size(), nameList);
					isolatedList.remove(key);
					
				} else if(minDegreeOfKinship < erdosList.size()) {
					HashSet<String> set2 = erdosList.get(minDegreeOfKinship);
					Iterator<String> it2 = nameList.iterator();
					while(it2.hasNext()) {
						String author = it2.next();
						set2.add(author);
		
						// erdosList�� �� nameList��, �� �Ʒ� erdosList Ž���ؼ� �����ϸ� ����
						for(int i=minDegreeOfKinship+1; i<erdosList.size(); i++) {
							HashSet<String> authorList2 = erdosList.get(i);
							if(authorList2.contains(author)) {
								authorList2.remove(author);
							}
						}
					}
					isolatedList.remove(key);
				}
			}
		}
		
		for(int j=0; j<authorNum; j++) {
			String name = sc.nextLine();
			
			for(int i=0; i<erdosList.size(); i++) {
				HashSet<String> set = erdosList.get(i);
				if(set.contains(name)) {
					System.out.println(name +" "+ (i));
					break;
				}
			}
			
			Set<Integer> set = isolatedList.keySet();
			Iterator<Integer> it = set.iterator();
			while(it.hasNext()) {
				HashSet<String> set2 = isolatedList.get(it.next());
				if(set2.contains(name)) {
					System.out.println(name +" infinity");
					break;
				}
			}
		}
	}
}