
//보조작업 스레드 객체를 생성하기 위한 사용자정의 스레드 클래스 만들기
//방법2. Runnable인터페이스를 구현받아 run추상메소드를 가진 일반클래스로 만들자

//보조작업 스레드객체가 할일을 구현해 놓을 run메소드를 가지고 있는 일반 클래스 만들기 
class ThreadDemo1 implements Runnable{
	//보조작업 스레드객체의 이름 저장
	String name;
	
	//보조작업 스레드객체의 이름을 초기화 할 생성자
	public ThreadDemo1(String name) {
		this.name = name;
	}
	//보조작업 스레드 객체가 할 작업을 run메소드에 구현해 놓자
	@Override
	public void run() {
		int sum = 0;		
		for(int i=0;  i<5; i++) {			
			try {
				Thread.sleep(1000);//현재 실행중(작업중)인 보조작업스레드 객체 1초간 휴식
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += i;		
			//보조작업스레드 작업하고 있는 정보 출력
			System.out.println(name + ":" + sum);
		}//for
	}//run
}

public class ThreadEx03 {

	//주(메인) 스레드 <-- 무조건 하나만 존재
	public static void main(String[] args) {
		//1. run()메소드를 오버라이딩 해놓은 일반 ThreadDemo1클래스의 객체 생성
		ThreadDemo1 t1 = new ThreadDemo1("첫번쨰 보조작업스레드1");
		//2. 실제 보조작업스레드 객체 역할을 위해
		//   자바에서 제공해주는 Thread클래스의 객체 생성시 생성자로 위 new ThreadDemo1객체의 주소를 전달해서 저장
		Thread tt1 = new Thread(t1); //<--- 첫번째 보조작업스레드객체 1
		
		//1. run()메소드를 오버라이딩 해 놓은 일반 ThreadDemo1클래스의 객체 생성
		//2. 그리고 실제 보조작업스레드 객체 역할을 위한 Thread클래스의 객체 생성시 생성자로 전달해서 스레드화 시킴
		Thread tt2 = new Thread(new ThreadDemo1("두번째 보조작업스레드2"));
		
		//start()메소드를 호출하여 run메소드가 실행되게 
		tt1.start();  tt2.start();

	}

}








