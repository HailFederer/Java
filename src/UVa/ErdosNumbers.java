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
		int scenarioIndex = 1;
		
		for(int k=0; k<scenarioNum; k++) {
			
			int paperNum = sc.nextInt();
			int authorNum = sc.nextInt();
			sc.nextLine();
		
			HashSet<String> protocolErdosList = new HashSet<String>();
			HashMap<Integer, HashSet<String>> erdosList = new HashMap<Integer, HashSet<String>>();
			HashMap<Integer, HashSet<String>> isolatedList = new HashMap<Integer, HashSet<String>>();
			protocolErdosList.add("Erdos, P.");
			erdosList.put(0, protocolErdosList);
			
			for(int j=0; j<paperNum; j++) {
				
				HashSet<String> nameList = new HashSet<String>();
				
				String paper = sc.nextLine();
				String[] strArray = paper.split(":");
				StringTokenizer st = new StringTokenizer(strArray[0], ",");
				while(st.hasMoreTokens()) {
					nameList.add(st.nextToken().trim()+", "+st.nextToken().trim());
				}
				
				isolatedList.put(isolatedList.size(), nameList);
			}

			boolean remainedAuthorYN = true;
			while(remainedAuthorYN == true) {
				
				int kinship = erdosList.size()-1;
				HashSet<String> maxKinshipAuthorSet = erdosList.get(kinship);
				HashSet<Integer> toRemoveKeySet = new HashSet<Integer>(); 
				
				Set<Integer> set = isolatedList.keySet();
				Iterator<Integer> it = set.iterator();
				while(it.hasNext()) {
					
					int key = it.next();
					HashSet<String> commonPaperAuthorSet = isolatedList.get(key);
					Iterator<String> it2 = maxKinshipAuthorSet.iterator();
					boolean containsYN = false;
					while(it2.hasNext()) {
						String author = it2.next();
						if(commonPaperAuthorSet.contains(author)) {
							commonPaperAuthorSet.remove(author);
							containsYN = true;
						}
					}
					
					if(containsYN == true) {
						if(commonPaperAuthorSet.size() > 0) {
							if(erdosList.get(kinship+1) == null) {
								erdosList.put(kinship+1, commonPaperAuthorSet);
							} else {
								HashSet<String> newKinshipAuthorSet = erdosList.get(kinship+1);
								Iterator<String> it3 = commonPaperAuthorSet.iterator();
								while(it3.hasNext()) {
									newKinshipAuthorSet.add(it3.next());
								}
							}
						}
						toRemoveKeySet.add(key);
					}
				}
				
				Iterator<Integer> removeKeySet = toRemoveKeySet.iterator();
				while(removeKeySet.hasNext()) {
					int removeKey = removeKeySet.next();
					isolatedList.remove(removeKey);
				}
	
				maxKinshipAuthorSet = erdosList.get(kinship+1);
				remainedAuthorYN = false;
				if(maxKinshipAuthorSet != null) {
					Iterator<String> it2 = maxKinshipAuthorSet.iterator();
				label1 :
					while(it2.hasNext()) {
						String author = it2.next();
						Set<Integer> set2 = isolatedList.keySet();
						Iterator<Integer> it3 = set2.iterator();
						while(it3.hasNext()) {
							HashSet<String> set3 = isolatedList.get(it3.next());
							if(set3.contains(author)){
								remainedAuthorYN = true;
								break label1;
							}
						}
					}
				}
			}
			
			System.out.println("Scenario "+scenarioIndex++);
			for(int j=0; j<authorNum; j++) {
				Boolean existYN = false;
				String name = sc.nextLine();
				
				for(int i=0; i<erdosList.size(); i++) {
					HashSet<String> set2 = erdosList.get(i);
					if(set2.contains(name)) {
						System.out.println(name +" "+ (i));
						existYN = true;
						break;
					}
				}
				
				if(existYN == false) {
					System.out.println(name +" infinity");
				}
			}
		}
	}
}