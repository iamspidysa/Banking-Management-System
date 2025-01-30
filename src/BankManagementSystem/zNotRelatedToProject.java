package BankManagementSystem;
/* -----------  THIS FILE IS NOT RELATED TO PROJECT , YOU CAN DELETE THIS FILE ----------------*/
public class zNotRelatedToProject {
    public static void main(String[] args) {
        // Testing to generate Random number for credit card,
        // Got to know Math.random is not much useful for complex arithmetics,
        // Instead use Random Class.
            String ran = 98765432+""+(long)(Math.random()*100000000);
            long ran2 = Long.parseLong(ran);
            System.out.println(ran2);
    }
}
