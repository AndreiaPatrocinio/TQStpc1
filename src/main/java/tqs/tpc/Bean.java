/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.tpc;

import java.io.Serializable;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author andreia
 */

@ManagedBean(name = "Bean")
@SessionScoped


public class Bean implements Serializable{
    private String from;
    private String to;
    private double amount;
    private double result;
    
    private Converter conv;
    private HashMap<String, String> moedas;
    
    @PostConstruct
    public void init(){
        conv=new Converter();
        moedas=conv.getMoedas();
    }
    
    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public double getAmount() {
        return amount;
    }

    public double getResult() {
        return result;
    }
    
    public HashMap<String, String> getMoedas(){
        return moedas;
    }
    
    public void setMoedas(HashMap<String, String> moedas){
        this.moedas= moedas;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
    public String convert(){
        double r = conv.convert(from, to, amount);
        setResult(r);
        return "index.xhtml";
        
    }
     
     
}
