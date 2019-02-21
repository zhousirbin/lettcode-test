package company.memory;

import java.util.LinkedList;
import java.util.List;

public class OutOfMemery {
    public static void main(String[] args){

        List<OoM> list = new LinkedList<>();
        while (true){
            list.add(new OoM());
        }
    }
    static class OoM{

    }
}
