package case_study.model.booking;

public class Booking {
    private String bookingId;
    private int dayStart;
    private int dayEnd;
    private String customerBookingId;
    private String nameServiceBooking;
    private String typeService;

    public Booking() {
    }

    public Booking(String bookingId, int dayStart, int dayEnd, String customerBookingId, String nameServiceBooking, String typeService) {
        this.bookingId = bookingId;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerBookingId = customerBookingId;
        this.nameServiceBooking = nameServiceBooking;
        this.typeService = typeService;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public int getDayStart() {
        return dayStart;
    }

    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(int dayEnd) {
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
