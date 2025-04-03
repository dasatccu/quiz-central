Quiz Central
 
 
 
Overview
Quiz Central is a console-based quiz application built using Java and PostgreSQL. Users can register, log in, and play quizzes, with their scores tracked over time. Future releases will expand the application to a desktop and web-based version, introducing more difficulty levels and additional features.
________________________________________
Application Flow
Here’s a simple diagram showing how the app works:
     +--------------------+
     |   User Registers   |
     +--------------------+
               |
               v
     +--------------------+
     |  User Logs In      |
     +--------------------+
               |
               v
     +--------------------+
     |   Starts Quiz      |
     +--------------------+
               |
               v
     +--------------------+
     |  Scores Saved      |
     +--------------------+
               |
               v
     +--------------------+
     | Score History View |
     +--------------------+
________________________________________
Features
✅ User Registration & Authentication – Secure login system with hashed passwords.
✅ Quiz Gameplay – Users take quizzes and receive scores at the end.
✅ Score Tracking – History of scores is stored for each user.
✅ PostgreSQL Integration – Stores user data, quiz questions, and scores.
Future Enhancements
🚀 Desktop & Web Versions – Transitioning from a console-based app.
🚀 Multiple Difficulty Levels – More challenge options.
🚀 Leaderboard & Analytics – Insights into top players and performance trends.
________________________________________
Requirements
•	Java (JDK 17 or later)
•	PostgreSQL (Latest version)
•	JDBC Driver for PostgreSQL
________________________________________
Setup Instructions
1.	Clone the Repository
2.	git clone https://github.com/your-repo/quiz-central.git
3.	cd quiz-central
4.	Set Up Database
o	Create a PostgreSQL database.
o	Run the provided SQL scripts to create necessary tables.
5.	Build and Run the Application
6.	javac -cp .:postgresql.jar Main.java  
7.	java -cp .:postgresql.jar Main  
________________________________________
License
This project is licensed under the MIT License.
Contributing
Contributions are welcome! Feel free to submit issues or pull requests.
