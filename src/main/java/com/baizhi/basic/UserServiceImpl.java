package com.baizhi.basic;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = (UserDAO) BeanFactory.getBean("userDao");
//    private UserDAO userDAO = new UserDAOImpl();
    @Override
    public void register(User user) {
        userDAO.save(user);
    }

    @Override
    public void login(String name,String password){
        userDAO.queryUserByNameAndPassword(name,password);
    }
}
