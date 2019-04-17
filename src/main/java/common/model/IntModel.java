package common.model;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/4/17 8:33
 */
public class IntModel implements Comparable<IntModel> {
    private int k;

    public IntModel(int k) {
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }



    @Override
    public int compareTo(IntModel o) {
        if(o.k<this.k)
        {
            return 1;
        }
        if(o.k>this.k)
        {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntModel)) return false;

        IntModel intModel = (IntModel) o;

        return getK() == intModel.getK();
    }

    @Override
    public int hashCode() {
        return getK();
    }

    @Override
    public String toString() {
        return "IntModel{" +
                "k=" + k +
                '}';
    }
}
