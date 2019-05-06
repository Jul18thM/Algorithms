package common.Chapter02order.package04;

import common.model.IntModel;

import java.util.Random;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/5/5 17:24
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;

    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (Key[])new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N ==0;
    }

    public int size(){
        return N;
    }

    public boolean less(int i,int j){
        return pq[i].compareTo(pq[j])<0;
    }

    public void exch(int i,int j){
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    //由下至上的堆有序化（上浮）的实现
    public void swim(int k){
        while(k>1&&less(k/2,k)){
            exch(k/2,k);
            k = k/2;
        }
    }

    //由上至下的堆的有序化（下浮）的实现
    public void sink(int k){
        while(2*k<N){
            int j = 2*k;
            if(j<=N && less(j,j+1)){
                j++;
            }
            if(!less(k,j)){
                break;
            }
            exch(k,j);
            k = j;
        }
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax(){
        Key max = pq[1];//从根节点得到最大的元素
        exch(1,N--);//将其和最后一个节点交换
        pq[N++] = null;//防止对象游离
        sink(1);//恢复堆的有序性
        return  max;
    }

    public Key[] getPq() {
        return pq;
    }

    public void setPq(Key[] pq) {
        this.pq = pq;
    }
}

class MaxDemo{
    public static void main(String[] args) {
        MaxPQ<IntModel> maxPQ = new MaxPQ<IntModel>(20);
        Random r = new Random();
        IntModel[] list = new IntModel[19];
        for(int i=0;i<list.length;i++){
            IntModel c = new IntModel(r.nextInt(1000));
            list[i] = c;
        }
        for(IntModel m:list){
            System.out.print(m);
        }
        System.out.println("");
        System.out.println(".......................................");
        for(int i=0;i<list.length;i++){
            maxPQ.insert(list[i]);
        }
        IntModel[] ms = maxPQ.getPq();
        for(int i=0;i<ms.length;i++){
            System.out.print(ms[i]);
        }


    }

}
