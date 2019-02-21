import org.springframework.stereotype.Component;
import util.ApplicationUtil;

@Component
public class Test {

    @org.junit.Test
    public void  test(){
        System.out.println("000000000000");

        System.out.println(ApplicationUtil.getApplicationContext());
    }

}

