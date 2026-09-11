public interface CalendarService {
    /**
     * Метод printCalendarInfo - Метод, который выводит информацию о годе и обо всех его месяцах
     */
    void printCalendarInfo();

    /**
     * Метод getDayOfWeek - Метод, который определяет день недели по номеру дня и номеру месяца
     * @param day - Параметр "День", номер дня месяца (1-31)
     * @param month - Параметр "Месяц", номер месяца (1-12)
     * @return - название дня недели на русском языке
     */
    String getDayOfWeek(int day, int month);
}
