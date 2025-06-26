package smartPhone;

import java.util.Scanner;

public class Battery {

	// 필드
	int battery;
	
	//생성자
	public Battery(int battery) { 
		this.battery = battery;
	}

	// 메소드
	// 충전 메소드
	void chargeBattery(int charge) { // 충전
		this.battery += charge;
		if(this.battery >= 100) {
			this.battery = 100;
		}
	}
	// 사용메소드
	void useBattery(int use) { // 사용
		this.battery -= use;
		if(this.battery <= 0 ) {
			this.battery = 0;
		}
	}
	
	// 15% 이하로 떨어졌을 때 충전이 필요합니다 출력
	void under15() {
		if(this.battery <= 15) {
			System.err.println("충전이 필요합니다");
		}else {
			System.out.println("충전이 필요하지 않습니다");
		}
	}
			
	// 현재 배터리 잔량 표시 메뉴(메뉴용)
	void printCurrentBattery() 
	{
		System.out.printf("=남은 배터리 잔량 :           %3d%c\t=\n",this.battery,'%');
		if(this.battery == 100) {
			System.out.println("충전이 완료되었습니다");
		}
	}
	

	// 메뉴 기능 구현
	void useMenu(Scanner sc) 
	{
		boolean checker = true;
		while(true) 
		{
			printMenu();
			int selectMenu = sc.nextInt();
			sc.nextLine();
			
			switch(selectMenu) 
			{
			
			case 1:
				System.out.println("폰을 충전 합니다.");
				chargeBattery(30); 
				break;
			case 2:
				under15();
				break;
			case 3:
				System.out.println("메뉴를 나갑니다.");
				checker = false;
				break;
			
			default:
				break;
			}
			
			if(checker == false) break;
			
		}
	}

	// 메뉴 출력문
	void printMenu() {
		System.out.println("=================================");
		printCurrentBattery();
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   1. 충   전\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   2. 배터리 충전 필요 여부\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   3. 뒤   로\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}

}
