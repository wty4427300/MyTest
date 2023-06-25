package com.design_patterns.proxy.v1;

public class UserControllerProxy implements IUserController {

    private final String desc;
    private final UserController userController;

    public UserControllerProxy(UserController userController) {
        this.desc = "静态代理模式";
        this.userController = userController;
    }

    @Override
    public String login(String telephone, String password) {
        //可以写一个代理类的逻辑,比如计时什么的.
        userController.login(telephone, password);
        return null;
    }

    @Override
    public String register(String telephone, String password) {
        userController.register(telephone, password);
        return null;
    }

    public static void main(String[] args) {
        IUserController proxy = new UserControllerProxy(new UserController());
    }
}
