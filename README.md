# My Library (Android)
[🇬🇷 Read this in Ελληνικά](./README_GR.md)

Android application for browsing a library of books. Users can filter books by category, select a book, and view detailed information such as title, author, category, and description.

## Features

- Browse a list of books
- Filter books by category using chips
- Select a book from a dropdown list (Spinner)
- View detailed book information
- Local logging of selections using SQLite
- Fragment-based navigation

## Tech Stack

- Java
- Android SDK
- Android Studio
- XML Layouts
- Android Jetpack Navigation Component
- ViewModel
- SQLite
- Material Components

## Architecture Overview

The application follows a simple layered structure with shared state management using Android ViewModel.

UI Layer (Fragments):
- `FirstFragment`: Displays book list and category filters
- `SecondFragment`: Displays selected book details

State Management:
- `BookViewModel` is used to share data between fragments
- It holds the list of books and the currently selected book

Data Source:
- Book data is loaded from `assets/library.xml`
- A helper class (`BookList`) parses and provides the data

Local Storage:
- SQLite is used to log user book selections locally
- Implemented via `SQLiteConnection` and database helper classes

## Project Structure

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

## Local Setup

1. Clone repository
```bash
git clone https://github.com/dgiagkoudi/android-library-app.git
cd android-library-app
```
2. Open the project in Android Studio
3. Let Gradle sync complete
4. Run the app on an emulator or physical device

## Future Improvements

- Book search functionality
- Favorites / Reading list
- CRUD operations for books
- Unit & UI testing

## License

This project is licensed under the MIT License.
