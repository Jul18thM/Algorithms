package common.order.ElementarySortingAlgorithms;

/**
 * @Author:sgyt
 * @Description:希尔排序，底层还是插入排序
 * @Date:2019/4/11 15:36
 */
public class Shell {
    public static void sort(Comparable[] a)
    {   //将a[] 按升序排序
        int N = a.length;
        int h = 1;
        while(h < N/3)
        {
            h = 3*h+1;  //1,4,13,40.。。。。。
        }

        while(h>=1)
        {
            //插入排序
            for(int i = h;i < N;i++)
            {//将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...之中
                for(int j = i;j >= h &&Example.less(a[j],a[j-h]);j-=h)
                {
                    Example.exch(a,j,j-h);
                }
            }
            h = h/3;
        }

    }
}
