package org.pahappa.systems.kimanyisacco.services;




import java.util.List;

import org.pahappa.systems.kimanyisacco.daos.AddMember;
import org.pahappa.systems.kimanyisacco.daos.AddUser;
import org.pahappa.systems.kimanyisacco.models.Members;




public class MemberImpl  {
   
   AddMember memberDAO = new AddMember();
    
    public void createMember(Members member) {


        if (member.getPassword() == null || member.getPassword().trim().isEmpty()) {
            // If password is empty or null, set it to the generated ID
            member.setPassword(member.getEmail());
        }

        if (member.getUserName() == null || member.getUserName().trim().isEmpty()) {
            // If password is empty or null, set it to the generated ID
            member.setUserName(member.getEmail());
        }

        if (member.getStatus() == null || member.getStatus().trim().isEmpty()) {
            // If password is empty or null, set it to the generated ID
            member.setStatus("PENDING");
        }

        
        memberDAO.save(member);
      
    }

    public List<Members> getAllMembers(){
        return memberDAO.getAllMembers();
    }
}
