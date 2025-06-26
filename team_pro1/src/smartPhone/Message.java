package smartPhone;

import java.util.Scanner;

public class Message {
	// 필드
	final int MAX_SAVE_MSG = 10;
	String[] receiveMsg = new String[MAX_SAVE_MSG]; // 최대로 받을수 있는 메시지 = 10칸

	// 메소드

	// 기능 : 다른 핸드폰으로 메시지 보내기(메시지 저장)
	// 1.휴대폰 배열내에서 비어있는곳을 찾아서
	// 2.보낼메시지 입력
	// 3.입력한 메시지 값을 휴대폰 배열내에 저장
	// 4.사용 후 배터리를 10%씩 소모
	void sendMessage(Scanner sc, SmartPhone myPhone) {
		System.out.print("휴대폰 번호를 입력하세요 : ");
		int phone = sc.nextInt();
		if (PhoneMain.phones[phone] == null) {
			System.out.println("없는 번호 입니다.");
		} else {
			String msg = sc.nextLine();
			PhoneMain.phones[phone].msg.receiveMessage(myPhone, msg);
			myPhone.battery.useBattery(10);
			System.out.printf("메시지를 전송 완료했습니다 현재 배터리는 %d% 입니다", myPhone.battery);
		}
	}

	// 기능 : 다른 핸드폰에서 메시지 받기(메시지 저장)
	// 1. SmartPhone의 휴대폰 배열번호와 메시지를 받아서
	// 2. 휴대폰에 저장하고
	// 3. 최대메시지량이 넘어간다면(10칸)
	// 4. 뒤에부터 빈칸(=삭제)으로 만들어준다.
	void receiveMessage(SmartPhone myPhone, String msg) {
		String temp = "";
		boolean empty = false;
		for (int i = 0; i < receiveMsg.length - 1; i++) {
			myPhone.msg.receiveMsg[receiveMsg.length] = "";
			empty = true;
			if (!empty) {
				myPhone.msg.receiveMsg[i] = msg;
				empty = true;
			} else if (i == receiveMsg.length) {
				temp = myPhone.msg.receiveMsg[i - 1];
				myPhone.msg.receiveMsg[i - 1] = myPhone.msg.receiveMsg[i];
				myPhone.msg.receiveMsg[receiveMsg.length - 1] = msg;
				empty = false;
			}
		}
	}
	
	void useMenu(Scanner sc) {
		boolean flag = true;
	}

	void MessageMenu() {
		System.out.println("=================================");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   1. 보 내 기\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t   2. 메 시 지 확 인\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=\t\t\t\t=");
		System.out.println("=================================");
	}
}