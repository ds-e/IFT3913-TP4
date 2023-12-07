package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

class TestBoiteNoire {
	
    ArrayList<Currency> currencies = Currency.init();
    Double result;
    
	@Test
	void incorrectCurrencySource_returnsNull() {
		System.out.println("----------in incorrectCurrencySource_returnsNull--------------");
		result = MainWindow.convert("AED", "CAD", currencies, 500.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void incorrectCurrencyTarget_returnsNull() {
		System.out.println("----------in incorrectCurrencyTarget_returnsNull--------------");
		result = MainWindow.convert("USD", "JPY", currencies, 500.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void incorrectCurrencySourceAndTarget_returnsNull() {
		System.out.println("----------in incorrectCurrencySourceAndTarget_returnsNull--------------");
		result = MainWindow.convert("CNY", "KRW", currencies, 500.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test  
	void correctCurrencySourceAndTarget1_returnsNotNull() {
		System.out.println("-------in correctCurrencySourceAndTarget1_returnsNotNull-------");
		result = MainWindow.convert("EUR", "GBP", currencies, 500.0);
        System.out.println("Result: " + result);
        assertNotNull(result);
		
	}
	@Test 
	void correctCurrencySourceAndTarget2_returnsNotNull() {
		System.out.println("------in correctCurrencySourceAndTarget2_returnsNotNull-------");
		result = MainWindow.convert("CAD", "USD", currencies, 500.0);
        System.out.println("Result: " + result);
        assertNotNull(result);
	}
	@Test
	void amountALotLessThan0_returnsNull() {
		System.out.println("----------in amountALotLessThan0_returnsNull--------------");
		result = MainWindow.convert("EUR", "GBP", currencies, -1500000.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void amountLessThan0_returnsNull() {
		System.out.println("----------in amountLessThan0_returnsNull--------------");
		result = MainWindow.convert("EUR", "GBP", currencies, -1.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void amountEquals0_returns0() {
		System.out.println("----------in amountEquals0_returns0--------------");
		result = MainWindow.convert("EUR", "GBP", currencies, 0.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void amountInInterval_returnsNotNull() {
		System.out.println("----------in amountInInterval_returnsNotNull--------------");
		result = MainWindow.convert("EUR", "GBP", currencies, 2500.0);
        System.out.println("Result: " + result);
		assertNotNull(result);
	}
	@Test
	void amountIsMaxValue_returnsNotNull() {
		System.out.println("----------in amountIsMaxValue_returnsNotNull--------------");
		result = MainWindow.convert("EUR", "GBP", currencies, 1000000.0);
        System.out.println("Result: " + result);
		assertNotNull(result);
	}
	@Test
	void amountMoreThanMax_returnsNull() {
		System.out.println("----------in amountMoreThanMax_returnsNull--------------");
		result = MainWindow.convert("EUR", "GBP", currencies, 1000001.0);
        System.out.println("Result: " + result);
        assertNull(result);
	}
	@Test
	void amountALotMoreThanMax_returnsNull() {
		System.out.println("----------in amountALotMoreThanMax_returnsNull--------------");
		result = MainWindow.convert("Euro", "British Pound", currencies, 1500000.0);
        System.out.println("Result: " + result);
        assertNull(result);
	}
	
	
	
}