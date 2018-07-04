package com.nuritelecom.domain;

public class PeopleVO {

	private String name;
	private int age;

	public PeopleVO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "PeopleVO [name=" + name + ", age=" + age + "]";
	}

}
