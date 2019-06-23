package mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/19 18:06
 * @description：
 * @modified By：
 * @version:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//使用全局配置
//@TableName(value = "tbl_employee")
public class Employee {
//    @TableId(type = IdType.AUTO)
    private Integer id ;
    @TableField(value = "last_name")
    private String lastName;
    private String email ;
    private Integer gender ;
    private Integer age ;

    // 该字段在数据库中不存在
    @TableField(exist = false)
    private String salary;

    @Version
    private Integer version;
}
