package week2.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class ListDup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("Aditya");
		list.add("Amit");
		list.add("sarath");
		list.add("gopi");
		list.add("Aditya");
		//		Set<String> set =new LinkedHashSet<String>();
		//		set.addAll(list);
		for(String each:list) {
			for(int i=0;i<list.size();i++) {
				if(each.equals(list.get(i+1))) {
					list.remove(each);
				}
			}
				System.out.println(each);
		}
			//			System.out.println(each);
	}		
}

