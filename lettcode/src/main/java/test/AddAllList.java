package test;

import java.util.ArrayList;
import java.util.List;

public class AddAllList {

        public static void main(String[] args) throws Exception {
            /*测试合并两个类型相同的list*/
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            //给list1赋值
            list1.add("测");
            list1.add("试");
            list1.add("一");
            list1.add("下");
            //给list2赋值
            list2.add("合");
            list2.add("并");
            list2.add("列");
            list2.add("表");
            //将list1.list2合并
            list1.addAll(list2);
            //循环输出list1 看看结果
            for (String s : list1) {
                System.out.print(s);
            }
        }

}
