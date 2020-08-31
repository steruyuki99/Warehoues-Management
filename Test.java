
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        WarehouseStaff s1 = new WarehouseStaff();
        WarehouseCust c1 = new WarehouseCust();
        Scanner i = new Scanner(System.in);
        String opt = "Y";
        String opt2 = "Y";
        int option;
        while (opt.equals("Y") || opt.equals("y")) {
            System.out.println("Choose the type of user: ");
            System.out.println("1.  Staff");
            System.out.println("2.  Customer");
            option = i.nextInt();
            if (option == 1) {
                s1.navi(i);
                System.out.println("Do you want to continue as Staff?? If yes, please type Y");
                opt2 = i.next();
                while(opt2.equals("Y") || opt2.equals("y")){
                    s1.navi(i);
                    System.out.println("Do you want to continue as Staff?? If yes, please type Y");
                    opt2 = i.next();
                    if (!opt2.equals("Y") && !opt2.equals("y")) {
                        opt2 = "n";
                    }
                }
            } else if (option == 2) {
                c1.navi(i);
                System.out.println("Do you want to continue as Customer?? If yes, please type Y");
                opt2 = i.next();
                while(opt2.equals("Y") || opt2.equals("y")){
                    c1.navi(i);
                    System.out.println("Do you want to continue as Customer?? If yes, please type Y");
                    opt2 = i.next();
                    if (!opt2.equals("Y") && !opt2.equals("y")) {
                        opt2 = "n";
                    }
                }
            } else {
                System.out.println("The user type you entered is not unavailable. Please type again");
            }

            System.out.println();
            System.out.println("Do you want to continue?? If yes, please type Y");
            opt = i.next();
            if (!opt.equals("Y") && !opt.equals("y")) {
                opt = "n";
                System.out.println("Exitting this function");
            }
            else{
                opt2="Y";
            }
        }
        i.close();
    }
}