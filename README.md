The studentmanagement is a CRUD based application which uses 2 sets of controllers, 2 repositories,
2 entity classes and a spring security class, it also makes use of a MySQL database, Thymeleaf and Bootstrap.

Thymeleaf is a modern server-side template engine for Java, Thymeleaf binds to the variables 
in the entity classes and using Bootstrap, I had created the elements of the page such as the buttons, fields
etc. Nothing crazy just simple navigation. 

The StudentController class is there to manage the requests for the students, prepare the model and return 
the view. Firstly I had injected the studentRepository class, this time I had not used a Service class to handle
the logic. 

    //findall students
    @GetMapping("/list")
    public String listAllStudents(ModelMap modelMap) {
        List<Student> students = studentRepository.findAll();
        modelMap.put("students", students);
        return "StudentList";
    }
    
    //add student
    @RequestMapping( "/add")
    public String addStudent(ModelMap modelMap, Student students) {
        modelMap.put("students", students);
        studentRepository.save(students);
        return "AddStudent";
    }

    //update student
    @RequestMapping("/update")
    public String updateStudent(Student student, ModelMap modelMap) {
        modelMap.put("students", student);
        studentRepository.save(student);
        return "UpdateStudent";
    }

    //delete student
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam(value = "student") Student student) {
        studentRepository.delete(student);
        return "redirect:/student/list";
    }

First method which was to list all the students using the find all method in studentRepository, I also 
create an object of student and variable in all methods, and then assign it to a ModelMap string to pass it to the
view so I can update and view the information. Next is the add student method, it uses a save method from the 
studentRepository to save the information into the database and then display it using find all. I have another 
method which basically acts the same way the add student method does, it just overwrites the information of the 
selected user. The last method is the delete method and uses a @RequestParam which when the user clicks on a 
specific user delete button, will extract the value of the user and then perform the delete method and then 
redirect back to the main screen. 

The spring security makes use of 2 beans, one which is a UserDetailsManager, this one basically just has a query of 
selecting the email and password from the user_details table where the email equals the user input. The second bean
makes use of SecurityFilterChain which restricts the users access to a few pages to allow the user to sign up or 
login and when they do login, they will be able to access any other pages. There is a custom login and logout page 
too. **I haven't yet figured out how to sort out the security, when I log in I can't access any other page**

**If there are any errors with my explanation please correct me as I still am quite new and would like to learn more :)**
