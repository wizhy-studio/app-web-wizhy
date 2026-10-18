package in.wizhy.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import in.wizhy.app.ui.theme.WizhyOrange

enum class Screen(val route: String, val title: String, val icon: ImageVector) {
    HOME("home", "Home", Icons.Default.Home),
    SERVICES("services", "Services", Icons.Default.GridView),
    PRICING("pricing", "Pricing", Icons.Default.Payments),
    AUDIT("audit", "SEO Audit", Icons.Default.Speed),
    CONTACT("contact", "Contact", Icons.Default.ChatBubble)
}

@Composable
fun WizhyBottomBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        tonalElevation = NavigationBarDefaults.Elevation
    ) {
        val items = listOf(
            Screen.HOME,
            Screen.SERVICES,
            Screen.PRICING,
            Screen.AUDIT,
            Screen.CONTACT
        )

        items.forEach { screen ->
            val isSelected = currentRoute == screen.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onNavigate(screen.route) },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.title
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = WizhyOrange,
                    selectedTextColor = WizhyOrange,
                    indicatorColor = WizhyOrange.copy(alpha = 0.15f),
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
            )
        }
    }
}
