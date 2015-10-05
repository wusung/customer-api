How to use
==========

##Scenario
An insurance company needs a system to manage their customer data.  A software engineering team is working on the story below.

*As a system user, I want to add new customer data into the system. After added, I can view a certain customer, and a customer list. Of course, I am also able to modify the data as well as remove it from the system.* 


## Instructions
Strongly suggest you use curl utility to test the following codes.

### Creating a single customer
```
curl -XPOST http://127.0.0.1:8080/rga/rest/customer -u franky@gmail.com:1234
```

### Updating a single customer

### Deleting a single customer
```
curl -XDELETE http://127.0.0.1:8080/rga/rest/customer/1 -u franky@gmail.com:1234
```

### Reading a single customer
```
curl -XGET http://127.0.0.1:8080/rga/rest/customer/50 -u franky@gmail.com:1234
```

### Listing all customers
```
curl -XGET http://127.0.0.1:8080/rga/rest/customer -u franky@gmail.com:1234
```

### Login - getting a login token.
>>> Only authenticated can use the web APIs or it will prompt the users inputting username and password. After login success, the system will assign a token id for a user.

### Logout - destroying a login token.
```
curl -XGET http://127.0.0.1:8080/rga/rest/logout -u franky@gmail.com:1234
```
