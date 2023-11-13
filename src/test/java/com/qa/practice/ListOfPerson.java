package com.qa.practice;

import java.util.ArrayList;
import java.util.List;

public class ListOfPerson {

	public static void main(String[] args) {

		List<Person> listOfPeople = new ArrayList<>();
		listOfPeople.add(new Person("Sema", 35));

		System.out.println(listOfPeople);

	}

}

class Person {

	String name;
	int age;

	public Person(String name, int age) {

		this.name = name;
		this.age = age;

	}

	public String toString() {
		return name + ":" + age;
	}

}