package com.fruit;

//建立橘子類及其屬性跟方法
class Orange{
    //橘子總量
    private int OraNumber=300;
    //賣橘子的方法
    public synchronized  void  OraSale(){
        //判斷是否還有橘子可賣
        if(OraNumber>0){
            System.out.println(Thread.currentThread().getName()+"賣出倉庫中,到數最後第"+OraNumber--+"顆橘子,還剩"+OraNumber+"顆橘子");
        }
    }
}
public class SaleOrange {
    //建立多個賣橘子的線程如售貨人員.調用橘子類的方法
    public static void main(String[] args) {

        //建立橘子類對象
        Orange orange=new Orange();
        //建立賣橘子的1線程
        new Thread(new Runnable() {
            @Override
            public void run() {
                  //調用橘子類的中賣橘子的方法
                for(int i=0; i<400;i++){
                    orange.OraSale();
                }
            }
        },"kelly").start();
        //建立賣橘子的2線程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //調用橘子類的中賣橘子的方法
                for(int i=0; i<400;i++){
                    orange.OraSale();
                }
            }
        },"Mary").start();
        //建立賣橘子的3線程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //調用橘子類的中賣橘子的方法
                for(int i=0; i<400;i++){
                    orange.OraSale();
                }
            }
        },"Nick").start();
    }
}