
//데몬 스레드를 만들 일반클래스(Runnable인터페이스의 fun메소드를 오버라이딩해서 작성해놓은 클래스)만들기
class T implements Runnable {

	// 작업파일을 자동저장할것인가 말것인가 여부값 (true, false)를 저장할 플래그 변수
	static boolean autoSave = false;

	// 작업파일을 자동저장하는 기능을 표시하는 일
	@Override
	public void run() {
		// 3초 휴식후 작업파일 저장되었다고 메세지를 반복해서 출력
		while (true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// autoSave변수에 저장되어 있는 값이 true일때만
			if (autoSave) {
				autoSave(); // 메소드를 호출하여 작업파일이 자동으로 저장되었다는 메세지 출력
			}
		} // while
	}// run

	public void autoSave() {
		System.out.println("작업파일이 자동으로 저장되었습니다.");
	}
}// T Class



public class ThreadEx09 {

	//주(메인)스레드
	public static void main(String[] args) throws InterruptedException {
		
		//보조작업스레드 객체 생성
		Thread thread = new Thread(new T());
		
		//보조작업스레드(일반스레드)를 데몬스레드로 변경
		thread.setDaemon(true);
		
		//데몬스레드 시작
		thread.start();
		
		//(주)메인스레드에서 숫자를 반복해서 출력하는 작업
		for(int i=0; i<20; i++) {
			//현재 실행되고 있는 메인스레드 1초 휴식 후 i변수값 출력
			Thread.sleep(1000);
			System.out.println(i);
			
//			i변수의 값이 5가 되면 static autoSave변수의 값을 true로 변경해서 저장
			if(i==5) {
				T.autoSave=true;
			}
		}
		System.out.println("프로그램종료.");
	}

}
