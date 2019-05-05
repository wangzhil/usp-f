package sinosoft.com.ribbon.serverb.controller;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class testThread {


	public static void main(String[] args) throws InterruptedException {
		Thread aa = new Thread(new AA());
		aa.start();
		TimeUnit.SECONDS.sleep(2);
		 
		lock.lock();
		
		
		condition.signal();
		lock.unlock();	
	}
	public static volatile ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	public static class AA implements Runnable {
		@Override
		public void run() {
			try {
				lock.lock();
				condition.await();
				System.out.println("Thread is going on ...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		}			
	}
}
