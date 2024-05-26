# MVVM Kotlin Android Project

This project is an Android application built using the MVVM (Model-View-ViewModel) architecture pattern with Kotlin. The application fetches video data from an API and displays it in a list. Users 
can tap on a video item to view its details and watch the video.

## Features

- Fetches and displays a list of videos from a remote API.
- Displays video details including thumbnail, presenter name, and description.
- Allows users to watch the video in a separate video player activity.
- Utilizes MVVM architecture for clear separation of concerns.
- Implements Dependency Injection with Hilt.
- Uses Retrofit for network requests.
- Utilizes Glide for image loading.
- Provides unit tests for the repository and ViewModel using Mockito.

## Getting Started

### Prerequisites

- Android Studio Arctic Fox or later
- Kotlin 1.5.30 or later

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/brams-9/mvvm-kotlin-android.git
    ```
2. Open the project in Android Studio.

3. Build the project to download dependencies.

### Running the App

1. Connect an Android device or start an emulator.

2. Click the "Run" button in Android Studio.

### Architecture

The project follows the MVVM architecture pattern:

- **Model**: Contains the data classes and repository. Handles data operations.
- **View**: Activities and layouts. Displays data and passes user actions to the ViewModel.
- **ViewModel**: Holds UI-related data and handles logic. Communicates with the repository and updates the view.

### Dependencies

- **Retrofit**: For network requests.
- **Gson**: For JSON parsing.
- **Glide**: For image loading.
- **Hilt**: For dependency injection.
- **Mockito**: For unit testing.

### API

The application fetches video data from the following API endpoint:

https://quipper.github.io/native-technical-exam/playlist.json

### Unit Tests

Unit tests are provided for the `PlaylistDataRepository` and `PlaylistViewModel` using Mockito.

#### Running Unit Tests

1. Right-click on the `test` directory in Android Studio.
2. Select "Run Tests" to execute all test
