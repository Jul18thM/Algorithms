package common.Chapter02order.package02;

import common.model.IntModel;
import common.Chapter02order.package01.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author:sgyt
 * @Description:这个只是归并的方法
 * @Date:2019/4/15 8:34
 */
public class Merge {
    //这个是归并用到的辅助类
    private static Comparable[] aux;

    /***
     *
     * @param a   需要比较的数组
     * @param lo  开始的值
     * @param mid 中间切断值
     * @param hi  末尾的值length-1
     */
    public static void merge(Comparable[] a,int lo,int mid,int hi) {
        //将a[lo...mid]和a[mid+1...hi]归并
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            //将a[lo..hi]复制到aux[lo..hi]
            aux[k] = a[k];
//            arr[k] = a[k];
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

    private static void sort(Comparable[] a,int lo,int hi)
    {
        //将数组a[lo...hi]排序
        if(hi<=lo){
            return;
        }
        int mid  = lo+(hi-lo)/2;
        sort(a,lo,mid);//左半边递归自身
        sort(a,mid+1,hi);//右半边递归自身
        merge(a,lo,mid,hi);

    }

    //最终的方法
    public static void mergeSort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        sort(a,0,a.length-1);
    }


    public static void main(String[] args) {
        Random r = new Random();
        IntModel[] list = new IntModel[20];
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
