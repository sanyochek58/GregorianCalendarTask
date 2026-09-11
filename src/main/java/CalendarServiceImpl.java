import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarServiceImpl implements CalendarService{

    private final Calendar calendar;

    public CalendarServiceImpl(int year){
        this.calendar = new GregorianCalendar(year, Calendar.JANUARY, 1);
        calendar.setLenient(true);
    }

    public Calendar getCalendar(){
        return this.calendar;
    }

    @Override
    public void printCalendarInfo(){
        System.out.println("Год: " + this.calendar.get(Calendar.YEAR) + "\n" + "Статус: " + printLeapInfo(this.calendar.get(Calendar.YEAR)));
        for(int i = 1; i < 13; i++){
            getMonthInfo();
        }
    }

    private void getMonthInfo(){
        switch(this.calendar.get(Calendar.MONTH)){

            case Calendar.JANUARY , Calendar.MARCH , Calendar.MAY , Calendar.JULY , Calendar.AUGUST , Calendar.OCTOBER , Calendar.DECEMBER:
                System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
                for(int i = 0; i < 31;  i++){
                    System.out.println(calendar.getTime());
                    calendar.roll(Calendar.DAY_OF_MONTH, 1);
                }
                calendar.roll(Calendar.MONTH, 1);
                break;

            case Calendar.APRIL , Calendar.JUNE , Calendar.SEPTEMBER , Calendar.NOVEMBER:
                System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
                for(int i = 0; i < 30;  i++){
                    System.out.println(calendar.getTime());
                    calendar.roll(Calendar.DAY_OF_MONTH, 1);
                }
                calendar.roll(Calendar.MONTH, 1);
                break;

            case Calendar.FEBRUARY:

                System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
                if(isLeap(this.calendar.get(Calendar.YEAR))) {
                    for (int i = 0; i < 29; i++) {
                        System.out.println(calendar.getTime());
                        calendar.roll(Calendar.DAY_OF_MONTH, 1);
                    }
                }
                else{
                    for (int i = 0; i < 28; i++) {
                        System.out.println(calendar.getTime());
                        calendar.roll(Calendar.DAY_OF_MONTH, 1);
                    }
                }
                calendar.roll(Calendar.MONTH, 1);
                break;

            default:
                System.out.println("Таких месяцев нет !");
                break;
        };
    }

    private static boolean isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static String printLeapInfo(int year){
        if(isLeap(year)){
            return "Високосный";
        }
        else{
            return "Не високосный";
        }
    }

}
