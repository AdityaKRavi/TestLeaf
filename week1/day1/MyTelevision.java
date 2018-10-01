package week1.day1;
import java.util.Scanner;
public class MyTelevision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Television tv = new Television();

		Scanner scan =new Scanner(System.in);
		
		System.out.print("Welcome to Computer TV...Do you want to switch to TV mode : (y/n)");
		String input=scan.nextLine();
		tv.channelInfo(input);
		System.out.println("Language:"+Television.channelLanguage());
		System.out.println("At present there are only 1-6 channels available...");	
		System.out.print("Please select the channel you want to watch: ");
		Television.myChannelNumber = scan.nextInt();
//		System.out.println("You are watching channel: "+Television.myChannelNumber);
		String switchChannel = tv.switchChannel();
		System.out.println(switchChannel);
		System.out.println("Language:"+Television.channelLanguage());
			
		scan.close();
	}
}
