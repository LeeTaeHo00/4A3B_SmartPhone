package smartPhone;

import java.util.Scanner;

public class SmartPhone {
	// 필드
	String model;
	String ownerName;
	
	// 필드 (클래스 목록)
	App app; //--> 만드는분
	Battery battery;
	Message msg;
	Power power;
	
	
	// 생성자
	public SmartPhone()
	{
		this.model = "테스트";
		this.ownerName = "test";
		
		this.app = new App();	
		this.battery = new Battery(50);
		this.msg = new Message();
		this.power = new Power();
	}
	
	public SmartPhone(String model, String ownerName) {
		this();
		this.model = model;
		this.ownerName = ownerName;
	}



	// 메소드
	
	// 핸드폰 사용 메서드
	void usePhone(Scanner sc) 
	{
		while(true) 
		{
			printPhoneMenu();
			int selectedMenu = sc.nextInt();
			sc.nextLine();
			
			boolean checker = Power.checkPower(this) ? true : false;
			if(checker == false) 
			{
				System.out.println("배터리가 부족하여 핸드폰을 종료합니다.");
				break;
			}
			
			// 이곳에 각자의 기능들이 들어가게 됩니다.
			switch(selectedMenu) 
			{
			case 1:
				System.out.println("앱을 선택합니다.");
				app.useMenu(sc, this);
				break;
			case 2:
				System.out.println("메시지를 보냅니다");
				msg.useMenu(sc,this);
				break;
			case 3:
				System.out.println("배터리를 확인합니다");
				battery.useMenu(sc);
				break;
			case 4:
				System.out.println("전원 설정을 엽니다.");
				power.power(sc);
				checker = power.powerOn ? true : false;
				break;
			}
			
			if(checker == false) break;				
			this.battery.useBattery(5);
		}
	}
	
	
	// 핸드폰에서 메뉴를 고를때 사용할 메뉴 출력 메소드
	void printPhoneMenu() 
	{
		System.out.println("=================================");
		battery.printCurrentBattery(); // 핸드폰 배터리 잔량 표시해주는 메소드
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   1. 앱 선택\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   2. 메 시 지\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   3. 배 터 리\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   4. 전   원\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}
	
	
}
