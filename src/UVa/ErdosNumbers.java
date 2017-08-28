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
		int scenarioNum = sc.nextInt();
		sc.nextLine();
		int scenarioIndex = 1;
		
		for(int k=0; k<scenarioNum; k++) {
			
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
			HashMap<Integer, HashSet<String>> isolatedList = new HashMap<Integer, HashSet<String>>();
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
				
				isolatedList.put(isolatedList.size(), nameList);
				
				boolean remainedAuthorYN = true;
				while(isolatedList != null && isolatedList.size() > 0 && remainedAuthorYN == true) {
					
					HashSet<Integer> toRemoveKeySet = new HashSet<Integer>(); 
					// 
					Set<Integer> set2 = isolatedList.keySet();
					Iterator<Integer> it3 = set2.iterator();
					while(it3.hasNext()) {
						
						int key = it3.next();
						
						HashSet<String> nameList2 = isolatedList.get(key);
					
						Iterator<String> it4 = nameList2.iterator();
						HashSet<String> closestAuthorList2 = new HashSet<String>();
						degreeOfKinship = 1000000;
						minDegreeOfKinship = 1000000;
						
						while(it4.hasNext()) {
							String name = it4.next();
				
							Set<Integer> set3 = erdosList.keySet();
							Iterator<Integer> it5 = set3.iterator();
							while(it5.hasNext()) {
								int key2 = it5.next();
								HashSet<String> authorListByKinship = erdosList.get(key2);
								
								if(authorListByKinship.contains(name)) {
									degreeOfKinship = key2+1;
									if(degreeOfKinship < minDegreeOfKinship) {
										minDegreeOfKinship = degreeOfKinship;
										closestAuthorList2 = new HashSet<String>();
										closestAuthorList2.add(name);
									} else if(degreeOfKinship == minDegreeOfKinship) {
										closestAuthorList2.add(name);
									}
									break;
								}
							}
						}
						if(closestAuthorList2.size() > 0 && closestAuthorList2.size() < nameList2.size()) {
							Iterator<String> it5 = closestAuthorList2.iterator();
							while(it5.hasNext()) {
								nameList2.remove(it5.next());
							}
						
							if(nameList2.size() > 0) {
								if(minDegreeOfKinship == erdosList.size()) {
									erdosList.put(erdosList.size(), nameList2);
									toRemoveKeySet.add(key);
									
								} else if(minDegreeOfKinship < erdosList.size()) {
									HashSet<String> set3 = erdosList.get(minDegreeOfKinship);
									Iterator<String> it6 = nameList2.iterator();
									while(it6.hasNext()) {
										String author = it6.next();
										set3.add(author);
						
										// erdosList에 들어간 nameList들, 그 아래 erdosList 탐색해서 존재하면 삭제
										for(int i=minDegreeOfKinship+1; i<erdosList.size(); i++) {
											HashSet<String> authorList2 = erdosList.get(i);
											if(authorList2.contains(author)) {
												authorList2.remove(author);
											}
										}
									}
									toRemoveKeySet.add(key);
								}
							}
						} else if(closestAuthorList2.size() == nameList2.size()) {
							toRemoveKeySet.add(key);
						}
					}
					
					// isolated에서 다 삭제하고, 다시 객체생성해서 넣기..
					Iterator<Integer> it6 = toRemoveKeySet.iterator();
					while(it6.hasNext()) {
						isolatedList.remove(it6.next());
					}
					
					HashMap<Integer, HashSet<String>> isolatedList2 = new HashMap<Integer, HashSet<String>>();
					Set<Integer> set5 = isolatedList.keySet();
					Iterator<Integer> it7 = set5.iterator();
					while(it7.hasNext()) {
						isolatedList2.put(isolatedList2.size(), isolatedList.get(it7.next()));
					}
					isolatedList = isolatedList2;
					
					// erdosList에 isolatedList 이름 중 존재하는 것이 있는 지 판단..
					Set<Integer> set3 = isolatedList.keySet();
					Iterator<Integer> it4 = set3.iterator();
				label1 :
					while(it4.hasNext()) {
						int key = it4.next();
						HashSet<String> set4 = isolatedList.get(key);
						Iterator<String> it5 = set4.iterator();
						while(it5.hasNext()) {
							String isolatedAuthorName = it5.next();
							
							Set<Integer> set = erdosList.keySet();
							Iterator<Integer> it2 = set.iterator();
							while(it2.hasNext()) {
								int key2 = it2.next();
								HashSet<String> set6 = erdosList.get(key2);
								if(set6.contains(isolatedAuthorName)) {
									System.out.println("아직 한발 남았다..");
									remainedAuthorYN = true;
									break label1;
								}
							}
						}
						remainedAuthorYN = false;
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
				
				Set<Integer> set3 = isolatedList.keySet();
				Iterator<Integer> it4 = set3.iterator();
				while(it4.hasNext()) {
					int key = it4.next();
					HashSet<String> set4 = isolatedList.get(key);
					Iterator<String> it5 = set4.iterator();
					System.out.print((key+1)+"번째 고립 : ");
					while(it5.hasNext()) {
						System.out.print(it5.next()+" / ");
					}
					System.out.println();
				}
			}
			
			System.out.println("Scenario "+scenarioIndex++);
			for(int j=0; j<authorNum; j++) {
				Boolean existYN = false;
				String name = sc.nextLine();
				
				for(int i=0; i<erdosList.size(); i++) {
					HashSet<String> set = erdosList.get(i);
					if(set.contains(name)) {
						System.out.println(name +" "+ (i));
						existYN = true;
						break;
					}
				}
				
				if(existYN == false) {
					System.out.println(name +" infinity");
				}
				
				/*Set<Integer> set = isolatedList.keySet();
				Iterator<Integer> it = set.iterator();
				while(it.hasNext()) {
					HashSet<String> set2 = isolatedList.get(it.next());
					if(set2.contains(name)) {
						System.out.println(name +" infinity");
						break;
					}
				}*/
			}
		}
	}
}