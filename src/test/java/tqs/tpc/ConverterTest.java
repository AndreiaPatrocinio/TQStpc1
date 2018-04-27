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
public class ConverterTest {
    
    public ConverterTest() {
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
     * Test of convert method, of class Converter.
     */
    @Test
    public void testConvert() {
        System.out.println("convert");
        String from = "EUR";
        String to = "GBP";
        double amount = 1.0;
        Converter instance = new Converter();
        double expResult = 0.8805489236980532;
        double result = instance.convert(from, to, amount);
        assertEquals(expResult, result, 0.8805489236980532);
    }

    /**
     * Test of getMoedas method, of class Converter.
     */
    @Test
    public void testGetMoedas() {
        System.out.println("getMoedas");
        Converter instance = new Converter();
        HashMap<String, String> expResult = new HashMap<>();
        expResult.put("EUR", "EUR");
        expResult.put("GBP", "GBP");
        HashMap<String, String> result = instance.getMoedas();
        assertEquals(expResult.containsKey(result), expResult.containsValue(result));
        
    }
    
}
