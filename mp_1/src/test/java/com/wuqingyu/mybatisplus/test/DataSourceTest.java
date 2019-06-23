package com.wuqingyu.mybatisplus.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wuqingyu.mybatisplus.entity.Employee;
import com.wuqingyu.mybatisplus.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void test01() throws Exception {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 新增
     *
     * @throws Exception
     */
    @Test
    public void mapperInsert01() throws Exception {
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setEmail("2222@qq.com");
        employee.setGender(0);
        employee.setLastName("李四");
        // insert方法在插入时， 会根据实体类的每个属性进行非空判断，只有非空的属性对应的字段才会出现到SQL语句中
        Integer insert = employeeMapper.insert(employee);
        // 获取主键值
        Integer id = employee.getId();
        System.out.println(id);
    }

    /**
     * 更新
     */
    @Test
    public void updateTest() {
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setId(7);
        //employee.setAge(50);
        employee.setEmail("WUQY@qq.com");
        employee.setGender(0);
        employee.setLastName("武清与01");
        employeeMapper.updateById(employee);
    }

    /**
     * 查询
     */
    @Test
    public void selectTest() {
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        /**
         * 根据ID查询
         */
        Employee employee = employeeMapper.selectById(7);
        System.out.println(employee);

        /**
         * 多个条件组合查询
         * map的key为数据库字段
         */
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("last_name", "Black");
        map.put("gender", "1");
        List<Employee> employees = employeeMapper.selectByMap(map);
        System.out.println(employees);
        /**
         * 根据条件查询单个对象
         */
        QueryWrapper<Employee> employeeQueryWrapper = new QueryWrapper<Employee>();
        employeeQueryWrapper.eq("last_name", "Black");
        Employee employee1 = employeeMapper.selectOne(employeeQueryWrapper);
        System.out.println(employee1);

        /**
         * 获取单列值
         */
        QueryWrapper<Employee> employeeQueryWrapper1 = new QueryWrapper<Employee>();
        employeeQueryWrapper1.between("id", 1, 5);
        List<Object> objects = employeeMapper.selectObjs(employeeQueryWrapper1);
        System.out.println(objects);
        /**
         * 获取全部数据的单列值
         */
        List<Object> objects1 = employeeMapper.selectObjs(null);
        System.out.println(objects1);
        /**
         * 分页查询（未安装插件前是内存分页）
         */
        IPage<Employee> employeeIPage = employeeMapper.selectPage(new Page<Employee>(1, 2),
                new QueryWrapper<Employee>()
                        .eq("gender", 0)
                        .orderByDesc("age")
                        // 在SQL的最后面拼接
                        .last("limit 1,2"));
        System.out.println("employeeIPage" + employeeIPage.getRecords());
    }

    @Test
    public void deleteTest() {
        EmployeeMapper employeeMapper = context.getBean("employeeMapper", EmployeeMapper.class);
        Integer i = employeeMapper.deleteById(9);
        System.out.println(i);

//        int i1 = employeeMapper.deleteBatchIds(Arrays.asList(5, 6));
//        System.out.println(i1);
    }
}
