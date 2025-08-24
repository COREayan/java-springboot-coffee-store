# ☕ Java Spring Boot – Coffee Store Order Management System  

A **RESTful backend system** to manage customer orders and product inventory, built with Spring Boot and JPA. The project models real-world entity relationships—**Customer, Order, OrderItem, and Product**—with proper mappings, CRUD APIs, and a clean layered architecture.  

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
