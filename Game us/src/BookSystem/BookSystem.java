package BookSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class BookSystem {
    public static void main(String[] args) {
        ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
        lecturers.add(new Lecturer("1234", "heema"));
        Scanner input = new Scanner(System.in);
        String Menu = "**The Main Menu**\n" +
                "1.  Lecturer menu\n" +
                "2.  Appointment menu\n" +
                "3.  Report menu\n" +
                "4.  Exit the system";
        String LecturerMenu="* Lecturer Menu***\n" +

                "1.  Add new Lecturer.\n" +
                "2.  Delete Lecturer.\n" +
                "3.  Show Lecturer.\n" +
                "4.  return to main menu.";
        String ModificationMenu = "**Modification Menu**\n"
                +"A. Add new Appointment.\n"
                + "D. Delete Appointment.\n" +
                "P. Postpone Appointment.\n" +
                "C. Change appointment status.\n" +
                "R. Return to main menu.";
        String Reportmenu ="**Report menu**\n"+

                "1. display all appointments for a specified day.\n" +
                "2. display appointment for a specified lecturer.\n" +
                "3. return to main menu.";
        String vf = "5";
        System.out.println(vf + 5);
        System.exit(0);
        while (true) {
            System.out.println(Menu);
            System.out.print("enter your choes : ");
            int menunum = input.nextInt();
            int choes = 0 ;
            String id = "";
            String name = " ";
            String yOn;
            while (choes!=4) {
                switch(menunum){
                    case 1 :
                        System.out.println(LecturerMenu);
                        System.out.print("enter your choes : ");
                        choes = input.nextInt();
                        switch(choes){
                            case 1 :
                                System.out.print("enter the Lecturer id : ");
                                id = input.next();
                                System.out.print("enter the Lecturer name : ");
                                name = input.next();
                                lecturers.add(new Lecturer(id, name));
                                break;
                            case 2 :
                                System.out.print("enter the Lecturer id : ");
                                id = input.next();
                                while (!testId(id, lecturers)) {
                                    System.out.print("The lecturer is not exits, Do you want try again(y/n)?");
                                    yOn = input.next();
                                    if (yOn.equalsIgnoreCase("y")) {
                                        System.out.print("enter the Lecturer id : ");
                                        id = input.next();
                                    }
                                }
                                System.out.println("The lecturer no : "+id+" ,The lecturer name : "+getName(id, lecturers));
                                remove(id, lecturers);
                                System.out.println("Delete is done");
                                break;
                            case 3 :
                                print(lecturers);
                                break;
                            case 4 :
                                break;
                            default:
                        }
                        break;
                    case 2 :
                        System.out.println(ModificationMenu);
                        System.out.print("enter your choes : ");
                        choes = input.nextInt();
                        switch(choes){
                            case 1 :
                                System.out.print("enter the Lecturer id : ");
                                id = input.next();
                                while (!testId(id, lecturers)) {
                                    System.out.print("The lecturer is not exits, Do you want try again(y/n)?");
                                    yOn = input.next();
                                    if (yOn.equalsIgnoreCase("y")) {
                                        System.out.print("enter the Lecturer id : ");
                                        id = input.next();
                                    }
                                }
                                System.out.println("Enter day Date: ");
                                String data = input.next();
                                int [] aa = findClass(id, lecturers).getSlots(data);
                                for (int i = 0; i < aa.length; i++) {
                                    System.out.println(aa[i]);
                                }

                                System.out.print("Enter the time slot No. : ");
                                int timeSlot = input.nextInt();
                                findClass(id, lecturers).addSlots(data, timeSlot);
                                int time = 0 ;
                                for (int i = 0; i < aa.length; i++) {
                                    if (i==timeSlot) {
                                        time=i;
                                    }
                                }
                                System.out.println("The appointment is reserved for lecturer in "+time );
                                break;
                            case 2:
                                System.out.println("Enter lecturer number: ");
                                String IdL = input.next();
                                while (!testId(IdL,lecturers)){
                                    System.out.println("the Id Is not true Please try Again");
                                    System.out.println("Do you want try again(y/n)?");
                                    String again = input.next();
                                    if (again.charAt(0) == 'N')
                                        break;
                                    System.out.println("Enter lecturer number: ");
                                    IdL = input.next();
                                }
                                if (testId(IdL,lecturers)){
                                    System.out.printf("The lecturer no : %s ," +
                                            "The lecturer name :%s.",IdL,findClass(IdL,lecturers).name);
                                    findClass(IdL,lecturers).printSlots();
                                    System.out.println("Enter Srn : ");
                                    int x = input.nextInt();
                                    findClass(IdL,lecturers).deleteAppointment(x);
                                }
                                break;
                            case 3 :
                                System.out.print("enter the Lecturer id : ");
                                id = input.next();
                                while (!testId(id, lecturers)) {
                                    System.out.print("The lecturer is not exits, Do you want try again(y/n)?");
                                    yOn = input.next();
                                    if (yOn.equalsIgnoreCase("y")) {
                                        System.out.print("enter the Lecturer id : ");
                                        id = input.next();
                                    }
                                }
                                System.out.print("Enter appointment SRN : ");
                                int ser = input.nextInt();
                                System.out.print("Enter the new day date: ");
                                String dd = input.next();
                                int [] q = findClass(id, lecturers).getSlots(dd);
                                for (int i = 0; i < q.length; i++) {
                                    System.out.println(q[i]);
                                }
                                System.out.print("Enter the 8me slot No. : ");
                                int tow = input.nextInt();
                                findClass(id, lecturers).postpone(name, ser, tow);

                                break;

                        }
                        break;
                    case 3 :
                        System.out.println(Reportmenu);
                        System.out.print("enter your choice : ");
                        choes = input.nextInt();
                        while (choes != 3){
                            switch (choes){
                                case 1 :
                                    System.out.print("Enter Day : ");
                                    String day = input.next();
                                    System.out.println();
                                    System.out.println("Date                      State         name");
                                    printAllSlotsDay(lecturers,day);
                                    break;
                                case 2 :
                                    System.out.print("Enter The Id For lecturer : ");
                                    String idT = input.next();
                                    Lecturer temp = findClass(idT,lecturers);
                                    if (testId(idT,lecturers)){
                                        temp.printSlots();
                                    }else{
                                        System.out.println("the Id Is not Exist ");
                                    }
                                    break;
                            }
                            System.out.println(Reportmenu);
                            System.out.print("enter your choice : ");
                            choes = input.nextInt();
                        }

                        break;
                    case 4 :
                        System.exit(0);
                }
            }
        }
    }
    public static void printAllSlotsDay(ArrayList<Lecturer> array , String time ){
        for (int i = 0; i < array.size(); i++) {
            array.get(i).printSlotsDay(time);
        }
    }
    public static boolean testId(String a , ArrayList<Lecturer> lecturers){
        for (int i = 0; i < lecturers.size(); i++) {
            if (a.equals(lecturers.get(i).id)) {
                return true;
            }
        }
        return false ;
    }
    public static String getName(String a , ArrayList<Lecturer> lecturers){
        String name = " ";

        for (int i = 0; i < lecturers.size(); i++) {
            if (a.equals(lecturers.get(i).id)) {
                name = lecturers.get(i).name;
            }
        }
        return name ;
    }
    public static void remove(String a , ArrayList<Lecturer> lecturers){

        for (int i = 0; i < lecturers.size(); i++) {
            if (a.equals(lecturers.get(i).id)) {
                lecturers.remove(i);
            }
        }
    }
    public static void print(ArrayList<Lecturer> lecturers){

        for (int i = 0; i < lecturers.size(); i++) {
            System.out.println(lecturers.get(i).id+" : "+lecturers.get(i).name);
        }
    }
    public static Lecturer findClass(String id , ArrayList<Lecturer> lecturers){
        Lecturer a = null;
        for (int i = 0; i < lecturers.size(); i++) {
            if (lecturers.get(i).id.equals(id)) {
                a=lecturers.get(i);
            }
        }
        return a ;
    }
}
class Lecturer {
    String id;
    String name;
    ArrayList<Appointment> appointments;
    // appointment , hour(slots) , state
    ArrayList<ArrayList<Integer>> slotsM = new ArrayList<>();
    Lecturer(String id , String name){
        this.id = id ;
        this.name = name ;
        appointments = new ArrayList();
    }

