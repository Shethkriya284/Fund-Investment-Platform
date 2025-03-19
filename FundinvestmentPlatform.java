import java.util.*;
//Main Class
class FundInvestmentPlatform
 {
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************************");
        System.out.println("    FUND INVESTMENT PLATFORM     ");
        System.out.println("*********************************");
        FundInvestmentPlatform login = new FundInvestmentPlatform();
        login.signup();
    }

    String name, phonenum ,userId;
    long mobileNumber;
int pin;
    // Empty Constructor
    FundInvestmentPlatform() 
    {

    }

    // User sign-up method
    void signup() 
    {
        System.out.println();
        System.out.println();
        Scanner sc = new Scanner(System.in); // Scanner created inside the method
        System.out.println("-----------------LOGIN-----------------"); //Login Page is displayed
        System.out.println();
        System.out.println("Enter your Name:");
        name = sc.nextLine();
        System.out.println("Enter your Mobile Number:");
        mobileNumber = sc.nextLong();
        phonenum = Long.toString(mobileNumber); // Convert long to string inorder to validate
        sc.nextLine(); 
		
        if(phonenum.length()==10) //checks if the length of the number is 10
        {
            if(phonenum.startsWith("7") || phonenum.startsWith("8") || phonenum.startsWith("9")) 
            {
                System.out.println("Valid Mobile Number.");
            } 
            else 
            {
                System.out.println("Invalid Mobile Number. Please enter a valid number.");
                mobileNumber = sc.nextLong(); // Retry signup
				
		}}
           else{ System.out.println("Invalid Mobile Number. Please enter a 10-digit number.");
            mobileNumber = sc.nextLong(); // Retry signup
			signup();
        }
        System.out.println("Enter your PIN:");
        pin = sc.nextInt();
		sc.nextLine();
        System.out.println("Enter your Confirm password:");
        int cpin= sc.nextInt(); //checks whether the password and confirm password are same

        if (pin==cpin) 
        {
            userId = generateUserId(name, phonenum);
            System.out.println("Signup Successful! Your user ID is: " + userId);//displays the user id
            System.out.println();

            // Loop for investment choices
            boolean b = true; // Declare and initialize the loop control variable
			
            while (b)
             {
                // Ask for investment preference
                System.out.println("Which type of investments would you prefer: "); //displays the investment options
				System.out.println();
                System.out.println("1. Government Investment");
                System.out.println("2. Mutual Fund Investment");
                System.out.println("3. Stock Investment");
                System.out.println("4. Exit");
				System.out.println();
                int choice = sc.nextInt();

                if (choice == 1) 
                {
                    GovernmentInvestment government = new GovernmentInvestment();
                    government.chooseInvestment(); //calls the chooseInvestment method of GovernmentInvestment 
                } 
                else if (choice == 2) 
                {
                    MutualFundInvestment mutualfund = new MutualFundInvestment();
                    mutualfund.chooseInvestment(); //calls the chooseInvestment method of MutualFundInvestment
                } 
                else if (choice == 3)
                {
                   StockMarket stock=new StockMarket();
				   stock.chooseInvestment(); //calls the chooseInvestment method of StockMarket
                }
                else if (choice == 4) 
                {
                    System.out.println("|| THANKS FOR CHOOSING FUND INVESTMENT PLATFORM ||.");
                    b = false; // Exits the loop
                } 
                else 
                {
                    System.out.println("Invalid choice.");
                }
            }
        } 
        else 
        {
            System.out.println("Your Pin is not Matched");
            signup(); // Retry signup
        }
    }

    String generateUserId(String name, String phonenum) //return type method
    {
        return name.substring(0, 4).toUpperCase() + phonenum.substring(0, 4); //generates the user id
    }
}

class GovernmentInvestment 
{

