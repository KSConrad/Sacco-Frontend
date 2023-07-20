package org.pahappa.systems.kimanyisacco.services;




import org.pahappa.systems.kimanyisacco.daos.AddUser;
import org.pahappa.systems.kimanyisacco.models.User;




public class UserImpl implements UserService  {
   
   AddUser userDAO = new AddUser();
    @Override
    public void createUser(User user) {
       

        userDAO.save(user);
      
    }
}