package ATM;
import java.util.Scanner;
public class ATMSystem extends Account{
	
    public static void main(String[] args) {
        // Create a new customer
    	System.out.println("********WELCOME TO OUR BANKING SYSTEM************");
    	int acc_pos=-1;
    	Account C[] = new Account[100];
		boolean ops = true;
		boolean found = false;
		int pass;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while(ops){
			System.out.println("+++Enter Your Choice : +++++++++++ ");
			System.out.println("0 - Create Account ");
			System.out.println("1 - Display your Account ");
			System.out.println("2 - View Balance");
			System.out.println("3 - Withdraw ");
			System.out.println("4 - Deposit ");
			System.out.println("5 - Transaction History ");
			System.out.println("6 - Exit");
		int choice = sc.nextInt();
		//Switch--------------------------------------------------
		
		switch(choice){
		case 0:
			acc_pos=acc_pos+1;
			C[acc_pos]=new Account();
			C[acc_pos].CreateAccount();
			//C[acc_pos].AccountDetails();
			break;
		case 1:      
			System.out.print("Enter your account no.: ");  
	        String account_Number = sc.next();  
	        found = false;  
	        for (int i = 0; i <= acc_pos; i++) {  
	            found = C[i].search(account_Number);  
	            if (found) {  
	            	System.out.println(C[i].AccountDetails()); 
	                break;  
	            }  
	        }  
	        if (!found) {  
	            System.out.println("Account Not Found !");  
	        } 
        break; 
			
		case 2:
			System.out.print("Enter your Account no. : ");  
			account_Number = sc.next();  
			System.out.print("Enter your Password. : ");  
		    pass = sc.nextInt();
			found = false;   
            for (int i = 0; i <= acc_pos; i++) {  
                found = C[i].search(account_Number);  
                if (found) {  
                	if(C[i].Login(pass))
                    C[i].balance();  
                	else
              		  System.out.println("Wrong Password !!");
                    break;  
                }  
            }  
            if (!found) {  
                System.out.println("Account not Found !");  
            }  
            break;  
			
		case 3:
			System.out.print("Enter your Account no. : ");  
			account_Number = sc.next();  
			System.out.print("Enter your Password. : ");  
		    pass = sc.nextInt();
			found = false;   
            for (int i = 0; i <= acc_pos; i++) {  
                found = C[i].search(account_Number);  
                if (found) {  
                	if(C[i].Login(pass))
                    C[i].withdraw(); 
                	else
              		  System.out.println("Wrong Password !!");
                    break;  
                }  
            }  
            if (!found) {  
                System.out.println("Account not Found !");  
            }  
			break;
		case 4:
			System.out.print("Enter your Account no. : ");  
			account_Number = sc.next();  
			System.out.print("Enter your Password. : ");  
		    pass = sc.nextInt();
			found = false;   
            for (int i = 0; i <= acc_pos; i++) {  
                found = C[i].search(account_Number);  
                if (found) {  
                	if(C[i].Login(pass))
                    C[i].deposit(); 
                	else
              		  System.out.println("Wrong Password !!");
                    break;  
                }  
            }  
            if (!found) {  
                System.out.println("Account not Found !");  
            }  
			break;
		case 5:
			System.out.print("Enter your Account no. : ");  
			account_Number = sc.next();  
			System.out.print("Enter your Password. : ");  
		    pass = sc.nextInt();
			found = false;   
            for (int i = 0; i <= acc_pos; i++) {  
                found = C[i].search(account_Number);  
                if (found) {  
                	if(C[i].Login(pass))
                    C[i].TransactionStatement();
                	else
              		  System.out.println("Wrong Password !!");
                    break;  
                }  
            }  
            if (!found) {  
                System.out.println("Account not Found !");  
            }  
			break;
		case 6:
			ops=false;
			System.exit(0);
			break;
		default: 
			System.out.println("Wrong Option");
			break;
			}//end switch
		}//end while	
	
        
    }
}