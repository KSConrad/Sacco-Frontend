package org.pahappa.systems.kimanyisacco.services;




import java.util.List;

import org.pahappa.systems.kimanyisacco.daos.AddUser;
import org.pahappa.systems.kimanyisacco.models.User;




public class UserImpl implements UserService  {
   
   AddUser userDAO = new AddUser();
    @Override
    public void createUser(User user) {
       

        userDAO.save(user);
      
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}