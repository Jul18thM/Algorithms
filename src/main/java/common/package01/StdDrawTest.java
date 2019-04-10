package common.package01;

import common.com.StdDraw;
import org.junit.jupiter.api.Test;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/8 11:15
 */
public class StdDrawTest {
    @Test
    public void demo(){
        int N = 100;
        StdDraw.setXscale(0,N);
        StdDraw.setYscale(0,N*N);
        StdDraw.setPenRadius(.01);
        for(int i = 1;i<=N;i++){
            StdDraw.point(i,i);
            StdDraw.point(i,i*i);
            StdDraw.point(i,i*Math.log(i));
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
