/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.nncloudrestservice.misc;

import com.mycompany.nncloudrestservice.pojo.ActivationFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Tomasz
 */
public class ActivationFunctionParser 
{
    private static final Logger logger = LogManager.getLogger(ActivationFunctionParser.class);
 
    public ActivationFunctionParser()
    {
        
    }

    public List<ActivationFunction> parse(String raw)
    {
        StringTokenizer rulesTok = new StringTokenizer(raw, ";");

        
        List<ActivationFunction> af = new ArrayList<>();
        ActivationFunction afun;
        
        while(rulesTok.hasMoreElements())
        {
            String[] rule = rulesTok.nextToken().split("<=>");
            String function;
            String domain = "";
            function = rule[0];
            if(rule.length > 1)
                domain = rule[1];
            
            afun = new ActivationFunction();

            afun.setFunction(function);
            afun.setDomain_rule(domain);
            afun.setFirst_derivative(calculateDerivative(function));

            af.add(afun);
        }
        
        return af;
    }
    
    private String calculateDerivative(String function)
    {
        if(function.equals("Tanh(x)"))
            return "Sech(x)^2";
        if(!function.contains("x"))
            return "0";
        logger.error("No derivative for function="+function);
        return "";
    }
}
