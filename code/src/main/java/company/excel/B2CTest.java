package company.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class B2CTest {
    public static void main(String[] args) {
        int[] poiIds = {1,2,3,45};
         writeData(poiIds);
        simpleRead();
    }

    public static List studentData(int[] ids){
        ArrayList demoData = new ArrayList<>(10);
        for (int i : ids) {
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

    public static void writeData(int[] ids){
        // 写入存放路径
        String fileName="/Users/kevin/test.csv";
        // 创建excel对象参数一：路径，参数二：实体类对象。sheet：表sheet名，doWrite：存放的对象集合
       // EasyExcel.write(fileName,DemoData.class).sheet("b2c").doWrite(studentData(ids));
        EasyExcel.write(fileName,DemoData.class).sheet().doWrite(studentData(ids));
    }

    /**
     * 最简单的读
     * <p>1. 创建excel对应的实体对象 参照{@link DemoData}
     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link }
     * <p>3. 直接读即可
     */
    public static void simpleRead() {
        //String fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
        String fileName = "/Users/kevin/test.csv";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, DemoData.class, new EasyExcelOrderListener()).sheet().doRead();

        /**
         *   不需要额外写一个listener
         *   这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
         *   这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
         *   具体需要返回多少行可以在`PageReadListener`的构造函数设置
         */
        List<Integer> list = new ArrayList<>();
        EasyExcel.read(fileName, DemoData.class, new PageReadListener<DemoData>(dataList -> {
            for (DemoData demoData : dataList) {
                list.add(demoData.getId());
                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
            }
        })).sheet().doRead();


        EasyExcel.read(fileName, DemoData.class, new ReadListener<DemoData>() {
            /**
             * 单次缓存的数据量
             */
            public static final int BATCH_COUNT = 100;
            /**
             *临时存储
             */
            private List<DemoData> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);

            @Override
            public void invoke(DemoData data, AnalysisContext context) {
                cachedDataList.add(data);
                if (cachedDataList.size() >= BATCH_COUNT) {
                    saveData();
                    // 存储完成清理 list
                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                saveData();
            }

            /**
             * 加上存储数据库
             */
            private void saveData() {
                log.info("{}条数据，开始存储数据库！", cachedDataList.size());
                log.info("存储数据库成功！");
            }
        }).sheet().doRead();
    }
}