    // Method for user to choose government investment type
    void chooseInvestment() 
    {
        Scanner sc = new Scanner(System.in); 
        System.out.println("---------------------");
        System.out.println("GOVERNMENT INVESTMENT");
        System.out.println("---------------------");
        System.out.println();
        System.out.println("Which type of Government Investment would you prefer: ");
        System.out.println("1. Fixed Deposit (FD)");
        System.out.println("2. Public Provident Fund (PPF)");
        System.out.println("3. Sukanya Samriddhi Yojana");
        System.out.println("4. National Pension Scheme (NPS)");

        int govChoice = sc.nextInt();
        if (govChoice == 1) 
        {
            FD();
        } 
        else if (govChoice == 2) 
        {
            PPF();
        } 
        else if (govChoice == 3) 
        {
            SukanyaSamriddhi();
        } 
        else if (govChoice == 4) 
        {
            System.out.println("Are you an employee of Central Government? ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("yes"))
            {
                NationalPensionScheme();//eligible for NPS
            } 
            else if (ans.equalsIgnoreCase("no")) 
            {
                System.out.println("You are not eligible for National Pension Scheme."); //not eligible for NPS
            } 
            else 
            {
                System.out.println("Invalid Choice Entered.");
            }
        } 
        else 
        {
            System.out.println("Invalid Choice Entered.");
        }
    }

    void FD() 
    {
        Scanner sc = new Scanner(System.in); 
        double amount, rate;
        int time;

        System.out.println("------------Fixed Deposit------------");
        System.out.println();
        System.out.print("Enter Principal Amount: "); //takes the principal amount
        amount = sc.nextDouble();
        System.out.print("Enter Time Period (1, 2, or 5 years): "); //takes the time period
        time = sc.nextInt();

        if (time == 1) 
        {
            rate = 6.25; //rate of interest for 1 year
        } 
        else if (time == 2) 
        {
            rate = 6.50; //rate of interest for 2 years
        } 
        else if (time == 5) 
        {
            rate = 7.10; //rate of interest for 5 years
        } 
        else 
        {
            System.out.println("Invalid time period entered."); //if the time period is not 1,2 or 5
            return;
        }

        double CI = (amount * rate * time) / 100; //calculates the compound interest
        double total = amount + CI; //calculates the total amount
        System.out.println("The amount you'll receive after " + time + " years will be: " + total);//displays the total amount
    }

    void PPF() 
    {
        Scanner sc = new Scanner(System.in); // Scanner created inside the method
        System.out.println("------------Public Provident Fund------------");
        System.out.println();
        double sum = 0;
        int depositedamt;
        System.out.println("There is a fixed timelimit for PPF which is 15 years & Rate of interest is 7.1%");
        for (int i = 1; i <= 15; i++) 
        {
            System.out.println("Enter deposited Amount for " + i + " Year");
            depositedamt = sc.nextInt(); //takes the deposited amount
            if (500 <= depositedamt && depositedamt <= 150000) 
            {
                sum = sum + depositedamt;
                System.out.println("Sum for " + i + " year is : " + sum); //displays the sum
            } 
            else 
            {
                System.out.println("Amount you entered is out of Range..");
                break;
            }
        }
        double ci = (sum * 7.1 * 15) / 100; //calculates the compound interest
        double total = sum + ci; //calculates the total amount
        System.out.println("The total amount with interest you get is: " + total); //displays the total amount
    }

    void SukanyaSamriddhi() {
        Scanner sc = new Scanner(System.in); // Scanner created inside the method
        System.out.println("------------Sukanya Samriddhi Yojana------------");
        System.out.println();
        double rate = 8.2;
        double sum = 0;
        for (int i = 0; i < 15; i++)
        {
            System.out.println("Enter amount for year " + (i + 1) + " : "); //takes the amount for each year
            int y = sc.nextInt();
            sum = sum + y;
        }
        double ans = sum * 15 * rate; //calculates the total amount
        System.out.println("Total amount after 15 years: " + ans); //displays the total amount
    }

    void NationalPensionScheme() 
    {
        Scanner sc = new Scanner(System.in); // Scanner created inside the method
        int age;
        double salary;
        System.out.print("Enter your age: "); //takes the age
        age = sc.nextInt();
        System.out.print("Enter your salary: "); //takes the salary
        salary = sc.nextDouble();

        double npsAmount = salary * 0.10; //calculates the NPS amount
        System.out.println("You will receive: " + npsAmount); //displays the NPS amount
    }
}

class MutualFundInvestment 
{

    // Method for user to choose mutual fund investment type
    void chooseInvestment() {
        Scanner sc = new Scanner(System.in); // Scanner created inside the method
        System.out.println("-----------------------");
        System.out.println("MUTUAL FUNDS INVESTMENT");
        System.out.println("-----------------------");
        System.out.println();
        System.out.println("Which type of Mutual Fund Investment would you prefer: ");
        System.out.println("1. Systematic Investment Plan (SIP) ");
        System.out.println("2. Systematic Withdrawal Plan (SWP)");
        int choice = sc.nextInt();
        if (choice == 1) 
        {
            SIP();
        } else if (choice == 2) 
        {
            SWP();
        }
    }

