package es.net_tel.weatherapp.ui.screen.components

import es.net_tel.weatherapp.R
import es.net_tel.weatherapp.ui.theme.ColorGradient1
import es.net_tel.weatherapp.ui.theme.ColorGradient2
import es.net_tel.weatherapp.ui.theme.ColorGradient3
import es.net_tel.weatherapp.ui.theme.ColorTextSecondary
import es.net_tel.weatherapp.ui.theme.ColorTextSecondaryVariant
import es.net_tel.weatherapp.ui.theme.ColorWindForecast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.constraintlayout.compose.Dimension

@Composable
fun DailyForecast(
    modifier: Modifier = Modifier,
    forecast: String = "Rain showers",
    date: String = "Monday, 12 Feb"
) {
    // Use Card for a consistent background and elevation
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        // Set the Card's own color to transparent so the Box behind it is visible
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        // This Box will hold the gradient background
        Box(
            modifier = Modifier.background(
                brush = Brush.linearGradient(
                    listOf(ColorGradient1, ColorGradient2, ColorGradient3)
                )
            )
        ) {
            Row(
                modifier = Modifier.padding(top = 24.dp, bottom = 24.dp, start = 4.dp, end = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // -- LEFT SIDE: Image and Text --
                Column(modifier = Modifier.weight(1f)) {
                    Image(
                        painter = painterResource(R.drawable.img_sub_rain),
                        contentDescription = null, // Consider providing a meaningful description
                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier.height(175.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp)) // Use Spacer for spacing

                    Text(
                        text = forecast,
                        style = MaterialTheme.typography.titleLarge,
                        color = ColorTextSecondary,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 20.dp) // Adjusted from original 24.dp
                    )

                    Text(
                        text = date,
                        style = MaterialTheme.typography.bodyMedium,
                        color = ColorTextSecondaryVariant,
                        modifier = Modifier.padding(start = 20.dp) // Adjusted from original 24.dp
                    )
                }

                // -- RIGHT SIDE: Forecast Value and Wind Image --
                Column(horizontalAlignment = Alignment.End) {
                    ForecastValue()

                    Spacer(modifier = Modifier.height(16.dp)) // Adds space between the items

                    WindForecastImage()
                }
            }
        }
    }
}

//@Composable
//private fun CardBackground(
//    modifier: Modifier = Modifier
//) {
//    Box(
//        modifier = modifier
//            .fillMaxWidth()
//            .background(
//                brush = Brush.linearGradient(
//                    0f to ColorGradient1,
//                    0.5f to ColorGradient2,
//                    1f to ColorGradient3
//                ),
//                shape = RoundedCornerShape(32.dp)
//            )
//    )
//}

@Composable
private fun ForecastValue(
    modifier: Modifier = Modifier,
    degree: String = "21",
    description: String = "Feels like 26°"
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                text = degree,
                letterSpacing = 0.sp,
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Black
                ),
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = "°",
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        0f to Color.White,
                        1f to Color.White.copy(alpha = 0.3f)
                    ),
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Light,
                ),
                modifier = Modifier.padding(top = 2.dp)
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            color = ColorTextSecondaryVariant
        )
    }
}

@Composable
private fun WindForecastImage(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_frosty),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
        Icon(
            painter = painterResource(R.drawable.ic_wind),
            contentDescription = null,
            modifier = Modifier.size(60.dp),
            tint = ColorWindForecast
        )
    }
}
