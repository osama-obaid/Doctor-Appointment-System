package control;

import ob.HashUtil;
import entity.Users;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import session.UsersFacade;

@Named(value = "userManagementBean")
@SessionScoped
public class UserManagementBean implements Serializable {

    @EJB
    private UsersFacade usersFacade;
    private Users user;
    private Users selectedUser;
    private List<Users> users;

    @PostConstruct
    public void init() {
        user = new Users(); // تهيئة المستخدم الجديد
        selectedUser = null; // تهيئة المستخدم المحدد
        users = usersFacade.findAll(); // جلب جميع المستخدمين
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Users selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    // إضافة مستخدم جديد
    public String addUser() {
        try {
            // تشفير كلمة المرور باستخدام SHA-256
            String hashedPassword = HashUtil.sha256(user.getPassword());
            user.setPassword(hashedPassword);

            usersFacade.create(user);
            resetForm();
            showMessage("Success", "تمت إضافة المستخدم بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في إضافة المستخدم: " + e.getMessage());
        }
        return null;
    }
    
     public String registerUser() {
        try {
            // تشفير كلمة المرور باستخدام SHA-256
            String hashedPassword = HashUtil.sha256(user.getPassword());
            user.setPassword(hashedPassword);

            usersFacade.create(user);
            resetForm();
            showMessage("Success", "تمت إضافة المستخدم بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في إضافة المستخدم: " + e.getMessage());
        }
        return "login.xhtml";
    }

    // تعديل مستخدم موجود
    public String updateUser() {
        try {
            // تشفير كلمة المرور إذا تم تغييرها
            if (selectedUser.getPassword() != null && !selectedUser.getPassword().isEmpty()) {
                String hashedPassword = HashUtil.sha256(selectedUser.getPassword());
                selectedUser.setPassword(hashedPassword);
            }

            usersFacade.edit(selectedUser);
            resetForm();
            showMessage("Success", "تم تحديث المستخدم بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في تحديث المستخدم: " + e.getMessage());
        }
        return null;
    }

    // حذف مستخدم
    public String deleteUser(Users user) {
        try {
            usersFacade.remove(user);
            showMessage("Success", "تم حذف المستخدم بنجاح!");
        } catch (Exception e) {
            showMessage("Error", "فشل في حذف المستخدم: " + e.getMessage());
        }
        return null;
    }

    // تحميل بيانات المستخدم للتعديل
    public void editUser(Users user) {
        this.selectedUser = user;
        this.user = new Users(user); // نسخ البيانات باستخدام constructor copy
    }

    // إعادة تعيين النموذج
    private void resetForm() {
        user = new Users();
        selectedUser = null;
        users = usersFacade.findAll(); // تحديث قائمة المستخدمين
    }

    // عرض رسائل
    private void showMessage(String severity, String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, message));
    }
}