package control;

import entity.Booking;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import session.BookingFacade;

@Named(value = "bookingController")
@SessionScoped
public class BookingController implements Serializable {

    @EJB
    private BookingFacade bookingFacade;

    private Booking booking;
    private Booking selectedBooking;

    @PostConstruct
    public void init() {
        booking = new Booking(); // تهيئة الحجز الجديد
        selectedBooking = null; // تهيئة الحجز المحدد
    }

    // Getters and Setters
    public BookingFacade getBookingFacade() {
        return bookingFacade;
    }

    public void setBookingFacade(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Booking getSelectedBooking() {
        return selectedBooking;
    }

    public void setSelectedBooking(Booking selectedBooking) {
        this.selectedBooking = selectedBooking;
    }

    public List<Booking> findAll() {
        return this.bookingFacade.findAll(); // جلب جميع الحجوزات
    }

    // إضافة حجز جديد
    public String insert() {
        try {
            this.bookingFacade.create(booking);
            this.booking = new Booking(); // إعادة تعيين الحجز
            resetForm();
            showMessage("Success", "تمت إضافة الحجز بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في إضافة الحجز: " + e.getMessage());
        }
        return "booking_data.xhtml?faces-redirect=true"; // الصفحة التي سيتم توجيه المستخدم إليها بعد الإضافة
    }

    // تحديث الحجز
    public String update() {
        try {
            this.bookingFacade.edit(selectedBooking);
            showMessage("Success", "تم تحديث الحجز بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في تحديث الحجز: " + e.getMessage());
        }
        return "dr_booking.xhtml?faces-redirect=true";
    }

    // حذف الحجز
    public String delete(Booking booking) {
        try {
            bookingFacade.remove(booking);
            showMessage("Success", "تم حذف الحجز بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في حذف الحجز: " + e.getMessage());
        }
        return null;
    }

    // تحميل الحجز للتعديل
    public String edit(Booking booking) {
        this.selectedBooking = booking;
        return "update_booking.xhtml?faces-redirect=true";
    }

    // إعادة تعيين النموذج
    private void resetForm() {
        booking = new Booking(); // إعادة تعيين الحجز
        selectedBooking = null; // إعادة تعيين الحجز المحدد
    }

    // عرض رسالة
    private void showMessage(String severity, String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, message));
    }
}