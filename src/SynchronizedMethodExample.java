

//공유 자원 클래스 정의
class SharedResource{
	private int count = 0; //공유 데이터 (모든 스레드가 접근 가능)
	
    // synchronized 키워드를 사용하여 
	// 한 번에 하나의 스레드만 increment() 메서드를 실행할 수 있도록 제한한다.
	public synchronized  void increment() {
		count++; //count값을 1증가
		System.out.println(Thread.currentThread().getName() + "- count: " + count);
	}
}

//Runnable인터페이스를 구현한 클래스를 정의하여 스레드 작업을 처리한다
class CounterRunnable implements Runnable{	
	
	private SharedResource resource;
	
	public CounterRunnable(SharedResource resource) {
		this.resource = resource;
	}	
	@Override
	public void run() {
		// 5번 반복해서 공유SharedResource객체 메모리 내부의 increment()메소드 호출
		for(int i=0;  i<5;  i++) {
			resource.increment();
		}
	}	
}

//실행 클래스 (메인 스레드 포함 하고 있는 클래스)
public class SynchronizedMethodExample {
	//메인스레드 
	public static void main(String[] args) {
		//공유 자원 객체를 생성 (모든 스레드가 이 객체를 공유)
		SharedResource resource = new SharedResource();
		
		//첫 번쨰 보조작업스레드 객체 생성
		Thread t1 = new Thread(new CounterRunnable(resource));
		
		//두 번째 보조작업스레드 객체 생성
		Thread t2 = new Thread(new CounterRunnable(resource));
		
		//두 개의 보조작업 스레드 실행
		t1.start();
		t2.start();
/*		
		Thread-0- count: 1
		Thread-0- count: 2
		Thread-0- count: 3
		Thread-0- count: 4
		Thread-0- count: 5
		Thread-1- count: 6
		Thread-1- count: 7
		Thread-1- count: 8
		Thread-1- count: 9
		Thread-1- count: 10
*/
		
	}

}







