package case_study.service.impl;

import case_study.model.booking.Booking;
import case_study.model.customer.Customer;
import case_study.model.furama_resort.Facility;
import case_study.service.IBooking;
import case_study.service.exception.CheckException;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BookingService implements IBooking {
    private static final Scanner scan = new Scanner(System.in);

    private static final Queue<Booking> bookings = new LinkedList<>();

    private static final String DAY_OF_MONTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    public void addBooking() throws IOException {
        System.out.println("------This is list customer-----");
        CustomerService customerService = new CustomerService();
        customerService.displayCustomer();
        System.out.println("-------Enter customer id to select-------");
        String idCustomerNewAdd = scan.nextLine();
        Customer customer = customerService.findCustomerId(idCustomerNewAdd);

        System.out.println("--------This is list service");
        FacilityService facilityService = new FacilityService();
        facilityService.displayFacility();
        System.out.println("Enter Facility Service");
        String serviceId = scan.nextLine();
        Facility facility = facilityService.findFacilityId(serviceId);

        int bookingId = this.createId();

        String starDay;
        while (true) {
            try {
                System.out.println("Enter start day");
                starDay = scan.nextLine();
                if (!starDay.matches(DAY_OF_MONTH)) {
                    throw new CheckException("Enter day is not format, again");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        }

        String endDay;
        while (true) {
            try {
                System.out.println("Enter end day");
                endDay = scan.nextLine();
                if (!starDay.matches(DAY_OF_MONTH)) {
                    throw new CheckException("Enter day is not format, again");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        }

        Booking booking = new Booking(bookingId, starDay, endDay, customer.getCustomerId(), facility.getNameService(), facility.getRentalType());
        bookings.add(booking);
        System.out.println("Access add");

        int value = FacilityService.facilities.get(facility);
        int newValue = value + 1;
        FacilityService.facilities.replace(facility, newValue);
    }

    @Override
    public void displayBooking() {
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    private int createId() {
        return bookings.size() + 1;
    }
}