    private boolean isSlotsExist(int indexAppointment , int indexSlots) {
        for (int i = 0; i < slotsM.size(); i++) {
            if (slotsM.get(i).get(0) == indexAppointment && slotsM.get(i).get(1)==indexSlots){
                return true ;
            }
        }
        return false;
    }
    public void printSlotsDay(String time ){
        if (checkDayExist(time)==-1)
            return ;
        Appointment temp = getAppointment(time);
        for (int i = 0; i < temp.stateSlots.length; i++) {
            if (temp.stateSlots[i]!=0){
                System.out.printf("%-24s  %-10s  %s \n",
                        temp.getStrDate(i), getTheState(temp.stateSlots[i]),name);
            }
        }
    }
    public int[] getSlots(String time){
        int index = checkDayExist(time);
        if (index!=-1){
            return appointments.get(index).stateSlots;
        }
        appointments.add(new Appointment(getDate(time)));
        return appointments.get(appointments.size()-1).stateSlots;
    }
    private GregorianCalendar getDate(String time){
        String[] temp = time.split("/");
        int day = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int year = Integer.parseInt(temp[2]);
        return new GregorianCalendar(year,month,day);
    }
    public Appointment getAppointment(String time){
        return appointments.get(checkDayExist(time));
    }
    public boolean addSlots(String time , int indexHour){
        Appointment temp ;
        int indexAppoint = checkDayExist(time);
        if (indexAppoint!= -1){
            temp = getAppointment(time);
            if (isSlotsExist(indexAppoint, indexHour))
                return false ;
        }else{
            temp = new Appointment(getDate(time));
            appointments.add(temp);
            indexAppoint = appointments.size() -1 ;
        }
        int[] slotsTemp = temp.stateSlots;
        if (slotsTemp[indexHour -1] == 0 ){
            slotsTemp[indexHour -1] = 1 ;
            slotsM.add(new ArrayList<>(Arrays.asList(indexAppoint , indexHour - 1 , 1 )));
            return true ;
        }
        return false ;
    }
    public int checkDayExist(String time) {
        for (int i = 0; i < appointments.size(); i++) {
            GregorianCalendar date = getDate(time);
            if (appointments.get(i).isTheSame(date)){
                return i ;
            }
        }
        return -1;
    }
    // rowIndex => index in slotsM
    public void deleteAppointment(int rowIndex){
        int indexAppointment = slotsM.get(rowIndex -1).get(0);
        int indexHour = slotsM.get(rowIndex-1).get(1);
        appointments.get(indexAppointment).stateSlots[indexHour] = 0 ;
        slotsM.remove(rowIndex);
    }
    public void printSlots(){
        System.out.println("SRN     Date /time                status");
        for (int i = 0; i < slotsM.size(); i++) {
            int indexA = slotsM.get(i).get(0);
            int indexS = slotsM.get(i).get(2);
            int indexHour = slotsM.get(i).get(1);
            System.out.printf("%d       %-24s  %-10s \n",i+1 ,
                    appointments.get(indexA).getStrDate(indexHour),getTheState(indexS));
        }

    }

