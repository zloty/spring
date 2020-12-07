package com.baizhi.basic;

public class UserDAOImpl implements UserDAO {
    @Override
    public void save(User user){
        System.out.println("insert");
    }

    @Override
    public void queryUserByNameAndPassword(String name,String password) {
        System.out.println("query");
    }
}
