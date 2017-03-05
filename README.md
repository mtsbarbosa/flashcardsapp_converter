# flashcardsapp_converter
Converter for backup files from Flash Cards App

<b>About:</b><br>
The mobile app Flash Cards App generates a xml file as a backup.

This is the url of the app in the play store:<br>
https://play.google.com/store/apps/details?id=com.grude.lernkartenapp

Sometimes we need our flashcard data for other purposes, like checking repeated words in a csv file, for example.<br>
This project is made to convert the xml generated from the Flash Cards App into separated deck files, the only converter by now is the csv converter.

<b>Usage:</b>

I put a JPanel as a UI for this project, but it can change it in the future.<br>
A command in the input window must contain:<br>
<format> <path of the xml file> <path of the output files> <name pattern for the output files><br>
Example:<br>
csv C:\folder_flashcards C:\folder_flashcards_output deck

Having a xml containing two decks:<br>
Stack 1 -> name: "english a1"<br>
Stack 2 -> name: "english a2"

Executing the command<br>
csv C:\folder_flashcards C:\folder_flashcards_output deck<br>
will output two csv files:<br>
deck_english_a1.csv<br>
deck_english_a2.csv

 
New converters are welcome!<br>
Enjoy.