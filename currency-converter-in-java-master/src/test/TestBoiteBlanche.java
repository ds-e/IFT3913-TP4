package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import currencyConverter.Currency;
import static org.junit.Assert.assertEquals;


import currencyConverter.MainWindow;
public class TestBoiteBlanche  {
	  ArrayList<Currency> currencies = Currency.init();
	 
	  
	  public boolean PaysExiste(String pays){
		   boolean existe=false;
		 	for (int i=0;i>currencies.size();i++) {
		 		if (currencies.get(i).getName()==pays) {
		 			existe = true;	
		 			return existe;
		 			
		 		}
	   }
		 	return existe;
	  }  	
	  @Test
	 public void testMainConvert() {
	 
		  
	       

		 	//le dollar canadian existe, dollare australian existe
		 	assertTrue(PaysExiste("Canadian Dollar"));
		 	assertTrue(PaysExiste("Australian Dollar"));
		 	//livre libanais n'existe pas
	        assertFalse(PaysExiste("Livre Libanais"));

	        //Couverture des i-chemins:
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
	        
	        //Couverture des arcs du graphe de flot de contrôle
	        assertTrue(MainWindow.convert( currencies.get(4).getName(), currencies.get(1).getName(), currencies, 10.0)==Currency.convert( 10.0,currencies.get(4).getExchangeValues().get(currencies.get(1).getShortName())));	        

	        //test le couverture des instructions 
	        assertNull(MainWindow.convert( currencies.get(1).getName(), currencies.get(2).getName(), currencies, -1.0));
	        assertNull(MainWindow.convert( currencies.get(1).getName(), currencies.get(2).getName(), currencies, 10000001.0));
	        assertFalse(MainWindow.convert( currencies.get(1).getName(), currencies.get(2).getName(), currencies, 0.0)==0.0);
	        assertNull(Currency.convert(1000001.0, 1.0));
	        assertNull(Currency.convert(-1.0, 1.0));
	        assertTrue(Currency.convert(0.0, 1.0)==0.0);
	        
	        //	Couverture des chemins indépendants du graphe de flot de contrôle:
	        assertNull(MainWindow.convert( currencies.get(4).getName(), currencies.get(1).getName(), currencies, -10.0));
	        assertNull(Currency.convert( -10.0,currencies.get(4).getExchangeValues().get(currencies.get(1).getShortName())));
	        assertNull(MainWindow.convert( currencies.get(4).getName(), currencies.get(1).getName(), currencies, 100001.0));
	        assertNull(Currency.convert( 100001.0,currencies.get(4).getExchangeValues().get(currencies.get(1).getShortName())));	        

	    
	        
	      //couverture des chemins indépendants 
	        //si l'exchange value est null la valeur retourner doit etre vide et non zero
	        assertNull(currencies.get(1).getExchangeValues().get(null));
	        //si curenci1 == curreci2 la valeur retourner doit etre vide
	        assertNull(currencies.get(0).getExchangeValues().get("USA"));
	        assertTrue(currencies.get(1).getExchangeValues().get("USA")==1.073);
	        
	        
	        
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
	    
	   


	    
	    
	    
	    
	    
	    
	    
	    

