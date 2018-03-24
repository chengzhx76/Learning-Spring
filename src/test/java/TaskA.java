import java.util.TimerTask;

/**
 * @desc:
 * @author: hp
 * @date: 2017/11/20
 */
public class TaskA extends TimerTask implements Task {
    @Override
    public Object exec(Object... obj) {

        System.out.println("------exec shell---------");

        return "success";
    }

    @Override
    public void run() {
        exec();
    }
}
