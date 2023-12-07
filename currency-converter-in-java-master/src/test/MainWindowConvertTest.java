package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

class MainWindowConvertTest {
	
    ArrayList<Currency> currencies = Currency.init();


	@Test
	void incorrectCurrencySource_returnsNull() {
		System.out.println("----------in incorrectCurrencySource_returns0--------------");
		Double result = MainWindow.convert("AED", "CAD", currencies, 500.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void incorrectCurrencyTarget_returnsNull() {
		System.out.println("----------in incorrectCurrencyTarget_returns0--------------");
		Double result = MainWindow.convert("USD", "JPY", currencies, 500.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void incorrectCurrencySourceAndTarget_returnsNull() {
		System.out.println("----------in incorrectCurrencySourceAndTarget_returns0--------------");
		Double result = MainWindow.convert("CNY", "KRW", currencies, 500.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test  
	void correctCurrencySourceAndTarget1_returnsNotNull() {
		System.out.println("-------in correctCurrencySourceAndTarget1_returnsNot0-------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, 500.0);
        System.out.println("Result: " + result);
        assertNotNull(result);
		
	}
	@Test 
	void correctCurrencySourceAndTarget2_returnsNotNull() {
		System.out.println("------in correctCurrencySourceAndTarget2_returnsNot0-------");
		Double result = MainWindow.convert("CAD", "USD", currencies, 500.0);
        System.out.println("Result: " + result);
        assertNotNull(result);
	}
	@Test
	void amountALotLessThan0_returnsNull() {
		System.out.println("----------in amountALotLessThan0_returnsNull--------------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, -1500000.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void amountLessThan0_returnsNull() {
		System.out.println("----------in amountLessThan0_returns0--------------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, -1.0);
        System.out.println("Result: " + result);
		assertNull(result);
	}
	@Test
	void amountEquals0_returns0() {
		System.out.println("----------in amountEquals0_returns0--------------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, 0.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void amountInInterval_returnsNotNull() {
		System.out.println("----------in amountInInterval_returnsNot0--------------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, 2500.0);
        System.out.println("Result: " + result);
		assertNotNull(result);
	}
	@Test
	void amountIsMaxValue_returnsNotNull() {
		System.out.println("----------in amountIsMaxValue_returnsNot0--------------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, 1000000.0);
        System.out.println("Result: " + result);
		assertNotNull(result);
	}
	@Test
	void amountMoreThanMax_returnsNull() {
		System.out.println("----------in amountMoreThanMax_returns0--------------");
		Double result = MainWindow.convert("EUR", "GBP", currencies, 1000001.0);
        System.out.println("Result: " + result);
        assertNull(result);
	}
	@Test
	void amountALotMoreThanMax_returnsNull() {
		System.out.println("----------in amountALotMoreThanMax_returns0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 1500000.0);
        System.out.println("Result: " + result);
        assertNull(result);
	}
}

