/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.ws;

import com.mycompany.nncloudrestservice.logic.NetworkCrudManager;
import com.mycompany.nncloudrestservice.exceptions.NetworkAccessException;
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
@Path("networks")
public class Networks
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListOfNetworks()
    {
        NetworkCrudManager ncm = new NetworkCrudManager();
        return Response.status(200).entity(ncm.getListOfNetworks().toString()).build();
    }
}
