


//주제 : 플래그변수(조건을 판단하는 변수)를 이용하여 
//     현재 run메소드가 실행중인 보조작업스레드객체 강제로 중지 시키기

//보조작업스레드 객체를 생성하기 위한 Runnable인터페이스를 구현한 일반클래스
class StopThreadDemo1 implements Runnable{
	
	//플래그변수 : 보조작업스레드객체가 현재 작업을 하고있는지 하고있지 않은지 
	//          판단할값 true 또는 false를 저장할변수
	private boolean stoped = false;
	
	//보조작업스레드객체( new Thread(new StopThreadDemo1()) )가 작업할 일 
	//run메소드 오버라이딩
	@Override
	public void run() {
		//플래그변수에 저장되어 있는 값이 false일때만 계속 반복해서 작업을 함
		while(!stoped) {
			//메세지 출력하는일
			System.out.println("보조작업스레드객체는 현재 동작하고 있다.");
			//보조작업스레드 객체를 0.5로 대기상태로 만들기(휴식)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//while반복문
		System.out.println("보조작업스레드객체는 현재 Dead..........");
	}//run메소드 
	
	//현재 작업하고 있는 보조작업스레드객체가 중지되었다고 판단할 값을 저장할 기능의 일반메소드
	public void stop() {
		this.stoped = true;
	}
}

public class StopThreadEx1 {

	//주(메인)스레드
	public static void main(String[] args) {
		System.out.println("## 플래그 변수를 이용한 보조작업스레드객체 강제 중지 기능 시작");
		new StopThreadEx1().process();	
	}
	//주(메인)스레드가 작업을 정의해 놓은 메소드
	//기능 : 보조작업스레드 객체 생성 및 일시키기
	public void process() {		
	//보조작업스레드 객체 생성 
		//순서1. run메소드가 강제로 메소드오버라이딩 된 일반 StopThreadDemo1클래스의 객체 생성
		StopThreadDemo1 std1 = new StopThreadDemo1();
		//순서2. 위 순서1.에서 생성된 StopThreadDemo1객체 메모리의 주소번지를
		//		제공되는 Thread클래스의 생성자로 전달해 초기화한 실제 보조작업스레드객체 생성
		Thread thread = new Thread(std1);
		
	//보조작업스레드객체 일시키기
		thread.start();//-> run()메소드가 자동으로 실행됨
		
		//(주)메인스레드 1초 휴식
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//StopThreadDemo1일반클래스의 객체 내부에 만들어져 있는
		//stop인스턴스메소드를 호출하여 플래그 변수 값을 false에서 true로 변경
		//즉! 강제로 보조작업스레드 객체 작업 중지 시키기!
		std1.stop();
	}//process메소드  <------ main메소드 내부에서 호출했었음 
	
}//class 









