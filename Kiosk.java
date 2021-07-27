import java.util.Scanner;

/**
 * simulates a rather simplistic Super Fantastic Kiosk
 * 
 * @author (Xin Li)
 * @version (23/04)
 */
public class Kiosk
{
    private Customer customer;
    private LuckyDipGenerator random;

    public Kiosk()
    {
        customer = new Customer();
        random = new LuckyDipGenerator();
    }

    /**
     * call other methods
     */
    public void main()
    {
        displayMenu();        
        Scanner mainMenuOption = new Scanner(System.in);
        String option = mainMenuOption.nextLine(); 
        boolean finish = false;
        while(!finish)
        {
            switch (option)
            {
                case "1": createOrder(); break;
                case "2": 
                if (customer.getName().length() == 0)
                    System.out.println("Error: please create a new order first");
                else
                    buyMoreCredit(); 
                break; 
                case "3": 
                if (customer.getName().length() == 0)
                    System.out.println("Error: please create a new order first");
                else
                    purchaseItem(); 
                break;
                case "4": 
                if (customer.getName().length() == 0)
                    System.out.println("Error: please create a new order first");
                else
                    customer.displayStatistics(); 
                break;
                case "5": 
                if (customer.getName().length() == 0)
                    System.out.println("Error: please create a new order first");
                else
                    collectOrder(); 
                break;
                case "6": displayHelp(); break;
                case "7": finish = true; break;     // (7) Leave Kiosk
                default: System.out.println("Error: please select a valid option");
            }
            if (!finish)
            {
                displayMenu();
                option = mainMenuOption.nextLine();
            }
        }
    }

    /**
     *  print the welcome message and the menu
     */
    public void displayMenu()
    {
        System.out.println("Welcom to Super Fantastic Kiosk");
        System.out.println("===============================");
        System.out.println("(1) Create A New Order");
        System.out.println("(2) Buy More Credit");
        System.out.println("(3) Purchase An Item");
        System.out.println("(4) What Have I Ordered So Far?");
        System.out.println("(5) Collect My Order");
        System.out.println("(6) Display Help");
        System.out.println("(7) Leave Kiosk");
        System.out.print("Choose an option: ");
    }

    /**
     * (1) Create A New Order
     */
    public void createOrder()
    {
        Scanner input = new Scanner(System.in);        
        System.out.println("Enter your name please: ");
        String name = input.nextLine();
        while (name.trim().length() ==0)
        {
            System.out.println("The customer's name must not be blank");
            System.out.println("Enter your name please: ");
            name = input.nextLine();
        }
        System.out.println("Hello, " + name);        
        System.out.println("Enter your balance please: ");
        int balance = input.nextInt();
        int i = 0;
        while (balance <= 0)
        {            
            System.out.println("The credit must be more than 0");
            System.out.println("Enter your balance please: ");
            balance = input.nextInt();
            i++;
            if (i ==2)
            {
                break;
            }
        }
        System.out.println("your balance is: " + balance);

        customer = new Customer(name, balance);       
    }

    /**
     * (2) Buy More Credit
     */
    public void buyMoreCredit()
    {        
        System.out.println("Please buy more credit: ");
        Scanner input = new Scanner(System.in);
        int moreCredit = input.nextInt();
        while (moreCredit <= 0)
        {
            System.out.println("The credit must be more than 0");
            System.out.println("Please buy more credit: ");
            moreCredit = input.nextInt();
        }
        updateBalacne(moreCredit);
    }
    public void test()
    {
        Customer customer = new Customer("Peter");
        customer.displayCustomer();
    }
    /**
     * update the balance
     */
    public void updateBalacne(int moreCredit)
    {
        int oldBalance = customer.getBalance();
        int newBalance = oldBalance + moreCredit;
        customer.setBalance(newBalance);
    }

    /**
     * print the list of available items
     */
    public void showMenu()
    {
        System.out.println("These are the items available for sale today:");
        System.out.println("---------------------------------------------");
        System.out.println("(1) Pen, worth $10.");
        System.out.println("(2) Book, worth $20.");
        System.out.println("(3) DVD, worth $30.");
        System.out.println("(4) MOUSE, worth $40.");
        System.out.println("(5) KEYBOARD, worth $50.");
        System.out.println("(6) Let ME pick a random item for you!!!");        
    }

    /**
     * (3) Purchase An Item
     */
    public void purchaseItem()
    {       
        Scanner input = new Scanner(System.in);
        showMenu();
        int option = input.nextInt();
        if (option == 6)
            option = random.randomItem(6, 1);
        if (option < 1 || option > 6)
            System.out.println("Error: you choice must be between 1-6"); 
        else if (customer.getBalance() < option * 10)
        {
            System.out.println("Error: The balance is not enough");
            System.out.println("Item cost: $" + option * 10);
            System.out.println("Your balance: $" + customer.getBalance());
        }
        else
        {
            switch (option)
            {
                case 1: 
                {
                    System.out.println("You have bought a PEN, worth $10.");
                    customer.updatePurchaseItem("PEN");
                    customer.updateTotalCosts(10);
                    updateBalacne(-10);
                }
                break;
                case 2:
                {
                    System.out.println("You have bought a BOOK, worth $20.");
                    customer.updatePurchaseItem("BOOK");
                    customer.updateTotalCosts(20);
                    updateBalacne(-20);
                }
                break;
                case 3:
                {
                    System.out.println("You have bought a DVD, worth $30.");
                    customer.updatePurchaseItem("DVD");
                    customer.updateTotalCosts(30);
                    updateBalacne(-30);
                }
                break;
                case 4:
                {
                    System.out.println("You have bought a MOUSE, worth $40.");
                    customer.updatePurchaseItem("MOUSE");
                    customer.updateTotalCosts(40);
                    updateBalacne(-40);
                }
                break;
                case 5:
                {
                    System.out.println("You have bought a KEYBOARD, worth $50.");
                    customer.updatePurchaseItem("KEYBOARD");
                    customer.updateTotalCosts(50);
                    updateBalacne(-50);
                }
                break;
            }
        }
    }

    /**
     * (5) Collect My Order
     */
    public void collectOrder()
    {
        customer.displayStatistics();
        System.out.println("Thank you for shopping with us. Please collect your goods (and your balance) at the front desk.");
        customer = new Customer();
    }

    /**
     * (6) Display Help
     */
    public void displayHelp()
    {
        System.out.print("Please create a new order and enter your name and buy some credit first.");
        System.out.print("After selecting 3 in the main menu, you can choose 1-5 to buy a pen ,a book, a DVD, a mouse or a keyboard, or choose 6 to get a random item from these 5 items.");
    }
}
