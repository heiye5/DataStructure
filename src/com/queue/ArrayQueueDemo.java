package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';             //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        //输出一个菜单
        while(loop){
            System.out.println("s(show) : 显示队列");
            System.out.println("e(exit) : 退出程序");
            System.out.println("a(add) : 添加数据");
            System.out.println("g(get)) : 取出数据");
            System.out.println("h(head) : 查看队列头数据");

            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字：");
                    int value =  scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try{
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


//使用数组模拟队列
class ArrayQueue{
    private int maxSize;        //数组最大容量
    private int front;          //队列头
    private int rear;           //队列尾
    private int[] arr;          //存放数据，模拟队列

    //创建队列的构造齐全
    public ArrayQueue(int arrMaxsize){
         maxSize = arrMaxsize;
         arr = new int[maxSize];
         front = -1;                //指向队列头部，队列头的前一个位置
         rear = -1;                 //指向队列尾，包含队列尾的数据
    }

    //判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if(isFull()){
            System.out.println("队列满，不能加入");
            return;
        }
        rear++;             //rear后移
        arr[rear] = n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否为空
        if(isEmpty()){
            //抛异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;            //front后移
        return arr[front];
    }

    //显示队列的所有数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列空，无法读取数据");
            return;
        }

        //遍历
        for(int i=0;i<arr.length;i++){
            System.out.printf("arr[%d] = %d\n",i,arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队列为空");
            throw new RuntimeException("队列空");
        }
        return arr[front + 1];
    }
}