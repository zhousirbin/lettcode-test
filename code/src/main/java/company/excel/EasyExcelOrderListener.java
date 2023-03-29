package company.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * 监听器
 *
 ***/

@Slf4j
public class EasyExcelOrderListener<DemoData> extends AnalysisEventListener<DemoData> {

    public static List<Integer> ids = new ArrayList<>();

    public EasyExcelOrderListener() {
        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数

    }
    /**
     * 此方法每一条数据解析都会来调用
     *
     * @param data
     * @param context
     */
    @Override
    public void invoke(DemoData data, AnalysisContext context) {
        log.info("解析到一条数据："+data);
    }

    /**
     * 所有数据解析完成都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！！！");
    }
}
