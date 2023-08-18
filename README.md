The studentmanagement is a CRUD based application which uses 2 sets of controllers, 2 repositories,
2 entity classes and a spring security class, it also makes use of a MySQL database, Thymeleaf and Bootstrap.

Thymeleaf is a modern server-side template engine for Java, Thymeleaf binds to the variables 
in the entity classes and using Bootstrap, I had created the elements of the page such as the buttons, fields
etc. Nothing crazy just simple navigation. 

The StudentController class is there to manage the requests for the studentEntities, prepare the model and return 
the view. Firstly I had injected the studentRepository class, this time I had not used a Service class to handle
the logic. 

First method which was to list all the studentEntities using the find all method in studentRepository, I also 
create an object of studentEntity and variable in all methods, and then assign it to a ModelMap string to pass it to the
view so I can update and view the information. Next is the add studentEntity method, it uses a save method from the 
studentRepository to save the information into the database and then display it using find all. I have another 
method which basically acts the same way the add studentEntity method does, it just overwrites the information of the 
selected userEntity. The last method is the delete method and uses a @RequestParam which when the userEntity clicks on a 
specific userEntity delete button, will extract the value of the userEntity and then perform the delete method and then 
redirect back to the main screen. 

The spring security makes use of 2 beans, one which is a UserDetailsManager, this one basically just has a query of 
selecting the email and password from the user_details table where the email equals the userEntity input. The second bean
makes use of SecurityFilterChain which restricts the users access to a few pages to allow the userEntity to sign up or 
login and when they do login, they will be able to access any other pages. There is a custom login and logout page 
too. **I haven't yet figured out how to sort out the security, when I log in I can't access any other page**

**If there are any errors with my explanation please correct me as I still am quite new and would like to learn more :)**
