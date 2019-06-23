package com.designPattern.atm;

public class AtmMachine implements AtmMachineState{

	 private AtmMachineState atmMachineState;

	  public AtmMachine()
	  {
	    atmMachineState = new NoDebitCardState();
	  }
	  
	  /* It will return the current state of ATM machine*/
	  public AtmMachineState getAtmMachineState()
	  {
	    return atmMachineState;
	  }
	  
	  /* It will set the ATM machine state to current state*/
	  public void setAtmMachineState( AtmMachineState atmMachineState )
	  {
	    this.atmMachineState = atmMachineState;
	  }

	  @Override
	  public void insertDebitCard()
	  {
		// It will call the insertDebitCard method of current ATM state.
	    atmMachineState.insertDebitCard();

	    /*
	     As Debit Card has been inserted so internal state of ATM Machine has been 
	     changed to 'hasDebitCardState'
	     */

	    if( atmMachineState instanceof NoDebitCardState )
	    {

	      AtmMachineState hasDebitCardState = new HasDebitCardState();
	      setAtmMachineState(hasDebitCardState);
	      System.out.println("ATM Machine internal state has been moved to : "
	                      + atmMachineState.getClass().getName());
	    }

	  }

	  @Override
	  public void ejectDebitCard()
	  {
		//It will call the ejectDebitCard method of current ATM machine state.  
	    atmMachineState.ejectDebitCard();

	    /*
	     As Debit Card has been ejected so internal state of ATM Machine
	     has been changed to 'noDebitCardState'
	     */
	    if( atmMachineState instanceof HasDebitCardState )
	    {

	      AtmMachineState noDebitCardState = new NoDebitCardState();
	      setAtmMachineState(noDebitCardState);
	      System.out.println("ATM Machine internal state has been moved to : "
	                      + atmMachineState.getClass().getName());
	    }

	  }

	  @Override
	  public void enterPinAndWithdrawMoney( int pin, int amount)
	  {
	    atmMachineState.enterPinAndWithdrawMoney(pin, amount);

	  }

}
