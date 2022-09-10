package Test;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestComparator {
	
	public static void main(String[] arg) {
		
		List<Employee> empList = new ArrayList<Employee>(Arrays.asList(new Employee("vivek", 28, "shuttle"),new Employee("ram", 29, "cricket"),new Employee("vicky", 27, "hockey"),new Employee("manoj", 30, "volleyball")));

		List<Integer> x = new ArrayList<Integer>(Arrays.asList(6, 3, 7, 5, 4));
		Collections.sort(x, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				// ascending order
				if (a > b)
					return 1; // 1 will swap the object location
				return -1; // 0,-1 won't do anything
			}
		});
		System.out.println(x);

		Collections.sort(x, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				// descending order
				if (a > b)
					return -1; // 1 will swap the object location
				return 1; // 0,-1 won't do anything
			}
		});
		System.out.println(x);

//		String[] arr = new String[] {"54","546","548","60"};
		List<String> arr = new ArrayList<String>(Arrays.asList("54", "546", "548", "60"));
		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String c, String d) {
				// TODO Auto-generated method stub
				String cd = c + d;
				String dc = d + c;
				return cd.compareTo(dc) > 0 ? -1 : 0;
			}
		});
		System.out.println(arr);
//		CustomComparator<Integer> com = new CustomComparator<Integer>();
		Collections.sort(x, new CustomComparator<Integer>());
		
		System.out.println(" Age sort in ascending order");
		empList.sort((a,b) -> a.getAge() - b.getAge());
		empList.forEach((Employee) -> System.out.println(Employee));
		System.out.println();
		
		System.out.println(" Age sort in descending order");
		empList.sort((a,b) -> b.getAge() - a.getAge());
		empList.forEach((Employee) -> System.out.println(Employee));
		System.out.println();
		
		System.out.println(" Name sort in ascending order");
		empList.sort((a,b) -> a.getName().compareTo(b.getName()));
		empList.forEach((Employee) -> System.out.println(Employee));
		System.out.println();
		
		System.out.println(" Name sort in descending order");
		empList.sort((a,b) -> b.getName().compareTo(a.getName()));
		empList.forEach((Employee) -> System.out.println(Employee));
		System.out.println();
		
		System.out.println(" Name sort in descending order using comparator");
		Collections.sort(empList,(a,b) -> b.getName().compareTo(a.getName()));
		empList.forEach((Employee) -> System.out.println(Employee));
		System.out.println();
		
		System.out.println(" Age sort in ascending order using comparator");
		Collections.sort(empList,(a,b) -> a.getAge() - b.getAge());
		empList.forEach((Employee) -> System.out.println(Employee));
		System.out.println();
	}
}

