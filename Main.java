import java.text.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat date_format = new SimpleDateFormat("dd.MM.yyyy");

        // Ввод первой даты
        System.out.println("Введите дату в формате dd.MM.yyyy:");
        String date_string_1 = scanner.nextLine();
        Date date_1;
        try {
            date_1 = date_format.parse(date_string_1);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты");
            scanner.close();
            return;
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date_1);

        // Увеличение на 45 дней
        calendar.add(Calendar.DAY_OF_MONTH, 45);
        System.out.println("Дата после увеличения на 45 дней: " + date_format.format(calendar.getTime()));

        // Сдвиг на начало года
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        System.out.println("Дата после сдвига на начало года: " + date_format.format(calendar.getTime()));

        calendar.setTime(date_1);

        // Увеличение на 10 рабочих дней
        int working_days = 10;
        int counter = 0;
        while (counter < working_days) {
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                ++counter;
            }
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + date_format.format(calendar.getTime()));

        // Ввод второй даты
        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String date_string_2 = scanner.nextLine();
        Date date_2;
        try {
            date_2 = date_format.parse(date_string_2);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты");
            scanner.close();
            return;
        }

        // Подсчет рабочих дней между датами
        int count_days = 0;
        Calendar calendar_1 = Calendar.getInstance();
        calendar_1.setTime(date_1);
        Calendar calendar_2 = Calendar.getInstance();
        calendar_2.setTime(date_2);
        if (calendar_1.after(calendar_2)) {
            Calendar temp = calendar_1;
            calendar_1 = calendar_2;
            calendar_2 = temp;
        }
        while (calendar_1.before(calendar_2)) {
            calendar_1.add(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar_1.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                ++count_days;
            }
        }
        System.out.println("Количество рабочих дней между введенными датами: " + count_days);

        scanner.close();
    }
}