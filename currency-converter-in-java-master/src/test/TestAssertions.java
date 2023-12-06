package test;

import static org.junit.Assert.*;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;
import org.junit.rules.ExpectedException;

public class TestAssertions  {
	  ArrayList<Currency> currencies = Currency.init();
	 @Test
	   public void testDefaultValues() {

	        currencies.add(new Currency("Canadian Dollar", "CAD")); 
	        currencies.add(new Currency("Australian Dollar", "AUD"));
	        
	        Currency currency1 = new Currency("US Dollar", "USD");
	        Currency currency2 =new Currency("Euro", "EUR") ;
	        Currency currency3 =new Currency("British Pound", "GBP") ;
	        Currency currency4 =new Currency("Swiss Franc", "CHF") ;
	        Currency currency7 = new Currency("Chinese Yuan Renminbi", "CNY") ;
		    Currency currency8= new Currency("Japanese Yen", "JPY") ;
	        Currency currency5 =new Currency("Canadian Dollar", "CAD") ;
	        Currency currency6 =new Currency("Australian Dollar ", "AUD") ;
	     
	        assertTrue(currencies.get(0).getName()=="US Dollar");
	        assertTrue(currencies.get(1).getName()=="Euro");
	        assertTrue(currencies.get(2).getName()=="British Pound");
	        assertTrue(currencies.get(3).getName()=="Swiss Franc");
	        assertTrue(currencies.get(4).getName()=="Chinese Yuan Renminbi");
	        assertTrue(currencies.get(5).getName()=="Japanese Yen");
	        assertTrue(currencies.get(6).getName()=="Canadian Dollar");
	        assertTrue(currencies.get(7).getName()=="Australian Dollar");
	      
	        
	    }

	    @Test
	    public void testNExiste() {
	        Currency currency1 = new Currency("Livre Libanais", "LL");	  
	        assertTrue(currency1.getExchangeValues().isEmpty());
	    }
	    
	    
	    @Test
	    public void testDefaultValuesForCanadianDollar() {
	        Currency canadianDollar = new Currency("Canadian Dollar", "CAD");
	        canadianDollar.defaultValues();

	        canadianDollar.setExchangeValues("USD", 0.74);
	        canadianDollar.setExchangeValues("GBP", 0.58);
	        canadianDollar.setExchangeValues("CHF", 0.64);
	        canadianDollar.setExchangeValues("CNY", 5.26);
	        canadianDollar.setExchangeValues("JPY", 108.26);
	        canadianDollar.setExchangeValues("AUD", 1.12);
	        canadianDollar.setExchangeValues("EUR", 0.68);
	       
	    }
	    @Test
	    public void testDefaultValuesForAustralianDollar() {
	        Currency AustDollar = new Currency("Australian Dollar", "AUD");
	        AustDollar.defaultValues();

	        AustDollar.setExchangeValues("USD", 0.66);
	        AustDollar.setExchangeValues("GBP", 0.52);
	        AustDollar.setExchangeValues("CHF", 0.57);
	        AustDollar.setExchangeValues("CNY", 4.65);
	        AustDollar.setExchangeValues("JPY", 96.43);
	        AustDollar.setExchangeValues("CAD", 0.89);

	       
	    }
	    @Test
	    public void testDefaultValuesForUSDDollar() {
	        Currency UsdDollar = new Currency("US Dollar", "USD");
	        UsdDollar.defaultValues();

	        
	        UsdDollar.setExchangeValues("CAN", 1.36);
	        UsdDollar.setExchangeValues("AUD", 1.53);
	        
	       
	    }
	    @Test
	    public void testDefaultValuesForBRitDollar() {
	        Currency Brit = new Currency("British Pound", "GBP");
	        Brit.defaultValues();

	        Brit.setExchangeValues("CAN", 1.71);
	        Brit.setExchangeValues("AUD", 1.92);
	        
	       
	    }
	    
	    @Test
	    public void testDefaultValuesForEURDollar() {
	        Currency uro = new Currency("Euro", "EUR");
	        uro.defaultValues();

	        uro.setExchangeValues("CAN", 1.47);
	        uro.setExchangeValues("AUD", 1.65);
	        
	       
	    
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
	    
	    
	    
	    
	    
	    
	    

