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
				
				// 논문 하나의 저자들 이름 중 하나씩 가져와서,
				// erdosList에 저장된 Erdos, P.와 관계된 저자들을 가까운 촌수부터 탐색.
				// 해당 논문에 이미 관계된 저자가 있는 지를 판별.
				// 있으면 그 저자의 촌수를 degreeOfKinship 변수에 저장.
				// 위와 같은 과정을 한 논문의 모든 저자들로 반복해, 최소 촌수를 가진 저자를 찾음.
				// 해당 저자를 제외한 나머지 저자들을 erdosList에 저장
				Iterator<String> it = nameList.iterator();
				HashSet<String> closestAuthorList = new HashSet<String>();
				degreeOfKinship = 1000000;
				minDegreeOfKinship = 1000000;
				
				while(it.hasNext()) {
					String name = it.next();
	
					Set<Integer> set2 = erdosList.keySet();
					Iterator<Integer> it2 = set2.iterator();
					while(it2.hasNext()) {
						int key = it2.next();
						// 촌수별 저자리스트를 authorListByKinship에 담음.
						HashSet<String> authorListByKinship = erdosList.get(key);
						
						if(authorListByKinship.contains(name)) {	
							degreeOfKinship = key+1;
							if(degreeOfKinship < minDegreeOfKinship) {
								minDegreeOfKinship = degreeOfKinship;
								// erdosList를 촌수의 오름차순으로 탐색하다 해당 저자의 이름이 나오면 Erdos와 가장 가까운 저자로 설정
								closestAuthorList = new HashSet<String>();
								closestAuthorList.add(name);	
							} else if(degreeOfKinship == minDegreeOfKinship) {
								closestAuthorList.add(name);	
							}
							break;
						}
					}
				}
				if(closestAuthorList.size() == 0) {
					// 어떤 erdosList에도 없는 nameList들은 별도 저장해뒀다 촌수 탐색 시 함께 탐색
					isolatedList.put(isolatedList.size(), nameList);
				} else if(closestAuthorList.size() > 0 && closestAuthorList.size() < nameList.size()) {
					// 가장 가까운 촌수를 가진 저자들 이름 모두를 nameList에서 제거
					Iterator<String> it2 = closestAuthorList.iterator();
					while(it2.hasNext()) {
						nameList.remove(it2.next());
					}
					
					if(nameList.size() > 0) {
						
						if(minDegreeOfKinship == erdosList.size()) {
							erdosList.put(erdosList.size(), nameList);
						} 
						else if(minDegreeOfKinship < erdosList.size()) {
							HashSet<String> set = erdosList.get(minDegreeOfKinship);
							Iterator<String> it3 = nameList.iterator();
							while(it3.hasNext()) {
								String author = it3.next();
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
					}
				}
				
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
									remainedAuthorYN = true;
									break label1;
								}
							}
						}
						remainedAuthorYN = false;
					}
				}
				
				/*Set<Integer> set = erdosList.keySet();
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
				}*/
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