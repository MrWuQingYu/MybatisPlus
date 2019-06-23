package mybatisplus.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/21 17:44
 * @description：
 * @modified By： 公共字段填充
 * @version:
 */
public class MyMetaObjectHandler implements MetaObjectHandler {

    public void insertFill(MetaObject metaObject) {
        setInsertFieldValByName("createTime", new Date(), metaObject);
        setInsertFieldValByName("operater", "wuqy", metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        setUpdateFieldValByName("modifyTime", new Date(), metaObject);
        setUpdateFieldValByName("operater", "lisi", metaObject);
    }
}
