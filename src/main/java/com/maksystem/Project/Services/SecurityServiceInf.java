package com.maksystem.Project.Services;

public interface SecurityServiceInf {

    String findLoggedInUserName();

    void autoLogin(String email, String password);
}
