/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.ws;

import com.mycompany.nncloudrestservice.exceptions.NetworkAccessException;
import com.mycompany.nncloudrestservice.logic.Load;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Tomasz
 */
@Path("network")
public class Network {
    @GET
    @Path("/{id: \\d+}")
    @Produces(MediaType.APPLICATION_XML)
    public Response loadNetwork(@PathParam("id") String id)
    {
        Load lc = new Load();
        String r = null;
        try
        {    
            r = lc.loadNetworkAsXML(Integer.parseInt(id));
        }
        catch(NetworkAccessException nae)
        {
            return Response.status(404).entity(nae.getMessage()).build();
        }    
        
        return Response.status(200).entity(r).build();
    }   
}