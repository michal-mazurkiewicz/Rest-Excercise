# Rest-Excercise

Simple Spring Boot Rest App of bank service that allows to create new accounts, retrive them, list them and transfer money between them. 
For data storage I used in-memory H2 db. 

To start the project just simply clone repository and or import it directly from your IDE download mvn dependencies and run the project. 

Application will be running on port: 8080.

## Implementation

#### Entities: 

Account{
id: Long,
name: String,
currency: Currency,
balance: double
} 

#### Comments: 

* Currency: I am aware of java.utils.Currency. However decided to implement own enum type for currencies. 
Consist EURO and DOLAR for simplicity and possible simple conversion during transfers. 
 

* balance: in the requirements it was expected to be of type Money. However for simplicity I decided to stick with double. I am aware about limitation of that solution and that it should be later replaced with the type that can store bigger amount eg. BigInteger.

#### Transfer Service

Service implemented to enable transfers from different currencies. 

## Endpoints

* Create new Account: 

        POST localhost:8080/api/accounts
        
        REQUEST BODY EXAMPLE:
        
        {
            "id":2,
            "name":"Michal",
            "currency":"Euro",
            "balance":150.00,
            "treasury":true
        } 
        
* Get Account by id: 

        GET localhost:8080/api/accounts/getbyid/1
    
* Get All Accounts: 

        GET localhost:8080/api/accounts
        
* Transfer money: 

        POST localhost:8080/api/accounts/transfer
        
        REQUEST BODY EXAMPLE: 
        
        {
            "idFrom":2,
            "idTo":3,
            "amount":10.0
        }
        

