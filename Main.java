import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("1.Додати в кінець");
            System.out.println("2.Додати за індексом");
            System.out.println("3.Видалити за індексом");
            System.out.println("4.Отримати за індексом");
            System.out.println("5.Кількість елементів (size)");
            System.out.println("6.Місткість буфера (capacity)");
            System.out.println("7.Показати весь список");
            System.out.println("0.Вихід");
            System.out.print("Виберіть дію: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    System.out.print("Введіть число: ");
                    int val = Integer.parseInt(scanner.nextLine());
                    list.add(val);
                } else if (choice == 2) {
                    System.out.print("Введіть індекс: ");
                    int idx = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введіть число: ");
                    int val = Integer.parseInt(scanner.nextLine());
                    list.add(idx, val);
                } else if (choice == 3) {
                    System.out.print("Введіть індекс для видалення: ");
                    int idx = Integer.parseInt(scanner.nextLine());
                    list.remove(idx);
                } else if (choice == 4) {
                    System.out.print("Введіть індекс: ");
                    int idx = Integer.parseInt(scanner.nextLine());
                    System.out.println("Результат: " + list.get(idx));
                } else if (choice == 5) {
                    System.out.println("Елементів у списку: " + list.getSize());
                } else if (choice == 6) {
                    System.out.println("Розмір буфера: " + list.getCapacity());
                } else if (choice == 7) {
                    System.out.println("Список: " + list.toString());
                } else if (choice == 0) {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Помилка, вводьте тільки числа");
            } catch (Exception e) {
                System.out.println("Сталася помилка");
            }
        }
        scanner.close();
    }
}