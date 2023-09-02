Requirements:

Implement proper data validation and error handling.

Implement token-based authentication for user access. The API should allow users to register, login, and obtain a token to access protected endpoints.

Implement endpoints that allows the user to do the following actions:

* Retrieve a list of all books available in the store.
* Retrieve details of a specific book by its ID.
* Allow users to search for books by title, author, or genre.
* Retrieve the user's shopping cart with a list of added books.
* Add a book to the user's shopping cart.
* Remove a book from the user's shopping cart.
* Retrieve a list of the user's previous orders.
* Place a new order with the books currently in the user's shopping cart.

Requirements
* Ensure that the API endpoints are secure and can only be accessed by authenticated users.
* Handle stock management: When a user places an order, make sure to update the book stock accordingly.

Tools:
* Use any backend programming language and framework of your choice (e.g., Python with Flask, Node.js with Express, Ruby on Rails, etc.).
Use a database of your choice (e.g., SQLite, PostgreSQL, MySQL) to store books, user information, shopping carts, and orders.

Evaluation Criteria:
* Functionality: Does the API meet the specified requirements? Does it operate correctly without significant bugs?
* Code Quality: Is the code well-structured, readable, and maintainable? Does it adhere to best practices?
* Error Handling: Does the API gracefully handle errors and provide informative feedback to the user?
