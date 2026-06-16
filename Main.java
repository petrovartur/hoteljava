package main;

import model.Guest;
import service.HotelService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelService hotel = new HotelService();

        while(true) {

            System.out.println("""
                    
                    1. Добавить гостя
                    2. Добавить номер
                    3. Заселить
                    4. Выселить
                    5. Продлить проживание
                    6. Информация о номере
                    7. История номера
                    0. Выход
                    """);

            int choice = sc.nextInt();

            switch(choice) {

                case 1 {
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ФИО: ");
                    String name = sc.nextLine();

                    System.out.print("Паспорт: ");
                    String passport = sc.nextLine();

                    hotel.addGuest(
                            new Guest(
                                    id,
                                    name,
                                    passport
                            )
                    );
                }

                case 2 {
                    System.out.print("Номер: ");
                    String room = sc.next();

                    System.out.print("Тип: ");
                    String type = sc.next();

                    System.out.print("Цена: ");
                    double price = sc.nextDouble();

                    hotel.addRoom(room, type, price);
                }

                case 3 {
                    System.out.print("Номер: ");
                    String room = sc.next();

                    System.out.print("ID гостя: ");
                    int id = sc.nextInt();

                    System.out.print("Ночей: ");
                    int nights = sc.nextInt();

                    hotel.checkIn(room, id, nights);
                }

                case 4 {
                    System.out.print("Номер: ");
                    hotel.checkOut(sc.next());
                }

                case 5 {
                    System.out.print("Номер: ");
                    String room = sc.next();

                    System.out.print("Доп. ночей: ");
                    int nights = sc.nextInt();

                    hotel.extendStay(room, nights);
                }

                case 6 {
                    System.out.print("Номер: ");
                    hotel.getRoomInfo(sc.next());
                }

                case 7 {
                    System.out.print("Номер: ");
                    hotel.showRoomHistory(sc.next());
                }

                case 0 {
                    return;
                }

                default
                        System.out.println("Ошибка");
            }
        }
    }
}
