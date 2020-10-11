package com.algorithm;

import com.common.util.JsonUtil;

import java.util.Date;

//实现一个 LRU 缓存，当缓存数据达到 N 之后需要淘汰掉最近最少使用的数据。
//N 小时之内没有被访问的数据也需要淘汰掉。
public class LRUDemo {

    /**
     * 最大缓存数大小
     */
    private Integer maxSize;

    /**
     * 缓存时间
     */
    private Integer aliveTime;

    /**
     * 当前缓存数，初始化 = 0
     */
    private volatile Integer currentSize = 0;

    private ListNode head = new ListNode();

    private ListNode tail = new ListNode();

    private void init(Integer maxSize, Integer aliveTime){
        this.maxSize = maxSize;
        this.aliveTime = aliveTime;

        //初始化头尾指针
        tail = head;

        //定时输出当前队列数据
        new Thread(()->{
            for(;;){
                System.out.println("当前队列：" + head.toString());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for(;;){
                if(tail == head){
                    continue;
                }
                Long now = new Date().getTime();
                Long tailTime = tail.getTime().getTime();
                Long diff = now - tailTime;
                if(diff >= aliveTime){
                    System.out.print("超时 == ");
                    del();
                }
            }
        }).start();
    }

    public LRUDemo(){
        init(11,15 * 1000);
    }

    public LRUDemo(Integer maxSize, Integer aliveTime) {
        init(maxSize,aliveTime);
    }

    public synchronized void add(ListNode listNode){

        while(currentSize >= maxSize){
            System.out.print("过载 == ");
            del();
        }
        listNode.time = new Date();
        if(currentSize == 0){
            head.nextNode = listNode;
            listNode.preNode = head;
            tail = listNode;
        }else{
            listNode.nextNode = head.nextNode;
            head.nextNode.preNode = listNode;
            head.nextNode = listNode;
            listNode.preNode = head;
        }
        currentSize++;
    }

    public void del(){
        if(currentSize > 0){
            System.out.println(JsonUtil.write2JsonStr("节点：" + tail.getData()) + "被删除，currentSize = " + currentSize);
            ListNode temp = tail;
            tail = tail.preNode;
            tail.nextNode = null;
            temp = null;
            currentSize--;
        }
    }

    public Integer getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }

    public Integer getAliveTime() {
        return aliveTime;
    }

    public void setAliveTime(Integer aliveTime) {
        this.aliveTime = aliveTime;
    }

    public static void main(String[] args) {

        //随机时间添加元素
        new Thread(() -> {
            LRUDemo lru = new LRUDemo();
            System.out.println("开始测试！");
            int dataId = 1;
            for(;;){
                ListNode node = new ListNode();
                node.setData(dataId);
                lru.add(node);
                dataId++;
                int randomTime = (int)(Math.random() * 1000 + 1000);//生成1-2秒之间的随机时间
                try {
                    Thread.sleep(randomTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class ListNode{

    public ListNode preNode;

    public Object data;

    public Date time;

    public ListNode nextNode;

    public String toString(){
        return JsonUtil.write2JsonStr(data) + " || "+ (nextNode == null? "":nextNode.toString());
    }

    public ListNode getPreNode() {
        return preNode;
    }

    public void setPreNode(ListNode preNode) {
        this.preNode = preNode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }
}

