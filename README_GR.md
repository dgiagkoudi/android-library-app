# My Library (Android)

Android εφαρμογή για περιήγηση σε μια συλλογή βιβλίων. Ο χρήστης μπορεί να φιλτράρει βιβλία ανά κατηγορία, να επιλέξει ένα βιβλίο και να δει αναλυτικές πληροφορίες όπως τίτλο, συγγραφέα, κατηγορία και περιγραφή.

## Λειτουργίες

- Περιήγηση σε λίστα βιβλίων
- Φιλτράρισμα ανά κατηγορία με chips
- Επιλογή βιβλίου μέσω dropdown (Spinner)
- Προβολή λεπτομερειών βιβλίου
- Τοπική καταγραφή επιλογών με SQLite
- Πλοήγηση μεταξύ οθονών με Fragments

## Τεχνολογίες

- Java
- Android SDK
- Android Studio
- XML Layouts
- Android Jetpack Navigation Component
- ViewModel
- SQLite (τοπική αποθήκευση)
- Material Components

## Αρχιτεκτονική

Η εφαρμογή ακολουθεί μια απλή δομή με κοινή διαχείριση κατάστασης μέσω ViewModel.

UI Layer (Fragments)
- `FirstFragment`: Εμφάνιση λίστας και φίλτρων
- `SecondFragment`: Εμφάνιση λεπτομερειών βιβλίου

Διαχείριση Κατάστασης
- Το `BookViewModel` μοιράζεται δεδομένα μεταξύ fragments
- Περιέχει τη λίστα βιβλίων και το επιλεγμένο βιβλίο

Πηγή Δεδομένων
- Τα δεδομένα φορτώνονται από το `assets/library.xml`
- Η κλάση `BookList` αναλαμβάνει το parsing

Τοπική Αποθήκευση
- SQLite για καταγραφή επιλογών χρήστη
- Υλοποίηση μέσω `SQLiteConnection` και βοηθητικών κλάσεων

## Δομή Φακέλων

```bash
app/src/main/
├── java/com/example/mylibrary/
│ ├── Book.java
│ ├── BookList.java
│ ├── BookViewModel.java
│ ├── Categories.java
│ ├── FirstFragment.java
│ ├── MainActivity.java
│ ├── SQLiteConnection.java
│ ├── SecondFragment.java
│ ├── SelectionLoggerContract.java
│ └── SelectionLoggerDbHelper.java
│
├── res/
│ ├── color/
│ │  └── button_hover.xml
│ ├── layout/
│ │  ├── first_fragment.xml
│ │  ├── main_activity.xml
│ │ ├── second_fragment.xml
│ │ └── spinner_item.xml
│ ├── navigation/
│ │ └── nav_graph.xml
│ └── values/
│ │ ├── colors.xml
│ │ └── strings.xml
│
├── assets/
│ └── library.xml
```

## Εκκίνηση Τοπικά

1. Κλωνοποιήστε το repository
```bash
git clone https://github.com/dgiagkoudi/android-library-app.git
cd android-library-app
```
2. Ανοίξτε το project στο Android Studio
3. Περιμένετε να ολοκληρωθεί το Gradle sync
4. Τρέξτε την εφαρμογή σε emulator ή συσκευή

## Μελλοντικές Βελτιώσεις

- Αναζήτηση βιβλίων
- Λίστα αγαπημένων βιβλίων
- CRUD λειτουργίες για βιβλία
- Unit & UI Tests

## License

Το project διατίθεται με άδεια MIT License.
