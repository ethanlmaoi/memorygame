CS141: Intro to Programming and Problem Solving
Professor: Edwin Rodríguez

Programming Assignment #3

This is assignment is a text-based MEMORY game. The grid is a two
dimensional array 4x4 containing 16 "CARDS" represented by O's.
The game ends when the PLAYER flipped all of the cards and the score
is the number of turns it takes the PLAYER to end the game.

Ethan Liao

This third assignment went a lot more smoothly than the first. I worked from the bottom up.
I first created the abstract Card class followed by the sub versions of the cards that 
extends the Card class. Afterwards, I created the Grid class and successfully got it to
create new RANDOM grids everytime, and printing out the grids effortlessly. The coding for
the gameplay took a little longer, but it was much easier than Escape the Dungeon.

I learned that although you can technically just create the game all in one class and one method, separating the
information and having several classes and subclasses not only made it easier for me to code and manage, but
it just logically makes sense. Also, I ran into a problem where printing out the grid gave me an
error, but I realized it's because in the UI constructor, I put Grid grid = new Grid() when I should have just
put grid = new Grid(), since I already created an instance above the constructor.