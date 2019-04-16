package common.order.ElementarySortingAlgorithms;

/**
 * @Author:sgyt
 * @Description:选择排序，先选到最小的，排在第一个，剩余的再选最小，放在第二个，以此往复
 * @Date:2019/4/10 8:39
 */
public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i=0;i<N;i++){
            //将a[i]和a[i+1..N]中最小的元素交换
            int min = i;
            for(int j = i+1;j<N;j++){
                if (Example.less(a[j],a[min])){
                    min = j;
                }
                Example.exch(a,i,min);
            }
        }
    }
}
