# My Library (Android)

Μια μικρή εφαρμογή Android για διαχείριση και προβολή βιβλίων σε μια βιβλιοθήκη. Ο χρήστης μπορεί να δει τη λίστα των διαθέσιμων βιβλίων, να επιλέξει ένα βιβλίο και να δει λεπτομέρειες όπως τίτλο, συγγραφέα και περιγραφή.

## Περιγραφή

Η εφαρμογή παρέχει:

- Προβολή λίστας βιβλίων σε Spinner.
- Εμφάνιση λεπτομερειών βιβλίου σε δεύτερο fragment.
- Δυνατότητα επιστροφής στο πρώτο fragment.
- Αποθήκευση επιλογών βιβλίων σε τοπική βάση δεδομένων SQLite (SelectionLogger).
- Χρήση ViewModel για κοινή διαχείριση δεδομένων μεταξύ fragments.

## Τεχνολογίες που χρησιμοποιήθηκαν

- Android Studio
- Java
- XML (Layout files)
- Android Jetpack Navigation
- ViewModel & LiveData
- SQLite

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
│ ├── SQLiteConnection.java    
│ ├── SelectionLoggerContract.java    
│ └── SelectionLoggerDbHelper.java    
│    
├── src/main/res/    
│    
│ ├── layout/    
│ │ ├── main_activity.xml    
│ │ ├── first_fragment.xml    
│ │ └── second_fragment.xml    
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
