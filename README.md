# Java-SpringBoot Coffee Store Order Management System

Built a RESTFul backend to manage customer orders and product inventory with full entity relationships. Designed POJOs for Customer, Order, OrderItem, and Product with proper JPA mappings and created CRUD endpoints for each using Spring Boot.  

- Designed and developed a RESTful Spring Boot application with a normalized relational data model involving multiple entities: Customer, Order, OrderItem, and Product.
- Implemented one-to-many and many-to-one relationships using JPA annotations such as @OneToMany, @ManyToOne, and @JoinColumn to model complex real-world business logic.
- Created DAO layer using Spring Data JPA repositories(CustomerRepository, OrderRepository, etc.) to perform seamless database operations.
- Structured application with a clean layered architecture: Controller-Service-Repository-Entity, ensuring high maintainability and separation of concerns.
- Designed OrderItem as a join entity between Order and Product, enabling a scalable model for itemized order details including quantity and product references.
- Ensured data integrity and referential mapping with foreign key constraints(customer_id, order_id, product_id) through proper JPA mappings.
- Tested APIs using Postman and simlated end-toend order placement, product listing, and customer hitory retrieval workflows.
- Configured application.properties with MySQL settings for local development and testing.

ER Diagram 
<img width="2764" height="2324" alt="image" src="https://github.com/user-attachments/assets/def710e3-8085-4dd5-bd15-e9924f3c29fe" />


Future Scope
- Documented API endpoints using Swagger UI for better API discoverability.
- Implemented global exception handling using @ControllerAdvice and custom exception classes for cleaner error responses.
- Followed SOLID principles and best practices in code structure and entity design. 
