package com.demo;
import org.apache.thrift.TException;


public class UserServiceImp implements com.demo.UserService.Iface {
    @Override
    public User getById(int id) throws TException {

        System.out.println("==getById==");
        User user = new User();
        user.setName("sdy");
        user.setId(id);
        user.setAge(30);
        return user;
    }

    @Override
    public boolean isExist(String name) throws TException {
        return false;
    }
}
