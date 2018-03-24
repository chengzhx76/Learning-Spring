import java.util.*;

/**
 * @desc:
 * @author: hp
 * @date: 2017/11/20
 */
public class TestTimer {
    public static void main(String[] args) throws InterruptedException {
        final Timer timer = new Timer();
        runTask(timer);

        final Map<String, TimerTask> map = new HashMap<>();
        final MyTaskC c = new MyTaskC();
        map.put("c", c);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("动态加入任务C");
                timer.schedule(c, new Date(), 4000);
                System.out.println("动态加入任务C-end");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("动态删除任务C");
                TimerTask taskC = map.get("c");
                taskC.cancel();
                map.remove("c");
                System.out.println("动态删除任务C-end");
            }
        }).start();

    }

    private static void runTask(Timer timer) {
        timer.schedule(new MyTaskA(), new Date(), 4000);
        timer.schedule(new MyTaskB(), new Date(), 4000);
    }

}



class MyTaskA extends TimerTask {

    @Override
    public void run() {
        System.out.println("A run timer=" + new Date());
        this.cancel();// 调用的是TimerTask类中的cancel()方法
        System.out.println("A任务自己移除自己,B任务不受影响，继续运行");
    }

}

class MyTaskB extends TimerTask {

    @Override
    public void run() {
        System.out.println("B run timer=" + new Date());
    }
}

class MyTaskC extends TimerTask {

    @Override
    public void run() {
        System.out.println("C run timer=" + new Date());
    }
}
