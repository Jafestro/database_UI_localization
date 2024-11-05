The project is a JavaFX application for managing employee data with localization support. **Table-Based Localization** approach was used to implement Database localization. It allows users to select a language (English, Farsi, or Japanese) and input employee details (first name, last name, email). The application then stores the data in a database table corresponding to the selected language.

Key components:

JavaFX UI: Defined in select_language.fxml.
Controller: HelloController handles UI interactions and updates.
Service: HelloService manages database operations.
Main Application: HelloApplication initializes and launches the JavaFX application.
The application uses Maven for build and dependency management, as defined in pom.xml.