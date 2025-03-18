

//보조작업스레드 객체를 생성하기 위한 클래스
//하는일 : 현재 실행중인 스레드 5초 휴식 주는 일
class ThreadDemo4 extends Thread{

	public ThreadDemo4(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		try {
			this.sleep(5*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}





public class ThreadEx10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
