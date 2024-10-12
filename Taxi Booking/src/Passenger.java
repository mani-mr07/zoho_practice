import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Passenger
{
    int id;

    char pickupLocation;
    int pickupTime;
    char dropLocation;
    int taxiNo;
Scanner sc=new
        Scanner(System.in);
    public Passenger(int id) {
        System.out.println("enter the pickupTime");
        this.pickupTime=sc.nextInt();
        System.out.println("Enter the pickupLocation ");
        this. pickupLocation=sc.next().charAt(0);
        System.out.println("enter drop location");
        this.dropLocation=sc.next().charAt(0);
        this.id=id;
    }
    public boolean book(ArrayList<Taxi>taxis,ArrayList<Passenger>passengerArrayList){
        ArrayList<Taxi>freeList=new ArrayList<>();
        freeList=getFreeTaxi(taxis,pickupTime,pickupLocation);
        if(freeList.isEmpty()){
            System.out.println("false");
            return false;
        }
        Collections.sort(freeList,(a,b)->a.earning-b.earning);

        int min=1000,distance=0;
        Taxi allotedtaxi=null;
        for(Taxi t:freeList){
            System.out.println("hi");
            distance=Math.abs((t.currentLocation-'0')-(pickupLocation-'0'))*15;
            if(distance<min){
                min=distance;
                allotedtaxi=t;
            }
        }
        if(allotedtaxi!=null){
        allotedtaxi.currentLocation=dropLocation;
        allotedtaxi.freeTime=pickupTime+Math.abs((pickupLocation-'0')-(dropLocation-'0'));
        allotedtaxi.earning+=100+(distance-5)*10;
        taxiNo=allotedtaxi.id;
//        System.out.println("ji");
        return true;}
        return false;
    }
    public static ArrayList<Taxi> getFreeTaxi(ArrayList<Taxi>taxis,int pickupTime,char pickupLocation){
        ArrayList<Taxi>freetaxii=new ArrayList<>();
        for(Taxi t:taxis){
            if(t.freeTime<=pickupTime && Math.abs((pickupLocation-'0')-(t.currentLocation-'0'))<=pickupTime-t.freeTime){
                System.out.println("hi");
                freetaxii.add(t);
            }
        }

        return freetaxii;
    }


    public void print() {
        System.out.println("Passenger{" +
                "id=" + id +
                ", pickupLocation=" + pickupLocation +
                ", pickupTime=" + pickupTime +
                ", dropLocation=" + dropLocation +
                ", taxiNo=" + taxiNo +
                ", sc=" + sc +
                '}');
    }
}
