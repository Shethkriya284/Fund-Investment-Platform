
import java.util.*;

class TicketMania
 {
    public static void main(String[] args)
     {
        TicketMania object = new TicketMania();
        Scanner sc = new Scanner(System.in);
        System.out.println("#################################################################");
        System.out.println("---------------------------TICKET  MANIA-------------------------");
        System.out.println("#################################################################");
        System.out.println();
       
        object.Login();
    }
        
        void Login()
        {
        // Taking user's details
        // Taking Name
        System.out.print("Enter your NAME : ");
        String name = sc.nextLine();
        // Taking Mobile Number
        System.out.print("Enter your mobile no. : ");
        long no = sc.nextLong();
        // Converting the mobile number to string
        String mobileno = Long.toString(no);
        // Checking if the mobile number entered is valid or not
        if (mobileno.length() != 10 || mobileno.charAt(0) == '0' || mobileno.startsWith("1") || mobileno.startsWith("2") || mobileno.startsWith("3") || mobileno.startsWith("4") || mobileno.startsWith("5"))
        {
            System.out.println("Invalid Mobile Number Entered.");
            System.out.println("TRY AGAIN ");
            return;
        } 
        else 
        {
            System.out.println("Mobile Number Verified.");
        }
        // Taking Date of Birth
        System.out.print("Enter your Date of Birth (DDMMYYYY): ");
        int dob = sc.nextInt();
        sc.nextLine(); // Consume newline
        

        System.out.println();
        // Displaying the welcome message
        System.out.print("Welcome " + name + " !");
        System.out.println();
        // Calling the BookTickets method
        BookTickets();
     }
        void BookTickets()
        {
        // Asking the user for the type of event they want to book tickets for
        System.out.println("What would you like to book Tickets for!?");
        System.out.println(" 1. Movie");
        System.out.println(" 2. Podcast");
        System.out.println(" 3. Comedy Shows");
        System.out.println(" 4. Other Live Events");
        int wish = sc.nextInt();
        sc.nextLine(); 
        // Checking the user's choice
        if (wish == 1) 
        {
            this.Movie();
        } 
        else if (wish == 2) 
        {
            this.Podcast();
        } 
        else if (wish == 3) 
        {
            this.ComedyShows();
        } 
        else if (wish == 4) 
        {
            this.OtherLiveEvents();
        } 
        else 
        {
            System.out.println("Invalid Choice Entered.");
            return;
        }
       }
    

    Scanner sc = new Scanner(System.in);
    // Method to book tickets for Movies
    void Movie() 
    {
        System.out.println("For which Movie would you like to book Tickets !?");
        System.out.println(" 1. Chhaava");
        System.out.println(" 2. Captain America");
        System.out.println(" 3. Umbro");
        System.out.println(" 4. Mom Tane Nahi Samjhay");
        int x = sc.nextInt();
        sc.nextLine(); 
        if (x == 1) 
        {
            System.out.println("Chhaava");
            System.out.println("~~~~~~~~");
            System.out.println();
        } 
        else if (x == 2) 
        {
            System.out.println("Captain America");
            System.out.println("~~~~~~~~~~~~~~~");
            System.out.println();
        } 
        else if (x == 3) 
        {
            System.out.println("Umbro");
            System.out.println("~~~~~");
            System.out.println();
        }
        else if (x == 4) 
        {
            System.out.println("Mom Tane Nahi Samjhay");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
        }
        else
        {
          System.out.println("Invalid Choice Entered!");
          return;
        }
        // Calling the Seat method
        Seat();
    }

    void Seat() 
    {
        System.out.print("Do You Want To book tickets for today or tomorrow ? ");
        System.out.print("1. Today ");
        System.out.print("2. Tomorrow ");
        int day = sc.nextInt();
        sc.nextLine(); // Consume newline
        if(day==1 || day==2)
        {
        System.out.print(" Enter Show Timings : (9 am ; 12 am ; 2 pm ; 6 pm ; 8 pm ; 11 pm) ");
        String time = sc.nextLine();
        System.out.println();
        // Asking the user for the type of seat they want to book
        System.out.println("Which type of seat would you prefer !?");
        System.out.println("1. Marvel : 150 Rs.");
        System.out.println("2. Royal : 250 Rs.");
        System.out.println("3. Lounger : 350 Rs.");
        int seat = sc.nextInt();
        //switch case for seat
        switch (seat) 
        {
            case 1:
                System.out.println("How many Marvel Seats you want to book ? ");
                int ans = sc.nextInt();
                
                System.out.println("You have to pay : " + (ans * 150) + " Rs.");
                
                break;
            case 2:
                System.out.println("How many Royal Seats you want to book ? ");
                int ans2 = sc.nextInt();
                
                System.out.println("You have to pay : " + (ans2 * 250) + " Rs.");
                
                break;
            case 3:
                System.out.println("How many Lounger Seats you want to book ? ");
                int ans3 = sc.nextInt();
                
                System.out.println("You have to pay : " + (ans3 * 350) + " Rs.");
                
                break;
        }
      }
      else
      {
        System.out.print("Invalid Choice Entered.");
      }
    }
    // Method to book tickets for Podcast
    void Podcast() 
    {

        System.out.println("For which Podcast would you like to book Tickets !?");
        System.out.println(" 1. The Nayab Show (By Nayab Midha)");
        System.out.println(" 2. Laagni (By RJ Viraj)");
        System.out.println(" 3. Main Shayar To Nahi (By Manhar Seth)");
        int x = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (x == 1) 
        {
            System.out.println("The Nayab Show");
            System.out.println("~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 1st February,2025       ||     Time : 7 p.m. ");
            System.out.println("Venue : Himalaya Mall ");
            System.out.println("Ticket Price : 1200 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int tickets1 = sc.nextInt();
            System.out.println("Amount to be paid : "+tickets1*1200);
        } 
        else if (x == 2) 
        {
            System.out.println("Laagni (By RJ Viraj)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 7th February,2025       ||     Time : 9 p.m. ");
            System.out.println("Venue : Mishty Studio ");
            System.out.println("Ticket Price : 600 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int tickets2 = sc.nextInt();
            System.out.println("Amount to be paid : "+tickets2*600);
        } 
        else if (x == 3) 
        {
            System.out.println("Main Shayar To Nahi (By Manhar Seth)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 6th April,2025       ||     Time : 8 p.m. ");
            System.out.println("Venue : Palladium Mall ");
            System.out.println("Ticket Price : 700 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int tickets3 = sc.nextInt();
            System.out.println("Amount to be paid : "+tickets3*700);
            
        }
    }
    
    // Method to book tickets for Comedy Shows
    void ComedyShows() 
    {
        System.out.println("For which Comedy Shows would you like to book Tickets !?");
        System.out.println(" 1. The Comedy Factory Show");
        System.out.println(" 2. CrowdWork Comedy by Akash Gupta");
        System.out.println(" 3. College Days by Pranav Sharma");
        System.out.println(" 4. Majja ni Life by Raghav Thakkar");
        System.out.println(" 5. Manik's Day Out by Manik Mahna");
        int x = sc.nextInt();
        sc.nextLine(); // Consume newline
        if (x == 1) 
        {
            System.out.println("The Comedy Factory Show");
            System.out.println("~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 23rd February,2025       ||     Time : 7 p.m. ");
            System.out.println("Venue : Himalaya Mall ");
            System.out.println("Ticket Price : 1000 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int seats1 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats1*1000);
        } 
        else if (x == 2) 
        {
            System.out.println("CrowdWork Comedy by Akash Gupta");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 7th March,2025       ||     Time : 8 p.m. ");
            System.out.println("Venue : Vastrapur Amphitheatre ");
            System.out.println("Ticket Price : 800 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int seats2 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats2*800);        
        } 
        else if (x == 3) 
        {
            System.out.println("College Days by Pranav Sharma");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 6th April,2025       ||     Time : 8 p.m. ");
            System.out.println("Venue : Signature Studio ");
            System.out.println("Ticket Price : 700 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int seats3 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats3*700);
        }
        else if (x == 4) 
        {
            System.out.println("Majja ni Life by Raghav Thakkar");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 8th March,2025       ||     Time : 8 p.m. ");
            System.out.println("Venue : Mishty Studio ");
            System.out.println("Ticket Price : 500 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int seats4 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats4*500);
        }
        else if (x == 5) 
        {
            System.out.println("Manik's Day Out by Manik Mahna");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 1st March,2025       ||     Time : 7 p.m. ");
            System.out.println("Venue : Mocha Cafe ");
            System.out.println("Ticket Price : 200 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int seats5 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats5*200);
        }
    }
    // Method to book tickets for Other Live Events
    void OtherLiveEvents() 
    {
        System.out.println("For which Other Live Events would you like to book Tickets !?");
        // displaying upcoming three live events in the city 
        System.out.println(" 1. Sonu Nigam Live In Concert");
        System.out.println(" 2. Aditya Gadhvi Live In Concert");
        System.out.println(" 3. Open Mic - The Creative Distraction");
        int x = sc.nextInt();
        if (x == 1) 
        {
            System.out.println("Sonu Nigam Live In Concert");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 1st February,2025       ||     Time : 6 p.m. ");
            System.out.println("Venue : Yet to be announced ");
            System.out.println("Ticket Price : 2000 Rs.");
            System.out.println("How many tickets you want to book ? ");
            int seats1 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats1*2000);
        } 
        else if (x == 2) 
        {
            System.out.println("Aditya Gadhvi Live In Concert");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 22nd March,2025       ||     Time : 6 p.m. ");
            System.out.println("Venue : Multiple Venus ");
            System.out.println("Ticket Price : 1500");
            System.out.println("How many tickets you want to book ? ");
            int seats2 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats2*1500);
        } 
        else if (x == 3) 
        {
            System.out.println("Open Mic - The Creative Distraction");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("Date : 6th April,2025       ||     Time : 8 p.m. ");
            System.out.println("Venue : Monkey Cafe ");
            System.out.println("Ticket Price : 200 Rs.");
            System.out.println("How many Seats you want to book ? ");
            int seats3 = sc.nextInt();
            System.out.println("Amount to be paid : "+seats3*200);
        }
    }
    
}
