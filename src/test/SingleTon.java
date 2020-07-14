package test;

/**
 * @author zyh
 * @date 2020/6/10
 */
public class SingleTon {
    private static volatile SingleTon singleTon = null;

    private SingleTon() {

    }

    public SingleTon getSingleTon() {
        if (singleTon != null) {
            return singleTon;
        }
        synchronized (SingleTon.class) {
            if (singleTon == null) {
                singleTon = new SingleTon();
            }
        }
        return singleTon;
    }
}
