package case_study.model.booking;

public class Booking {
    private int bookingId;
    private String dayStart;
    private String dayEnd;
    private String customerBookingId;
    private String nameServiceBooking;
    private String typeService;

    public Booking() {
    }

    public Booking(int bookingId, String dayStart, String dayEnd, String customerBookingId, String nameServiceBooking, String typeService) {
        this.bookingId = bookingId;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerBookingId = customerBookingId;
        this.nameServiceBooking = nameServiceBooking;
        this.typeService = typeService;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCustomerBookingId() {
        return customerBookingId;
    }

    public void setCustomerBookingId(String customerBookingId) {
        this.customerBookingId = customerBookingId;
    }

    public String getNameServiceBooking() {
        return nameServiceBooking;
    }

    public void setNameServiceBooking(String nameServiceBooking) {
        this.nameServiceBooking = nameServiceBooking;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s", bookingId, dayStart, dayEnd, customerBookingId, nameServiceBooking, typeService);
    }
}
