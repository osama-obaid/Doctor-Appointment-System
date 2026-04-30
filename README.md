# Doctor-Appointment-System
This project is a Doctor Appointment Booking System developed using Java EE technologies. It allows patients to book appointments with doctors, manage their reservations, and interact with the system easily.
# 🏥 Medical Booking System (Doctor Appointment System)


The system is designed to simplify the booking process for clinics and improve the patient experience.

---

## 🚀 Features

* 👤 User Registration & Login
* 📅 Book Doctor Appointments
* 🗂 Manage Bookings (Create / View)
* 🧑‍⚕️ Admin Panel for managing users and appointments
* 🔐 Secure Authentication System
* 📊 Database Integration using JPA

---

## 🛠 Technologies Used

### Backend:

* Java (Java EE / Jakarta EE)
* JPA (Java Persistence API)

### Frontend:

* JSF (JavaServer Faces)
* XHTML
* CSS

### Server:

* GlassFish Server

### Build Tool:

* Apache Ant

### Database:

* MySQL (or any database supported via JPA)

---

## 📁 Project Structure

```
PROJECT_OSAMA/
│
├── src/
│   ├── java/          # Java classes
│   ├── conf/          # configuration (persistence.xml)
│   ├── web/           # frontend files (xhtml, css, js)
│
├── WEB-INF/           # web configuration
├── build/             # generated files
├── dist/              # WAR file
├── nbproject/         # NetBeans config
├── setup/             # server resources
│
├── build.xml          # Ant build file
├── *.sql              # database scripts
```

---

## ⚙️ Requirements

Before running the project, make sure you have the following installed:

* Java JDK 8 or later
* GlassFish Server
* NetBeans IDE (recommended)
* MySQL Server
* Git (for version control)

---

## 🧪 Database Setup

1. Open MySQL
2. Create a new database:

```sql
CREATE DATABASE medical_booking;
```

3. Import the following files:

* `H.sql`
* `salesdb.sql`

---

## ⚡ Configuration

Make sure to update the following file:

```
src/conf/persistence.xml
```

With your correct database credentials:

```xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/medical_booking"/>
<property name="javax.persistence.jdbc.user" value="root"/>
<property name="javax.persistence.jdbc.password" value="your_password"/>
```

---

## ▶️ How to Run

### Using NetBeans:

1. Open the project
2. Click Run
3. It will be automatically deployed to GlassFish

---

### Manually:

1. Build the WAR file:

```
ant build
```

2. Locate the file:

```
dist/project_osama.war
```

3. Deploy it to GlassFish

---

## 🌐 Project Pages

* Login Page
* Sign Up Page
* Booking Page
* Admin Dashboard

---

## 📌 Future Improvements

* Convert the system to React or Next.js
* Add a Mobile App using Expo
* Support online payments 💳
* Improve UI/UX

---

## 👨‍💻 Author

**Osama Abdullah Obaid**
osamhobaid4@gmail.com
IT Engineer | Web & App Developer

---

## 📄 License

This project is for educational purposes.
