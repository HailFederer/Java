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
		sc.nextLine();
		
		// ErdosList : Erdos, P.를 erdosList에 저장하기 위한 객체
		HashSet<String> protocolErdosList = new HashSet<String>();
		
		// < erdosList > : Erdos, P.와 관계가 있는 저자들의 이름을 촌수별로 저장
		// - key:0 -> Erdos, P.
		// - key:1 -> 1촌 관계인 저자들
		// - key:2 -> 2촌 관계인 저자들
		//
		// < isolatedList > : 연관 없는 저자들을 논문 별로 저장
		HashMap<Integer, HashSet<String>> erdosList = new HashMap<Integer, HashSet<String>>();
		HashMap<Integer, HashSet<String>> isolatedList = null;
		protocolErdosList.add("Erdos, P.");
		erdosList.put(0, protocolErdosList);
		
		// degreeOfKinship : 개별 저자의 촌수를 담을 변수
		// minDegreeOfKinship : 한 논문 저자들의 촌수 중 가장 적은 촌수를 담을 변수
		int degreeOfKinship;
		int minDegreeOfKinship = 0;
		
		for(int j=0; j<paperNum; j++) {
			
			// nameList : 하나의 논문 공동 저자들의 이름을 저장
			HashSet<String> nameList = new HashSet<String>();
			
			// nameList 해쉬셋 객체에 논문 하나의 저자들 이름 저장
			String paper = sc.nextLine();
			String[] strArray = paper.split(":");
			StringTokenizer st = new StringTokenizer(strArray[0], ",");
			while(st.hasMoreTokens()) {
				nameList.add(st.nextToken().trim()+", "+st.nextToken().trim());
			}
			
			// 논문 하나의 저자들 이름 중 하나씩 가져와서,
			// erdosList에 저장된 Erdos, P.와 관계된 저자들을 가까운 촌수부터 탐색.
			// 해당 논문에 이미 관계된 저자가 있는 지를 판별.
			// 있으면 그 저자의 촌수를 degreeOfKinship 변수에 저장.
			// 위와 같은 과정을 한 논문의 모든 저자들로 반복해, 최소 촌수를 가진 저자를 찾음.
			// 해당 저자를 제외한 나머지 저자들을 erdosList에 저장
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
					HashSet<String> authorListByKinship = erdosList.get(key);	// 촌수별 저자리스트를 authorListByKinship에 담음.
					
					if(authorListByKinship.contains(name)) {	
						degreeOfKinship = key+1;
						if(degreeOfKinship < minDegreeOfKinship) {
							minDegreeOfKinship = degreeOfKinship;
							closestAuthor = name;	// erdosList를 촌수의 오름차순으로 탐색하다 해당 저자의 이름이 나오면 Erdos와 가장 가까운 저자로 설정
						}
						break;
					}
				}
			}	
			if(closestAuthor != null) {
				nameList.remove(closestAuthor);
			}
			
			// 어떤 erdosList에도 없는 nameList들은 별도 저장해뒀다 촌수 탐색 시 함께 탐색
			if(minDegreeOfKinship == 1000000) {
				isolatedList = new HashMap<Integer, HashSet<String>>();
				isolatedList.put(isolatedList.size(), nameList);
			} // 
			else if(minDegreeOfKinship == erdosList.size() && nameList.size() != 0) {
				erdosList.put(erdosList.size(), nameList);
			} 
			else if(minDegreeOfKinship < erdosList.size()) {	// 
				HashSet<String> set = erdosList.get(minDegreeOfKinship);
				Iterator<String> it2 = nameList.iterator();
				while(it2.hasNext()) {
					String author = it2.next();
					set.add(author);

					// erdosList에 들어간 nameList들, 그 아래 erdosList 탐색해서 존재하면 삭제
					for(int i=minDegreeOfKinship+1; i<erdosList.size(); i++) {
						HashSet<String> authorList2 = erdosList.get(i);
						if(authorList2.contains(author)) {
							authorList2.remove(author);
						}
					}
				}
			}
			
			Set<Integer> set = erdosList.keySet();
			Iterator<Integer> it2 = set.iterator();
			while(it2.hasNext()) {
				int key = it2.next();
				HashSet<String> set2 = erdosList.get(key);
				Iterator<String> it3 = set2.iterator();
				System.out.print(key+"촌 : ");
				while(it3.hasNext()) {
					System.out.print(it3.next()+" / ");
				}
				System.out.println();
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
		
						// erdosList에 들어간 nameList들, 그 아래 erdosList 탐색해서 존재하면 삭제
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
			
			Set<Integer> set2 = isolatedList.keySet();
			Iterator<Integer> it2 = set2.iterator();
			while(it2.hasNext()) {
				int key = it2.next();
				HashSet<String> set3 = isolatedList.get(key);
				Iterator<String> it3 = set3.iterator();
				System.out.print((key+1)+"번째 고립 : ");
				while(it3.hasNext()) {
					System.out.print(it3.next()+" / ");
				}
				System.out.println();
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