# Task Rocket 🚀

Task Rocket is a simple and elegant task management web application built with **Spring Boot**, **Thymeleaf**, **HTML/CSS**, and **Java**. It allows users to:

- Add tasks with title, description, status, and deadline
- View all tasks and update their status
- Delete tasks

---

## ✨ Features
- Add / View / Update / Delete Tasks
- Responsive UI with modern design
- Deadline countdown
- Gradient button styling and consistent UI theme

---

## 📁 Project Structure
```
TaskRocket/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/task/taskManagement/
│       │       ├── controller/
│       │       │   ├── TaskController.java
│       │       │   └── UserController.java
│       │       ├── model/
│       │       │   ├── Task.java
│       │       │   └── User.java
│       │       ├── repository/
│       │       │   ├── TaskRepository.java
│       │       │   └── UserRepository.java
│       │       └── TaskManagementApplication.java
│       └── resources/
│           ├── static/
│           ├── templates/
│           │   ├── add.html
│           │   ├── home.html
│           │   └── taskList.html
│           └── application.properties
└── pom.xml
```

---

## ⚙️ Prerequisites
- Java 17+
- Maven
- Git

---

## 📦 How to Run
```bash
# Clone the repository
git clone https://github.com/Rakesh0713/taskrocket.git
cd taskrocket

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

Then open your browser and go to: [http://localhost:8080](http://localhost:8080)

---

## 📊 Screenshots
LogIn and Account Creation,

![Screenshot 2025-04-24 193811](https://github.com/user-attachments/assets/307c859c-2e5b-4cc3-8285-1b7c3dddb480)

Add Task,

![Screenshot 2025-04-24 193917](https://github.com/user-attachments/assets/49a9b95b-6284-412c-bac1-61c3cc9c2384)

Monitor Task,

![Screenshot 2025-04-24 193927](https://github.com/user-attachments/assets/60035b94-bd2b-4f43-bc3d-08514b177e8d)
