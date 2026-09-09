# Cat Medical Organizer

An intuitive Android app to easily organize and manage your cat's medical files, images, and documents all in one place.

## Features

✅ **Easy Cat Management** - Add and manage multiple cats with their information
✅ **Medical File Organization** - Store and categorize medical files by type
✅ **Image Storage** - Keep all cat photos and medical images organized
✅ **Search & Filter** - Quickly find files by name, category, or date
✅ **Categories** - Organize files by: Vaccination, Surgery, Checkup, Other
✅ **Clean Interface** - Simple, intuitive design for easy use without struggle
✅ **Offline Storage** - All data stored locally on your device

## Installation

### Build from Source

1. Clone the repository
```bash
git clone https://github.com/medina3580health-cmd/CatMedicalOrganizer.git
cd CatMedicalOrganizer
```

2. Open in Android Studio

3. Build and run on your Android device or emulator

### System Requirements

- Android 8.0 (API 26) or higher
- Minimum 50MB storage space

## Usage

### Adding a Cat
1. Click the "+" button on the home screen
2. Enter your cat's name, breed, and optional information
3. (Optional) Add a photo
4. Click Save

### Adding Medical Files
1. Select a cat from the list
2. Click "Add Medical File"
3. Choose file type and category
4. Upload or take a photo
5. Add optional details (date, veterinarian name, notes)
6. Click Save

### Organizing Files
- Files are automatically categorized
- Sort by date or category
- Search for specific files quickly
- Delete files individually or by category

## Project Structure

```
CatMedicalOrganizer/
├── src/main/java/com/medicalorganizer/cats/
│   ├── MainActivity.kt
│   ├── data/
│   │   ├── db/
│   │   ├── model/
│   │   └── repository/
│   └── ui/
│       ├── screens/
│       ├── theme/
│       └── viewmodel/
└── src/main/res/
```

## Technologies Used

- **Kotlin** - Primary language
- **Jetpack Compose** - Modern UI framework
- **Room Database** - Local data persistence
- **Coroutines** - Asynchronous programming
- **MVVM Architecture** - Clean architecture pattern

## Permissions

The app requires:
- READ_EXTERNAL_STORAGE - To access files
- WRITE_EXTERNAL_STORAGE - To save medical files
- CAMERA - To capture cat photos (optional)

## Future Features

- Cloud backup
- Share medical records with veterinarian
- Vaccination reminders
- Appointment scheduling
- Export medical history

## License

MIT License - Feel free to use and modify

## Support

For issues or suggestions, please open an issue on GitHub.
