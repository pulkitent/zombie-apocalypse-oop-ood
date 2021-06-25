### Zombie Apocalypse Submission
--------------------

#### Assumptions:
 - Each Grid will contain only one creature
 - Direction command for zombie is case in sensitive

---------------------------

#### INPUT:

 - The first line of input is the grid size

 - The second line contains comma separated (x,y)coordinates of zombie in the grid

 - Third contains space separated coordinated(x,y) of each creature within the grid

 - Fourth line contains the direction commands to be executed by each zombie

#### OUTPUT:

 - The output will have logs of all movements done by each zombie
 - Also, whenever a zombie infects a creature, the same will be logged in console
 - Final positions of all the zombies and creatures will be displayed at the end.
 - If no creatures are left, no output will be dispayed for creature's coordinates

---------------------------

#### INPUT AND OUTPUT:

##### Test Input:
4 \
3,1 \
0,1 1,2 1,1 \
RDRU 

##### Expected Output:

zombies’ positions:\
1 1 \
2 1 \
3 2 \
3 1 \
creatures’ positions:\
*No output here in case no creatures left*
---------------------------

#### HOW TO RUN : 
- A test-input.txt file is present in the directory
- Provide the input in the above format in the input file and run the Main.java file

---------------------------

##### Expected Execution failures:
- If the provided grid size is less than equal to 0 -> Exception will be thrown
- If the coordinated provided for either the zombie/creature is (less than 0 OR greater than or equal to gridSize) -> Exception will be thrown with appropriate message
- If the direction command other then LRDU or lrdu is provided -> Exception will be thrown
--------------------------
