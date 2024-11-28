# Online Banking Management Application

## Project Overview

This is a comprehensive online banking management application developed using Spring Boot, providing a secure and feature-rich platform for banking operations with role-based access control.

## Key Features

### User Roles
- **ADMIN**: Full system access, user management, complete account and transaction control
- **USER**: Personal account management, transaction creation
- **EMPLOYEE**: Account viewing, transaction approval

### Core Functionalities
- User Management
- Bank Account Management
- Transaction Processing
- Bill Management
- Loan Applications
- Detailed Transaction History

## Technical Stack

- **Backend**: Spring Boot
- **Database**: 
  - Relational Database (MySQL/PostgreSQL)
  - ElasticSearch for transaction indexing
- **Database Migration**: Liquibase
- **Testing**: JUnit
- **Additional Tools**:
  - Lombok
  - MapStruct
  - Custom Authentication (non-Spring Security)
  - Bcrypt Password Encoding

## Prerequisites

- Java 17+
- Maven
- Docker (optional, for ElasticSearch)
- PostgreSQL/MySQL

## Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/[your-username]/banking-app.git
   cd banking-app
   ```

2. Configure Database
   - Edit `application.yml` with your database credentials
   - Ensure Liquibase migration scripts are in place

3. Build the project:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Authentication

The application uses a custom authentication mechanism:
- User registration with role assignment
- JWT-like token generation
- Role-based access control

### Authentication Endpoints
- `/auth/register`: User registration
- `/auth/login`: User login
- `/auth/validate`: Token validation

## Transaction Types

1. **Classic Transactions**: Standard account transfers
2. **Instant Transactions**: Immediate processing
3. **Recurring Transactions**: Scheduled transfers

## Loan Application Criteria

Loan eligibility requires:
- Minimum age: 18 years
- Stable monthly income
- Good credit history
- Debt-to-income ratio ≤ 40%
- Potential collateral
- Minimum 6 months banking relationship

## Configuration

Configuration is managed via `application.yml`:
- Database connection
- ElasticSearch settings
- Transaction rate configurations

## Running Tests

Execute unit tests:
```bash
mvn test
```

## Docker Support

Recommended Docker setup for ElasticSearch:
```bash
docker run -d --name elasticsearch \
  -p 9200:9200 -p 9300:9300 \
  -e "discovery.type=single-node" \
  docker.elastic.co/elasticsearch/elasticsearch:7.15.0
```

## API Documentation

Recommended: Use Swagger or Postman for API exploration and testing.

## Security Considerations

- Passwords encrypted using BCrypt
- Custom token-based authentication
- Role-based access control
- Transaction approval workflow

## Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/BankingFeature`)
3. Commit changes (`git commit -m 'Add banking feature'`)
4. Push to branch (`git push origin feature/BankingFeature`)
5. Open Pull Request

## Potential Improvements

- Implement comprehensive logging
- Add more detailed transaction tracking
- Enhance security mechanisms
- Create more granular role permissions


