package company.annotion;

import com.google.common.util.concurrent.RateLimiter;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Test10 {

    Long firstTime = 0L;

    HashMap<String ,Integer> map = new HashMap<String,Integer>();

    RateLimiter limiter = RateLimiter.create(5, 1000, TimeUnit.MILLISECONDS);

    public boolean isLimit(String key) {


        int i=1;
        if(!map.containsKey(key)){
            firstTime = System.currentTimeMillis()/1000;
            map.put(key,i);

        }
        else{
            Long nowTime = System.currentTimeMillis()/1000;

            if((nowTime-firstTime) <0 && i<= 5){
                map.put(key,i+1);

            }else{
                return true;
            }

        }

        return false;
    }
}
