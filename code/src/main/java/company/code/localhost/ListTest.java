package company.code.localhost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {


        List<Long> groupIds = Arrays.asList(123L,456L,789L,135L);

        Long first = groupIds.get(0); //一级部门
        groupIds.add(0L); //没有部门，将交易流水和没有订单号的线下用车和超期退款放到这里

        List<Long> groupIds1 = new ArrayList();


        groupIds1.add(0L);

        List<String> list = new ArrayList<>();

    }
}
