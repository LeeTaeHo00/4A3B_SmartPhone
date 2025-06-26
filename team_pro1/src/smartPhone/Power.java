package smartPhone;

import java.util.Scanner;

public class Power {
	boolean powerOn = true;
	
	boolean checkPower(SmartPhone myphone) 
	{		
		return myphone.battery.battery <= 0 ? false : true;
	}
	
	void power(Scanner sc) 
	{
		if(powerOn == false) 
		{
			System.out.println("전원이 켜집니다");
			powerOn = true;
		}
		
		else 
		{
			int powerReset = sc.nextInt();
			sc.nextLine();
			
			if(powerReset == 0)
			{
				System.out.println("전원을 다시 시작합니다");
			}
			
			else
			{
				System.out.println("전원이 꺼집니다");
				powerOn = false;
			}
		}			
	}
	
	void printMenu() 
	{
		System.out.println("=================================");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   1. 다시 시작\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   2. 종   료\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}
}
