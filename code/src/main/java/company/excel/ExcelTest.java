package company.excel;


import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

public class ExcelTest {
    public static void main(String[] args) {
        writeData();

    }
    // 这里我们创建一个方法，里面负责往集合里面存放数据（这里改成对于的业务逻辑即可）
    public static List studentData(){
        ArrayList demoData = new ArrayList<>(10);
        for (int i = 0; i < 100; i++) {
            DemoData demoData1 = new DemoData();
//            demoData1.setName("麻辣烫");
            demoData1.setId(i);
//            demoData1.setFenlei(“测试分类”);
//            demoData1.setJiage(“0.01”);
//            demoData1.setMiaoshu(“这道菜品经济实惠”);
//            demoData1.setCanfeihe(“0.01”);
//            demoData1.setLeixing(“1”);
//            demoData1.setShuxing(“冷饮”);
//            demoData1.setShangjia(“1”);
            demoData.add(demoData1);
        }
        return demoData;
    }

    public static void writeData(){
        // 写入存放路径
        String fileName="/Users/kevin/writer8.xls";
// 创建excel对象参数一：路径，参数二：实体类对象。sheet：表sheet名，doWrite：存放的对象集合
        EasyExcel.write(fileName,DemoData.class).sheet("菜品分类").doWrite(studentData());
    }
}
