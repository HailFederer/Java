package UVa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ErdosNumbers {

	public static void main(String[] args) {
		
		HashSet<String> phdList = new HashSet<String>();
		HashSet<String> nameList = new HashSet<String>();
		
		HashMap<Integer, HashSet<String>> erdosList = new HashMap<Integer, HashSet<String>>();
		phdList.add("Erdos, P.");
		erdosList.put(0, phdList);

		Scanner sc = new Scanner(System.in);
		//int paperNum = sc.nextInt();
		//int phdNum = sc.nextInt();
		for(int j=0; j<4; j++) {
	System.out.println(j);
			String paper = sc.nextLine();
			String[] strArray = paper.split(":");
			StringTokenizer st = new StringTokenizer(strArray[0], ",");
			while(st.hasMoreTokens()) {
				nameList.add(st.nextToken().trim()+", "+st.nextToken().trim());
			}
			
			Iterator<String> it = nameList.iterator();
			while(it.hasNext()) {
				String name = it.next();
	System.out.println(name);
				for(int i=0; i<erdosList.size(); i++) {
					System.out.println(i);
					HashSet<String> set = erdosList.get(i);
					if(set.contains(name)) {
						nameList.remove(name);
						if(erdosList.get(i+1) == null) {
							System.out.println("--------------");
							erdosList.put(i+1, nameList);
						} else {
							set = erdosList.get(i+1);
							Iterator<String> it3 = nameList.iterator();
							while(it3.hasNext()) {
								set.add(it3.next());
							}
						}
					}
				}
			}	
		}
		
		while(true) {
			String name = sc.nextLine();
			
			for(int i=0; i<erdosList.size(); i++) {
				Iterator<String> it2 = erdosList.get(i+1).iterator();
				while(it2.hasNext()) {
					if(it2.next().equals(name)) {
						System.out.println(name +" "+ (i+1));
					}
				}
			}
		}
	}
}
