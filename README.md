# 📚 Book API (Spring Boot)

This project is a simple Spring Boot REST API that returns a static list of books. It is designed as a demonstration of how to create and expose RESTful endpoints using Spring Boot.

---

## 📖 Project Description

The application provides a single endpoint:

GET /books


When accessed, it returns a JSON response containing a list of hardcoded books. Each book object contains the following attributes:

- `title` (String)
- `author` (String)
- `isbn` (String)
- `year` (Integer)

---

## ⚙️ Prerequisites

To run this project locally, ensure that the following tools are installed:

- Java 8 or above
- Maven
- Git
- Spring Tool Suite (STS) or any IDE that supports Spring Boot

---

## 🚀 How to Run the Project

### 1. Clone the Repository


git clone https://github.com/Smile-Khan/Book-API-Demo.git
cd Book-API-Demo


2. Build and Run the Application
Using Spring Tool Suite (STS):
Import the project into STS.

Right-click the project → Run As → Spring Boot App.

Or using the terminal:

./mvnw spring-boot:run


🌐 Accessing the API
Once the application is running, open your browser or use a tool like Postman to access:

http://localhost:8080/books
You will receive a JSON response with book details.


✅ Sample Output

[
  {
    "title": "The Hobbit",
    "author": "J.R.R. Tolkien",
    "isbn": "978-0261103344",
    "year": 1937
  },
  {
    "title": "1984",
    "author": "George Orwell",
    "isbn": "978-0451524935",
    "year": 1949
  },
  {
    "title": "To Kill a Mockingbird",
    "author": "Harper Lee",
    "isbn": "978-0061120084",
    "year": 1960
  }
]


👤 Author
Smile-Khan
GitHub: Smile-Khan
