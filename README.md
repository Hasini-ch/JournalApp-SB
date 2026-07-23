# 🧠 Personal Journal Analytics Web Application

This project is a Java Spring Boot web application for maintaining personal journal entries and analyzing moods through an interactive dashboard. It enables users to securely create, view, update, and delete journal entries while providing visual insights into mood trends for better self-reflection.

---

## 🚀 Project Features

- ✅ Add, edit, and delete journal entries
- 📅 View journal entries sorted by date
- 📊 Analyze mood trends with interactive visualizations
- 🎨 Clean and responsive user interface
- 🧮 Automatic mood-based analytics and summaries
- 💾 Secure storage using MySQL database

---

## 🛠 Tech Stack

| Category | Technologies |
|----------|--------------|
| Backend | Java, Spring Boot |
| Frontend | HTML, CSS, JavaScript |
| Database | MySQL |

---

## 📁 Project Structure

```
journal-analytics/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   └── service/
│   │   └── resources/
│   │       ├── templates/
│   │       ├── static/
│   │       └── application.properties
│   └── test/
│
├── pom.xml
└── README.md
```

---

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/Hasini-ch/JournalApp-SB.git
cd JournalApp-SB
```

### 2. Configure Database

Update your MySQL configuration in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/newjournaldb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

Open your browser:

```
http://localhost:8080/dashboard
```

---

## 📊 Dashboard

The application provides:

- Mood-wise journal analytics
- Interactive mood visualization
- Daily journal management
- Secure data storage
- Simple and responsive interface

---

## 🌟 Sample Moods

- 😊 Happy
- 😐 Neutral
- 😢 Sad

---

## 👨‍💻 Author

**Cheyyeti Hasini**

- GitHub: https://github.com/Hasini-ch
- Email: cheyyetihasini@gmail.com

---

## 🚀 Future Enhancements

- User Authentication
- Advanced Mood Analytics
- Search and Filter Entries
- Export Reports (PDF/CSV)
- Additional Mood Categories

---

## 📄 License

This project is licensed under the MIT License.