    public static void SIP() 
    {
		Scanner sc = new Scanner(System.in);
        System.out.println("------------Systematic Investment Plan------------");
        System.out.println();
        // Getting user input for SIP with validation using if-else
        double amount = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Enter your monthly investment amount: "); //takes the monthly investment amount
            amount = sc.nextDouble();
            if (amount <= 0) 
            {
                System.out.println("Amount must be greater than zero. Please enter a valid amount.");
            } 
            else 
            {
                validInput = true;
            }
        }

        double rate = 0;
        validInput = false;
        while (!validInput) 
        {
            System.out.print("Enter the expected annual return rate (in percentage): ");//takes the expected annual return rate
            rate = sc.nextDouble();
            if (rate < 0) 
            {
                System.out.println("Return rate cannot be negative. Please enter a valid return rate.");
            } 
            else 
            {
                validInput = true;
            }
        }

        int years = 0;
        validInput = false;
        while (!validInput) 
        {
            System.out.print("Enter the number of years you plan to invest: "); //takes the number of years
            years = sc.nextInt();
            if (years <= 0) 
            {
                System.out.println("Years must be greater than zero. Please enter a valid number of years.");
            } 
            else 
            {
                validInput = true;
            }
        }

        // Option to include lumpsum investment with validation using if-else
        double lumpsumAmount = 0;
        sc.nextLine(); 
        validInput = false;
        while (!validInput) {
            System.out.print("Do you want to make a lumpsum investment (at the beginning)? (Yes/No): "); //asks whether to take lumpsum investment
            String lumpsumOption = sc.nextLine();
            if (lumpsumOption.equalsIgnoreCase("Yes")) 
            {
                System.out.print("Enter the lumpsum investment amount: "); //takes the lumpsum investment amount
                lumpsumAmount = sc.nextDouble();
                if (lumpsumAmount < 0) 
                {
                    System.out.println("Lumpsum amount cannot be negative. Please enter a valid lumpsum amount.");
                } 
                else 
                {
                    validInput = true;
                }
            } 
            else if (lumpsumOption.equalsIgnoreCase("No")) 
            {
                validInput = true;
            } 
            else 
            {
                System.out.println("Please enter 'Yes' or 'No' for lumpsum option.");
            }
        }

        // Option to increase/decrease SIP every year using if-else
        int increaseOption = 0;
        validInput = false;
        while (!validInput) 
        {
            System.out.println("Do you want to increase/decrease your monthly investment every year?"); //asks whether to increase/decrease the monthly investment
            System.out.println("1. Yes");
            System.out.println("2. No");
            increaseOption = sc.nextInt();
            if (increaseOption == 1 || increaseOption == 2) 
            {
                validInput = true;
            } 
            else 
            {
                System.out.println("Invalid choice. Please enter 1 for Yes or 2 for No.");//if the choice is not 1 or 2
            }
        }

        double percentageChange = 0;
        double fixedChange = 0;
        if (increaseOption == 1) 
        {
            validInput = false;
            while (!validInput) 
            {
                System.out.println();
                System.out.println("Choose the method of adjustment:"); //asks the method of adjustment
                System.out.println("1. Percentage");
                System.out.println("2. Fixed Rupees");
                int adjustmentType = sc.nextInt();

                if (adjustmentType == 1) 
                {
                    System.out.print("Enter the percentage by which you want to increase/decrease your SIP each year: ");//takes the percentage by which the SIP is to be increased/decreased
                    percentageChange = sc.nextDouble() / 100; // Convert to decimal for percentage calculation
                    validInput = true;
                } 
                else if (adjustmentType == 2) 
                {
                    System.out.print("Enter the fixed rupee amount by which you want to increase/decrease your SIP each year: "); //takes the fixed rupee amount by which the SIP is to be increased/decreased
                    fixedChange = sc.nextDouble();
                    validInput = true;
                } 
                else 
                {
                    System.out.println("Invalid choice. Please enter 1 for Percentage or 2 for Fixed Rupees."); //  if the choice is not 1 or 2
                }
            }
        }

        // Convert annual return rate to monthly rate
        double monthlyRate = rate / 100 / 12;

