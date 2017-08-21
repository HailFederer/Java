package test;

import java.util.Iterator;
import java.util.TreeSet;

class Person implements Comparable<Person>
{
    String name;
    int age;

    public Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public void showData()
    {
    	System.out.printf("%s %d \n", name, age);
    }
    public int compareTo(Person p)
    {
    	if(name.equals(p.name))
    		return 0;
        if(age>p.age)
            return -1;
        else 
            return 1;
    }
}

class ComparablePerson 
{
	public static void main(String[] args)
	{
		TreeSet<Person> sTree=new TreeSet<Person>();
		sTree.add(new Person("Lee", 24));
		sTree.add(new Person("Lee", 29));
		sTree.add(new Person("Choi", 24));
		
		Iterator<Person> itr=sTree.iterator();
		while(itr.hasNext())
			itr.next().showData();
	}
}