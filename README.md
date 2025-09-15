# My Design System

A custom Android design system library built with Jetpack Compose, featuring reusable UI components with consistent styling and theming.

## 🚀 Features

- **ButtonApp**: Custom button component with unique rounded corners and dynamic styling
- **Custom Typography**: Predefined text styles for consistent design
- **Color System**: Organized color palette for different UI states
- **JitPack Ready**: Configured for easy distribution via JitPack

## 📦 Installation

### Using JitPack

Add JitPack repository to your root `build.gradle` file:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency:

```gradle
dependencies {
    implementation 'com.github.nguyenxdat:my-design-system:1.0.0'
}
```

### Local Development

To use this library locally in your project:

```gradle
dependencies {
    implementation project(':library')
}
```

## 🎨 Components

### ButtonApp

A custom button component with unique styling and state management.

#### Features:
- Custom rounded corners (8dp top-left, top-right, bottom-right)
- Dynamic colors based on enabled state
- Custom typography integration
- Consistent padding and styling

#### Usage:

```kotlin
import com.datnx.design_system.components.ButtonApp

@Composable
fun MyScreen() {
    ButtonApp(
        modifier = Modifier.fillMaxWidth(),
        btnTitle = "Click Me",
        isEnable = true,
        onBtnClick = {
            // Handle button click
        }
    )
}
```

#### Parameters:
- `modifier: Modifier` - Modifier for the button
- `btnTitle: String` - Text to display on the button
- `isEnable: Boolean` - Enable/disable state (default: true)
- `onBtnClick: () -> Unit` - Click callback

## 🎭 Theming

### Setting up the Theme

To use the design system's typography in your app:

```kotlin
import com.datnx.design_system.theme.LocalTypo
import com.datnx.design_system.theme.customType

@Composable
fun MyApp() {
    CompositionLocalProvider(
        LocalTypo provides customType
    ) {
        MaterialTheme {
            // Your app content
        }
    }
}
```

### Colors

The library includes predefined colors:

- `PrimaryColor` - Main brand color (Lime Green)
- `DisableColor` - Disabled state color
- `TextEnableColor` - Text color for enabled buttons
- `TextDisableColor` - Text color for disabled buttons
- And more...

### Typography

Access custom text styles:

```kotlin
import com.datnx.design_system.theme.LocalTypo

@Composable
fun MyText() {
    Text(
        text = "Hello World",
        style = LocalTypo.current.textButtonEnable
    )
}
```

Available text styles:
- `textButtonEnable` - For enabled button text
- `textButtonDisable` - For disabled button text
- `dialogTitle` - For dialog titles
- `normal` - For regular text
- And more...

## 📱 Demo App

The project includes a demo app with examples:

1. **MainActivity**: Basic ButtonApp usage examples
2. **AdvancedButtonDemoActivity**: Advanced layouts and state management

### Running the Demo

1. Clone the repository
2. Open in Android Studio
3. Run the `app` module
4. Explore different button configurations and interactions

## 🛠 Development

### Project Structure

```
mydesignsystem/
├── app/                     # Demo application
│   └── src/main/java/com/datnx/my_design_system/
│       ├── MainActivity.kt
│       ├── AdvancedButtonDemoActivity.kt
│       └── ui/theme/Theme.kt
├── library/                 # Design system library
│   └── src/main/java/com/datnx/design_system/
│       ├── components/
│       │   └── ButtonApp.kt
│       └── theme/
│           ├── Color.kt
│           ├── CustomType.kt
│           └── Text.kt
└── build.gradle.kts
```

### Building the Library

To build the library:

```bash
./gradlew :library:build
```

To publish locally:

```bash
./gradlew :library:publishToMavenLocal
```

## 🎯 Usage Examples

### Basic Button

```kotlin
ButtonApp(
    btnTitle = "Save",
    onBtnClick = { /* Save action */ }
)
```

### Disabled Button

```kotlin
ButtonApp(
    btnTitle = "Submit",
    isEnable = false,
    onBtnClick = { /* Won't be called */ }
)
```

### Full Width Button

```kotlin
ButtonApp(
    modifier = Modifier.fillMaxWidth(),
    btnTitle = "Continue",
    onBtnClick = { /* Continue action */ }
)
```

### Button Row

```kotlin
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(8.dp)
) {
    ButtonApp(
        modifier = Modifier.weight(1f),
        btnTitle = "Cancel",
        onBtnClick = { /* Cancel */ }
    )
    ButtonApp(
        modifier = Modifier.weight(1f),
        btnTitle = "OK",
        onBtnClick = { /* Confirm */ }
    )
}
```

## 📄 License

MIT License - see LICENSE file for details.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## 📞 Contact

- Author: Dat Nguyen
- Email: nguyenxtdat@gmail.com
- GitHub: [@nguyenxdat](https://github.com/nguyenxdat)
