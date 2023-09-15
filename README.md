The entity is mapped to a database, through ORM which is Object Relational Mapping, this provides us a way where we can map the objects to the tables in the database, 
this manages the communication between the entities and the database. In my application I had 2 tables which were created by the entities, 
one called “student_details” and the other “user_details”, we assign columns to the variables so that when we set the password for example, 
it will insert it into the database with the password already hashed into that specific column. 

Another thing I had done was created an enum which had contained a user and admin which were the two roles I wanted for the app. 
The @Enumerated allowed me to store these values in the database which was assigned to a Set of RoleEntity so both enums would get inserted into the database upon adding them using the Set method. 

Next I had created a User and Student repository, this is to implement the CRUD methods for the entities, we don’t have to write any SQL queries, 
it is connected via the generics where we assign the class and Long which is the primary id. 

A service implementation class is used to handle all the business logic, I created several methods in a service interface to implement into the implementation class. 
I had then injected both repositories which is used to save, find, or delete. I had used the add method from the Set collection which allowed me to assign the role to 
the user when they had inserted their details into the form. 

The UserDetailsService queries the database using the find by email in the user repository as we must depend on the user repository to provide us with the querying the data. 
Then we return the user entities so that it would find all details that are linked to the one that we are trying to load. 
In the same class we also have granted authorities, which takes the role entity as an input and uses the stream api to process the roles and maps it to a granted authority object, 
then collects the objects into a list.

To summarise for the Spring Security, when we make a request it goes through a series of filters, these filters make security checks based on our config. 
So we have limited user access to specific pages and allowed the admins to access all pages. When we perform our authentication it goes through the provider manager, 
then through to the DAO auth manager which contains the user details service and the password encoder, it will check for the correct email, loading it from the database, 
then returns the email, password, and role, we then have the password encoder which then decrypts the password and matches it. It will try to authenticate based off the provided details, 
if the details are correct it will pass back a response which will then allow the user access to the endpoints.


