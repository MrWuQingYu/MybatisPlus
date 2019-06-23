package mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mybatisplus.entity.Employee;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/20 10:16
 * @description：
 * @modified By：
 * @version:
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    Integer deleteAll();
}
