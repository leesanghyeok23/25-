

//Semaphore는 동시 접근을 제어하기 위한 클래스로,
//여러 스레드가 동시에 공유 자원에 접근할 수 있는 최대 개수를 제한하는데 사용됩니다.
import java.util.concurrent.Semaphore;

//공유 자원을 다룰 클래스
class SharedResource4{
	
	//최대스레드 2개, 동시에 자원에 접근할수 있는 스레드는 2개로 제한됨
	private final Semaphore semaphore = new Semaphore(2);
	
	//자원에 접근하는 메서드
	public void accessResource() {
		
		try {
			//스레드는 acuquir()메서드 호출하여 ㅔ미포어에서 자원에 대한 접근 허가 요청합니다.
			//2개의 스레드가 자원을 사용중이라면 이호출은 대기상태가되어 다른스레드가 자원을 반환할떄까지 기다립니다. 
			semaphore.acquire();
			
			//자원에 접근한 현재 스레드의 이름을 출력합니다.
			System.out.println(Thread.currentThread().getName()+"자원사용중....");
			
			Thread.sleep(1000);
			
			
		} catch (InterruptedException e) {
			//예외가 발생하면 예외 메세지를 출력
			e.printStackTrace();
			
		} finally {
			semaphore.release();			
		}
	}

}



public class SemaphoreExample {

	public static void main(String[] args) {

		//공유자원을 다루는 객체를 생성
		SharedResource4 resource4 = new SharedResource4();
		
		//5개의 보조작업스레드를 생성하여 공유자원에 접근하게함
		for(int i = 0; i<5; i++) {
			//내부 익명 구현 객체?
			new Thread(new Runnable() {
				@Override
				public void run() {
					
					resource4.accessResource();
					
				}}).start();// 보조작업 스레드 객체 일 시작 시키기
		}
		

	}

}
