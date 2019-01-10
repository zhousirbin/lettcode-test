package company.thread;



import java.util.Timer;
import java.util.TimerTask;

public class TimerTest1 {
    public static void main(String[] args){
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("定时");
            System.out.println("1");

        }
    };
        /*
         * schedule 和 scheduleAtFixedRate 区别：
         *  可将schedule理解为scheduleAtFixedDelay，
         *  两者主要区别在于delay和rate
         *  1、schedule，如果第一次执行被延时（delay），
         *      随后的任务执行时间将以上一次任务实际执行完成的时间为准
         *  2、scheduleAtFixedRate，如果第一次执行被延时（delay），
         *      随后的任务执行时间将以上一次任务开始执行的时间为准（需考虑同步）
         *
         *  参数：1、任务体    2、延时时间（可以指定执行日期）3、任务执行间隔时间
         */
    Timer timer = new Timer();
    timer.schedule(timerTask, 0,1000);//延时1秒
    timer.scheduleAtFixedRate(timerTask,0,1000);


   }
}
