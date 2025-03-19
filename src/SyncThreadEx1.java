

//주제 : 스레드 동기화 처리를 위한 화장실 예제

//화장실 설계도(클래스) <--------스레드가 아님
class Toilet{
	
	//화장실 문으로 들어가 대변을 보는 행동표현한 메소드
	public void openDoor(String name) {//화장실 문으로 들어오는 가족단위 스레드 객체 이름
		
		//가족 구성원 가족스레드들 중에서 화장실 문으로 입장하는것을 보여주기 위해 출력
		System.out.println(name + "스레드가 화장실 문으로 입장함");
		
		//대변을 보는 시간을 억번 반복해서 출력
		//만약 10000번 되는 순간 대변보는 효과를 출력
		for(int i =0; i<100000000; i++) {
			if(i == 10000) {
				System.out.println(name + " : 끄으으응~~~~~");
			}
		}
		//대변을 다본 효과 출력
		System.out.println(name + " : 아~ 시원해~");
		
	}
}

//가족 설계도(보조작업 객체를 생성하기 위한 클래스) <--각각 가족단위로 보조작업스레드 생성될 것임
class Family extends Thread{
	
	Toilet toilet;
	//가족구성원 중에서 한사람
	
	
}




public class SyncThreadEx1 {

	public static void main(String[] args) {

		
	}

}
