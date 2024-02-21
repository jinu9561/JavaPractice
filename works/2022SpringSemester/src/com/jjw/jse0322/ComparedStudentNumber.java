package com.jjw.jse0322;

import java.io.*;

abstract class Person implements Comparable {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
//==============================================	
	public void setName(String name){
		this.name = name;
	}
//==============================================
}



//--------------------------------------------------------------------------


class Student extends Person {
	private int id; // �й�

	public Student(String name, int id) {
		super(name);

		this.id = id;
	}
//==============================================
	@Override
	public int compareTo(Object obj) {
		
		Student s = (Student) obj;
		
		if(this.id > s.id) {
			
			return 1;
			
		} else if(this.id < s.id) {
			
			return -1;
			
		} else {
			return 0;
		}
		
	}		
//==============================================
}


//---------------------------------------------------------------------------

class Main2{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name1 = br.readLine();
		int id1 = Integer.parseInt(br.readLine());
		String name2 = br.readLine();
		int id2 = Integer.parseInt(br.readLine());

		Person p1 = new Student(name1, id1);
		Person p2 = new Student(name2, id2);
		
		int cmp = p1.compareTo(p2);
		if (cmp < 0) {
  		System.out.println(p1.getName());
		} else if (cmp > 0) {
  		System.out.println(p2.getName());
		} else {
			System.out.println("SAME");
		}
	}
}
