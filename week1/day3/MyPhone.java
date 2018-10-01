package week1.day3;

public class MyPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Samsung mySamsung = new Samsung();
		mySamsung.addFunctionBrowser("Chrome");
		System.out.println(mySamsung.addFunctionCalculator());
		mySamsung.addFunctionMaps();
		
		Jio myJio = new Jio();
		System.out.println(myJio.addFunctionBrowser("Mozilla"));
		System.out.println(myJio.addFunctionCalculator());
		myJio.addFunctionMaps();
		
		myJio.callDialer();
		myJio.Redial();
		
		MobilePhone mPhone = new Samsung();
		mPhone.addFunctionMaps();
	}

}
