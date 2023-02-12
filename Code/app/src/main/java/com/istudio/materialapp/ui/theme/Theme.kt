package com.istudio.materialapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

@Composable
fun MaterialAppTheme(
    // Flag to determine the dark/light theme
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    // Parent most top level composable
    content: @Composable () -> Unit
) {
   // We need context here because the support for dynamic colors comes from android system
    val context = LocalContext.current
    val view = LocalView.current

    // We can apply one of four different color scheme's depending on what type of device the user has.
    // CONDITION-1:-> If the user is running on android-12 and above, We need to use dynamic colors.
    // CONDITION-2:-> If the user is running on device prior to android-12, We will use normal material-2 theme.
    // CONDITION-3:-> If the user again is using light theme, then we use light colors else use dark colors.
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            // CONDITION-1:-> If the user is running on android-12 and above, We need to use dynamic colors.
            if (darkTheme){
                // CONDITION-3:-> If the user again is using dark theme, then we use dark colors.
                dynamicDarkColorScheme(context)
            } else {
                // CONDITION-3:-> If the user again is using light theme, then we use light colors.
                dynamicLightColorScheme(context)
            }
        }
        darkTheme -> {
            // CONDITION-1:-> If the user is running on below android-12, We need to use material-2 colors.
            // CONDITION-3:-> If the user again is using dark theme, then we use dark colors.
            DarkColorScheme
        }
        else -> {
            // CONDITION-1:-> If the user is running on below android-12, We need to use material-2 colors.
            // CONDITION-3:-> If the user again is using light theme, then we use light colors.
            LightColorScheme
        }
    }

    // Set the color for the status bar
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
            ViewCompat.getWindowInsetsController(view)?.isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}