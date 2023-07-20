package org.pahappa.systems.kimanyisacco.daos;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.pahappa.systems.kimanyisacco.config.SessionConfiguration;
import org.pahappa.systems.kimanyisacco.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class AddUser {

    public void save(User user){
        Transaction transaction = null;
        try{
            Session session = SessionConfiguration.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch(Exception ex){
            if(transaction!=null){
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }}
