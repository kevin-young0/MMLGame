MMLGame

Please do not contribute on this project until after Dec 18 2013
=======
Memory Math and language game

The purpose of this game is to develop an application to enhance learning for children.

The primary part of the application is a memory game. There should be five levels (beginner, Easy, Medium, Hard, and Custom) to it. The level selection will determine the number of matches (?, 5, 15, 30, or ?) to be found.  Beginner allows the user to specify the number of matches; it also allows mouse over to make the cards visible.

All cards (Pictures) are covered until selected. When the first card is selected it is turned over and stays that way until the second card is selected. When the second card is selected it is turned over and compared to the first card. If the cards match they remain visible. If they do not match they are both turned over. The player continues to select cards until all are turned over. When all the cards are successfully turned over or selected the game ends displaying a missed count.

Cards are randomly selected from a folder so that they are not always the same. The player can specify the folder or use the default. When a level is chosen the game will select the number of cards equal to the level choice. It will then duplicate and randomly place them for the matches. 

The program will need to have a means of examining its folders to list the user added ones at start-up. The user can create cards for use in the game. These cards can be pictures of family, friends, and have words on them. This will help parents teach their children to recognize specific people, or help them learn to read, another language, or basic math. They can put these in different folders so that they can specify which they want to use.

As users will be able to add new items into the game they will need directions on how to do that and what image size and type to use. 




Design:
   The Primary UI Form: 
	Needs a list box set to drop down
This will scan a directory when the game is first opened and list the folders        inside as selection options
	Beginner’s button
Selecting Beginners opens another interface and allows the user to choose the number of matches, up to 15. It also sets the card visibility to mouseover.
Drop down list numbered 1 – 15
Start button
   Opens the game window with beginner settings
Cancel button
	Easy button
	   Opens the game window with Easy settings
	Medium Button
	   Opens the game window with medium settings
	Hard button
	   Opens the game window with hard settings
	Custom button
Opens an interface that allows the user to specify the number of matches, up to 60
Text box
Start button
   Opens the game window with custom settings
Cancel button
	How To button
This opens an HTML document that explains how to add pictures to the game. 
	Close button
Label - display the number of misses/Hidden when first open


Game window Form:
When the game window opens it is populated with a number of picture frames filled with a default picture. The cards are then randomly assigned to the frames and made visible when selected. The number of frames is dependent upon the number of matches chosen times two.

When all matches are made the games closes the Primary UI re-appears and a label is set to visible. 


Primary UI Design:
   Upon load populate listbox
	Call directory game
	   Read paths of subdirectories
	   Parse paths to get folder name
	   Put folder name in list box
   End load
   Upon click open beginners UI
   	Call beginnerUI form
   End beginner



	Populate listbox with numbers 1-15
   	Set card visibility to on mouseover
