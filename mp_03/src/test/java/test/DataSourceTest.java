package test;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import mybatisplus.entity.Employee;
import mybatisplus.entity.User;
import mybatisplus.mapper.EmployeeMapper;
import mybatisplus.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/20 9:44
 * @description：
 * @modified By：
 * @version:
 */
public class DataSourceTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    @Test
    public void test01(){
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<Employee>(1, 1), null);
        System.out.println(employeeIPage.getRecords());
    }
    @Test
    public void test03(){
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        Integer integer = employeeMapper.deleteAll();
        System.out.println(integer);
    }

    @Test
    public void test04(){
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        Integer integer = userMapper.deleteById(1);
        System.out.println(integer);
    }

    @Test
    public void test06(){
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = new User();
        user.setLastName("网吧");
        user.setAge(20);
        user.setEmail("12@qq.com");
        user.setGender(1);
        user.setDelFalg(1);
        Integer integer = userMapper.insert(user);
        System.out.println(integer);
    }

    @Test
    public void test07(){
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        User user = new User();
        user.setLastName("网吧xxx");
        user.setId(7);
        Integer integer = userMapper.updateById(user);
        System.out.println(integer);
    }

    @Test
    public void test05(){
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user.getCreateTime());
        }
        System.out.println(users);
    }
    @Test
    public void test02(){
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setAge(100);
        employee.setId(1);
        employee.setVersion(3);
        employeeMapper.updateById(employee);
    }
}
