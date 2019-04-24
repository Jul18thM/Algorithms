package common.Chapter02order.package03;

import common.Chapter02order.package01.Example;
import common.com.StdRandom;
import common.model.IntModel;

import java.util.Random;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/20 15:14
 */
public class Quick {

    //快速排序的切分
    private static int partition(Comparable[] a,int lo,int hi){
        //讲数组切分为a[lo..i-1],a[i],a[i+1..hi]
        int  i = lo;
        int  j = hi+1;
        Comparable v = a[lo];
        while(true){
            //扫描左右，检查扫描是否结束并交换元素位置
            while(Example.less(a[++i],v)){
                if(i ==hi){
                    break;
                }
            }
            while(Example.less(v,a[--j])){
                if(j == lo){
                    break;
                }
            }
            if(i>=j){
                break;
            }
            //扫描出a[i]<v<a[j]的，然后i,j互换
            Example.exch(a,i,j);
        }
        Example.exch(a,lo,j);
        return j;
    }

    private static void sort(Comparable[] a,int lo,int hi)
    {
        if(hi<=lo){
            return;
        }
        int j = partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }


    public  static void sort(Comparable[] a)
    {
        //数组打乱
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
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
