package com.designPattern.atm;

public interface AtmMachineState {
	
	public void insertDebitCard();
	  
	public void ejectDebitCard();
	  
	public void enterPinAndWithdrawMoney(int pin, int amount);
}
