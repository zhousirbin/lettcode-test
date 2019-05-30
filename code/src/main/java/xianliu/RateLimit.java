package xianliu;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimit {

    public static void main(String[] args){
        RateLimiter limiter = RateLimiter.create(2);

        System.out.println(limiter.acquire()); //初始状态直接放了两个令牌，消耗了一个,拿到第一个令牌的时间，类似时间戳
        try {
            Thread.sleep(2000L); // 到第二秒时候，此时又放了两个令牌。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());//0.0  0.0  0.0  0.0  0.499876  0.495799






    }

}
