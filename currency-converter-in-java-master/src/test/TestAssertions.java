package test;

import static org.junit.Assert.*;

import java.util.ArrayList;


import org.junit.Test;

import currencyConverter.Currency;

import currencyConverter.MainWindow;
public class TestAssertions  {
	  ArrayList<Currency> currencies = Currency.init();
	 @Test
	   public void testDefaultValues() {

	        currencies.add(new Currency("Canadian Dollar", "CAD")); 
	        currencies.add(new Currency("Australian Dollar", "AUD"));
	        
//	        Currency currency1 = new Currency("US Dollar", "USD");
//	        Currency currency2 =new Currency("Euro", "EUR") ;
//	        Currency currency3 =new Currency("British Pound", "GBP") ;
//	        Currency currency4 =new Currency("Swiss Franc", "CHF") ;
//	        Currency currency7 = new Currency("Chinese Yuan Renminbi", "CNY") ;
//		    Currency currency8= new Currency("Japanese Yen", "JPY") ;
//	        Currency currency5 =new Currency("Canadian Dollar", "CAD") ;
//	        Currency currency6 =new Currency("Australian Dollar ", "AUD") ;
//	     
	        assertTrue(currencies.get(0).getName()=="US Dollar");
	        assertTrue(currencies.get(1).getName()=="Euro");
	        assertTrue(currencies.get(2).getName()=="British Pound");
	        assertTrue(currencies.get(3).getName()=="Swiss Franc");
	        assertTrue(currencies.get(4).getName()=="Chinese Yuan Renminbi");
	        assertTrue(currencies.get(5).getName()=="Japanese Yen");
	        assertTrue(currencies.get(6).getName()=="Canadian Dollar");
	        assertTrue(currencies.get(7).getName()=="Australian Dollar");
	      	     
	        currencies.get(6).setExchangeValues("USD", 0.74);
	        currencies.get(6).setExchangeValues("GBP", 0.58);
	        currencies.get(6).setExchangeValues("CHF", 0.64);
	        currencies.get(6).setExchangeValues("CNY", 5.26);
	        currencies.get(6).setExchangeValues("JPY", 108.26);
	        currencies.get(6).setExchangeValues("AUD", 1.12);
	        currencies.get(6).setExchangeValues("EUR", 0.68);
	        currencies.get(7).setExchangeValues("USD", 0.66);
	        currencies.get(7).setExchangeValues("GBP", 0.52);
	        currencies.get(7).setExchangeValues("CHF", 0.57);
	        currencies.get(7).setExchangeValues("CNY", 4.65);
	        currencies.get(7).setExchangeValues("JPY", 96.43);
	        currencies.get(7).setExchangeValues("CAD", 0.89);
	        currencies.get(0).setExchangeValues("CAN", 1.36);
	        currencies.get(0).setExchangeValues("AUD", 1.53);
	        currencies.get(2).setExchangeValues("CAN", 1.71);
	        currencies.get(2).setExchangeValues("AUD", 1.92); 
	        currencies.get(1).setExchangeValues("CAN", 1.47);
	        currencies.get(1).setExchangeValues("AUD", 1.65); 
	        currencies.get(3).setExchangeValues("CAN", 1.55);
	        currencies.get(3).setExchangeValues("AUD", 1.75); 
	     
	        currencies.get(6).defaultValues();
	        currencies.get(7).defaultValues();
   
	        Double convertedAmount =MainWindow.convert("Canadian Dollar","US Dollar", currencies,198.0);   
	        assertEquals(146.52, convertedAmount, 0.01);
	        convertedAmount = MainWindow.convert("Canadian Dollar","British Pound", currencies,198.0);
	        assertEquals(114.84, convertedAmount, 0.01);
	        convertedAmount = MainWindow.convert("Canadian Dollar", "Euro",currencies , 198.0);
	        assertEquals(134.64, convertedAmount, 0.01);
	        convertedAmount =  MainWindow.convert("Canadian Dollar", "Swiss Franc", currencies , 198.0);
	        assertEquals(126.72, convertedAmount, 0.01);
	        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 198.0);
	        assertEquals(221.76, convertedAmount, 0.01);
	        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 0.0);
	        assertEquals(0.0, convertedAmount, 0.01);
	        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 1000000.0);
	        assertEquals(1120000.0, convertedAmount, 0.01);
	        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 1000001.0);
	        assertEquals(1120001.12, convertedAmount, 0.01);
	        System.out.println(MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, -1.0));
	        
	    }
	   void testAmount() {
	        assertThrows(IllegalArgumentException.class, () -> {
	        	
	            Currency.convert(-1000000.0, 1.0);
	        });
	        assertThrows(IllegalArgumentException.class, () -> {
	            Currency.convert(-1.0, 1.0);
	        });
	        assertThrows(IllegalArgumentException.class, () -> {
	            Currency.convert(1000001.0, 1.0);
	        });
	        assertThrows(IllegalArgumentException.class, () -> {
	            Currency.convert(1000111.0, 1.0);
	        });
	        System.out.println("montant doit etre entre 0 et 1000000");
	        }

	 
	        
	        
}
	    
	    
	    
	    
	    
	    
	    

