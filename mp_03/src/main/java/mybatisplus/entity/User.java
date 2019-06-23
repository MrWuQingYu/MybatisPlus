package mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "tbl_user")
public class User extends BaseEntity{
    private Integer id ;
    private String lastName;
    private String email ;
    private Integer gender ;
    private Integer age ;

    @TableLogic
   private Integer delFalg;
}