        // Total number of months
        int totalMonths = years * 12;

        double totalAmount = 0;
        double currentAmount = amount;

        // Calculate lumpsum growth (compound interest on lumpsum)
        totalAmount += lumpsumAmount * Math.pow(1 + monthlyRate, totalMonths);

        // Total deposits (including lumpsum and monthly SIPs)
        double totalDeposits = lumpsumAmount + amount * 12 * years;

        // Loop through each year and calculate SIP
        for (int year = 1; year <= years; year++) 
        {
            // Calculate the number of months in the current year
            int monthsInYear = 12;

            // Calculate the SIP for the current year (compounded monthly)
            for (int month = 1; month <= monthsInYear; month++) 
            {
                totalAmount += currentAmount * Math.pow(1 + monthlyRate, totalMonths - (year - 1) * 12 - month); // Calculate SIP
            }

            // Adjust SIP amount for the next year based on user preference
            if (increaseOption == 1) 
            {
                if (percentageChange != 0) 
                {
                    currentAmount += currentAmount * percentageChange; // Increase/Decrease by percentage
                } else if (fixedChange != 0) 
                {
                    currentAmount += fixedChange; // Increase/Decrease by fixed amount
                }
            }
        }

        // Calculate total return (Maturity Amount - Total Deposits)
        double totalReturn = totalAmount - totalDeposits; // Calculate total return

        // Output the results
        System.out.println("------------ Investment Summary ------------"); //displays the investment summary
        System.out.println("Maturity Amount: Rs." + totalAmount);
        System.out.println("Total Deposits (including lumpsum and SIP): Rs." + totalDeposits);
        System.out.println("Total Return (Profit earned): Rs." + totalReturn);
		System.out.println("---------------------------------------------");
    }


    void SWP() 
    {
        Scanner sc = new Scanner(System.in); 
        int amount, time;
        double rate;
        System.out.println("------------Systematic Withdrawal Plan------------");
        System.out.println();
        System.out.println("Enter Deposit Amount: "); //    takes the deposit amount
        amount = sc.nextInt();
        System.out.println("Enter Withdrawal Time Period (4 months / 6 months / 12 months): "); //takes the withdrawal time period
        time = sc.nextInt();
        System.out.println("Enter Expected rate: "); //takes the expected rate
        rate = sc.nextDouble();

        System.out.println("Enter your choice of withdrawal (1 or 2):"); //  asks for the choice of withdrawal
        System.out.println("1. Capital Appreciation ");
        System.out.println("2. Fixed Withdrawal Amount ");
        int choice = sc.nextInt();

        if (rate <= 10) 
        {
            if (choice == 1) 
            {
                if (time == 4 || time == 6 || time == 12) 
                {
                    double profit = (rate * amount * time) / 100; //calculates the profit
                    System.out.println("The amount of withdrawal is: " + profit); //displays the amount of withdrawal
                } 
                else 
                {
                    System.out.println("Invalid time period entered."); //if the time period is not 4,6 or 12
                }
            } 
            else if (choice == 2) 
            {
                if (time == 4 || time == 6 || time == 12) 
                {
                    System.out.println("Enter your amount to be withdrawn:"); //takes the amount to be withdrawn
                    int withdrawAmt = sc.nextInt();
                    double profit = (rate * amount * time) / 100; //calculates the profit
                    double total = amount + profit; //calculates the total amount
                    if (total > withdrawAmt)
                    {
                        System.out.println("Current Balance: " + (total - withdrawAmt) + " Rs."); //displays the current balance
                    } 
                    else 
                    {
                        System.out.println("Insufficient Balance for withdrawal."); //if the balance is insufficient
                    }
                }
            }
        } 
        else 
        {
            System.out.println("Invalid rate entered.");
        }
    }
}
//Stock Market
class StockInvestment 
{
    String companyName;
    double price;

    // Constructor to initialize stock details
    public StockInvestment(String companyName, double price) 
    {
        this.companyName = companyName;
        this.price = price;
    }

    // Method to display details of stock
    public void displayDetails() 
    {
        System.out.println(companyName + " | Price per share: Rs." + price); //displays the details of the stock
    }

    // Method to buy stock
    public void buyStock(int quantity) 
    {
        double total = price * quantity; //calculates the total amount
        System.out.println("Buying " + quantity + " shares of " + companyName + " for a total of Rs." + total); //displays the total amount
    }

