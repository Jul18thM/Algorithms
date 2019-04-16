package common.order.package02;

import common.order.ElementarySortingAlgorithms.Example;

/**
 * @Author:sgyt
 * @Description:这个只是归并的方法
 * @Date:2019/4/15 8:34
 */
public class Merge {
    public static void merge(Comparable[] a,int lo,int mid,int hi) {
        //将a[lo...mid]和a[mid+1...hi]归并
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            //将a[lo..hi]复制到aux[lo..hi]
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

    //这个是归并用到的辅助类
    private static Comparable[] aux;


    public static void sort(Comparable[] a)
    {
        aux = new Comparable[a.length];
        Example.sort(aux);
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

}
