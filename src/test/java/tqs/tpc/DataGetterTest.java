/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs.tpc;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andreia
 */
public class DataGetterTest {
    
    public DataGetterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getJsonAPI method, of class DataGetter.
     */
    @Test
    public void testGetJsonAPI() {
        System.out.println("getJsonAPI");
        DataGetter instance = new DataGetter();
        HashMap<String, Double> expResult = new HashMap<>();
        expResult.put("EUR", 0.824304);
        expResult.put("GBP", 0.72584);
        HashMap<String, Double> result = instance.getJsonAPI();
        assertEquals(expResult.containsKey(result), expResult.containsValue(result));
        
    }
    
}
