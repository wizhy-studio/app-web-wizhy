package in.wizhy.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import in.wizhy.app.ui.components.Screen
import in.wizhy.app.ui.components.WizhyBottomBar
import in.wizhy.app.ui.components.WizhyTopBar
import in.wizhy.app.ui.screens.*
import in.wizhy.app.ui.theme.WizhyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WizhyAppTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route ?: Screen.HOME.route

                var selectedCurrency by remember { mutableStateOf("INR") }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        WizhyTopBar(
                            selectedCurrency = selectedCurrency,
                            onCurrencyToggle = {
                                selectedCurrency = if (selectedCurrency == "INR") "USD" else "INR"
                            }
                        )
                    },
                    bottomBar = {
                        WizhyBottomBar(
                            currentRoute = currentRoute,
                            onNavigate = { route ->
                                if (currentRoute != route) {
                                    navController.navigate(route) {
                                        popUpTo(Screen.HOME.route) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HOME.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.HOME.route) {
                            HomeScreen(
                                selectedCurrency = selectedCurrency,
                                onNavigateToServices = { navController.navigate(Screen.SERVICES.route) },
                                onNavigateToPricing = { navController.navigate(Screen.PRICING.route) },
                                onNavigateToAudit = { navController.navigate(Screen.AUDIT.route) },
                                onNavigateToContact = { navController.navigate(Screen.CONTACT.route) }
                            )
                        }

                        composable(Screen.SERVICES.route) {
                            ServicesScreen(
                                onNavigateToContact = { navController.navigate(Screen.CONTACT.route) }
                            )
                        }

                        composable(Screen.PRICING.route) {
                            PricingScreen(
                                selectedCurrency = selectedCurrency,
                                onNavigateToContact = { navController.navigate(Screen.CONTACT.route) }
                            )
                        }

                        composable(Screen.AUDIT.route) {
                            AuditScreen()
                        }

                        composable(Screen.CONTACT.route) {
                            ContactScreen()
                        }
                    }
                }
            }
        }
    }
}
