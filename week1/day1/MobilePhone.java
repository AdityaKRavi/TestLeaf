package week1.day1;

public class MobilePhone {
	
	//variables
	//public long phoneNumber = 9003746012l;
	public String brandName ="Samsung";
	public String model = "Galaxy S3";
//	public String callerName = "Aditya";

	
	//methods
	public long dialCaller(String name) {
		if(name.equals("Aditya"))
		return 9003746012l;
		else if(name.equals("Gautam"))
		return 9535006331l;
		else if(name.equals("Satish"))
		return 9790185217l;
		else
		return 0;		
	}
	
	//The method checks if the brand has SendSMS facility
	public boolean sendSms (String name) {
		if(brandName.equals(name)) {
			return true;
		}
		else
			return false;
	}
	
	public String brandName(String brand) {
		brand=brandName;
		return brand;
	}
	
	public String brandModel(String phoneModel) {
		phoneModel=model;
		return phoneModel;
	}
}
