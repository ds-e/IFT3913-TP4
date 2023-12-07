package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.Test;
import currencyConverter.Currency;
import currencyConverter.MainWindow;
public class TestBoiteBlanche  {
	  ArrayList<Currency> currencies = Currency.init();
	 Double convertedAmount;
	  
		
		public boolean deviseExiste(String devise) {
		    for(Currency currency : currencies) {
		        if (currency.getShortName().equals(devise)) {
		            return true;
		        }
		    }
		    return false;
		}

		@Test
		public void checkDevisesExist() {
	        String[] devisesSpe = {"USD", "CAD", "GBP", "EUR", "CHF", "AUD"};

	        for(String d : devisesSpe) {
	            try {
	                assertTrue("Devise " + d + " n'existe pas", deviseExiste(d));
	            } 
	            catch (AssertionError e) {
	                System.out.println(e.getMessage());
	            }
	        }
	    }
		
		
		@Test
		public void incorrectCurrencySource_returns0() {
			convertedAmount = MainWindow.convert("Lebanese Pound", "US Dollar", currencies, 500.0);
//	        System.out.println("convertedAmount: " + convertedAmount);
			assertEquals(0.0, convertedAmount);
		}
		@Test
		public void incorrectCurrencyTarget_returns0() {
			convertedAmount = MainWindow.convert("US Dollar", "United Arab Emirates Dirham", currencies, 500.0);
			assertEquals(0.0, convertedAmount);
		}
		@Test
		public void incorrectCurrencySourceAndTarget_returns0() {
			convertedAmount = MainWindow.convert("Canadian Dollar", "Lebanese Pound", currencies, 500.0);
			assertEquals(0.0, convertedAmount);
		}

	  
	  @Test
	 public void testMainConvert() {

	        //Couverture des i-chemins:
			try {
		        convertedAmount =MainWindow.convert("Canadian Dollar","US Dollar", currencies,198.0);  
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a US Dollar", 0.0, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        convertedAmount = MainWindow.convert("Canadian Dollar","British Pound", currencies,198.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a British Pound", 114.84, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        convertedAmount = MainWindow.convert("Canadian Dollar", "Euro",currencies , 198.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a Euro", 134.64, convertedAmount, 0.01);
		  }catch (AssertionError e) {
	          System.out.println(e.getMessage());
	      }  
			try {
		        convertedAmount =  MainWindow.convert("Canadian Dollar", "Swiss Franc", currencies , 198.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a Swiss Franc", 126.72, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 198.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a Australian Dollar", 221.76, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 0.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a Euro", 0.0, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 1000000.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a Euro", 1120000.0, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        convertedAmount =MainWindow.convert("Canadian Dollar", "Australian Dollar", currencies, 1000001.0);
		        System.out.println(convertedAmount);
		        assertEquals("mauvaise conversion Canadian Dollar a Euro", 1120001.12, convertedAmount, 0.01);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        //Couverture des arcs du graphe de flot de contrôle
				Double mc = MainWindow.convert( currencies.get(4).getName(), currencies.get(1).getName(), currencies, 10.0);
		        Double cc = Currency.convert( 10.0,currencies.get(4).getExchangeValues().get(currencies.get(1).getShortName()));
				assertTrue("mc != cc", mc == cc);	        
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        //test le couverture des instructions 
				Double result = MainWindow.convert( currencies.get(1).getName(), currencies.get(2).getName(), currencies, -1.0);
		        assertNull(result);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        assertNull(MainWindow.convert( currencies.get(1).getName(), currencies.get(2).getName(), currencies, 10000001.0));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        assertFalse(MainWindow.convert( currencies.get(1).getName(), currencies.get(2).getName(), currencies, 0.0)==0.0);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        assertNull("Amount 1000001 should return Null", Currency.convert(1000001.0, 1.0));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        assertNull("Amount -1 should return Null", Currency.convert(-1.0, 1.0));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        assertTrue("Amount 0 should return 0", Currency.convert(0.0, 1.0)==0.0);
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        //	Couverture des chemins indépendants du graphe de flot de contrôle:
		        assertNull(MainWindow.convert( currencies.get(4).getName(), currencies.get(1).getName(), currencies, -10.0));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try { 
		        assertNull(Currency.convert( -10.0,currencies.get(4).getExchangeValues().get(currencies.get(1).getShortName())));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {    
		        assertNull(MainWindow.convert( currencies.get(4).getName(), currencies.get(1).getName(), currencies, 100001.0));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {  
		        assertNull(Currency.convert( 100001.0,currencies.get(4).getExchangeValues().get(currencies.get(1).getShortName())));	        
	
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        
		      //couverture des chemins indépendants 
		        //si l'exchange value est null la valeur retourner doit etre vide et non zero
		        assertNull(currencies.get(1).getExchangeValues().get(null));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {  
		        //si curenci1 == curreci2 la valeur retourner doit etre vide
		        assertNull(currencies.get(0).getExchangeValues().get("USA"));
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
			try {
		        assertTrue(currencies.get(1).getExchangeValues().get("USA")==1.073);
	        
			}catch (AssertionError e) {
                System.out.println(e.getMessage());
            }
	        
	 }

	 
	 
	 
	 
	 		//couverture des instructions
	        @Test
		    public void testInvalidAmount() {
		        assertThrows(IllegalArgumentException.class, () -> {
		        	
		            Currency.convert(-1000000.0, 1.0);
		        });
		        
		        assertThrows(IllegalArgumentException.class, () -> {
		            Currency.convert(1000001.0, 1.0);
		        });
		      
		        assertThrows(IllegalArgumentException.class, () -> {
		        	
		        	MainWindow.convert( "US Dollar", "Euro", currencies, -1.0);
		        });
		        
		        assertThrows(IllegalArgumentException.class, () -> {
		        	MainWindow.convert( "US Dollar", "Euro", currencies, 1000001.0);
		        });
		        
		       
		      
		    }

	       
	      
	    }
	    
	   


	    
	    
	    
	    
	    
	    
	    
	    
