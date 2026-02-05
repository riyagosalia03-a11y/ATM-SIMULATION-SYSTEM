# ATM Simulation System

A Java-based ATM (Automated Teller Machine) simulation system with MySQL database integration. This console application demonstrates core banking operations including account creation, authentication, and transaction management.

## Features

- **User Authentication**
  - Secure sign-up with account number and PIN
  - Login verification against database records

- **Banking Operations**
  - Check account balance
  - Deposit funds
  - Withdraw money
  - Real-time balance updates

- **Database Integration**
  - MySQL database connectivity
  - Transaction management with commit/rollback support
  - Persistent data storage

## Prerequisites

Before running this application, ensure you have the following installed:

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J (JDBC Driver)

## Database Setup

1. Create a MySQL database named `atm_db`:

```sql
CREATE DATABASE atm_db;
```

2. Create the `account` table:

```sql
USE atm_db;

CREATE TABLE account (
    accno INT PRIMARY KEY,
    pin INT NOT NULL,
    name VARCHAR(100) NOT NULL,
    op_bal DOUBLE NOT NULL
);
```

## Configuration

Update the database connection details in the `connect()` method:

```java
con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/atm_db",
    "your_username",  // Replace with your MySQL username
    "your_password"   // Replace with your MySQL password
);
```

## Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/atm-simulation-system.git
cd atm-simulation-system
```

2. Add MySQL Connector/J to your classpath:
   - Download from [MySQL official website](https://dev.mysql.com/downloads/connector/j/)
   - Add the JAR file to your project's classpath

3. Compile the program:
```bash
javac ATM_Stimulation_db.java
```

4. Run the application:
```bash
java ATM_Stimulation_db
```

## Usage

### Main Menu
- **Sign Up**: Create a new account with holder name, account number, PIN, and opening balance
- **Log In**: Access existing account using account number and PIN
- **Exit**: Close the application

### ATM Menu (After Login)
1. **Check Balance**: View current account balance
2. **Deposit**: Add funds to your account
3. **Withdraw**: Remove funds from your account
0. **Exit**: Logout and close application

## Project Structure

```
atm-simulation-system/
├── ATM_Stimulation_db.java    # Main application file
├── README.md                   # Project documentation
├── LICENSE                     # MIT License
└── .gitignore                  # Git ignore file
```

## Security Note

⚠️ **Important**: This is an educational project. In production environments:
- Never hardcode database credentials
- Use PreparedStatements to prevent SQL injection
- Implement proper password hashing
- Add input validation and error handling
- Use secure connection protocols

## Known Issues

- Input handling in `signup()` method has a `sc.next()` call that may need adjustment
- No input validation for account numbers or PINs
- SQL queries are vulnerable to SQL injection attacks
- Database credentials are hardcoded

## Future Enhancements

- [ ] Implement PreparedStatements for SQL queries
- [ ] Add input validation
- [ ] Implement password hashing
- [ ] Add transaction history feature
- [ ] Create a GUI interface
- [ ] Add fund transfer functionality
- [ ] Implement session management

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Your Name - [Your GitHub Profile](https://github.com/yourusername)

## Acknowledgments

- Built as a learning project to understand database connectivity in Java
- Demonstrates basic JDBC operations and SQL transactions

---

**Disclaimer**: This project is for educational purposes only. It demonstrates basic concepts and should not be used in production without significant security enhancements.
