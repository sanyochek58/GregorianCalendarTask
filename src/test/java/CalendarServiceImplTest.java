import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CalendarServiceImplTest {

    private CalendarService calendarService;

    /**
     * Конструктор с 1 параметром
     * Инициализирует тестовый CalendarService для 1601 года
     */
    public CalendarServiceImplTest(){
        calendarService = new CalendarServiceImpl(1601);
    }

    /**
     * Метод testIsLeapYear_divisaible400 - Метод, который проверяет, что год, кратный 400, определяется как високосный
     */
    @Test
    @DisplayName("Год, кратный 400 - високосный")
    public void testIsLeapYear_divisaible400(){
        assertTrue(CalendarServiceImpl.isLeap(1600));
    }

    /**
     * Метод testIsLeapYear_divisaible100Only - Метод, который проверяет, что год, кратный 100, но не кратный 400, определяется как не високосный
     */
    @Test
    @DisplayName("Год, кратный 100, но не кратный 400 - не високосный")
    public void testIsLeapYear_divisaible100Only(){
        assertFalse(CalendarServiceImpl.isLeap(1900));
    }

    /**
     * Метод testIsLeapYear_divisaible4 - Метод, который проверяет, что год, кратный 4, но не кратный 100, определяется как високосный
     */
    @Test
    @DisplayName("Год, кратный 4, но не 100 - високосный")
    public void testIsLeapYear_divisaible4(){
        assertTrue(CalendarServiceImpl.isLeap(2000));
    }

    /**
     * Метод testIsLeapYear_notDivisaible4 - Метод, который проверяет, что год, не кратный 4, определяется как не високосный
     */
    @Test
    @DisplayName("Год, не кратный 4 - не високосный")
    public void testIsLeapYear_notDivisaible4(){
        assertFalse(CalendarServiceImpl.isLeap(2001));
    }

    /**
     * Метод testPrintInfo_LeapYear - Метод, который проверяет, что для високосного года возвращается строка "Високосный"
     */
    @Test
    @DisplayName("Вывод информации на високосность: 2000 - високосный")
    public void testPrintInfo_LeapYear(){
        assertEquals("Високосный", CalendarServiceImpl.printLeapInfo(2000));
    }

    /**
     * Метод testPrintInfo_notLeapYear - Метод, который проверяет, что для не високосного года возвращается строка "Не високосный"
     */
    @Test
    @DisplayName("Вывод информации на високосность: 2001 - не високосный")
    public void testPrintInfo_notLeapYear(){
        assertEquals("Не високосный", CalendarServiceImpl.printLeapInfo(2001));
    }

    /**
     * Метод testPrintInfo_leapYearNotEquals - Метод, который проверяет, что для високосного года результат не равен строке "Не високосный"
     */
    @Test
    @DisplayName("Вывод на не соответствие не високосности")
    public void testPrintInfo_leapYearNotEquals(){
        assertNotEquals("Не високосный",  CalendarServiceImpl.printLeapInfo(2000));
    }

    /**
     * Метод testPrintInfo_NotLeapYearNotEquals - Метод, который проверяет, что для не високосного года результат не равен строке "Високосный"
     */
    @Test
    @DisplayName("Вывод на не соответствие високосности")
    public void testPrintInfo_NotLeapYearNotEquals(){
        assertNotEquals("Високосный",  CalendarServiceImpl.printLeapInfo(2001));
    }

    /**
     * Метод testGetDayOfWeek_firstOfYear - Метод, который проверяет день недели для 1 января 1601 года
     */
    @Test
    @DisplayName("01.01.1601 - понедельник")
    public void testGetDayOfWeek_firstOfYear(){
        assertEquals("Понедельник", calendarService.getDayOfWeek(1, 1));
    }

    /**
     * Метод testGetDayOfWeek_midYear - Метод, который проверяет день недели для 12 июня 1601 года
     */
    @Test
    @DisplayName("12.06.1601 - вторник")
    public void testGetDayOfWeek_midYear(){
        assertEquals("Вторник", calendarService.getDayOfWeek(12, 6));
    }

    /**
     * Метод testGetDayOfWeek_lastOfYear - Метод, который проверяет день недели для 31 декабря 1601 года
     */
    @Test
    @DisplayName("31.12.1601 - понедельник")
    public void testGetDayOfWeek_lastOfYear(){
        assertEquals("Понедельник", calendarService.getDayOfWeek(31, 12));
    }

    /**
     * Метод testGetDayOfWeek_leapDayInNonLeapYear - Метод, который проверяет, что 29 февраля в не високосном 1601 году
     * корректно переносится календарём на 1 марта (setLenient(true))
     */
    @Test
    @DisplayName("29.02.1601 в не високосном году переносится на 01.03 - четверг")
    public void testGetDayOfWeek_leapDayInNonLeapYear(){
        assertEquals("Четверг", calendarService.getDayOfWeek(29, 2));
    }
}
