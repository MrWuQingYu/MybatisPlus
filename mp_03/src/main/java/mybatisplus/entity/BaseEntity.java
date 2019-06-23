package mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/21 17:32
 * @description：
 * @modified By：
 * @version:
 */
@Data
@ToString
public class BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    protected Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    protected Date modifyTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    protected String operater;
}
