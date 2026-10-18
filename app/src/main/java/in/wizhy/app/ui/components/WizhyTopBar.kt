package in.wizhy.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import in.wizhy.app.ui.theme.WizhyCream
import in.wizhy.app.ui.theme.WizhyDarkCard
import in.wizhy.app.ui.theme.WizhyOrange
import in.wizhy.app.ui.theme.WizhyOrangeDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WizhyTopBar(
    selectedCurrency: String,
    onCurrencyToggle: () -> Unit
) {
    val context = LocalContext.current

    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(WizhyOrange, WizhyOrangeDark)
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "W",
                        color = WizhyCream,
                        fontWeight = FontWeight.Black,
                        fontSize = 20.sp
                    )
                }
                Column {
                    Text(
                        text = "Wizhy",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                    Text(
                        text = "Web Studio",
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 11.sp,
                        color = WizhyOrange,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        },
        actions = {
            // Currency Switcher Chip
            FilledTonalButton(
                onClick = onCurrencyToggle,
                contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                modifier = Modifier.height(34.dp),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onSurface
                ),
                shape = CircleShape
            ) {
                Text(
                    text = if (selectedCurrency == "INR") "🇮🇳 ₹ INR" else "🇺🇸 $ USD",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            // Direct Link to live website
            IconButton(
                onClick = { ActionUtils.openWebsite(context) }
            ) {
                Icon(
                    imageVector = Icons.Default.Language,
                    contentDescription = "Visit Website",
                    tint = WizhyOrange
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        )
    )
}