    public boolean postpone(String time , int index , int newHour){
        int indexAppoint = checkDayExist(time);
        int indexHour = slotsM.get(index -1).get(1);
        System.out.println(indexAppoint + " " + indexHour);
        if (isSlotsExist(indexAppoint, indexHour)){
            System.out.println("false");
            return false ;
        }
        else{
            deleteAppointment(indexHour);
            addSlots(time, indexHour);
            System.out.println("dh");
            return true ;
        }
    }
    // choice between 2 & 3
    public boolean changeState(int indexAppointment  , int newState){
        int index = slotsM.get(indexAppointment-1).get(0);
        int indexHour = slotsM.get(indexAppointment- 1).get(1);
        slotsM.get(indexAppointment-1).set(2, newState -1);
        appointments.get(index).stateSlots[indexHour]=newState-1;
        return true ;
    }
    public String getTheState(int state){
        switch (state){
            case 0 :
                return "available";
            case 1 :
                return "pending";
            case 2 :
                return  "canceled";
            case 3:
                return "completed";
        }
        return "";
    }
    public String toString() {
        return "";
    }
}

class Appointment {
    // day
    GregorianCalendar time = new GregorianCalendar();
    // state slots
    /**
     * 0 => available
     * 1 => pending
     * 2 => canceled
     * 3 => completed
     * */
    int[] stateSlots = new int[10];

    Appointment() {

    }
    Appointment( GregorianCalendar time) {
        this.time = time;
        stateSlots = new int[10];
    }
    public String getStrDate(int hour){
        return getDay(time.get(GregorianCalendar.DAY_OF_WEEK)) + " " + time.get(GregorianCalendar.DAY_OF_MONTH)
                + " " + getMonth(time.get(GregorianCalendar.MONTH)) + " " + time.get(GregorianCalendar.YEAR) + " " + getStrHour(hour)  ;
    }
    public String getDay(int n){
        switch (n){
            case 1 :
                return "Fri";
            case 2 :
                return "Sat";
            case 3 :
                return "Sun";
            case 4 :
                return "Mon";
            case 5 :
                return "Tues";
            case 6 :
                return "Wen";
            case 7 :
                return "thu";
        }
        return "";
    }
    public String getMonth(int n){
        switch (n){
            case 1 :
                return "Jan" ;
            case 2 :
                return "Feb";
            case 3 :
                return "Mar";
            case 4 :
                return "Apr";
            case 5 :
                return "May";
            case 6 :
                return "Jun";
            case 7 :
                return "July";
            case 8 :
                return "Aug";
            case 9 :
                return "Sep";
            case 10 :
                return "Oct";
            case 11 :
                return "Nov";
            case 12 :
                return "Dec";
        }
        return "" ;
    }

    public String getStrHour(int n){
        return (n+8) + ":00";
    }

    boolean isTheSame(GregorianCalendar time2) {
        return time.equals(time2);
    }

}