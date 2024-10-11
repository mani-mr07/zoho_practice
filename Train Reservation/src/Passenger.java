import java.awt.print.Book;
import java.util.*;

public class Passenger {
    int id;
    String name;

    String ticketType;
    int  age;
    char preferencedBerth;

    char allotedBerth;
    static ArrayList<Passenger> confirmList=new ArrayList<>();
    static Queue<Passenger> racList= new LinkedList<>();
    static Queue<Passenger>waitingList=new LinkedList<>();


    static HashMap<Character,Integer>berth=new HashMap<>();

    static {
        berth.put('u',2);
        berth.put('l',2);
        berth.put('m',2);
    }
    static int sizeofConfirmList=6;
    static int sizeofracList=2;
    static int sizeofwaitinglist=2;

    public Passenger(int id,String name, int age, char preference) {
        this.name = name;
        this.age = age;
        this.preferencedBerth = preference;
        this.id=id;
    }
    public boolean bookTicket(){
        if(sizeofConfirmList>0){
            for(Map.Entry<Character,Integer>entries:berth.entrySet()){
                if((entries.getKey().equals(this.preferencedBerth)) && entries.getValue()>0){
                    entries.setValue(entries.getValue()-1);
                    this.allotedBerth=this.preferencedBerth;
                    confirmList.add(this);
                    this.ticketType="confirm";
                    sizeofConfirmList--;
                    return true;
                }
            }
            for(Map.Entry<Character,Integer>entries: berth.entrySet()){
                if(entries.getValue()>0){
                    entries.setValue(entries.getValue()-1);
                    this.allotedBerth=entries.getKey();
                    this.ticketType="confirm";
                    confirmList.add(this);
                    sizeofConfirmList--;
                    return true;
                }
            }
        } else if (sizeofracList>0) {
            racList.offer(this);
            this.ticketType="rac";

            sizeofracList--;
            return true;
        }
        else if(sizeofwaitinglist>0){
            waitingList.offer(this);
            this.ticketType="waiting";
            sizeofwaitinglist--;
            return true;
        }

        return false;
    }
    public Passenger cancelTicket(){
      if(this.ticketType.equals("confirm")){
          for(Passenger p:confirmList){
              if(p.id==this.id){
                  confirmList.remove(p);
                  for(Map.Entry<Character,Integer>entry: berth.entrySet()){
                      if(entry.getKey().equals(this.allotedBerth)){
                          entry.setValue(entry.getValue()+1);
                      }
                  }
                  Passenger pass=racList.poll();
                  Passenger passenger=waitingList.poll();
                  if(passenger!=null){
                  sizeofwaitinglist++;
                  passenger.ticketType="rac";
                  racList.add(passenger);
//                  sizeofracList++;
                  sizeofConfirmList++;
                  }
                  return pass;
              }
          }
      } else if (this.ticketType.equals("rac")) {
          for(Passenger p:racList){
              if(p.id==this.id){
                  racList.remove(p);
//                  for(Map.Entry<Character,Integer>entry: berth.entrySet()){
//                      if(entry.getKey().equals(this.allotedBerth)){
//                          entry.setValue(entry.getValue()+1);
//                      }
//                  }
                  Passenger pass=waitingList.poll();
                  sizeofracList++;
                  sizeofwaitinglist++;
                  return pass;
              }
          }
      } else if (this.ticketType.equals("waiting")) {
          for(Passenger p:waitingList) {
              if (p.id == this.id) {
                  waitingList.remove(p);
                  sizeofwaitinglist++;
              }
          }
      }
        return null;
    }
    public static void printAvailable(){
        for(Map.Entry<Character,Integer>entries: berth.entrySet()){
            System.out.println(entries.getKey() +" "+ entries.getValue());
        }
    }
}
