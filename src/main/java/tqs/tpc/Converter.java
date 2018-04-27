/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.tpc;

import java.util.HashMap;

/**
 *
 * @author andreia
 */
public class Converter {
    
    DataGetter data= new DataGetter();
    public double result;
    
    
    public double convert(String from, String to, double amount){
        result=amount*(data.getJsonAPI().get(to)/data.getJsonAPI().get(from));
        return result;
    }
    
    public HashMap<String, String> getMoedas(){
        HashMap<String, String> moedas = new HashMap<>();
        
        for (String k: data.getJsonAPI().keySet()){
            moedas.put(k, k);
        }
        return moedas;
    }
  
   
}

