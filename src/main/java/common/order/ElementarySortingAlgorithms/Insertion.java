package common.order.ElementarySortingAlgorithms;

/**
 * @Author:sgyt
 * @Description:插入排序
 * @Date:2019/4/10 9:11
 */
public class Insertion {
    public static void sort(Comparable[] a){
        //将a[]按升序排序
        for(int i=1;i<a.length;i++){
            //将a[i]插入到a[i-1],a[i-2],a[
            //
            // i-3]..之中
            for(int j=i;j>0&&Example.less(a[j],a[j-1]);j--){
                Example.exch(a,j,j-1);
            }
        }
    }
}
