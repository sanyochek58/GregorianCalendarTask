import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = readInt(input);

            if (command == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            switch (command) {
                case 1:
                    System.out.print("Введите год: ");
                    int year = readInt(input);
                    CalendarService service = new CalendarServiceImpl(year);
                    service.printCalendarInfo();
                    break;

                case 2:
                    System.out.print("Введите год: ");
                    int dowYear = readInt(input);
                    System.out.print("Введите день (1-31): ");
                    int day = readInt(input);
                    System.out.print("Введите месяц (1-12): ");
                    int month = readInt(input);
                    CalendarService dowService = new CalendarServiceImpl(dowYear);
                    System.out.println("День недели: " + dowService.getDayOfWeek(day, month));
                    break;

                default:
                    System.out.println("Неизвестная команда, попробуйте ещё раз.");
                    break;
            }
        }

        input.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Меню:");
        System.out.println("1 - Вывести информацию о годе и всех его месяцах");
        System.out.println("2 - Узнать день недели по дате");
        System.out.println("0 - Выход");
        System.out.print("Введите команду: ");
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Введите целое число: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
