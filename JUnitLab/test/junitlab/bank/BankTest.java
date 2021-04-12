package junitlab.bank;

import junitlab.bank.impl.FirstNationalBank;
import org.junit.Assert;
import org.junit.Test;


public class BankTest {

	@Test
	public void testOpenAccount() throws AccountNotExistsException
	{
		Bank bank = new FirstNationalBank();
		String account_number = bank.openAccount();
		Assert.assertNotEquals("",  account_number);
		Assert.assertEquals(0,  bank.getBalance(account_number),0);
		
	}
	
	@Test
	public void testUniqueAccount()
	{
		Bank bank = new FirstNationalBank();
		
		String account1 = bank.openAccount();
		String account2 = bank.openAccount();
		String account3 = bank.openAccount();
		
		Assert.assertNotEquals(account1, account2);
		Assert.assertNotEquals(account1, account3);
		Assert.assertNotEquals(account2, account3);
	}
	
	@Test(expected=AccountNotExistsException.class)
	public void testInvalidAccount()
	{
		Bank bank = new FirstNationalBank();
		try {
			bank.closeAccount("2");
		} catch (AccountNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void testDeposit() throws AccountNotExistsException
	{
		Bank bank = new FirstNationalBank();
		String account1 = bank.openAccount();
		bank.deposit(account1, 1000);
		Assert.assertEquals("not expected", 1000, bank.getBalance(account1));
		}
	
}
