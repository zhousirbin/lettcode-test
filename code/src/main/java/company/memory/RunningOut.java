package company.memory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunningOut {
    public static void main(String[] args) throws Throwable{

        List<String> list = new ArrayList<>();
        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
