package myJavaPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Electricitybillpayment {

    private static Map<String, String> userdetails = new HashMap<>();

    static {
    	userdetails.put("balaji", "1509");
    	userdetails.put("praveen", "1234");
    	userdetails.put("praisy", "johnwillson");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("===============================================================================================================================================================");
        System.out.println("      /     |     TANGEDCO ⚡");
        System.out.println("  TANGEDCO  |     Tamilnadu Generation And Distribution Corperation"); 
        System.out.println("    /       |     Consumer Services");   
        System.out.println("================================================================================================================================================================");
        System.out.println();
        System.out.println("Welcome to TANGEDCO Electricity Bill Payment System!");
        System.out.println();
        System.out.print("Are you a new user? (yes/no): ");
        String isNewUser = scanner.nextLine().toLowerCase();

        if (isNewUser.equals("yes")) {
        	System.out.println();
            System.out.print("Enter a new username: ");
            String newUsername = scanner.nextLine();
            System.out.print("Enter a password for " + newUsername + ": ");
            String newPassword = scanner.nextLine();
            System.out.print("Enter your Consumer Number: ");
            String consumernumber = scanner.nextLine();

            userdetails.put(newUsername, newPassword);
            System.out.println();
            System.out.println("User registered successfully!");
            calculateBillAndProcessPayment(scanner, newUsername);

        } else if (isNewUser.equals("no")) {
        	boolean validLogin = false;
        	while(!validLogin){
        	System.out.println();
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (isValidUser(username, password)) {
            	System.out.println();
                System.out.println("Welcome, " + username + "!");
                calculateBillAndProcessPayment(scanner, username);
                validLogin=true;
            } else {
            	System.out.println();
                System.out.println("Invalid username or password. Please enter valid username and password");
            }
        	}
        }else {
        	System.out.println();
            System.out.println("Invalid input. Please refresh the page.");
            
        }
    }

    private static boolean isValidUser(String username, String password) {
        return userdetails.containsKey(username) && userdetails.get(username).equals(password);
    }

    private static void calculateBillAndProcessPayment(Scanner scanner, String username) {
    	System.out.println();
        int maxUnits = 1500;
    	Random random= new Random();
        double totalunit = random.nextInt(maxUnits);
        double totalamount;
        if (totalunit <= 100) {
            totalamount = totalunit *0;
            System.out.println("Total Amount You Want to Pay is: " + totalamount + " Rs");
            return;
        }
        if(totalunit <= 400) {
            totalamount = totalunit * 4.50;
            System.out.println("Total Amount You Want to Pay is: " +"₹ "+ totalamount);
        } else if(totalunit <= 500) {
            totalamount = totalunit * 6;
            System.out.println("Total Amount You Want to Pay is: " +"₹ "+ totalamount + " Rs");
        } else if(totalunit > 500) {
            totalamount = totalunit * 8;
            System.out.println("Total Amount You Want to Pay is: " + "₹ "+totalamount + " Rs");
        } else{
        	System.out.println();
            System.out.println("Invalid input");
            return;
        }

        int choice;

        while (true) {
        	System.out.println();
            System.out.println("Select a Payment option:");
            System.out.println("1. Credit/Debit Card payment");
            System.out.println("2. UPI Payment");
            System.out.println("3. Cancel Payment");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println();
                    System.out.print("Enter card number: ");
                    String cardNumber = scanner.nextLine();
                    boolean paymentSuccessful1 = processPayment1(cardNumber);
                    if (paymentSuccessful1) {
                    	System.out.println();
                        System.out.println("Processing Payment...");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println();
                        System.out.println("Payment successful! Thank you " + username +". Have a great day!");
                        System.out.println();
                        bill(totalunit,totalamount,username);
                        System.out.println();
                        thankyou();
                        return; 
                    } else {
                        System.out.println("Payment failed. Please check your card details.");
                    }
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.println();
                    System.out.print("Enter UPI ID: ");
                    String UPIID = scanner.nextLine();
                    boolean paymentSuccessful2 = processPayment2(UPIID);
                    if (paymentSuccessful2) {
                    	System.out.println();
                        System.out.println("Processing Payment...");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Payment successful! Thank you "+ username + ". Have a great day!");
                        System.out.println();
                        bill(totalunit,totalamount,username);
                        System.out.println();
                        thankyou();
                        return; 
                    } else {
                    	System.out.println();
                        System.out.println("Payment failed. Please check your Account details.");
                    }
                    break;
                case 3:
                	System.out.println();
                    System.out.println("Payment cancelled for " + username + ".Come back again  and complete your payment .");
                    System.out.println();
                    thankyou();
                    return;
                default:
                	System.out.println();
                    System.out.println("Invalid choice. Please try again.");
          }
        }
    }
    private static boolean processPayment1(String cardNumber) {
        return cardNumber.length() == 16;
    }
    private static boolean processPayment2(String UPIID) {
        return UPIID.length() == 8;
    }
    private static void bill(double totalunit, double totalamount,String username) {
    	System.out.println("=================Payment Details==============");
    	System.out.println();
    	System.out.println("Consumer Name:"+username);
    	System.out.println("Total Units:"+totalunit);
        System.out.println("Unit Price:"+"₹ "+totalamount/totalunit);
        System.out.println("Total Amount:"+"₹ "+totalamount);
        System.out.println("                                                                                                          (TANGEDCO⚡)   ");  
    	System.out.println();
    	return;
    }
    private static void thankyou() {
        System.out.println("*************************************************************************************************************************************************************");
        System.out.println("                                   Thank you for using our service. Have a nice day!!!");
        System.out.println("*************************************************************************************************************************************************************");
    }
}
    
