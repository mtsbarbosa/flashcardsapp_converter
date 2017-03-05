# flashcardsapp_converter

About:
The mobile app Flash Cards App generates a xml file as a backup.

This is the url of the app in the play store:
https://play.google.com/store/apps/details?id=com.grude.lernkartenapp

Sometimes we need our flashcard data for other purposes, like checking repeated words in a csv file, for example.
This project is made to convert the xml generated from the Flash Cards App into separated deck files, the only converter by now is the csv converter.

Usage:

I put a JPanel as a UI for this project, but it can change it in the future.
A command in the input window must contain:
<format> <path of the xml file> <path of the output files> <name pattern for the output files>
Example:
csv C:\folder_flashcards C:\folder_flashcards_output deck

Having a xml containing two decks:
Stack 1 -> name: "english a1"
Stack 2 -> name: "english a2"

Executing the command
csv C:\folder_flashcards C:\folder_flashcards_output deck
will output two csv files:
deck_english_a1.csv
deck_english_a2.csv

 
New converters are welcome!
Enjoy.