package tz.go.necta.widgettest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import tz.go.necta.widgettest.components.OrderItemDetailsScreen
import tz.go.necta.widgettest.components.Orders

@Composable
fun SetUpNavHost(
    navController: NavHostController,
    startDestination: String = "technician_orders"
) {
    NavHost(navController, startDestination = startDestination) {
        composable("technician_orders") {
            Orders(navController)
        }

        composable("technician_orders_details") {
          OrderItemDetailsScreen(navController)
        }
    }
}