🧠 Quiz Central
A Java-based Quiz Application using JDBC and PostgreSQL


📌 Overview
Quiz Central is a console-based quiz application where users can register, authenticate, and take quizzes. Scores are stored in a history tracking system, ensuring that users can see their progress over time.

Current Features:
✔ User Registration & Login (with password hashing)
✔ Single-Level Quiz Gameplay
✔ Score History Tracking
✔ PostgreSQL Database Integration

Future Enhancements:
🔹 Multi-Level Quizzes
🔹 Desktop GUI Version (JavaFX/Swing)
🔹 Web-Based Version (Spring Boot & React)
🔹 Leaderboards & Multiplayer Mode

🛠️ Technologies Used
Java (JDBC for database connectivity)

PostgreSQL (For storing user data and scores)

BCrypt (For password hashing)

📂 Project Structure
pgsql
Copy
📁 QuizCentral
│── 📜 README.md
│── 📜 quiz.sql        # Database schema
│── 📂 src
│   │── QuizApp.java   # Main application
│   │── User.java      # User authentication logic
│   │── Quiz.java      # Quiz mechanics
│   │── Database.java  # JDBC connection & queries
🚀 Installation & Setup
1️⃣ Prerequisites
🔹 Java 11+ (JDK Installed)
🔹 PostgreSQL Installed
🔹 PostgreSQL JDBC Driver

2️⃣ Database Setup
Open PostgreSQL and create a new database:

sql
Copy
CREATE DATABASE quiz_central;
Run the provided quiz.sql file to create tables.

Update Database.java with your PostgreSQL credentials:

java
Copy
private static final String URL = "jdbc:postgresql://localhost:5432/quiz_central";
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
3️⃣ Running the Application
Compile Java files:

sh
Copy
javac -cp .:postgresql.jar src/*.java  
Run the main class:

sh
Copy
java -cp .:postgresql.jar src.QuizApp  
🔐 Security
Password Hashing: Uses BCrypt to securely hash passwords.

SQL Injection Prevention: Uses Prepared Statements to prevent attacks.

📊 Database Schema
sql
Copy
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash TEXT NOT NULL
);

CREATE TABLE scores (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    score INT NOT NULL,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
🏆 Future Roadmap
Version	Features Planned
v1.0	Console-based app, single-level quiz, user authentication
v2.0	Desktop version with JavaFX, multiple quiz levels
v3.0	Web-based app with Spring Boot & React, leaderboards
🎨 Architecture Diagram
(Basic Representation of the System Flow)

pgsql
Copy
+---------------+        +---------------+        +------------+
|  User Input   | -----> |  Java (JDBC)  | -----> | PostgreSQL |
+---------------+        +---------------+        +------------+
🤝 Contributing
Feel free to fork this repository, improve features, and submit a pull request.

📧 Contact
For any queries or suggestions, reach out to me at your.email@example.com.