    // Method to sell stock with a current price and profit/loss calculation
    public void sellStock(int quantity, double currentPrice) 
    {
        double totalCost = price * quantity; //calculates the total cost
        double totalSellingPrice = currentPrice * quantity; //calculates the total selling price
        double profitOrLoss = totalSellingPrice - totalCost; //calculates the profit or loss

        // Profit or Loss
        if (profitOrLoss > 0) 
        {
            System.out.println("Selling " + quantity + " shares of " + companyName + " at Rs." + currentPrice + " each for a total of Rs." + totalSellingPrice);
            System.out.println("Profit: Rs." + profitOrLoss); //displays the profit
        } 
        else if (profitOrLoss < 0) 
        {
            System.out.println("Selling " + quantity + " shares of " + companyName + " at Rs." + currentPrice + " each for a total of Rs." + totalSellingPrice);
            System.out.println("Loss: Rs." + Math.abs(profitOrLoss)); //displays the loss
        } 
        else 
        {
            System.out.println("Selling " + quantity + " shares of " + companyName + " at Rs." + currentPrice + " each for a total of Rs." + totalSellingPrice);
            System.out.println("No profit or loss."); //if there is no profit or loss
        }
    }
}

// LargeCap stock class
class LargeCapStock extends StockInvestment
 {
    public LargeCapStock(String companyName, double price) 
    {
        super(companyName, price);  // Constructor call
    }
}

// MidCap stock class
class MidCapStock extends StockInvestment
 {
    public MidCapStock(String companyName, double price)
    {
        super(companyName, price);  // Constructor call
    }
}

// SmallCap stock class
class SmallCapStock extends StockInvestment 
{
    public SmallCapStock(String companyName, double price) 
    {
        super(companyName, price);  // Constructor call
    }
}

