/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.daos;

import com.mycompany.nncloudrestservice.model.Network;
import com.mycompany.nncloudrestservice.model.User;
import com.mycompany.nncloudrestservice.utils.CurrentUserContainer;
import com.mycompany.nncloudrestservice.utils.SessionContainer;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Tomasz
 */
public class NetworkDAO implements DAO<Network>
{
    private final SessionFactory factory;
    
    public NetworkDAO()
    {
        this.factory = SessionContainer.factory;
    }
    
    @Override
    public void addItem(Network item) 
    {        
        User u = CurrentUserContainer.getInstance();
        List<Network> ln = u.getNetworks();
        ln.add(item); // TODO: Fix bug- Networks non existent after closing session
        u.setNetworks(ln);
        UserDAO udao = new UserDAO();
        udao.updateItem(u);
    }

    @Override
    public void updateItem(Network item) {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try
        {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        }
        catch(HibernateException he)
        {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public void removeItem(Network item) {
        Session session = factory.openSession();
        Transaction tx = null;
        
        try
        {
            tx = session.beginTransaction();
            session.delete(item);
            tx.commit();
        }
        catch(HibernateException he)
        {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
    }

    @Override
    public Network getItem(String... keys) throws Exception {
        Session session = factory.openSession();
        Transaction tx = null;
        
        String id_network = keys[0];
        
        Network n = null;
        
        try
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM Network n WHERE n.id_network = :id_network");
            query.setParameter("id_network", id_network);
            List results = query.list();    
            n = (Network)results.get(0);
            tx.commit();
        }
        catch(HibernateException he)
        {
            if (tx != null) tx.rollback();
            he.printStackTrace();
        }
        finally
        {
            session.close();
        }
        return n;
    }
}
