package com.example.messages

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.messages.R

// Define the two Open Sans fonts
val OpenSansRegular = FontFamily(
    Font(R.font.opensans_regular, FontWeight.Normal)
)

val OpenSansSemiBold = FontFamily(
    Font(R.font.opensans_semibold, FontWeight.SemiBold)
)

// Color palette
private val LightColorScheme = lightColorScheme(
    primary = colorResource(id = R.color.colorPrimary),
    onPrimary = colorResource(id = R.color.colorOnPrimary),
    primaryContainer = colorResource(id = R.color.colorPrimaryVariant),
    secondary = colorResource(id = R.color.colorSecondary),
    onSecondary = colorResource(id = R.color.colorOnSecondary),
    secondaryContainer = colorResource(id = R.color.colorSecondaryVariant),
    background = colorResource(id = R.color.colorBackground),
    onBackground = colorResource(id = R.color.colorOnBackground),
    surface = colorResource(id = R.color.colorSurface),
    onSurface = colorResource(id = R.color.colorOnSurface),
    error = colorResource(id = R.color.colorError),
    onError = colorResource(id = R.color.colorOnError)
)

// You can add DarkColorScheme if needed later
private val DarkColorScheme = darkColorScheme(
    primary = colorResource(id = R.color.colorPrimary),
    onPrimary = colorResource(id = R.color.colorOnPrimary),
    primaryContainer = colorResource(id = R.color.colorPrimaryVariant),
    secondary = colorResource(id = R.color.colorSecondary),
    onSecondary = colorResource(id = R.color.colorOnSecondary),
    secondaryContainer = colorResource(id = R.color.colorSecondaryVariant),
    background = colorResource(id = R.color.colorBackground),
    onBackground = colorResource(id = R.color.colorOnBackground),
    surface = colorResource(id = R.color.colorSurface),
    onSurface = colorResource(id = R.color.colorOnSurface),
    error = colorResource(id = R.color.colorError),
    onError = colorResource(id = R.color.colorOnError)
)

@Composable
fun TodoTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(
            bodyLarge = androidx.compose.ui.text.TextStyle(
                fontFamily = OpenSansRegular,
                fontSize = 16.sp
            ),
            bodyMedium = androidx.compose.ui.text.TextStyle(
                fontFamily = OpenSansRegular,
                fontSize = 14.sp
            ),
            titleLarge = androidx.compose.ui.text.TextStyle(
                fontFamily = OpenSansSemiBold,
                fontSize = 20.sp
            ),
            titleMedium = androidx.compose.ui.text.TextStyle(
                fontFamily = OpenSansSemiBold,
                fontSize = 18.sp
            )
        ),
        content = content
    )
}