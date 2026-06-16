package service;

import model.Booking;
import model.Guest;
import model.Room;

import java.util.*;

public class HotelService {

    private ArrayList<Guest> guests = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

    private HashMap<String, Room> rooms = new HashMap<>();

    private int bookingCounter = 1;

    public void addGuest(Guest guest) {
        guests.add(guest);
    }

    public void addRoom(String roomNumber,
                        String type,
                        double price) {

        if (price <= 0) {
            System.out.println("Цена должна быть больше 0");
            return;
        }

        rooms.put(roomNumber,
                new Room(roomNumber, type, price));
    }

    private Guest findGuest(int id) {
        for (Guest guest : guests) {
            if (guest.getId() == id) {
                return guest;
            }
        }
        return null;
    }

    public void checkIn(String roomNumber,
                        int guestId,
                        int nights) {

        Room room = rooms.get(roomNumber);

        if (room == null) {
            System.out.println("Номер не найден");
            return;
        }

        if (findGuest(guestId) == null) {
            System.out.println("Гость не найден");
            return;
        }

        if (room.isOccupied()) {
            System.out.println("Номер занят");
            return;
        }

        if (nights <= 0) {
            System.out.println("Количество ночей должно быть > 0");
            return;
        }

        room.setGuestId(guestId);
        room.setOccupied(true);

        bookings.add(
                new Booking(
                        bookingCounter++,
                        roomNumber,
                        "CHECK_IN",
                        nights,
                        "Заселение"
                )
        );
    }

    public void checkOut(String roomNumber) {

        Room room = rooms.get(roomNumber);

        if (room == null) {
            System.out.println("Номер не найден");
            return;
        }

        if (!room.isOccupied()) {
            System.out.println("Номер уже свободен");
            return;
        }

        bookings.add(
                new Booking(
                        bookingCounter++,
                        roomNumber,
                        "CHECK_OUT",
                        0,
                        "Выселение"
                )
        );

        room.setGuestId(0);
        room.setOccupied(false);
    }

    public void extendStay(String roomNumber,
                           int additionalNights) {

        Room room = rooms.get(roomNumber);

        if (room == null) {
            System.out.println("Номер не найден");
            return;
        }

        if (additionalNights <= 0) {
            System.out.println("Неверное количество ночей");
            return;
        }

        bookings.add(
                new Booking(
                        bookingCounter++,
                        roomNumber,
                        "EXTEND",
                        additionalNights,
                        "Продление"
                )
        );
    }

    public void getRoomInfo(String roomNumber) {

        Room room = rooms.get(roomNumber);

        if (room == null) {
            System.out.println("Номер не найден");
            return;
        }

        System.out.println(room);
    }

    public void showRoomHistory(String roomNumber) {

        for (Booking booking : bookings) {
            if (booking.getRoomNumber()
                    .equals(roomNumber)) {

                System.out.println(booking);
            }
        }
    }

    public double getTotalRevenue() {

        double total = 0;

        for (Booking booking : bookings) {

            if (booking.getType().equals("CHECK_IN")
                    || booking.getType().equals("EXTEND")) {

                Room room = rooms.get(
                        booking.getRoomNumber());

                total += room.getPricePerNight()
                        * booking.getNights();
            }
        }

        return total;
    }

    public void showAvailableRooms(String type) {

        for (Room room : rooms.values()) {

            if (!room.isOccupied()
                    && room.getType().equals(type)) {

                System.out.println(room);
            }
        }
    }

    public void guestWithMaxNights() {
        HashMap<Integer, Integer> map =
                new HashMap<>();

        for (Booking booking : bookings) {

            if (booking.getType()
                    .equals("CHECK_IN")) {

                Room room =
                        rooms.get(
                                booking.getRoomNumber());

                int guestId =
                        room.getGuestid();

                map.put(
                        guestId,
                        map.getOrDefault(
                                guestId,
                                0
                        ) + booking.getNights()
                );
            }
        }
        int maxGuest = -1;
        int maxNights = 0;

        for (Integer id : map.keySet()) {
            if (map.get(id) > maxNights) {
                maxNights = map.get(id);
                maxGuest = id;
            }
        }
        System.out.println(
                "Гость GST-" + maxGuest +
                        ", ночей: " + maxNights
        );
    }
}
