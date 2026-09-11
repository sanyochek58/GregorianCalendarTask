public class Main {
    public static void main(String[] args) {

        CalendarService service = new CalendarServiceImpl(1600);
        service.printCalendarInfo();
    }
}
