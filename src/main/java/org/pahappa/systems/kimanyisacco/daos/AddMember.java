package org.pahappa.systems.kimanyisacco.daos;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.Members;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class AddMember {

    public void save(Members member){
        Transaction transaction = null;
        try{
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(member);
            transaction.commit();
        }catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

       public List<Members> getAllMembers(){
        
        Session session = SessionConfiguration.getSessionFactory().openSession();
        return session.createCriteria(Members.class).list();
      

}
  public List<Members> getJoinRequests(){
        
        Session session = SessionConfiguration.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Members.class);
        criteria.add(Restrictions.eq("status", "PENDING"));


        return criteria.list();
    
      

}

public void updateStatus(long id){
    Transaction transaction = null;
    try{
    Session session = SessionConfiguration.getSessionFactory().openSession();
    transaction = session.beginTransaction();
    Members member = (Members) session.get(Members.class,id);

    
    member.setStatus("APPROVED");

    
    session.update(member);
    transaction.commit();
    }catch(Exception ex) {
        if (transaction != null) {
            transaction.rollback();
        }
    }

}


}

