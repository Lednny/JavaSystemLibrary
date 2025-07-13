# JavaSystemLibrary

## Overview

**JavaSystemLibrary** is a digital library management system written purely in Java. This project focuses solely on implementing the core logic for managing a library's inventory and user interactions—no graphical interface is included at this stage. It is designed for educational purposes and as a foundation for future enhancements.

> **Note:** A fully modernized version with a JavaFX graphical user interface is planned for release in the coming months.

## Features

- **User Registration:** Register new library users with basic details.
- **Book Inventory Management:**
  - Pre-loaded with a diverse collection of books across genres (fiction, romance, documentaries, children's books, comedy, etc.).
  - Add new books to the library inventory.
  - Remove books or update stock levels.
  - View complete inventory status.
- **Book Search:**
  - Search for books by title, author, or genre.
- **Borrowing and Returns:**
  - Lend books to users and keep track of borrowing status.
  - Handle book returns, updating inventory accordingly.
- **Client Management:**
  - View list of registered users and their borrowing history.
- **Console-based Menu:**
  - All interactions are performed via simple console prompts.
  - Color-coded and clearly organized menus for ease of use.

## Project Structure

- `MainBilbioteca.java` — Main entry point, user menu, and the core logic for library operations.
- `StockBook.java` — Manages the book inventory, allowing for retrieval, addition, and removal of books.
- `Book.java` — Model class representing a book, including title, author, genre, and stock.
- Other utility classes for user management, screen cleaning, and color output.

## Usage

1. **Compile** all Java files:
   ```bash
   javac *.java
   ```
2. **Run** the main class:
   ```bash
   java MainBilbioteca
   ```
3. Use the menu to register users, manage the library, and handle book operations.

## Future Plans

- **JavaFX GUI:** This project will be migrated to a graphical interface using JavaFX, improving user experience and usability.
- **Extended Features:** Planned enhancements include advanced search, data persistence, and role-based access.

## Disclaimer

This repository contains only the application logic and is intended as a learning resource or base for future development. Contributions and suggestions are welcome, especially for the upcoming JavaFX version!

---
