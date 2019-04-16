package common.order.ElementarySortingAlgorithms;


import common.com.*;

/**
 * @Author:sgyt
 * @Description:比较插入排序和选择排序的性能
 * @Date:2019/4/10 10:03
 */
public class SortCompare {
    public static double time(String alg,Comparable[] a){
        Stopwatch timer = new Stopwatch();
        if(alg.equals("Insertion")){
            Insertion.sort(a);
        }
        if(alg.equals("Selection")){
            Selection.sort(a);
        }
        if(alg.equals("Shell")){
            Shell.sort(a);
        }
        if(alg.equals("Merge")){
            Merge.sort(a);
        }
        return timer.elapsedTime();

    }

    public static double timeRandomInput(String alg,int N,int T){
        //使用算法alg将T个长度为N的数组排序
        double total = 0.0;
        Double[] a = new Double[N];
        for(int t=0;t<T;t++)
        {   //进行一次测试（生产一个数组并排序）
            for(int i=0;i<N;i++){
                a[i] = StdRandom.uniform();
            }
            total += time(alg,a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = "Insertion";
        String alg2 = "Selection";
        int N = Integer.parseInt("1000");
        int T = Integer.parseInt("100");
        double t1 = timeRandomInput(alg1,N,T);//算法1的时间
        double t2 = timeRandomInput(alg2,N,T);//算法2的时间
        StdOut.printf("For %d random Doubles\n   %s is",N,alg1);
        StdOut.printf("%.1f times faster than %s\n",t2/t1,alg2);

    }
}
