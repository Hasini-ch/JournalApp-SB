🧠 Journal Analytics Dashboard

This project is a Spring Boot web application for maintaining personal journal entries and analyzing moods using interactive visualizations.
It allows users to create, view, and analyze their journal entries with a clean and modern dashboard built using Thymeleaf and Chart.js.


---

🚀 Project Features

✅ Add, edit, and delete journal entries easily
📅 View entries sorted by date
📊 Visualize mood distribution (Happy, Sad, Neutral) with dynamic charts
🎨 Clean and responsive Bootstrap-based UI
🧮 Automatic mood-based analytics and count summary
💾 Data stored securely in a MySQL database
🧰 Built with Spring Boot, Thymeleaf, and JPA


---

🛠 Technologies Used

Category	Technologies

Backend Framework	Spring Boot (v3.x)
Frontend	Thymeleaf, Bootstrap 5, Chart.js
Database	MySQL
ORM	Spring Data JPA / Hibernate
Language	Java 17+
Build Tool	Maven



---

📁 Project Structure

journal-analytics/
│
├── src/
│   ├── main/
│   │   ├── java/com/journal/journalapp/
│   │   │   ├── controller/        # Handles web requests
│   │   │   ├── model/             # Entity classes
│   │   │   ├── repository/        # JPA Repositories
│   │   │   └── service/           # Business logic
│   │   └── resources/
│   │       ├── templates/         # Thymeleaf HTML files
│   │       ├── static/            # CSS, JS, images
│   │       └── application.properties
│   └── test/                      # Unit and integration tests
│
├── pom.xml                        # Maven dependencies
└── README.md                      # Project documentation


---

⚙ Setup Instructions

1️⃣ Clone the Repository

git clone https://github.com/your-username/journal-analytics-dashboard.git
cd journal-analytics-dashboard

2️⃣ Configure Database

In src/main/resources/application.properties, update your MySQL details:

spring.datasource.url=jdbc:mysql://localhost:3306/newjournaldb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

3️⃣ Build & Run the Project

mvn spring-boot:run

Then open your browser and go to:

http://localhost:8080/dashboard


---

📊 Analytics Dashboard Preview

The Analytics Page displays:

Total count of journal entries by mood

Pie/doughnut chart visualization of mood distribution

A clean table listing all entries



---

🌟 Example Moods

Mood	Emoji	Description

😊 Happy	#36a2eb	Positive mood
😢 Sad	#ff6384	Negative mood
😐 Neutral	#ffcd56	Balanced mood



---

👨‍💻 Author

Cheyyeti Hasini
🔗 GitHub: https://github.com/Hasini-ch
📧 Email: cheyyetihasini@gmail.com


---

🧩 Future Enhancements

🚀 Add user authentication (Spring Security)
📅 Add date filters for mood tracking
📈 Include export to CSV/PDF reports
🌈 Add more moods and insights


---

🪪 License

This project is licensed under the MIT License — feel free to use and modify for learning or personal use.