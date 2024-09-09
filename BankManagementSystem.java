import java.util.*;

public class BankManagementSystem {

    static boolean ans;

    static String tocheck;

    static ArrayList<Info> table;
    
    static Scanner sc = new Scanner(System.in);

    public static class Info {
        String name;
        String mName;
        String acntType;
        String gender;
        String phone;
        String adhaar;
        float amt;
        String acntNumber;

        public Info(String name, String mName, String acntType, String gender, String phone, String  adhaar,
        String acntNumber) {
            this.name = name;
            this.mName = mName;
            this.acntType = acntType;
            this.gender = gender;
            this.phone = phone;
            this.adhaar = adhaar;
            this.amt = (float) 1000;
            this.acntNumber = acntNumber;
        }
    }

    public static String capitalize(String r){
        if(r.equals("")){
            return r;
        }
        String n = "";
        String l[] = r.split(" ");
        for(int i = 0; i<l.length; i++){
            n = n + l[i].substring(0, 1).toUpperCase() + l[i].substring(1);
            if(i != l.length-1){
                n += " ";
            }
        }
        return n;
    }

    public static boolean validateName(String x) {
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if (!Character.isAlphabetic(ch) && ch != ' ') {
                System.out.println("Invalid Input");
                return false;
            }
        }
        return true;
    }

    public static boolean validateGender(String x) {
        if (x.equalsIgnoreCase("male") ||
            x.equalsIgnoreCase("female") ||
            x.equalsIgnoreCase("other")) {
            return true;
        }
        return false;
    }

    public static boolean validateAcntType(String x) {
        if (x.equalsIgnoreCase("a") ||
                x.equalsIgnoreCase("b") ||
                x.equalsIgnoreCase("c") ||
                x.equalsIgnoreCase("d")) {
            return true;
        }
        return false;
    }
  
    public static boolean validateNumber(String x) {
        if (x.length() != 10) {
            return false;
        }
        for(int i = 0; i<x.length(); i++){
            char ch = x.charAt(i);
            if(!Character.isDigit(ch)){
                return false;
            }
        }
        return true;
    }

    public static boolean validateAcntNumber(String x) {
        if (x.length() != 14) {
            return false;
        }
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateAdhaar(String x) {
        if (x.length() != 12) {
            return false;
        }
        for (int i = 0; i < x.length(); i++) {
            char ch = x.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static void createNew() {
        System.out.println("=================================================================");
        System.out.println("                   CREATE NEW ACCOUNT");
        System.out.println("PRESS 'ENTER' TO SKIP DATA ENTRY");
        System.out.println("=================================================================\n");

        // name
        ans = false;
        while (ans == false) {
            System.out.print("Enter student's name : ");
            tocheck = sc.nextLine();
            if (tocheck.equals("")) {
                System.out.println("Entering customer name is compulsory");
                continue;
            }
            ans = validateName(tocheck);
        }
        String addname = capitalize(tocheck);

        // // mothers name
        ans = false;
        while (ans == false) {
            System.out.print("Enter mother's name : ");
            tocheck = sc.nextLine();
            if (tocheck.equals("")) {
                tocheck = "";
                ans = true;
                continue;
            }
            ans = validateName(tocheck);
        }
        String addmName = capitalize(tocheck);

        // acnt type
        ans = false;
        while (ans == false) {
            System.out.println("A. Savings Account");
            System.out.println("B. Current Account");
            System.out.println("C. Fixed Deposit Account");
            System.out.println("D. Money Account");
            System.out.println();
            System.out.print("Enter type of account you want to create : ");
            tocheck = sc.nextLine();
            if (tocheck.equals("")) {
                System.out.println("\nEntering customer name is compulsory\n");
                continue;
            }
            ans = validateAcntType(tocheck);
            if (ans == false) {
                System.out.println("\nInvalid Input\n");
            }
        }
        
        String addacntType = "";
        if (tocheck.equalsIgnoreCase("a")) {
            addacntType = "Savings Account";
        } else if (tocheck.equalsIgnoreCase("b")) {
            addacntType = "Current Account";
        } else if (tocheck.equalsIgnoreCase("c")) {
            addacntType = "Fixed Deposit Account";
        } else if (tocheck.equalsIgnoreCase("d")) {
            addacntType = "Money Account";
        }

        // gender
        // ans = false;
        while (ans == false) {
            System.out.print("Enter your gender : ");
            tocheck = sc.nextLine();
            if (tocheck.equals("")) {
                System.out.println("Entering gender is compulsory");
                continue;
            }
            ans = validateGender(tocheck);
            if (ans == false) {
                System.out.println("Invalid Input");
                continue;  
            }
            break;
        }
        String addgender = capitalize(tocheck);
        
        // phone no
        ans = false;
        while (ans == false) {
            if (tocheck.equals("")) {
                System.out.println("Entering phone no. is compulsory");
                continue;
            }
            ans = validateNumber(tocheck);
            if (ans == false) {
                System.out.println("Invalid Input");
            }
        }
        String inputphn = tocheck;

        // adhaar
        // ans = false;
        // System.out.print("Enter your Adhaar no. : ");
        // long inputadhar = sc.nextLong();
        while (ans == false) {
            if (tocheck.equals("")) {
                System.out.println("Entering Adhaar no. is compulsory");
                continue;
            }
            ans = validateAdhaar(tocheck);
            if (ans == false) {
                System.out.println("Invalid Input");
            }
        }
        String inputadhar = tocheck;

        String addacntNumber;
        if (table.isEmpty()) {
            addacntNumber = "1074901152172";
        } else {
            Info last = table.get(table.size() - 1);
            String old = last.acntNumber;
            String strt = old.substring(0, 11);
            String end = old.substring(11, 14);
            int endNew = Integer.parseInt(end) + 1;
            addacntNumber = strt + Integer.toString(endNew);
        }

        // long addacntNumber;
        // if (table.isEmpty()) {
        //     addacntNumber = 1074901152172L;
        // } else {
        //     Info last = table.get(table.size() - 1);
        //     long old = last.acntNumber;
        //     addacntNumber = old+1;
        // }

        table.add(new Info(addname, addmName, addacntType, addgender, inputphn, inputadhar, addacntNumber));
        System.out.println("=================================================================");
        System.out.println("                   ACCOUNT CREATED SUCCESSFULLY!");
        System.out.println("               YOUR ACCOUNT NO. IS -> " + addacntNumber);
        System.out.println("=================================================================");
    }

    public static void display() {
        while (true) {
            System.out.print("Enter account no. : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Invalid Input");
                continue;
            }
            ans = validateAcntNumber(tocheck);
            if (ans == true) {
                break;   
            } else{
                System.out.println("Invalid Input");
            }
        }
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber.equals(tocheck)) {
                found = true;
                System.out.println("CUSTOMER NAME  :  " + curr.name);
                System.out.println("ACCOUNT NO.    :  " + curr.acntNumber);
                System.out.println("MOTHER'S NAME  :  " + curr.mName);
                System.out.println("ACCOUNT TYPE   :  " + curr.acntType);
                System.out.println("GENDER         :  " + curr.gender);
                System.out.println("PHONE NO.      :  " + curr.phone);
                System.out.println("ADHAAR NO.     :  " + curr.adhaar);
                System.out.println("BALANCE        :  " + curr.amt);
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + tocheck);
        }
    }

    public static void chkBalance() {
        
        while (true) {
            System.out.print("Enter account no. : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Invalid Input");
                continue;
            }
            ans = validateAcntNumber(tocheck);
            if (ans == true) {
                break;   
            } else{
                System.out.println("Invalid Input");
            }
        }
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber.equals(tocheck)) {
                found = true;
                System.out.println("BALANCE        :  " + curr.amt);
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + tocheck);
        }
    }

    public static void deposit() {
        while (true) {
            System.out.print("Enter account no. : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Invalid Input");
                continue;
            }
            ans = validateAcntNumber(tocheck);
            if (ans == true) {
                break;   
            } else{
                System.out.println("Invalid Input");
            }
        }
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber.equals(tocheck)) {
                found = true;
                System.out.print("Enter the amount : ");
                Float money = sc.nextFloat();
                System.out.println("PREVIOUS BALANCE        :  " + curr.amt);
                curr.amt = curr.amt + money;
                System.out.println("CURRENT BALANCE        :  " + curr.amt);
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + tocheck);
        }
    }

    public static void withdraw() {
        while (true) {
            System.out.print("Enter account no. : ");
            tocheck = sc.nextLine();
            if(tocheck.equals("")){
                System.out.println("Invalid Input");
                continue;
            }
            ans = validateAcntNumber(tocheck);
            if (ans == true) {
                break;   
            } else{
                System.out.println("Invalid Input");
            }
        }
        boolean found = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr = table.get(i);
            if (curr.acntNumber.equals(tocheck)) {
                found = true;
                System.out.print("Enter the amount : ");
                Float money = sc.nextFloat();
                if (money > curr.amt) {
                    System.out.println("Not enough balance");
                } else {
                    System.out.println("PREVIOUS BALANCE        :  " + curr.amt);
                    curr.amt = curr.amt - money;
                    System.out.println("CURRENT BALANCE        :  " + curr.amt);
                }
                break;
            }
        }
        if (found == false) {
            System.out.println("No bank account exist for account no. : " + tocheck);
        }
    }

    public static void transfer() {
        String fromAcnt;
        String toAcnt;
        while (true) {
            System.out.print("Enter account no. to transfer from : ");
            fromAcnt = sc.nextLine();
            if(fromAcnt.equals("")){
                System.out.println("Invalid Input");
                continue;
            }
            ans = validateAcntNumber(fromAcnt);
            if (ans == true) {
                break;   
            } else{
                System.out.println("Invalid Input");
            }
        }
        while (true) {
            System.out.print("Enter account no. to transfer from : ");
            toAcnt = sc.nextLine();
            if(toAcnt.equals("")){
                System.out.println("Invalid Input");
                continue;
            }
            ans = validateAcntNumber(toAcnt);
            if (ans == true) {
                break;   
            } else{
                System.out.println("Invalid Input");
            }
        }
        boolean found1 = false;
        boolean found2 = false;
        for (int i = 0; i < table.size(); i++) {
            Info curr1 = table.get(i);
            if (curr1.acntNumber.equals(fromAcnt)) {
                // String fromAcnt = curr1.acntNumber;
                found1 = true;
                for (int j = 0; j < table.size(); j++) {
                    Info curr2 = table.get(j);
                    if (curr2.acntNumber.equals(toAcnt)) {
                        // String toAcnt = curr2.acntNumber;
                        found2 = true;
                        System.out.println("BALANCE        :  " + curr1.amt);
                        System.out.print("Enter the amount : ");
                        Float money = sc.nextFloat();
                        if (money > curr1.amt) {
                            System.out.println("Not enough balance");
                        } else {
                            System.out.println("MONEY Transferred");
                            System.out.println("PREVIOUS BALANCE        :  " + curr1.amt);
                            curr1.amt = curr1.amt - money;
                            curr2.amt = curr2.amt + money;
                            System.out.println("CURRENT BALANCE        :  " + curr1.amt);
                        }
                    }
                }
            }
        }
        if (found1 == false) {
            System.out.println("No bank account exist for account no. : " + fromAcnt);
        }if(found2 == false){
            System.out.println("No bank account exist for account no. : " + toAcnt);
        }
    }

    public static void menu() {
        System.out.println();
        System.out.println("=================================================================");
        System.out.println("                              MENU");
        System.out.println("=================================================================");
        System.out.println("Enter 'A' to 'Create New Account'");
        System.out.println("Enter 'B' to ''Display Details'");
        System.out.println("Enter 'C' to 'Check Balance Left'");
        System.out.println("Enter 'D' to 'Deposit Money'");
        System.out.println("Enter 'E' to 'Withdraw Money'");
        System.out.println("Enter 'F' to 'Transafer Money'");
        System.out.println("Enter 'G' to 'Update Details'");
        System.out.println("Enter 'H' to 'Close The Programme'");
        System.out.println("=================================================================");
    }

    public static void main(String[] args) {

        table = new ArrayList<>();
        table.add(new Info("Ansh", "Rama", "Savings Account", "Male", "7099890380", "123456789012", "10748901152172"));
        table.add(new Info("Tanisha", "Rita", "Current Account", "Female", "7034654480", "149586039480",
                "10748901152173"));
        table.add(new Info("Mira", "Tanya", "Money Account", "Female", "7908890380","123459162539", "10748901152174"));


        while (true) { 
            menu();
            System.out.print("Enter your choice : ");
            tocheck = sc.nextLine();

            if(tocheck.equalsIgnoreCase("a")){
                createNew();
            }else if(tocheck.equalsIgnoreCase("b")){
                display();
            }else if(tocheck.equalsIgnoreCase("c")){
                chkBalance();
            }else if(tocheck.equalsIgnoreCase("d")){
                deposit();
            }else if(tocheck.equalsIgnoreCase("e")){
                withdraw();
            }else if(tocheck.equalsIgnoreCase("f")){
                transfer();
            }else if(tocheck.equalsIgnoreCase("h")){
                break;
            }else{
                System.out.println("Invalid Input");
            }
        }
    }
}