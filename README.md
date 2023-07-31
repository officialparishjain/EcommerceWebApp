# EcommerceWebApp

This project contains several controller classes for handling different functionalities in an E-commerce web application built with Spring Boot.

## Technology Used

The E-commerce web application is developed using the following technologies and frameworks:

1. **Spring Boot:** The project is built on top of the Spring Boot framework, which provides a rapid development environment for building Java-based applications.

2. **Spring MVC:** The application follows the Model-View-Controller (MVC) architectural pattern using Spring MVC for handling web requests and responses.

3. **Spring Data JPA:** Spring Data JPA is used for database access and provides a repository abstraction over the underlying database.

4. **Thymeleaf:** Thymeleaf is used as the templating engine for generating dynamic HTML pages and rendering data on the frontend.

5. **Java Persistence API (JPA):** JPA is used to map Java objects to relational database entities and handle database operations.

6. **Lombok:** Lombok is used to reduce boilerplate code by automatically generating getters, setters, constructors, and other utility methods.

7. **Jakarta Persistence API (Jakarta EE):** Jakarta EE (previously Java EE) is used for defining and managing enterprise-level components and services.

8. **HTML/CSS:** The frontend part of the application is built using HTML and CSS to create the user interface.

9. **Bootstrap:** Bootstrap is used as a frontend framework to enhance the responsiveness and aesthetics of the web application.

10. **JavaScript:** JavaScript is used for client-side interactions and adding dynamic behavior to the frontend.



## AdminController

The `AdminController` handles admin-related functionalities such as category management and product management.

### Endpoints:

- `GET /admin`: Displays the admin home page.
- `GET /admin/categories`: Displays a list of all categories.
- `GET /admin/categories/add`: Displays the category add form.
- `POST /admin/categories/add`: Adds a new category.
- `GET /admin/categories/delete/{id}`: Deletes the category with the specified ID.
- `GET /admin/categories/update/{id}`: Displays the category update form for the category with the specified ID.
- `GET /admin/products`: Displays a list of all products.
- `GET /admin/products/add`: Displays the product add form.
- `POST /admin/products/add`: Adds a new product.
- `GET /admin/product/delete/{id}`: Deletes the product with the specified ID.
- `GET /admin/product/update/{id}`: Displays the product update form for the product with the specified ID.

## HomeController

The `HomeController` handles general functionalities related to the home page and product listing.

### Endpoints:

- `GET /` and `GET /home`: Displays the home page.
- `GET /shop`: Displays the shop page with a list of all products and categories.
- `GET /shop/category/{id}`: Displays the shop page with products filtered by the specified category ID.
- `GET /shop/viewproduct/{id}`: Displays the details of the product with the specified ID.

## UserController

The `UserController` handles user-related functionalities such as user registration and login.

### Endpoints:

- `GET /register`: Displays the user registration form.
- `POST /register`: Registers a new user.
- `GET /login`: Displays the login form.
- `POST /login`: Authenticates the user based on email and password.

## Models

The project includes several model classes representing entities like Category, Product, and User, which are used to map database tables to Java objects.

## Services

The project contains various service classes responsible for handling business logic related to categories, products, and users.

## Repositories

The project uses Spring Data JPA repositories for database operations related to categories, products, and users.

