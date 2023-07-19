package org.pahappa.systems.kimanyisacco.userView;

import org.pahappa.systems.kimanyisacco.models.User;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="userView")
public class UserView {
    private List<User> users;

    public void setUsers(List<User> users){
        this.users=users;
    }
    public List<User> getUsers(){
        return users;
    }
     public UserView(){
        this.users = new ArrayList<>();
        for(int i=0;i<5;i++){
            User user = new User();
            user.setPassword("password");
            user.setUserName("hi");
            this.users.add(user);
        }


        
     }
}
