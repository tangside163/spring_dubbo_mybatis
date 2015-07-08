import com.github.pagehelper.Page;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tangsi.entity.Order;
import org.tangsi.entity.User;
import org.tangsi.service.OrderService;
import org.tangsi.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by tangsi 2015/7/6
 */
public class SpringTransactionTest {

    public static void main(String[] args)  {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        User user = userService.findById(1);
        System.out.println("用户名：" + user.getName());

       OrderService orderService = (OrderService) context.getBean("orderServiceImpl");
         Order order = orderService.getOrderById(user.getId());
        System.out.println(order.getName());

        /*List<Order> list = orderService.getListByUserId(user.getId());
        for(Order order : list) {
            System.out.println(order.getName());
        }*/

    }

    /**
     * 测试mybatis插入并返回主键的值
     */
    @Test
    public void testInsert() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        User user = new User();
        user.setName("liushiyi");
        user.setEmail("12124158@qq.com");
        user.setPhone("18678745784");
        int num = userService.insert(user); //返回的是影响的行数
        System.out.println(num);
        System.out.println(user.getId());  //user对象的主键id已被填充

    }

    /**
     * 测试mybatis批量插入
     */
    @Test
    public void testSaveBatch() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        List<User> users = new ArrayList<User>();

        for(int i=0; i<3; i++) {
            User user = new User();
            user.setEmail("email" + i);
            user.setName("name" + i);
            user.setPhone("189" + i);
            users.add(user);
        }
        int num = userService.saveBatch(users);
        System.out.print("插入的数据条数为： " + num);

    }

    /**
     * 测试mybatis分页
     */
    @Test
    public void testPaging() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        Page<User> page = new Page<User>();
        page.setPageNum(1);
        page.setPageSize(7);
        page = userService.listPage(page);

        List<User> users = page;
        System.out.println("总数: " + page.getTotal());
        System.out.println("总页数：" + page.getPages());

        for(User user : users) {
            System.out.println("name:" + user.getName() + ",email:" + user.getEmail());
        }
    }


    /**
     * 测试mybatis 变量$与#的区别,$替代表名，#替代字段名
     */
    @Test
    public void testParamMap() {

        ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
        UserService userService = (UserService) context.getBean("userServiceImpl");
        Map<String, Object> param = new HashMap<>();
        param.put("table","t_user");
        param.put("id",8);

        User user = userService.selectWithParamMap(param);
        if(user != null)
        System.out.println("userId:" + user.getId() + " , name=" + user.getName());

    }

}
