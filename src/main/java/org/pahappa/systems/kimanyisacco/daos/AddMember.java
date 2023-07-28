package org.pahappa.systems.kimanyisacco.daos;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.Members;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class AddMember {

    public boolean save(Members member){
        Transaction transaction = null;
        boolean isSuccess = false;
        try{
            
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
           Members memberEmail= getMemberByUsername(member.getEmail());
           if(memberEmail==null){
            isSuccess= true;
            session.save(member);
            transaction.commit();
            
        }
            
            
        }catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }

        return isSuccess;
    }

       public List<Members> getAllMembers(){
        
        Session session = SessionConfiguration.getSessionFactory().openSession();
        return session.createCriteria(Members.class).list();
      

}


public Members getMemberByUsername(String userName){
    try  {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        
        Criteria criteria = session.createCriteria(Members.class);
        criteria.add(Restrictions.eq("userName", userName));
        
        return (Members) criteria.uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}


  public List<Members> getJoinRequests(){
        
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Members.class);
        criteria.add(Restrictions.eq("status", "PENDING"));


        return criteria.list();
    
      

}
public List<Members> getMembers(){
        
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Members.class);
        criteria.add(Restrictions.eq("status", "APPROVED"));


        return criteria.list();
    
      

}


public void updateStatus(String userName){
    Transaction transaction = null;
    try{
    Session session = SessionConfiguration.getSessionFactory().openSession();
    transaction = session.beginTransaction();
    Members member = (Members) session.get(Members.class,userName);

    
    member.setStatus("APPROVED");

    
    session.update(member);
    transaction.commit();
    }catch(Exception ex) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

}
public void updateMember(Members updatedDetails){
    System.out.println("name"+updatedDetails.getUserName());
    Transaction transaction = null;

  try{
  Session session = SessionConfiguration.getSessionFactory().openSession();
  transaction = session.beginTransaction();
  Members member = (Members) session.get(Members.class,updatedDetails.getUserName());
 
  member.setLocation(updatedDetails.getLocation());
 
  member.setTelephoneContact(updatedDetails.getTelephoneContact());
 
  member.setCurrentEmployment(updatedDetails.getCurrentEmployment());
  member.setEmployerName(updatedDetails.getEmployerName());
  member.setEmployerPhoneNumber(updatedDetails.getEmployerPhoneNumber());
  member.setJobPosition(updatedDetails.getJobPosition());
  member.setMonthlySalary(updatedDetails.getMonthlySalary());
  member.setSourcesOfIncome(updatedDetails.getSourcesOfIncome());
  member.setRefereeName(updatedDetails.getRefereeName());
  member.setRefereePhoneNumber(updatedDetails.getRefereePhoneNumber());
  member.setRefereeJobPosition(updatedDetails.getRefereeJobPosition());
  

  session.update(member);
  transaction.commit();
  }catch(Exception ex) {
      if (transaction != null) {
          transaction.rollback();
      }
  }

}

public Members getMemberByCredentials(String userName){
    
    try  {
        Session session = SessionConfiguration.getSessionFactory().openSession();
        
        Criteria criteria = session.createCriteria(Members.class);
        criteria.add(Restrictions.eq("userName", userName));
        
        criteria.add(Restrictions.eq("status", "APPROVED"));
        return (Members) criteria.uniqueResult();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }

}

public void updatePassword(String password, String userName){
     Transaction transaction = null;
    try{
    Session session = SessionConfiguration.getSessionFactory().openSession();
    transaction = session.beginTransaction();
    Members member = (Members) session.get(Members.class,userName);

    
    member.setPassword(password);

    
    session.update(member);
    transaction.commit();
    }catch(Exception ex) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

}

// public Members getMemberByEmail(String email){
   
//     }



}




