package smartPhone;

import java.util.Scanner;

public class PhoneMain {
	static SmartPhone[] phones = new SmartPhone[10];

	public static void main(String[] args) {
		
		// 필수 변수 선언
		// 지역변수
		PhoneMain menus = new PhoneMain();	// PhoneMain 객체생성
		Scanner sc = new Scanner(System.in); // 스캐너 사용
		
		menus.selectPhone(sc); // 메뉴 선택 기능 메소드 호출
		
		sc.close(); // 스캐너 사용 종료
	}

	// 메소드
	// 핸드폰 선택 메뉴 메소드
	void selectPhone(Scanner sc) 
	{
		while(true) 
		{
			printSelectPhoneMenu();
			int selectedMenu = sc.nextInt();
			sc.nextLine();
			
			if(selectedMenu == 1) 
			{
				printMenu("핸드폰을 선택해주세요");
				usePhone(sc);
			}
			
			else if(selectedMenu == 2) 
			{
				printMenu("시스템을 종료 합니다.");
				break;
			}
			
			else 
			{
				System.out.println("다시 선택해 주세요");
			}
		}
	}
	
	// 핸드폰 메뉴 선택 메소드
	void usePhone(Scanner sc) 
	{
		while(true) 
		{
			printPhoneArray();
			int selectedMenu = sc.nextInt();
			sc.nextLine();
			
			if(selectedMenu == phones.length + 1) // 마지막 값은 무조건 종료
			{
				break;
			}
			
			else 
			{
				selectPhone(selectedMenu, sc);
				phones[selectedMenu].usePhone(sc);
				break;
			}
		}
	}
	
	// 핸드폰 선택 및 생성 메소드
	int selectPhone(int index, Scanner sc) 
	{
		// 핸드폰 이 없을 경우
		if(phones[index] == null) 
		{
			System.out.println("핸드폰을 새로 생성합니다. 정보를 입력해 주세요");
			
			System.out.println("사용자 이름을 입력해주세요");
			String name = sc.nextLine();
			
			System.out.println("모델명을 입력해주세요");
			String model = sc.nextLine();
			
			phones[index] = new SmartPhone(model, name);
		}
		
		System.out.println((index + 1) + "번째 핸드폰을 선택하셨습니다.");
		return index;
	}
	
	// 화면 출력 메소드들
	// 핸드폰을 선택하는 창을 만들 메소드
	void printSelectPhoneMenu() 
	{
		System.out.println("=================================");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   1. 폰 선 택\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   2. 종   료\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}

	// 핸드폰을 생성할 때 사용할 메소드
	void printMenu(String menuName) 
	{
		System.out.println("=================================");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.printf("=\t%s\t\t=\n", menuName);
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}
	
	// 핸드폰 목록 출력 메소드
	void printPhoneArray() 
	{
		System.out.println("=================================");
		for(int i = 0; i < phones.length; i++) 
		{
			if(phones[i] == null) 
			{
				System.out.printf("=\t%d.   비 어 있 음\t\t=\n", i);
			}
			else 
			{
				// 이곳에 핸드폰 배터리량 표시해주는 메소드 사용해 줄거임
				System.out.printf("=\t   %d.%s\t\t=\n",i,phones[i].ownerName);
			}
			System.out.println("=================================");
		}
		
		System.out.printf("=\t%d.   종     료\t\t=\n", phones.length + 1);
		System.out.println("=================================");
	}

}
