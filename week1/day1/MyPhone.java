package week1.day1;

public class MyPhone {

	public String brandName;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MobilePhone mobile = new MobilePhone();
		String brandName = mobile.brandName("Samsung");
		System.out.println("Brand: "+brandName);
		String mobileModel = mobile.brandModel("Galaxy");
		System.out.println("Model: "+mobileModel);
		long callerPhone= mobile.dialCaller("Aditya");
		System.out.println("Phone Number: " +callerPhone);
		boolean canSendSms = mobile.sendSms(brandName);
		System.out.println("Can the model send sms: " +canSendSms);
	}

}
