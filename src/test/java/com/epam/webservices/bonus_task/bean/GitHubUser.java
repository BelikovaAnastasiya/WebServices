package com.epam.webservices.bonus_task.bean;

import java.io.Serializable;

public class GitHubUser implements Serializable{

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "login='" + login + '\'' +
                '}';
    }

}
