import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarServiceImpl implements CalendarService{

    private final Calendar calendar;

    /**
     * Конструктор с 1 параметром
     * @param year - Параметр "Год", для которого нужно вывести информацию
     */
    public CalendarServiceImpl(int year){
        this.calendar = new GregorianCalendar(year, Calendar.JANUARY, 1);
        calendar.setLenient(true);
    }

    /**
     * Метод геттер, возвращает текущий объект с типом Calendar
     * @return - возвращает текущий объект calendar
     */
    public Calendar getCalendar(){
        return this.calendar;
    }

    /**
     * Главный функционал
     * Метод printCalendarInfo - Метод, который выводит информацию о всех месяцах,
     * в цикле вызывает метод getMonthInfo для получения информации о конкретном месяце
     */
    @Override
    public void printCalendarInfo(){
        System.out.println("Год: " + this.calendar.get(Calendar.YEAR) + "\n" + "Статус: " + printLeapInfo(this.calendar.get(Calendar.YEAR)));
        for(int i = 1; i < 13; i++){
            getMonthInfo();
        }
    }

    /**
     * Метод getMonthInfo - Метод, который выводит информацию об определённом месяце и изменяет счётчик даты
     * в теле вызывает метод pipelinePrintMonthInfo
     */
    private void getMonthInfo(){
        switch(this.calendar.get(Calendar.MONTH)){

            case Calendar.JANUARY , Calendar.MARCH , Calendar.MAY , Calendar.JULY , Calendar.AUGUST , Calendar.OCTOBER , Calendar.DECEMBER:
                pipelinePrintMonthInfo(31);
                break;

            case Calendar.APRIL , Calendar.JUNE , Calendar.SEPTEMBER , Calendar.NOVEMBER:
                pipelinePrintMonthInfo(30);
                break;

            case Calendar.FEBRUARY:
                pipelinePrintMonthInfo(isLeap(this.calendar.get(Calendar.YEAR)) ? 29 : 28);
                break;

            default:
                System.out.println("Таких месяцев нет !");
                break;
        }
    }

    /**
     * Метод pipelinePrintMonthInfo - Метод, который печатает номер текущего месяца, выводит его дни через printInfoTimeAndPlusDayPipeline и переводит календарь на следующий месяц
     * @param daysInMonth - Параметр "Количество дней в месяце", сколько дней нужно вывести
     */
    private void pipelinePrintMonthInfo(int daysInMonth){
        System.out.println("Месяц: " + this.calendar.get(Calendar.MONTH));
        printInfoTimeAndPlusDayPipeline(daysInMonth);
        calendar.roll(Calendar.MONTH, 1);
    }

    /**
     * Метод printInfoTimeAndPlusDayPipeline - Метод, который в цикле выводит текущую дату календаря и переводит его на следующий день
     * @param n - Параметр "Количество дней", сколько раз повторить вывод даты
     */
    private void printInfoTimeAndPlusDayPipeline(int n){
        for(int i = 0; i < n; i++){
            System.out.println(calendar.getTime());
            calendar.roll(Calendar.DAY_OF_MONTH, 1);
        }
    }


    /**
     * Метод isLeap - Метод, который проверяет год на високосность
     * @param year - Параметр "Год", который нужно проверить
     * @return - true, если год високосный, иначе false
     */
    public static boolean isLeap(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    /**
     * Метод printLeapInfo - Метод, который возвращает текстовое описание високосности года
     * @param year - Параметр "Год", для которого нужно получить описание
     * @return - строка "Високосный" или "Не високосный"
     */
    public static String printLeapInfo(int year){
        if(isLeap(year)){
            return "Високосный";
        }
        else{
            return "Не високосный";
        }
    }

}
