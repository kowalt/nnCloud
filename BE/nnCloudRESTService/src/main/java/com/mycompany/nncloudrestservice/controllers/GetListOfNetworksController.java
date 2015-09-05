/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.controllers;

import com.mycompany.nncloudrestservice.model.Network;
import com.mycompany.nncloudrestservice.utils.SessionContainer;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Tomasz
 */
public class GetListOfNetworksController 
{
    public JSONObject getListOfNetworks()
    {
        List<Network> list = getFromDatabase();
        JSONArray r = new JSONArray();
        for(Network n: list)
        {
            JSONObject singleNetwork = new JSONObject();
            singleNetwork.put("id", n.getId());
            singleNetwork.put("name", n.getName());
            singleNetwork.put("creation-date", n.getCreation());
            r.put(singleNetwork);
        }
        return new JSONObject(r);
    }
    
    private List<Network> getFromDatabase()
    {
        SessionFactory factory = SessionContainer.factory;
        Session session = factory.openSession();
        Transaction tx = null;
        List<Network> networks = null;
        try
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("FROM networks");
            networks = query.list();
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
        return networks;
    }
}

