
# Walmart Take-Home Project

This repository contains a sample Android project developed as part of a take-home assignment for Walmart. The project demonstrates the implementation of a modern Android application using best practices, clean architecture, and several Android Jetpack components.

## Table of Contents

- [Project Overview](#project-overview)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Features](#features)
- [Setup Instructions](#setup-instructions)
- [Testing](#testing)
- [Code Structure](#code-structure)

## Project Overview

The Walmart Take-Home Project is designed to showcase a sample Android application that demonstrates the ability to retrieve and display a list of products from an API. The app is built using modern development practices, focusing on scalability, testability, and maintainability.

## Architecture

This project follows the **MVVM (Model-View-ViewModel)** with **Clean Architecture)** architecture pattern, which is a widely used design pattern for Android applications. The architecture separates the application logic into different components, making the code more modular and easier to maintain.

- **Model**: Represents the data logic of the application.
- **ViewModel**: Acts as a bridge between the Model and the View, holding UI-related data and handling the logic to update the View.
- **View**: Represents the UI layer, observing the ViewModel for data updates.

## Technologies Used

- **Kotlin**: The primary programming language used for Android development.
- **Android Jetpack Components**:
  - **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
  - **LiveData**: Allows the UI to observe data changes.
- **Retrofit**: A type-safe HTTP client for Android and Java.
- **Hilt**: Dependency injection library for Android.
- **Coroutine**: For asynchronous programming.
- **Mockk**: For mocking in tests.
- **JUnit**: For unit testing.

## Features

- Fetches and displays a list of Countries from a remote API.
- Supports error handling and displays appropriate messages for network errors.
- Follows MVVM architecture to separate concerns and promote testability.
- Unit tests covering core components.

## Setup Instructions

To run this project on your local machine, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/bhaumikpan/walmarttakehome.git
   ```

2. **Open the project**:
   - Use Android Studio to open the cloned project.

3. **Sync the project**:
   - Let Android Studio sync the project and download all necessary dependencies.

4. **Run the application**:
   - Use the "Run" button in Android Studio or use the following command:
   ```bash
   ./gradlew assembleDebug
   ```

5. **Build and Run the tests**:
   - Run the unit tests using:
   ```bash
   ./gradlew test
   ```

## Testing

The project inside feature-data includes unit tests for various components to ensure reliability and correctness. The tests are written using JUnit and Mockk.

- **Repository Tests**: Verifies that the repository returns the correct data and handles errors as expected.

## Code Structure

The project is organized into multiple packages based on functionality:

- **data**: Contains the data sources, models, and repository implementations.
- **di**: Contains dependency injection modules using Hilt.
- **ui**: Contains the UI-related classes such as activities, fragments, and view models.
- **network**: Contains the Retrofit setup and API service definitions.
- **utils**: Contains utility classes and extension functions.
- **testing**: Contains the test classes for unit testing.

![Alt text](https://github.com/bhaumikpan/walmarttakehome/blob/master/app_screenshot) "Screenshot")
