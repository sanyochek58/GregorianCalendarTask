import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CalendarServiceImplTest {

    private CalendarService calendarService;

    public CalendarServiceImplTest(){
        calendarService = new CalendarServiceImpl(1601);
    }

    @Test
    @DisplayName("Год, кратный 400 - високосный")
    public void testIsLeapYear_divisaible400(){
        assertTrue(CalendarServiceImpl.isLeap(1600));
    }

    @Test
    @DisplayName("Год, кратный 100, но не кратный 400 - не високосный")
    public void testIsLeapYear_divisaible100Only(){
        assertFalse(CalendarServiceImpl.isLeap(1900));
    }

    @Test
    @DisplayName("Год, кратный 4, но не 100 - високосный")
    public void testIsLeapYear_divisaible4(){
        assertTrue(CalendarServiceImpl.isLeap(2000));
    }

    @Test
    @DisplayName("Год, не кратный 4 - не високосный")
    public void testIsLeapYear_notDivisaible4(){
        assertFalse(CalendarServiceImpl.isLeap(2001));
    }

    @Test
    @DisplayName("Вывод информации на високосность: 2000 - високосный")
    public void testPrintInfo_LeapYear(){
        assertEquals("Високосный", CalendarServiceImpl.printLeapInfo(2000));
    }

    @Test
    @DisplayName("Вывод информации на високосность: 2001 - не високосный")
    public void testPrintInfo_notLeapYear(){
        assertEquals("Не високосный", CalendarServiceImpl.printLeapInfo(2001));
    }

    @Test
    @DisplayName("Вывод на не соответствие не високосности")
    public void testPrintInfo_leapYearNotEquals(){
        assertNotEquals("Не високосный",  CalendarServiceImpl.printLeapInfo(2000));
    }

    @Test
    @DisplayName("Вывод на не соответствие високосности")
    public void testPrintInfo_NotLeapYearNotEquals(){
        assertNotEquals("Високосный",  CalendarServiceImpl.printLeapInfo(2001));
    }

}
