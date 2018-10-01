package week1.day3;

public class Jio implements MobilePhone, Telephone {

	@Override
	public void callDialer() {
		// TODO Auto-generated method stub
		System.out.println("Added basic numpad keys");
	}

//	@Override
//	public void addScreen() {
//		// TODO Auto-generated method stub
//		System.out.println("Added small display");
//		
//	}

	@Override
	public String Redial() {
		// TODO Auto-generated method stub
		return "Redial Available";
	}

	@Override
	public String addFunctionBrowser(String browserName) {
		// TODO Auto-generated method stub
		return "Mozilla FireFox";
	}

	@Override
	public String addFunctionCalculator() {
		// TODO Auto-generated method stub
		return "Added Basic Calculator";
	}

	@Override
	public void addFunctionMaps() {
		// TODO Auto-generated method stub
		System.out.println("Added Google Maps with Google Earth");
	}

}
