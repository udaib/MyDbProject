package com.opms.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DriverClass {
   public static void main(String[] args){
	   DataFromDb dfdb=new DataFromDb();
	   List<Student> students=dfdb.getAllStudent();
	   List<Student> addAllStudens=new ArrayList<>();
	   addAllStudens.addAll(students);
	   Iterator<Student> itr=addAllStudens.iterator();
	   while(itr.hasNext()){
		   Student std=itr.next();
		   System.out.println(std.toString());
		   //this is just for testing github
		   System.out.println("");
		   
	   }
	   
   }
}
