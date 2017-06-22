/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tomasz
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Network
{
    @XmlAttribute
    private int id;
    private String name;
    private Date creation;
    private String state;
    private Integer trainingIterationsMax;
    private Integer trainingIterationsDone;
    
    @XmlElementWrapper
    @XmlElement(name="layer")
    private List<Layer> layers = new ArrayList<>();
    @XmlTransient
    private User user;
    
    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTrainingIterationsMax() {
        return trainingIterationsMax;
    }

    public void setTrainingIterationsMax(Integer trainingIterationsMax) {
        this.trainingIterationsMax = trainingIterationsMax;
    }

    public Integer getTrainingIterationsDone() {
        return trainingIterationsDone;
    }

    public void setTrainingIterationsDone(Integer trainingIterationsDone) {
        this.trainingIterationsDone = trainingIterationsDone;
    }
}
