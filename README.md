# 🚀 StreetPulse

StreetPulse is a backend system built using **Spring Boot, MySQL, and JWT Authentication** that allows users to discover, review, and analyze local businesses based on engagement metrics.

---

## 📌 Features

### 🔐 Authentication
- User Registration & Login
- JWT-based secure authentication
- Protected APIs

### 🏪 Business Management
- Create Business
- Get All Businesses
- Get Business by ID
- Get My Businesses (user-specific)
- View Count Tracking

### ⭐ Review System
- Add Reviews to Businesses
- Fetch Reviews by Business
- Average Rating Calculation

### 📈 Trending System (Core USP)
- Businesses ranked based on:
    - View Count
    - Average Rating
- Dynamic scoring algorithm

### ⚙️ Backend Standards
- Global Exception Handling
- Input Validation (`@Valid`)
- Clean DTO-based responses
- Layered Architecture (Controller → Service → Repository)

---

## 🧠 Tech Stack

- Java (Spring Boot)
- Spring Security
- JWT (Authentication)
- MySQL
- JPA / Hibernate
- Maven

---

## ⚡ API Endpoints

### 🔓 Public APIs

| Method | Endpoint | Description |
|--------|--------|------------|
| POST | `/api/auth/register` | Register user |
| POST | `/api/auth/login` | Login user |

---

### 🔐 Protected APIs

#### Business

| Method | Endpoint | Description |
|--------|--------|------------|
| POST | `/api/business` | Create business |
| GET | `/api/business` | Get all businesses |
| GET | `/api/business/{id}` | Get business by ID |
| GET | `/api/business/my` | Get my businesses |
| GET | `/api/business/trending` | Get trending businesses |

---

#### Review

| Method | Endpoint | Description |
|--------|--------|------------|
| POST | `/api/review` | Add review |
| GET | `/api/review/business/{id}` | Get reviews by business |
| GET | `/api/review/business/{id}/average` | Get average rating |

---

## 🔐 Authentication Usage

For protected APIs, add header:


Authorization: Bearer <your_token>


---

## ⚙️ How to Run

1. Clone the repository
2. Open in IntelliJ
3. Configure MySQL in `application.properties`
4. Run Spring Boot application
5. Test APIs using Postman

---

## 📊 Project Architecture


Controller → Service → Repository → Database


---

## 🎯 Future Improvements

- Pagination & Filtering
- Image Upload for Reviews
- Caching (Redis)
- Advanced Trending Algorithm
- Deployment (AWS / Render)

---

## 👨‍💻 Author

Krishna