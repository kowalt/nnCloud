/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tomasz
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ActivationFunction
{
    @XmlAttribute
    private int id;
    private String function;
    private String domain_rule;
    @XmlTransient
    private Neuron neuron;
    private String first_derivative;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
  
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getDomain_rule() {
        return domain_rule;
    }

    public void setDomain_rule(String domain_rule) {
        this.domain_rule = domain_rule;
    }

    public Neuron getNeuron() {
        return neuron;
    }

    public void setNeuron(Neuron neuron) {
        this.neuron = neuron;
    }

    public ActivationFunction cloneFunctionAndDomainRule()
    {
        ActivationFunction instance = new ActivationFunction();
        instance.setFunction(function);
        instance.setFirst_derivative(first_derivative);
        instance.setDomain_rule(domain_rule);

        return instance;
    }

    public String getFirst_derivative() {
        return first_derivative;
    }

    public void setFirst_derivative(String first_derivative) {
        this.first_derivative = first_derivative;
    }
}
