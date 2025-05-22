# 📚 Book API (Spring Boot)

A simple RESTful API built with Spring Boot to manage books.  
Features include:

- Add new books with validation  
- Retrieve all books  
- Search books by title  
- Clean logging with Lombok’s `@Slf4j`  
- Consistent error handling and validation  

---

### Running the Application

bash
mvn spring-boot:run

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


API Endpoints
Method	Endpoint	Description	Request Body	Response
GET	/api/books	Get all books	None	List of books (JSON)
POST	/api/books	Add a new book	{ "title": "...", "author": "..." }	Created book (JSON)
GET	/api/books/search	Search books by title	Query param: title	List of matching books


Validation
title and author are mandatory fields on book creation.

If validation fails, API responds with status 400 Bad Request and details.

Testing
You can test the API manually using Postman:

Import the provided Postman collection (BookAPI.postman_collection.json) to quickly access pre-configured requests.

Run the requests against the running server at http://localhost:8080.


Logging
All controller methods include detailed logging using Lombok’s @Slf4j for easy debugging and monitoring.


👤 Author
Smile-Khan
GitHub: Smile-Khan
