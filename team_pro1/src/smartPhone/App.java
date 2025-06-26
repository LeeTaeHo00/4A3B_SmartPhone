package smartPhone;

import java.util.Scanner;

public class App {
	// 필드
	String[] app; // 앱 받을 수 있는 배열 설정
	String name;	// 설치할 앱 이름을 문자열로 받는다
	
	public App() {				// 기본 생서자를 만들어 app에다가 배열 3개를 저장 하게 함
		app = new String[3];
	}
	
	void useMenu(Scanner sc, SmartPhone phone) 						// 메뉴를 사용하기 위해 사용
	{	
		boolean checker = true;						// 와일문을 종료해줄 변수선언
		while(true) 								// 와일문 시작
		{
			
			// 메뉴뜨는거
			showMenu(phone);							
			int chooseMenu = sc.nextInt();
			sc.nextLine();
			
			switch(chooseMenu) 
			{
			case 1: 
				askInstall(sc);
				break;
				
			case 2:
				runApp(sc);
				break;
			case 3:
				checker = false;
				break;
			default:
				System.out.println("올바른 숫자를 입력하세요^^");				
				break;
			}
			
			// 이부분 이태호가 설명할겁니다.
			phone.battery.useBattery(10);
			if(phone.power.checkPower(phone)) 
			{
				System.out.println("");
				break;
			}
			if(checker == false) break;
		}
	}
	
	void installApp(int i, String name) // 앱을 설치할 위치와 이름을 정해주는 메소드
	{		
		if(i < 0 || i >= app.length)  	// 입력한 값이 앱의 인덱스 번호 밖인경우 18번줄 출력
		{
			System.out.println("범위 밖입니다. 다시 입력해주세요.");
		}
		
		if(app[i] != null){				// 해당 칸이 앱이 설치되어 있는 경우
				System.out.println("앱 설치 불가"); 	// 설치 불가
		}else { 									// 앱이 없을 경우
			System.out.println( name + "앱이 설치됌"); //설치됨
			app[i] = name;							// 빈칸에 입력
		}
	}
	
	void askInstall(Scanner sc)         		//설치 할 수 있게 물어봄
	{		
		System.out.println("설치할 앱을 입력해주세요");
		name = sc.next();						// 입력 받은 값을 저장
		sc.nextLine();
	
		showInstallMenu();
		System.out.println("어디에 설치하실래요?");	// 설치 위치 물어봄
		int choose = sc.nextInt();	
		sc.nextLine();							// 설치할 위치의 번호를 츄즈에 저장

		installApp(choose, name);
	}
	
	
	void runApp(Scanner sc) 
	{
		showInstallMenu();
		name = sc.next();
		// 앱을 실행
		for (int i = 0; i < app.length; i++) {			//앙;
			if (name.equals(app[i])) {
				System.out.println(name + "앱을 실행했습니다. 배터리가 10% 줄어듭니다");
				
				break;
			}
		}
		
	}
	
	void showMenu(SmartPhone phone) // 설치인지 확인
	{
		System.out.println("=================================");
		phone.battery.printCurrentBattery();
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   1. 설   치\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   2. 실   행\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   3. 뒤   로\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}
	
	
	void showInstallMenu()
	{
		System.out.println("=================================");
		for(int i = 0; i < app.length; i++) 
		{
			if(app[i] == null) 
			{
				System.out.printf("=\t%d.   비 어 있 음\t\t=\n", i);
			}
			else 
			{
				// 이곳에 핸드폰 배터리량 표시해주는 메소드 사용해 줄거임
				System.out.printf("=\t   %d.%s\t\t=\n",i,app[i]);
			}
			System.out.println("=================================");
		}
		
		System.out.printf("=\t%d.   뒤     료\t\t=\n", app.length + 1);
		System.out.println("=================================");
	}

}
