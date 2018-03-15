package step6;

// Thread Priority Scheduling에 대한 Test

class Worker extends Thread{
	public void run(){
		for(long i = 0; i < 900000000L; i++){
			System.out.println(getName() + " Thread 실행, 우선 순위 : " + getPriority());
		}
	}
}

public class TestThread6 {
	public static void main(String[] args) {
		/*
		Worker wt1 = new Worker();
		wt1.setName("첫 번째 일꾼");
		
		Worker wt2 = new Worker();
		wt2.setName("두 번째 일꾼");
	
		wt1.start();
		wt2.start();
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		
		Thread Prioirity Test를 위해 Worker Thread를 20개 생성하고
		각각의 Thread에 이름을 설정(0번째 Thread)하고,
		10번 Index에 해당하는 Thread 하나만 setPriority(10);
		나머지 19개는 setPriority(1);
		각각 start();
		*/
	
		for(int i = 0; i < 20; i++){
			Worker wt = new Worker();
			
			wt.setName(i + "번째");
			
			if(i == 10){
				wt.setPriority(Thread.MAX_PRIORITY);
			}
			else{
				wt.setPriority(Thread.MIN_PRIORITY);
			}
			
			wt.start();
		}
	}
}
