package ATM;

import java.util.Random;

class Card {
     private String cardNumber;
     private String expirationDate;
     private int pin;

    public Card() {
        this.cardNumber = CreateCardNumber();
        
    }
    public String CreateCardNumber(){
    	Random random = new Random();
	    String numbers = "0123456789";
	    StringBuilder sb = new StringBuilder();
	    int length=16;
	    for(int i = 0; i < length; i++) {
	    	if (i > 0 && i % 4 == 0) {
                sb.append('-');
            }
	    	int index = random.nextInt(numbers.length());
	        char randomChar = numbers.charAt(index);
	        sb.append(randomChar);
	      }
	    cardNumber = sb.toString();
	    return cardNumber;
    	
    }
    
    // Getters and setters

    public String getCardNumber() {
        return cardNumber;
    }
    public void setExpirationDate(String expirationDate){
    	this.expirationDate = expirationDate;
    }
    public String getExpirationDate() {
        return expirationDate;
    }
    public void setPin(int pin){
    	this.pin = pin;
    }
    public int getPin() {
        return pin;
    }
	public String CardDetails() {
		return "Card Number ->" + cardNumber + "\nExpiration Date ->" + expirationDate ;
	}
    
}
