# CS 0458 SEC4010 Final Project 

<b> Due:Friday, April 23, 11:59pm </b>

## Assignment details

Final project for Data Structures and Files
The final project has to implement two data structures that were discussed in class. 
These must be our (the students) own implementation. 
If the standard API implementation is used it is an automatic zero.   
Additionally, it should incorporate some persistence mechanism. 
A connection to a database or file i/o would be best. 
Optional, but strongly recommended is Junit or Scala for unit testing. 
	
Group: Harlan Chandler, Hunter Shaw

## Project overview 

The workspace has two directories

- `src/test/java/com/HarlanHunter/InventoryProject`: This path is for source files
- `src/test/res/local`: This path is for file I/O

The overall concept for this final project was to make some inventory management 
program. The idea was to make a program that could be used for warehouses and others
to maintain and track products. With this overall concept in mind the process of
implementation came. From the ADT's discussed in class the group agreed that dictionary
is a great data structure to use. The second ADT was harder to consider but after
some testing and discussion the stack was our second data structure we would implement. 
So, the dictionary is the main backbone of the program. Our implementation for
the project is a linked chain dictionary of nodes. This dictionary is the backbone of
the program and holds all the products and quantities for an inventory in some industry.
The second ADT we implemented was stack. We chose to not use a vector stack and instead
implement an array based stack which is used to handle the interactions between the
user and the data inside of the dictionary. Additionally, there needs to be some
form of persistence to the program. The ending decision was to use object I/O to create
this persistence mechanism. 

##### Tools Used
* Java
* Eclipse IDE
* Git

##### Personal thoughts

Hunter Shaw: I enjoyed creating the project a lot and feel it has helped better my 
programming specifically in the documentation/commenting area. It is always great
to enjoy doing something and gain valuable knowledge in the process as well. There
is naturally a lot I would like to change/add to the project. After this busy end to
a very unique semester, I would like to add GUI to the project with javaFX. Additionally,
I would like to add more commands for the user to use. Two specific commands that I feel
are important are SORT & UPDATE. The SORT command would have two options ASC & DESC which
would sort in ascending or descending order. Also, the UPDATE command would be used to 
change to current quantity of the product inside the Dictionary. Further, I would like to
change the persistence mechanism of the project. Rather than just simple binary I/O using
MySQL & JDBC to use a fully functioning database. Overall, I am happy with the current 
state of the project and in time will work towards adding these desired additions. 

## Contact

Hunter Shaw: hms75@pitt.edu | huntershaw0@gmail.com

Harlan Chandler: 
