package com.opms.dao;

public class Student {
	private int id;
	private String name;
	private String address;
	private String phone;
	
	//public getter and setter
	public void setId(int id ){
		this.id=id;
	 	
	}
	public int getId(){
		return id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setAddress(String address){
		this.address=address;
		
	}
	public String getAddress(){
		return address;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	//public void display
	@Override
	public String toString(){
		return "\n Id ="+id+"\n Name ="+name+"\n Address ="+address+"\n Phone Number ="+phone;
		
	}
}
