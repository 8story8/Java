package step6;

// Thread Priority Scheduling�� ���� Test

class Worker extends Thread{
	public void run(){
		for(long i = 0; i < 900000000L; i++){
			System.out.println(getName() + " Thread ����, �켱 ���� : " + getPriority());
		}
	}
}

public class TestThread6 {
	public static void main(String[] args) {
		/*
		Worker wt1 = new Worker();
		wt1.setName("ù ��° �ϲ�");
		
		Worker wt2 = new Worker();
		wt2.setName("�� ��° �ϲ�");
	
		wt1.start();
		wt2.start();
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		
		Thread Prioirity Test�� ���� Worker Thread�� 20�� �����ϰ�
		������ Thread�� �̸��� ����(0��° Thread)�ϰ�,
		10�� Index�� �ش��ϴ� Thread �ϳ��� setPriority(10);
		������ 19���� setPriority(1);
		���� start();
		*/
	
		for(int i = 0; i < 20; i++){
			Worker wt = new Worker();
			
			wt.setName(i + "��°");
			
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
