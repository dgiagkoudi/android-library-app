# My Library (Android)

Μια μικρή εφαρμογή Android για διαχείριση και προβολή βιβλίων σε μια βιβλιοθήκη. Ο χρήστης μπορεί να δει τη λίστα των διαθέσιμων βιβλίων, να επιλέξει ένα βιβλίο και να δει λεπτομέρειες όπως τίτλο, συγγραφέα και περιγραφή.

## Περιγραφή

Η εφαρμογή παρέχει:

- Προβολή και επιλογή βιβλίων μέσω Spinner.
- Φιλτράρισμα της λίστας βιβλίων ανά κατηγορία με χρήση ChipGroup στο πρώτο fragment.
- Δυναμική ενημέρωση του Spinner σύμφωνα με την επιλεγμένη κατηγορία.
- Εμφάνιση λεπτομερειών βιβλίου σε δεύτερο fragment.
- Δυνατότητα επιστροφής στο πρώτο fragment.
- Αποθήκευση βιβλίων σε τοπική βάση δεδομένων SQLite (SelectionLogger).
- Χρήση ViewModel για κοινή διαχείριση δεδομένων μεταξύ fragments.

## Τεχνολογίες που χρησιμοποιήθηκαν

- Android Studio
- Java
- XML (Layout files)
- Android Jetpack Navigation
- ViewModel & LiveData
- SQLite
- Material Components

## Δομή φακέλων
app/    
├── src/main/java/com/example/mylibrary/    
│    
│ ├── MainActivity.java    
│ ├── FirstFragment.java   
│ ├── SecondFragment.java    
│ ├── Book.java    
│ ├── BookList.java    
│ ├── BookViewModel.java    
│ ├── Categories.java    
│ ├── SQLiteConnection.java    
│ ├── SelectionLoggerContract.java    
│ └── SelectionLoggerDbHelper.java    
│    
├── src/main/res/    
│    
│ ├── layout/    
│ │ ├── main_activity.xml    
│ │ ├── first_fragment.xml    
│ │ ├── second_fragment.xml    
│ │ └── spinner_item.xml   
│    
│ ├── navigation/    
│ │ └── nav_graph.xml    
│    
│ └── values/    
│ ├── colors.xml    
│ └── strings.xml    
│    
└── assets/    
└── library.xml    

## Τοπική εκτέλεση

1. Κλωνοποιήστε το repository.  
2. Ανοίξτε το project με **Android Studio**.  
3. Εκτελέστε **Build -> Rebuild Project** για να βεβαιωθείτε ότι όλα τα dependencies φορτώνονται σωστά.  
4. Τρέξτε την εφαρμογή σε emulator ή πραγματική συσκευή Android.
