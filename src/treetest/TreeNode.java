package treetest;

/**
 * @author zyh
 * @date 2020/5/22
 */
public class TreeNode {
    // 静态方法，上类锁，函数功能为连续打印10个value值，调用时会传1，所以会打印10个1
    synchronized public static void mB(String value) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.print(value);
            Thread.sleep(100);
        }
    }

    public void mC(String value) throws InterruptedException {
        // 修饰this上对象锁，函数功能也是连续打印10个value值，调用时会传2，所以会打印10个2
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(value);
                Thread.sleep(100);
            }
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TreeNode.mB("1");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        TreeNode b = new TreeNode();
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.mC("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();

    }
}
