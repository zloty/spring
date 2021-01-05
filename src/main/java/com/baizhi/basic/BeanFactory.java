package com.baizhi.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    private static Properties env = new Properties();
    //为了避免重复的读取properties文件中的数据（即重复的IO），这里用静态代码块，即在项目启动的时候主动执行
    static {
        // 获得io流
        InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
        // 将内容封装到Properties
        try {
            env.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String key) {
        Object ret = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 对象的创建方式
     * 1、直接调用构造方法 创建对象 UserService service = new UserServiceImpl()
     * 2、通过反射形式 创建对象 解耦合
     *      Class clazz = Class.forName("com.baizhiedu.basic.UserServiceImpl");
     *      UserService service = (UserService) Clazz.newInstance();
     * @return
     */
//    public static UserService getUserService() {
//        UserService userService = null;
//        try {
//            Class clazz = Class.forName(env.getProperty("userService"));
//            userService = (UserService) clazz.newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return userService;
////        return new UserServiceImpl();
//    }
//
//    public static UserDAO getUserDao() {
//        UserDAO userDAO = null;
//        try {
//            Class clazz = Class.forName(env.getProperty("userDao"));
//            userDAO = (UserDAO) clazz.newInstance();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return userDAO;
//    }
}
