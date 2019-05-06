package common.Chapter02order.package03;

import common.Chapter02order.package01.Example;
import common.com.StdRandom;
import common.model.IntModel;

import java.util.Random;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/25 16:53
 */
public class Quick3way {

    private static void sort3way(Comparable[] a,int lo,int hi)
    {
        if(hi<lo){
            return;
        }

        int lt = lo;
        int i= lo+1;
        int gt = hi;

        Comparable v = a[lo];
        while(i<=gt){
            int cmp = a[i].compareTo(v);
            if(cmp<0){
                Example.exch(a,lt++,i++);
            }else if(cmp>0){
                Example.exch(a,i,gt--);
            }else{
                i++;
            }
        }

        sort3way(a,lo,lt-1);
        sort3way(a,gt+1,hi);
    }

    public  static void sort(Comparable[] a)
    {
        //数组打乱
        StdRandom.shuffle(a);
        sort3way(a,0,a.length-1);
    }

    public static void main(String[] args) {
        Random r = new Random();
        IntModel[] list = new IntModel[19];
        for(int i=0;i<list.length;i++){
            IntModel c = new IntModel(r.nextInt(1000));
            list[i] = c;
        }
        for(IntModel model:list)
        {
            System.out.print(model.getK()+",");
        }
        System.out.println("........................................");
        System.out.println("list");
        sort(list);
        for(IntModel model:list)
        {
            System.out.print(model.getK()+",");
        }


    }
}
