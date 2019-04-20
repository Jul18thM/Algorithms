package common.Chapter02order.package02;

import common.Chapter02order.package01.Example;
import common.model.IntModel;

import java.util.Random;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/17 9:28
 */
public class MergeBU {
    //归并中需要的数组
    private static Comparable[] aux;

    public static void merge(Comparable[] a,int lo,int mid,int hi)
    {
        int i = lo;
        int j = mid+1;
        for(int k=lo;k<=hi;k++){
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            }else if(j > hi) {
                a[k] = aux[i++];
            }else if(Example.less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
    }

    public static void mergeSort(Comparable[] a){
        aux = new Comparable[a.length];
        int N = a.length;
        for(int sz = 1 ; sz<N ; sz = sz+sz){
            for(int lo = 0 ; lo < N-sz ; lo += sz+sz){
                merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
            }
        }
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
        mergeSort(list);
        for(IntModel model:list)
        {
            System.out.print(model.getK()+",");
        }
        System.out.println("........................................");
        System.out.println("aux");
        //
        for(int k=0;k<aux.length;k++)
        {
            IntModel md = (IntModel)aux[k];
            System.out.print(md.getK()+",");
        }
    }

}
