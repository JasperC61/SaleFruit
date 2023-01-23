package com.orange.lock;

import java.util.concurrent.locks.ReentrantLock;

class LOrange{
	private int OraNumber=40;
     //手動鎖定線程
	private final  ReentrantLock lock=new ReentrantLock();
	
	public void OraSale() {
		//手動鎖
		lock.lock();
		try {if(OraNumber>0){
            System.out.println(Thread.currentThread().getName()+"賣出倉庫中,到數最後第"+OraNumber--+"顆橘子,還剩"+OraNumber+"顆橘子");
        }
			
		}finally {
			
		}
		 
		//手動解鎖 
		 lock.unlock();
	}
}

public class LSaleOrange {

	public static void main(String[] args) {
		LOrange lorange =new LOrange();
		
		new Thread(()->{
			for(int i=0; i<41;i++){
                lorange.OraSale();
			}
		},"Mary").start();
		
		new Thread(()->{
			for(int i=0; i<41;i++){
                lorange.OraSale();
			}
		},"Betty").start();
		
		
		new Thread(()->{
			for(int i=0; i<41;i++){
                lorange.OraSale();
			}
		},"Cindy").start();
        
	}

}
