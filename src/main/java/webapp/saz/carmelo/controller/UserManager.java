package webapp.saz.carmelo.controller;

import java.util.List;

import webapp.saz.carmelo.model.User;

public interface UserManager {

   public List<User> getUsers() throws Exception;

   public String addUser() throws Exception;

   public User findUser(String username, String password) throws Exception;

   public User getNewUser();

}