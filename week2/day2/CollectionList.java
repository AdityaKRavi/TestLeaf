package week2.day2;

import java.util.ArrayList;
import java.util.List;

public class CollectionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		list.add("Aditya");
		list.add("Akshay");
		list.add("Sarath");
		list.add("Gopi");
		list.add("Sakthi");
		list.add("sanket");
		System.out.println(list.size());
		for(int i=0; i<list.size();i++) {
			String each=list.get(i).toLowerCase();
			if(each.startsWith("s")){
				System.out.println(list.get(i));
			}
		}
	}
}
