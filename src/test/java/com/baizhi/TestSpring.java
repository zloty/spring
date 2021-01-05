package com.baizhi;

import com.baizhi.basic.BeanFactory;
import com.baizhi.basic.User;
import com.baizhi.basic.UserService;
import com.baizhi.basic.UserServiceImpl;
import org.junit.Test;

public class TestSpring {
    @Test
    public void test1() {
//        UserService service = new UserServiceImpl();
//        UserService service = BeanFactory.getUserService();
        UserService service = (UserService) BeanFactory.getBean("userService");
        service.login("zz","dd");
        User user = new User(1L,"gg","dd");
        service.register(user);

    }
}
