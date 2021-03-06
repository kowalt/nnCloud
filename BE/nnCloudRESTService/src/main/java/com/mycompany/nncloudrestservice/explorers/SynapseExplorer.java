/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.explorers;

import com.mycompany.nncloudrestservice.pojo.Layer;
import com.mycompany.nncloudrestservice.pojo.Network;
import com.mycompany.nncloudrestservice.pojo.Neuron;
import com.mycompany.nncloudrestservice.pojo.Synapse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Tomasz
 */
public class SynapseExplorer {
    private Network network;
    private List<Synapse> synapses;
    
    public SynapseExplorer(Network n)
    {
        this.network = n;
        synapses = new ArrayList<Synapse>();
    }

    /**
     * Returns all unique synapses
    */
    public List<Synapse> getAll()
    {        
        for(Layer layer: network.getLayers())
        {
            for(Neuron neuron: layer.getNeurons())
            {
                for(Synapse synIn: neuron.getSynapses_in())
                    synapses.add(synIn);

                for(Synapse synOut: neuron.getSynapses_out())
                    synapses.add(synOut);
            }
        }

        return synapses;
    }
    
    /**
     * Set weights of all synapses
     */
    public void setWeights(double value)
    {
        for(Layer layer: network.getLayers())
        {
            for(Neuron neuron: layer.getNeurons())
            {
                for(Synapse synIn: neuron.getSynapses_in())
                    synIn.setWeight(value);

                for(Synapse synOut: neuron.getSynapses_out())
                    synOut.setWeight(value);
            }
        }
    }
}
