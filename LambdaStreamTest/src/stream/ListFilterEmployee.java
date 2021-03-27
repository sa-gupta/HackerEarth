package com.cg.stream;
	
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.cg.bean.Employee;

public class ListFilterEmployee {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1159,"sachin",40000,"male",21));
		empList.add(new Employee(9856,"annu",35000,"female",22));
		empList.add(new Employee(2255,"srushti",51000,"female",21));
		empList.add(new Employee(3265,"lalit",32500,"male",21));
		empList.add(new Employee(7584,"akhil",38000,"male",35));
		empList.add(new Employee(1123,"ritika",27000,"female",35));
		empList.add(new Employee(5642,"anurag",35000,"male",30));
		empList.add(new Employee(3315,"hardik",40000,"male",32));
		
		System.out.println("All the Employee");
		empList.forEach(System.out::println);
		
		
		System.out.println("\nAll the female Employee");
		empList.stream()
				.filter(emp -> emp.getGender().equalsIgnoreCase(Gender.FEMALE.toString()))
				.forEach(System.out::println);
		
		System.out.println("\nAll the Male Employee");
		empList.stream()
				.filter(emp -> emp.getGender().equalsIgnoreCase(Gender.MALE.toString()))
				.forEach(System.out::println);
//		List<Employee> sortedEmp = 
//		empList.stream().sorted((emp1,emp2) -> emp1.getId()-emp2.getId()).forEach(System.out::println);
//		System.out.println(sortedEmp);
//		Optional<Employee> maxAge = empList.stream().max((emp1,emp2) -> emp1.getAge()-emp2.getAge());
		
		System.out.println("\nEmployee with maximum Age");
		getMaxOrMin(empList,empList.stream().max((emp1,emp2) -> emp1.getAge()-emp2.getAge())).forEach(System.out::println);
//		Passing the optional in function
		
		
		System.out.println("\nEmployee with minimum Age");
		getMaxOrMin(empList,empList.stream().min((emp1,emp2) -> emp1.getAge()-emp2.getAge())).forEach(System.out::println);
		
		System.out.println("\nSorted Employee list (According to name)");
		Collections.sort(empList,(emp1,emp2) -> emp1.getName().compareTo(emp2.getName()));
		empList.forEach(System.out::println);
	}

	private static List<Employee> getMaxOrMin(List<Employee> empList, Optional<Employee> max) {
		Predicate<Employee> empTest = emp -> max.get().getAge()==emp.getAge();
		List<Employee> res = new ArrayList<>();
		for (Employee employee : empList) {
			if(empTest.test(employee))
				res.add(employee);
		}
		return res;
	}
}
