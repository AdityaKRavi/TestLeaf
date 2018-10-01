package week1.day1;

public class Television {
	
	//variable
	
	public static String language;
	public String channelName;
	public static int myChannelNumber;

	
	//Methods
	public String switchChannel() {

		if(myChannelNumber == 1) {
			channelName= "Mirror Now";
			return channelName;
		}
		else if (myChannelNumber == 2) {
			channelName = "National Geographic";
			return channelName;
		}
		else if (myChannelNumber == 3) {
			channelName = "Surya TV";
			return channelName;
		}
		else if (myChannelNumber == 4) {
			channelName = "Cartoon Network";
			return channelName;
		}
		else if (myChannelNumber == 5) {
			channelName = "Star Plus";
			return channelName;
		}
		else if (myChannelNumber == 6) {
			channelName = "Jaya TV";
			return channelName;
		}
		else
			return "Sorry no more channels...Contact your cable operator";
	}
	
	public void channelInfo(String input) {
		if(input.equalsIgnoreCase("y")) {
			
			System.out.println("S\tA\tM\tS\tU\tN\tG");
			myChannelNumber = (int)(Math.random()*5+1);
			System.out.println("You are watching channel:"+myChannelNumber+" "+switchChannel());
		}

		else if(input.equalsIgnoreCase("n"))
			System.out.println("Exiting");
		else
			System.out.println("Wrong Input!!! Aborting");
	}
	
	public static String channelLanguage() {
			
		switch(myChannelNumber) {
			case 1: language ="English";
					break;
			case 2: language ="English";
					break;
			case 3: language ="Tamil";
					break;
			case 4: language ="English";
					break;
			case 5: language ="Hindi";
					break;
			case 6: language ="Tamil";
					break;
			default:
			}
				return language;
	}
	
}
