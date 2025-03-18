

//주제 : start(), run() 메소드 사용 예제
/*
 예제 스토리
 
 어떤 값을 입력하여 엔터키를 누르면...
 결과가 오랜시간뒤에 출력되어 나온다고 가정할떄...
 결과가 나오기 전에 약간의 효과를 줘서~~   잠시만 기다려주세요.... 라는 메세지를 스레드를 이용하여 처리하자.
 
 예) 
 	 숫자 입력: _
 	 잠시만 기다려주세요.. <-- 스레드를 이용하여 처리 
 	 결과: _

*/

//보조작업스레드 객체를 생성하기 위한 Runnable인터페이스를 구현한 일반 클래스 정의

import java.util.Scanner;

class TestThread  implements Runnable{
	@Override
	public void run() {
		System.out.println("\n\n잠시만 기다려 주세요...\n\n");
	}
}
public class ThreadEx05 {
	//(주)메인 스레드 
	public static void main(String[] args) {
		System.out.print("숫자입력:");
		
		//키보드로부터 입력받은 숫자를 바이트단위의 크기로 읽어들이기 위한 입력스트림 통로 준비
		//Scanner클래스 :  System.in을 통해 읽어들인 바이트 데이터들을 쉽게 기본자료형으로 형변환하는
		//				 nextXX메소드를 제공하는 클래스.
		Scanner scanner = new Scanner(System.in);
			
		//키보드로 부터 입력받은 숫자는 System.in(BufferedInputStream)입력스트림 통로로부터
		//바이트 단위로 읽어들이기 떄문에 읽어들인 바이트 데이터들을
		//long데이터로 변환해서 얻어오기 위해 
		//Scanner객체의 nextLong()메소드 호출하면 long데이터로 반환받습니다.
		long num = scanner.nextLong();//입력한 숫자가 저장되어 있음
		
		//보조작업 스레드 객체 생성하자
		//순서1. run메소드를 강제로 오버라이딩 해 놓은 TestThread일반클래스의 객체 생성
		//순서2. 생성된 TestThread객체의 주소번지를 Thread클래스의 생성자로 전달해 저장시킨
		//		new Thread(new TestThread()); 실제 보조작업스레드 객체 생성
		Thread thread = new Thread(new TestThread());
		
		//실제 보조작업스레드 객체에  일시키기 위해 대기 상태로 만들기
		thread.start(); //run콜백메소드가 JVM에 의해서 자동으로 호출될것임 
		
		//---------------------------------------------
		//(주)메인 스레드 작업
		//-> 0부터  입력받은 숫자까지의 합을 누적해서 출력
		long total = 0;
		
		for(long i=0;   i<=num;  i++) {
			total += i; //0부터 ~ 1씩 증가시키면서 total에 입력받은 숫자까지 반복해서 누적 
		}
		
		System.out.println("총합의 결과 : " + total);
		
	}//main (주)메인스레드

}









