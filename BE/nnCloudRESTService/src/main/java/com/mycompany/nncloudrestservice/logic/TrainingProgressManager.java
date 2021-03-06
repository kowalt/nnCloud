/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.logic;

import com.mycompany.nncloudrestservice.daos.NetworkDAO;
import com.mycompany.nncloudrestservice.pojo.Network;
import org.json.JSONObject;

/**
 *
 * @author Tomek
 */
public class TrainingProgressManager {
    public JSONObject getProgress(String networkId)
    {
        NetworkDAO ndao = new NetworkDAO();
        ndao.setLazyLoadMode(true);
        Network network = ndao.getItem(networkId);

        JSONObject jsonO = new JSONObject();

        Integer trainingIterationsMax,trainingIterationsDone;
        
        if(network.getTrainingIterationsDone() == null || network.getTrainingIterationsMax() == null)
        {
            trainingIterationsDone = -1;
            trainingIterationsMax = -1;
        }
        else
        {
            trainingIterationsDone = network.getTrainingIterationsDone();
            trainingIterationsMax = network.getTrainingIterationsMax();
        }
        jsonO.append("iterationsMax", trainingIterationsMax);
        jsonO.append("iterationsDone", trainingIterationsDone);

        return jsonO;
    }
}
