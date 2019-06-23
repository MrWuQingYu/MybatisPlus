package mybatisplus.config;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.baomidou.mybatisplus.core.injector.methods.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/21 16:04
 * @description： Sql注入器添加,即全局配置Sql注入器,sqlInjector改写  添加自定义SQL方法
 * @modified By：
 * @version:
 */
public class MySqlInjector extends AbstractSqlInjector  {

    /**
     * 自定义SQL方法时需要把默认的API方法加进来  否则调MyBATISPlus默认的API会报错
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList() {
        List<AbstractMethod> abstractMethods = new ArrayList<AbstractMethod>();
        abstractMethods.add(new DeleteAll());
        abstractMethods.add(new Insert());
        abstractMethods.add(new SelectPage());
        abstractMethods.add(new SelectList());
        abstractMethods.add(new DeleteById());
        abstractMethods.add(new UpdateById());
        return abstractMethods;
    }
}
