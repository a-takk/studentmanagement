The studentmanagement is a CRUD based application which uses 2 sets of controllers, 2 repositories,
2 entity classes and a spring security class, it also makes use of a MySQL database, Thymeleaf and Bootstrap.

Thymeleaf is a modern server-side template engine for Java, Thymeleaf binds to the variables 
in the entity classes and using Bootstrap, I had created the elements of the page such as the buttons, fields
etc. Nothing crazy just simple navigation. 

The StudentController class is there to manage the requests for the students, prepare the model and return 
the view. Firstly I had injected the studentRepository class, this time I had not used a Service class to handle
the logic. 

First method which was to list all the students using the find all method in studentRepository, I also 
create an object of student and variable in all methods, and then assign it to a ModelMap string to pass it to the
view so I can update and view the information. Next is the add student method, it uses a save method from the 
studentRepository to save the information into the database and then display it using find all. I have another 
method which basically acts the same way the add student method does, it just overwrites the information of the 
selected user. The last method is the delete method and uses a @RequestParam which when the user clicks on a 
specific user delete button, will extract the value of the user and then perform the delete method and then 
redirect back to the main screen. 

**If there are any errors with my explanation as I still am quite new and would like to learn more :)**
