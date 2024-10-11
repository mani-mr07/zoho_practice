import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static ArrayList<Passenger>passengers=new ArrayList<>();
    static int id=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while(loop){
            System.out.println("Enter the choice 1.book 2.cancel 3.printDetails 4.printAvailableBerth");
            int ch=sc.nextInt();
            switch (ch){
                case 1: {
                    System.out.println("enter the passenger name: ");
                    String name = sc.next();
                    System.out.println("enter age:");
                    int age = sc.nextInt();
                    System.out.println("enter the preferred berth:");
                    char preferredBerth = sc.next().charAt(0);
                    Passenger p = new Passenger(id++,name, age, preferredBerth);
                    if(p.bookTicket()){
                        passengers.add(p);
                    }
                    break;
                }
                case 2:{
                    System.out.println("enter the id ");
                int id=sc.nextInt();
                Passenger p=getPassengerById(id);
                if(p!=null){
                   Passenger pas= p.cancelTicket();
                   if(pas!=null){
                   pas.bookTicket();}
                   passengers.remove(p);

                }
                else{
                    System.out.print("not found");
                    }
                break;
                }
                case 3:{
                    for(Passenger p:passengers){
                        System.out.println(p.id+" "+p.name+" "+p.allotedBerth+" "+p.ticketType);
                    }
                    break;
                }
                case 4:
                {
                    System.out.println("availbleBerth");
                    Passenger.printAvailable();
                }
            }
        }
    }
    public static Passenger getPassengerById(int id){
        for(Passenger p:passengers){
            if(p.id==id){
                return p;
            }
        }
        return null;
    }
}