class StockMarket 
{
    void chooseInvestment()
    {
        Scanner scanner = new Scanner(System.in);
        boolean continueSimulation = true;

        System.out.println("-----------------------------");
        System.out.println("Welcome to the Stock Market !");
        System.out.println("-----------------------------");
        System.out.println();

        while (continueSimulation) 
        {
            // Display available companies
           
            System.out.println("Choose a category:"); //displays the categories
            System.out.println("1. Large Cap Companies");
            System.out.println("2. Mid Cap Companies");
            System.out.println("3. Small Cap Companies");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter your choice (1-4): ");

            int categoryChoice = scanner.nextInt();

            StockInvestment stock = null;

            // Switch case to handle different categories
            switch (categoryChoice) 
            {
                case 1:
                    System.out.println("Choose a Large Cap Company:"); //displays the large cap companies
                    System.out.println("1.Titan");
                    System.out.println("2. Nestle India");
                    System.out.println("3. TCS");
                    System.out.println("4. Britannia Inds.");
                    System.out.println("5. Larsen and Toubro");
                    System.out.print("Enter your choice (1-5): ");
                    int largeCapChoice = scanner.nextInt();
                    if (largeCapChoice == 1) 
                    {
                        stock = new LargeCapStock("Titan", 3210.00);
                    } 
                    else if (largeCapChoice == 2) 
                    {
                        stock = new LargeCapStock("Nestle India", 2209.05);
                    } 
                    else if (largeCapChoice == 3) 
                    {
                        stock = new LargeCapStock("TCS", 3929.00);
                    } 
                    else if (largeCapChoice == 4) 
                    {
                        stock = new LargeCapStock("Britannia", 4934.00);
                    } 
                    else 
                    {
                        stock = new LargeCapStock("Larsen and Toubro", 3250.85);
                    }
                    break;

                case 2:
                    System.out.println("Choose a Mid Cap Company:"); //displays the mid cap companies
                    System.out.println("1. Lloyds Metals.");
                    System.out.println("2. Reliance Inds.");
                    System.out.println("3. ICICI Bank");
                    System.out.println("4. Infosys");
                    System.out.println("5. Tech Mahindra");
                    System.out.print("Enter your choice (1-5): ");
                    int midCapChoice = scanner.nextInt();
                    if (midCapChoice == 1) 
                    {
                        stock = new MidCapStock("Lloyds Metals", 1114.00);
                    } 
                    else if (midCapChoice == 2) 
                    {
                        stock = new MidCapStock("Reliance Inds", 1218.80);
                    } 
                    else if (midCapChoice == 3) 
                    {
                        stock = new MidCapStock("ICICI Bank", 1243.80);
                    } 
                    else if (midCapChoice == 4) 
                    {
                        stock = new MidCapStock("Infosys", 1840.95);
                    } 
                    else 
                    {
                        stock = new MidCapStock("Tech Mahindra", 1657.00);
                    }
                    break;

                case 3:
                    System.out.println("Choose a Small Cap Company:"); //displays the small cap companies
                    System.out.println("1. ITC");
                    System.out.println("2. Wipro");
                    System.out.println("3. ONGC");
                    System.out.println("4. ZOMATO");
                    System.out.println("5. Reliance Power");
                    System.out.print("Enter your choice (1-5): ");
                    int smallCapChoice = scanner.nextInt();
                    if (smallCapChoice == 1) 
                    {
                        stock = new SmallCapStock("ITC", 408.50);
                    } 
                    else if (smallCapChoice == 2) 
                    {
                        stock = new SmallCapStock("Wipro", 303.00);
                    } 
                    else if (smallCapChoice == 3) 
                    {
                        stock = new SmallCapStock("ONGC", 231.00);
                    } 
                    else if (smallCapChoice == 4) 
                    {
                        stock = new SmallCapStock("ZOMATO", 218.00);
                    } 
                    else 
                    {
                        stock = new SmallCapStock("Reliance Power", 36.00);
                    }
                    break;

                case 4:
                    System.out.println("EXITING STOCK MARKET");
                    continueSimulation = false;  // Exit the loop
                    break;
                default:
				    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Invalid choice. Exiting..."); //if the choice is invalid
					System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    return;
            }

            if (stock != null) 
            {
                stock.displayDetails();
                System.out.println();
                // Stock buying/selling functionality
                System.out.println("Do you want to buy or sell stock?"); //asks whether to buy or sell stock
                System.out.println("1. Buy");
                System.out.println("2. Sell");
                System.out.print("Enter your choice (1-2): "); //takes the choice
                int actionChoice = scanner.nextInt();

                System.out.print("Enter the quantity: "); //takes the quantity
                int quantity = scanner.nextInt();

                double currentPrice = 0;

                // Define default current prices for selling
                if (stock instanceof LargeCapStock) 
                {
                    if (stock.companyName.equals("Titan")) 
                    {
                        currentPrice = 3300.00;
                    } 
                    else if (stock.companyName.equals("Nestle India")) 
                    {
                        currentPrice = 2300.00;
                    } 
                    else if (stock.companyName.equals("TCS")) 
                    {
                        currentPrice = 4000.00;
                    } 
                    else if (stock.companyName.equals("Britannia")) 
                    {
                        currentPrice = 5100.00;
                    } 
                    else 
                    {
                        currentPrice = 3300.00;  // Default for others
                    }
                } 
                else if (stock instanceof MidCapStock) 
                {
                    if (stock.companyName.equals("Lloyds Metals")) 
                    {
                        currentPrice = 1200.00;
                    } 
                    else if (stock.companyName.equals("Reliance Inds")) 
                    {
                        currentPrice = 1300.00;
                    } 
                    else if (stock.companyName.equals("ICICI Bank")) 
                    {
                        currentPrice = 1300.00;
                    } 
                    else if (stock.companyName.equals("Infosys")) 
                    {
                        currentPrice = 1900.00;
                    } 
                    else 
                    {
                        currentPrice = 1700.00;  // Default for others
                    }
                } 
                else if (stock instanceof SmallCapStock) 
                {
                    if (stock.companyName.equals("ITC")) 
                    {
                        currentPrice = 420.00;
                    } 
                    else if (stock.companyName.equals("Wipro")) 
                    {
                        currentPrice = 320.00;
                    } 
                    else if (stock.companyName.equals("ONGC")) 
                    {
                        currentPrice = 240.00;
                    } 
                    else if (stock.companyName.equals("ZOMATO")) 
                    {
                        currentPrice = 220.00;
                    } 
                    else 
                    {
                        currentPrice = 40.00;  // Default for others
                    }
                }

                switch (actionChoice) 
                {
                    case 1:
                        stock.buyStock(quantity);
                        break;
                    case 2:
                        stock.sellStock(quantity, currentPrice);  // Selling with the default current price
                        break;
                    default:
                        System.out.println("Invalid action. Exiting...");
                }
            }
        }
	}
        
    }