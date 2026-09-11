import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarServiceImpl implements CalendarService{

    private final Calendar calendar;

    public CalendarServiceImpl(int year){
        this.calendar = new GregorianCalendar(year, Calendar.JANUARY, 1);
    }

    public Calendar getCalendar(){
        return this.calendar;
    }

    @Override
    public void printCalendarInfo(){
        for(int i = 1; i < 13; i++){
            getMonthInfo();
        }
    }

    private void getMonthInfo(){
        switch(this.calendar.get(Calendar.MONTH)){

            case Calendar.JANUARY , Calendar.MARCH , Calendar.MAY , Calendar.JULY , Calendar.AUGUST , Calendar.OCTOBER , Calendar.DECEMBER:
                System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
                for(int i = 1; i < 32;  i++){
                    calendar.roll(Calendar.DAY_OF_MONTH, 1);
                    System.out.println(calendar.getTime());
                }
                calendar.roll(Calendar.MONTH, 1);
                break;

            case Calendar.APRIL , Calendar.JUNE , Calendar.SEPTEMBER , Calendar.NOVEMBER:
                System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
                for(int i = 1; i < 31;  i++){
                    calendar.roll(Calendar.DAY_OF_MONTH, 1);
                    System.out.println(calendar.getTime());
                }
                calendar.roll(Calendar.MONTH, 1);
                break;

            case Calendar.FEBRUARY:
                // TODO( Реализовать функцию проверки на високосный год )
                System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
                for(int i = 1; i < 29;  i++){
                    calendar.roll(Calendar.DAY_OF_MONTH, 1);
                    System.out.println(calendar.getTime());
                }
                calendar.roll(Calendar.MONTH, 1);
                break;

            default:
                System.out.println("Таких месяцев нет !");
                break;
        };
    }


}
