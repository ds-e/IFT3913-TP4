package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import currencyConverter.Currency;
import currencyConverter.MainWindow;

class MainWindowConvertTest {
	MainWindow mwConvert;
	ArrayList<Currency> currencies;
	
	@BeforeEach 
    void init() {
        currencies = new ArrayList<Currency>();
		
        currencies.add(new Currency("US Dollar", "USD"));
        currencies.add(new Currency("Canadian Dollar", "CAD"));
        currencies.add(new Currency("British Pound", "GBP"));
        currencies.add(new Currency("Euro", "EUR"));
        currencies.add(new Currency("Swiss Franc", "CHF"));
        currencies.add(new Currency("Australian Dollar", "AUD"));
    	for (Integer i =0; i < currencies.size(); i++) {
			currencies.get(i).defaultValues();
		}	
//        System.out.println("Currency List: " + currencies);
    }

	@Test
	void incorrectCurrencySource_returns0() {
		System.out.println("----------in incorrectCurrencySource_returns0--------------");
		Double result = MainWindow.convert("United Arab Emirates Dirham", "Canadian Dollar", currencies, 500.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void incorrectCurrencyTarget_returns0() {
		System.out.println("----------in incorrectCurrencyTarget_returns0--------------");
		Double result = MainWindow.convert("US Dollar", "Japanese Yen", currencies, 500.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void incorrectCurrencySourceAndTarget_returns0() {
		System.out.println("----------in incorrectCurrencySourceAndTarget_returns0--------------");
		Double result = MainWindow.convert("Chinese Yuan", "South Korean Won", currencies, 500.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test  // code retourne bon resultat avec des devises acceptables
	void correctCurrencySourceAndTarget1_returnsNot0() {
		System.out.println("-------in correctCurrencySourceAndTarget1_returnsNot0-------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 500.0);
        System.out.println("Result: " + result);
        assertNotEquals(0.0, result);
		// assertEquals(355.0, result);
	}
	@Test  // code echoue avec des devises acceptables 
	void correctCurrencySourceAndTarget2_returnsNot0() {
		System.out.println("------in correctCurrencySourceAndTarget2_returnsNot0-------");
		Double result = MainWindow.convert("Canadian Dollar", "US Dollard", currencies, 500.0);
        System.out.println("Result: " + result);
        assertNotEquals(0.0, result);
		// assertEquals(370.0, result);
	}
	@Test
	void amountALotLessThan0_returns0() {
		System.out.println("----------in amountLessThan0_returns0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, -1500000.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void amountLessThan0_returns0() {
		System.out.println("----------in amountLessThan0_returns0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, -1.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void amountEquals0_returns0() {
		System.out.println("----------in amountEquals0_returns0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 0.0);
        System.out.println("Result: " + result);
		assertEquals(0.0, result);
	}
	@Test
	void amountInInterval_returnsNot0() {
		System.out.println("----------in amountInInterval_returnsNot0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 2500.0);
        System.out.println("Result: " + result);
        assertNotEquals(0.0, result);
	}
	@Test
	void amountIsMaxValue_returnsNot0() {
		System.out.println("----------in amountIsMaxValue_returnsNot0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 1000000.0);
        System.out.println("Result: " + result);
        assertNotEquals(0.0, result);
	}
	@Test
	void amountMoreThanMax_returns0() {
		System.out.println("----------in amountMoreThanMax_returns0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 1000001.0);
        System.out.println("Result: " + result);
        assertEquals(0.0, result);
	}
	@Test
	void amountALotMoreThanMax_returns0() {
		System.out.println("----------in amountALotMoreThanMax_returns0--------------");
		Double result = MainWindow.convert("Euro", "British Pound", currencies, 1500000.0);
        System.out.println("Result: " + result);
        assertEquals(0.0, result);
	}
}

