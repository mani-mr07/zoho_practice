import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int taxiId=1;
    static int passengerId=1;


    static ArrayList<Passenger>passengerArrayList;
    public static void main(String[] args) {
        ArrayList<Taxi>taxis=new ArrayList<Taxi>();
        Scanner sc=new Scanner(System.in);
        taxis.add(new Taxi(1,'A',0,6));
        taxis.add(new Taxi(2,'A',0,6));
        taxis.add(new Taxi(3,'A',0,6));
        ArrayList<Passenger>passengers=new ArrayList<Passenger>();
        boolean condition=true;
        while(condition){
            System.out.println("enter the choice");
            int ch=sc.nextInt();
            switch (ch){
                case 1:{

                    Passenger p=new Passenger(passengerId++);
                    if(p.book(taxis,passengerArrayList)){
//                        System.out.println("hi");
                        passengerArrayList.add(p);
                        taxis.get(p.taxiNo-1).passengerArrayList.add(p);
                    }
                    break;
                }
                case 2:{
                    for(Taxi i:taxis){
                        i.print();
                    }
                    break;
                }
                case 3:{
                    for(Passenger p:passengerArrayList){
                        if(p!=null){
                        p.print();}
                    }
                    break;
                }
            }
        }
    }
}