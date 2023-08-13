# ReadX Software Prototype

## Project Description

This project aims to develop a software prototype for ReadX, an "Egyptian conglomerate", to manage their global publication business. The software provides various functionalities for managing bibliographic products and user interactions.

## Functionalities

### Bibliographic Product Management

The system facilitates the management of two types of bibliographic products: books and magazines.

- **Books:** Each book is characterized by a unique identifier (3 hexadecimal characters), name, page count, short review, publication date, genre, cover image URL, sale value (in dollars), copies sold, and accumulated pages read. Supported genres are Science Fiction, Fantasy, and Historical Novel.

- **Magazines:** Each magazine has a unique identifier (3 alphanumeric characters), name, page count, publication date, category, cover image URL, subscription value (in dollars), frequency of issuance, active subscriptions, and accumulated pages read. Supported categories are Varieties, Design, and Scientific.

The system should be designed to accommodate future types of bibliographic products.

### User Management

There are two user types: regular and premium.

- **Regular Users:** Can purchase up to 5 books, subscribe to 2 magazines, and will encounter advertisements during platform usage.

- **Premium Users:** Can buy books and subscribe to as many magazines as desired, without advertisements.

### Product Purchase and Subscription

Users can buy books or subscribe to magazines. Upon purchase/subscription, the operation date, amount paid, and relevant counters (e.g., copies sold) are updated. Users can also cancel magazine subscriptions at any time.

### Library Presentation

The software features a menu for users to view their product collection in a simulated library format. The library is presented as a 5x5 matrix displaying product codes sorted by publication date. Users can navigate through their collection and select products for reading based on coordinates or product identifiers.

### Reading Session Simulation

Users can simulate reading sessions for products. The simulation presents the product's name, current page, and navigation options (previous page, next page, return to library). For regular users, advertisements are shown at the start of a session and after every 20 pages of a book or 5 pages of a magazine.

### Report Generation

The prototype generates real-time reports for targeted content creation:

- Total accumulated pages read for each product type (book/magazine).
- Most-read genre and category.
- Top 5 most-read books and magazines.
- Sales report by genre.
- Subscriptions report by category.

### Test Data Generation

The prototype includes functionality to automatically generate at least one user and one product object per user type.

## Usage

1. Run the program in the console.
2. Follow the menu prompts to interact with the system's functionalities.

## Contributing

Contributions are welcome. Feel free to open issues or pull requests in the GitHub repository for suggestions, corrections, or improvements.

## License

This project is licensed under the MIT License.
