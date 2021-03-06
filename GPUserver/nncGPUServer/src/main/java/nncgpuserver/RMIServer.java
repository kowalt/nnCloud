/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nncgpuserver;

import java.util.Timer;

/**
 *
 * @author Tomasz
 */
public class RMIServer {
    private Integer id;
    private String label;
    private String host;
    private Integer port;
    private String name;
    private Long last_report_time;
    
    public RMIServer(Integer id, String label) {
        this.id = id;
        this.label = label;
        last_report_time = System.currentTimeMillis();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLast_report_time() {
        return last_report_time;
    }

    public void setLast_report_time(Long last_report_time) {
        this.last_report_time = last_report_time;
    }
}