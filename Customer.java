/**
 * store the information of the customer
 * 
 * @author (Xin Li)
 * @version (23/04)
 */
public class Customer
{
    private String name;
    private int balance;
    private String purchasedItem;
    private int totalCosts;
    
    public Customer()
    {
        name = "";
        balance = 0;
        purchasedItem = "";
        totalCosts = 0;
    }
    
    public Customer(String newName)
    {
        name = newName;
        balance = 0;
        purchasedItem = "";
        totalCosts = 0;
    }
    
    public Customer(String newName, int credit)
    {
        name = newName;
        balance = credit;
        purchasedItem = "";
        totalCosts = 0;
    }
    
    /**
     * set the name of customer
     */
    public void setName(String newName)
    {
        name = newName;
    }    
    
    /**
     * get the name of customer
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * set the credit balance
     */
    public void setBalance(int credit)
    {
        balance = credit;
    }
    
    /**
     * get the credit balance
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**
     * set the purchased item
     */
    public void setPurchaseItem(String items)
    {
        purchasedItem = items;
    }
    
    /**
     * update the purchased item
     */
    public void updatePurchaseItem(String newItem)
    {
        purchasedItem = purchasedItem + " " + newItem;
    }
    
    /**
     * get the purchased item
     */
    public String getPurchasedItem()
    {
        return purchasedItem;
    }
    
    /**
     * set the total costs
     */
    public void setTotalCosts(int totalCosts)
    {
        totalCosts = totalCosts;
    }
    
    /**
     * update the total costs
     */
    public void updateTotalCosts(int newCost)
    {
        totalCosts = totalCosts + newCost;
    }
    
    /**
     * get the total costs
     */
    public int getTotalCosts()
    {
        return totalCosts;
    }
    
    /**
     * print the customer name and the balance
     */
    public void displayCustomer()
    {
        System.out.println(name + ", " + balance);
    }
    
    /**
     * (4) What Have I Ordered So Far?
     */
    public void displayStatistics()
    {
        System.out.println("Customer " + name + "has purchased these items: ");
        System.out.println(purchasedItem);
        System.out.println("worth a total of $" + totalCosts);
        System.out.println("Credit balance: $" + balance);
    }
}
