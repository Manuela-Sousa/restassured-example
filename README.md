# Rest-Assured Test Automation Project

This is a **test automation project** built with **Rest-Assured**, designed to help you quickly get started with API testing. It provides a ready-to-use framework that you can easily integrate into your own projects.

---

## Table of Contents

- [Installation](#installation)
- [Project Structure](#project-structure)
- [Setting Up the Test Environment](#setting-up-the-test-environment)
- [Running Tests](#running-tests)

---

## Installation

To get started with this project, you'll need to have the following installed on your machine:

1. **Java**:
   - Ensure that you have **Java 8** or higher installed.
   - You can download and install Java from the official [Oracle JDK website](https://www.oracle.com/java/technologies/javase-downloads.html) or use an open-source alternative like [OpenJDK](https://openjdk.java.net/).

2. **Maven**:
   - This project uses Maven to manage dependencies and build the project. Install **Maven** from the official [Maven website](https://maven.apache.org/download.cgi).
   - Alternatively, you can use a package manager like **Homebrew** (macOS) or **Chocolatey** (Windows).

3. **Set Up Environment Variables**:
   - Ensure the `JAVA_HOME` and `MAVEN_HOME` environment variables are set correctly on your machine. 
   - You can check if they're set by running:
     ```bash
     echo %JAVA_HOME%
     echo %MAVEN_HOME%
     ```

   For detailed setup instructions, follow the official documentation for [Java](https://docs.oracle.com/javase/tutorial/getStarted/index.html) and [Maven](https://maven.apache.org/install.html).

4. **Rest-Assured**:
   - This project includes Rest-Assured as a dependency, so once Maven is set up, it will automatically download the required dependencies.

---

## Project Structure

This repository follows a modular folder structure to keep the test automation framework organized and maintainable.


### Directories Overview:

- **`java/utils/`**: Contains environment-specific configuration files. Each environment (e.g., `local`, `staging`, `production`) should have its own file in this directory to configure API base URLs, authentication tokens, etc.
  
- **`java/resources/`**: Stores environment properties file.

- **`test/java/`**: Contains java classes with the test defined.

---

## Setting Up the Test Environment

You can configure the test environment in the `ReadPropertiesFile` class. Specifically, modify the environment setting in this line:

```java
private static String env = "prod";  // Change to "staging", "local", etc.
```
---

## Running Tests

You can run the tests using **Maven** either from the command line or directly within your IDE (e.g., **Visual Studio Code**, **IntelliJ IDEA**). Below are some common commands:

### 1. Run All Tests

To execute all the tests in the project, run the following Maven command from your terminal:

```bash
mvn test
```
