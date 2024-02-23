package com.design_patterns.proxy.v1;

public class UserControllerProxyII extends UserController {

    @Override
    public String login(String telephone, String password) {
        String login = super.login(telephone, password);
        //可以写一个代理的逻辑,比如计时什么的.
        return null;
    }

    @Override
    public String register(String telephone, String password) {
        String register = super.register(telephone, password);
        //可以写一个代理的逻辑,比如计时什么的.
        return null;
    }

    public static void main(String[] args) {
        IUserController proxy = new UserControllerProxyII();
    }
}
