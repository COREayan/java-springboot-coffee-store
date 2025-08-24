# ☕ Java Spring Boot – Coffee Store Order Management System  

A **RESTful backend system** to manage customer orders and product inventory, built with Spring Boot and JPA. The project models real-world entity relationships—**Customer, Order, OrderItem, and Product**—with proper mappings, CRUD APIs, and a clean layered architecture.  

---

## 🛠️ Tech Stack  

- ☕ **Java 17+**, **Spring Boot 3.x**  
- 🌐 Spring Web (REST APIs)  
- 🗄️ Spring Data JPA + **MySQL** (Persistence)  
- ✅ Validation (JSR-380 `javax.validation`)  
- 📖 API Docs: **springdoc-openapi (Swagger UI)**  
- 🧪 Testing: **JUnit 5**, **Mockito**, **Postman/Newman**, optional **RestAssured**
  
---

# 📡 API Endpoints — Coffee Store  

This document lists all available API endpoints for the Coffee Store application.  
Each endpoint follows RESTful conventions with proper HTTP methods and status codes.  

---

## 👤 Customers  

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET    | `/api/v1/customers` | Get all customers | 200 OK |
| GET    | `/api/v1/customers/{id}` | Get customer by ID | 200 OK, 404 Not Found |
| POST   | `/api/v1/customers` | Create a new customer | 201 Created, 400 Bad Request |
| PUT    | `/api/v1/customers/{id}` | Update existing customer | 200 OK, 404 Not Found |
| DELETE | `/api/v1/customers/{id}` | Delete customer by ID | 204 No Content, 404 Not Found |

---

## 📦 Products  

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET    | `/api/v1/products` | Get all products | 200 OK |
| GET    | `/api/v1/products/{id}` | Get product by ID | 200 OK, 404 Not Found |
| POST   | `/api/v1/products` | Add a new product | 201 Created, 400 Bad Request |
| PUT    | `/api/v1/products/{id}` | Update existing product | 200 OK, 404 Not Found |
| DELETE | `/api/v1/products/{id}` | Delete product by ID | 204 No Content, 404 Not Found |

---

## 🧾 Orders  

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET    | `/api/v1/orders` | Get all orders | 200 OK |
| GET    | `/api/v1/orders/{id}` | Get order by ID | 200 OK, 404 Not Found |
| POST   | `/api/v1/orders` | Place a new order | 201 Created, 400 Bad Request |
| PUT    | `/api/v1/orders/{id}` | Update an order (e.g., status) | 200 OK, 404 Not Found |
| DELETE | `/api/v1/orders/{id}` | Cancel/delete order | 204 No Content, 404 Not Found |

---

## 📑 Order Items  

| Method | Endpoint | Description | Status Codes |
|--------|----------|-------------|--------------|
| GET    | `/api/v1/orders/{orderId}/items` | Get all items in an order | 200 OK |
| GET    | `/api/v1/orders/{orderId}/items/{id}` | Get specific item in an order | 200 OK, 404 Not Found |
| POST   | `/api/v1/orders/{orderId}/items` | Add a product to an order | 201 Created, 400 Bad Request |
| PUT    | `/api/v1/orders/{orderId}/items/{id}` | Update item quantity | 200 OK, 404 Not Found |
| DELETE | `/api/v1/orders/{orderId}/items/{id}` | Remove item from order | 204 No Content, 404 Not Found |

---

## 📖 Example Request & Response  

### Create Customer  
**POST** `/api/v1/customers`  
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "gender": "Male",
  "phoneNumber": "+91-9876543210"
}


---

## 🚀 Key Highlights  

- **Relational Data Modeling**  
  - Designed a normalized schema with multiple entities: `Customer`, `Order`, `OrderItem`, and `Product`.  
  - Established relationships:  
    - `Customer → Order` (1:N)  
    - `Order → OrderItem` (1:N)  
    - `OrderItem → Product` (N:1)  

- **Entity & JPA Mappings**  
  - Used `@OneToMany`, `@ManyToOne`, and `@JoinColumn` annotations to model real-world business logic.  
  - Designed `OrderItem` as a join entity to track product, quantity, and order references.  
  - Enforced data integrity with foreign key constraints (`customer_id`, `order_id`, `product_id`).  

- **Architecture**  
  - Structured with **Controller → Service → Repository → Entity** layers for maintainability and separation of concerns.  
  - DAO layer implemented via **Spring Data JPA Repositories** (`CustomerRepository`, `OrderRepository`, etc.).  

- **API Development & Testing**  
  - CRUD endpoints for all entities.  
  - Tested workflows (order placement, product listing, customer history) using **Postman**.  
  - Configured `application.properties` with **MySQL** for local dev & testing.  

---

## 📊 ER Diagram  

<img width="2764" height="2324" alt="ER Diagram" src="https://github.com/user-attachments/assets/def710e3-8085-4dd5-bd15-e9924f3c29fe" />  

---

## 🔮 Future Scope  

- 📘 API documentation with **Swagger UI** for improved discoverability.  
- ⚡ Global exception handling using `@ControllerAdvice` and custom exception classes.  
- 🏗️ Follow **SOLID principles** and design best practices for scalability.  
- ☁️ Extend deployment to cloud environments (AWS / GCP).  
