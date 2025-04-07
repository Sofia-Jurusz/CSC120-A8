Use this file to record your reflection on this assignment.

- Which methods did you decide to `overload`, and why?
- What worked, what didn't, what advice would you give someone taking this course in the future?


In the house class, first I decided to make an overload constructor for if you do not know the address of a Smith College House. In general, I don't think anyone on campus navigates based on addresses, so it was easier to add this version of the constructor than look up the address for every Smith College house. Second, I decided to add an overload for the moveIn() method. Previously, if a student was already a resident of a house, they needed to call two functions to move into a different house (first moveOut() of old house, then moveIn() to new house). But with the new method I wrote, if you give the name of the house a student wants to leave, you can move out and move in all in one method.

In the library class, first I added an overload constructor which does not have nFloors as a parameter and hardcodes the number of floors to 4. I did this for just in case you did not know the number of floors in a library, but mostly because I was experimentng with calling different super constructors. I wanted to try calling the super constrcutor that doesn't take floor number, but then setting floor number to 4. Next, similar to the House class, I added another overload constructor that does not require an address and just states that the library is on Smith's campus.

In the cafe class, I added an overload method for black coffee drinkers. Now if you want a plain black coffee, you don't need to bother saying you want 0 cream and 0 sugar, you can simply order the oz of coffee you want! This makes life much simpler for the baristas. Lastly, I added a method where if a cafe is not given a name, it automatically becomes a Starbucks. I added this method because the market is super competative right now! These big corporations will swoop in whenever they can! If you don't watch your back, Starbucks is going to come in and steal your cafe!! It's tough for small cafes to compete with Starbucks too, since thir inventory is much larger (aka I made the Starbucks inventory initially much larger, but they still can only restock at the same rate). 

I found this assignment fun and I liked using my creativity. I tried making it possible to play the campus map and struggled. It was not as easy as I thought. The best dea I came up with, but didn't impliment, would be using something similar to what I did in the conversation homework. So a user types in what they want (a string) and then that corresponds to the a list of methods/ buildings that they want to use. (i.e. 'enter comstock') would correspond with the method enter and the building comstock. With this idea though, I think I'd need to initialize the buildings with each campus map. Could I have feedback on this idea, or is it too confusing typed out?


