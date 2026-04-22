# 🚀 StreetPulse

StreetPulse is a backend-driven platform to discover and analyze local businesses based on engagement metrics like views and ratings.

---

## 🧠 Features

- 🔐 JWT Authentication (Login/Register)
- 🏪 Business Management (Create, Fetch, Trending)
- ⭐ Review System (Add, Fetch, Average Rating)
- 📈 View-based Trending Algorithm

---

## ⚙️ Tech Stack

- Java (Spring Boot)
- Spring Security (JWT)
- MySQL / PostgreSQL
- JPA / Hibernate

---

## 🚀 How to Run

1. Clone repo
2. Configure database in `application.properties`
3. Run Spring Boot application
4. Backend runs on:
   http://localhost:8080

---

## 🌐 API Documentation

Swagger UI:

http://localhost:8080/swagger-ui/index.html

### How to Use:

1. Register user → `/api/auth/register`
2. Login → `/api/auth/login`
3. Copy token
4. Click **Authorize 🔒**
5. Paste:
   Bearer <your_token>
6. Now access protected APIs

---

## 🧪 Frontend

A basic frontend UI is provided:

`frontend/index.html`

- Login
- Create Business
- View Businesses
- View Count increment via API

---

## 📊 Key Feature (USP)

Each time a business is fetched by ID:


GET /api/business/{id}


👉 View count increases  
👉 Used in trending score calculation

---

## ⚙️ Scalability Considerations

- Microservices architecture can separate User, Business, and Review services
- Redis caching for trending businesses and ratings
- Database indexing for faster queries
- Load balancing using Nginx or cloud services
- Async processing using Kafka/RabbitMQ for analytics
- Containerization using Docker and Kubernetes

---

"SORRY FOR A PROBLEM, FRONTEND IS STILL NOT READY TO VIEW RATING AND VIEWS, HOWEVER, IT CAN BE ACHIEVED ON json TESTING ON SWAGGER, BUT WORKING ON IT TO FIX IT ASAP"

## 👨‍💻 Author

Krishna