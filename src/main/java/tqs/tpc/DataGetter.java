/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.tpc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author andreia
 */

public class DataGetter {
    // essential URL structure is built using constants 
    public static final String ACCESS_KEY = "94a0812b9145a13b2959eca0c5cf30d0";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";
    

    // this object is used for executing requests to the (REST) API
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public  HashMap<String, Double> getJsonAPI(){
        
        HashMap<String, Double> convertDolarMoedas = new HashMap<>();

   
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&format=1" );
        
        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            JSONObject jsonObject = new JSONObject(EntityUtils.toString(entity));
            
            
            JSONObject quotes= jsonObject.getJSONObject("quotes");
            //System.out.println("*** "+quotes);
            Iterator itr= quotes.keys();
            
            
            
            while(itr.hasNext()){
                String k = itr.next().toString();
                //System.out.println("**" + k);
                if("USDUSD".equals(k)){
                    convertDolarMoedas.put("USD", 1.0);
                }
                else{
                    convertDolarMoedas.put(k.replace("USD", ""), quotes.getDouble(k));     
                }    
            }
           
            
            response.close();
        } catch (ClientProtocolException e) {
            System.out.println("catch 1");
            // TODO Auto-generated catch block
                e.printStackTrace();
        } catch (IOException e) {
            System.out.println("catch 2");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("catch 3");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("catch 4");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return convertDolarMoedas;
    }
  
}
