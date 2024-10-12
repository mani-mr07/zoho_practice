import java.util.ArrayList;

public class Taxi {
    int id;
    char currentLocation;

    int freeTime;
    int earning;
    ArrayList<Passenger> passengerArrayList;

    public Taxi(int id, char currentLocation, int earning,int freeTime) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.earning = earning;
        this.freeTime=freeTime;
    }

//    @Override
    public void print() {
        System.out.println( "Taxi{" +
                "id=" + id +
                ", currentLocation=" + currentLocation +
                ", freeTime=" + freeTime +
                ", earning=" + earning +
                ", passengerArrayList=" + passengerArrayList +
                '}');
    }
}
