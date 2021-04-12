package junitlab.bank;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import junitlab.bank.impl.FirstNationalBank;

public class BankTestFixture {
	Bank bank;
	String account1;
	String account2;
	
	@Before
	public void setUp() {
		bank = new FirstNationalBank();
		account1 = bank.openAccount();
		account2 = bank.openAccount();
		try {
			bank.deposit(account1, 1500);
		} catch (AccountNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bank.deposit(account2, 12000);
		} catch (AccountNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testTransfer()
	{
		try {
			bank.transfer(account2, account1, 3456);
		} catch (AccountNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotEnoughFundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("not expected", 4956, bank.getBalance(account1));
		} catch (AccountNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Assert.assertEquals("not expected", 8544, bank.getBalance(account2));
		} catch (AccountNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test(expected=NotEnoughFundsException.class)
	public void testTransferWithoutEnoughFunds() throws AccountNotExistsException, NotEnoughFundsException  
	{
		bank.transfer(account1, account2, 3456);	
	}
}
