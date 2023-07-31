# EcommerceWebApp

This project contains several controller classes for handling different functionalities in an E-commerce web application built with Spring Boot.

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

