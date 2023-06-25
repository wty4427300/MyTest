package com.design_patterns.proxy.v1;

public interface IUserController {
    String login(String telephone, String password);

    String register(String telephone, String password);
}
