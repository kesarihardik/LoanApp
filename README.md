# Loan Transaction Application Assignment
***

Loan application for storing loan transactions.


## Given Conditions

There is a scenario where thousands of loans are flowing into one store, assume any way of
transmission of Loans. We need to create a one loan store, which store the loans in the following
order

  Given requirement/validation

1. The payment date can’t be greater than the Due Date. If its greater we have to reject the
   Loan and thrown the exception
2. We need to write an aggregation on the remaining amount, Interest and Penalty Group by
   Lender, Group by Interest and Group by Customer ID.
3. If the Loan crosses the due date, it should write an alert in the log message.

## Architecture 
***

There are 4 layers of the application -

### 1. Database Layer

The application uses an in memory and relational database H2 to keep the design minimal and simple.
It is already populated with some records on initialization.

### 2. Data Access Layer 

The data access layer is responsible for storing, updating and retrieval of records from the database.It uses the JPA for implementing API methods and custom queries.

### 3. Service Layer

The service layer is where all the business logic and validation is kept. It is the middles layer between data access layer and the user.

 There are two services in this application
1. One that interacts with the data access layer.
2. Other service contains scheduled tasks.

### 4. Controller

This layer exposes the endpoints to the user for data manipulation, fetching and other operations.



## Testing 
****

The controller layer is tested using JUnit framework based on the principle of Red-Green factor.
Test Cases try to cover all the possible test cases.


