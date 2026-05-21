package ni.edu.uam.pasteleria_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ni.edu.uam.pasteleria_app.ui.screens.components.LoadingIndicator
import ni.edu.uam.pasteleria_app.ui.screens.clientes.ClienteDetailScreen
import ni.edu.uam.pasteleria_app.ui.screens.clientes.ClienteFormScreen
import ni.edu.uam.pasteleria_app.ui.screens.clientes.ClienteListScreen
import ni.edu.uam.pasteleria_app.ui.screens.home.HomeScreen
import ni.edu.uam.pasteleria_app.ui.screens.pedidos.PedidoDetailScreen
import ni.edu.uam.pasteleria_app.ui.screens.pedidos.PedidoFormScreen
import ni.edu.uam.pasteleria_app.ui.screens.pedidos.PedidoListScreen
import ni.edu.uam.pasteleria_app.viewmodel.ClienteViewModel
import ni.edu.uam.pasteleria_app.viewmodel.PedidoViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val clienteViewModel: ClienteViewModel = viewModel()
    val pedidoViewModel: PedidoViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        composable(Routes.HOME) {
            HomeScreen(
                onClientesClick = {
                    navController.navigate(Routes.CLIENTES)
                },
                onPedidosClick = {
                    navController.navigate(Routes.PEDIDOS)
                }
            )
        }

        composable(Routes.CLIENTES) {
            if (clienteViewModel.isLoading) {
                LoadingIndicator("Cargando clientes...")
            } else {
                ClienteListScreen(
                    clientes = clienteViewModel.clientes,
                    onAgregarClick = {
                        navController.navigate(Routes.CLIENTE_FORM)
                    },
                    onEditarClick = { clienteId ->
                        navController.navigate("${Routes.CLIENTE_FORM}/$clienteId")
                    },
                    onEliminarClick = { clienteId ->
                        clienteViewModel.eliminarCliente(clienteId)
                    },
                    onDetalleClick = { cliente ->
                        navController.navigate("${Routes.CLIENTE_DETAIL}/${cliente.id}")
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Routes.CLIENTE_FORM) {
            ClienteFormScreen(
                clienteId = null,
                onGuardarClick = { cliente ->
                    clienteViewModel.guardarCliente(cliente)
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("${Routes.CLIENTE_FORM}/{clienteId}") { backStackEntry ->
            val clienteId = backStackEntry.arguments
                ?.getString("clienteId")
                ?.toLongOrNull()

            ClienteFormScreen(
                clienteId = clienteId,
                onGuardarClick = { cliente ->
                    clienteViewModel.guardarCliente(cliente)
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("${Routes.CLIENTE_DETAIL}/{clienteId}") { backStackEntry ->
            val clienteId = backStackEntry.arguments
                ?.getString("clienteId")
                ?.toLongOrNull()

            val cliente = clienteViewModel.buscarClientePorId(clienteId)

            if (cliente != null) {
                ClienteDetailScreen(
                    cliente = cliente,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onEditarClick = { id ->
                        navController.navigate("${Routes.CLIENTE_FORM}/$id")
                    },
                    onEliminarClick = { id ->
                        clienteViewModel.eliminarCliente(id)
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Routes.PEDIDOS) {
            if (pedidoViewModel.isLoading) {
                LoadingIndicator("Cargando pedidos...")
            } else {
                PedidoListScreen(
                    pedidos = pedidoViewModel.pedidos,
                    onAgregarClick = {
                        navController.navigate(Routes.PEDIDO_FORM)
                    },
                    onEditarClick = { pedidoId ->
                        navController.navigate("${Routes.PEDIDO_FORM}/$pedidoId")
                    },
                    onEliminarClick = { pedidoId ->
                        pedidoViewModel.eliminarPedido(pedidoId)
                    },
                    onDetalleClick = { pedido ->
                        navController.navigate("${Routes.PEDIDO_DETAIL}/${pedido.id}")
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable(Routes.PEDIDO_FORM) {
            PedidoFormScreen(
                pedidoId = null,
                clientes = clienteViewModel.clientes,
                onGuardarClick = { pedido ->
                    pedidoViewModel.guardarPedido(pedido)
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("${Routes.PEDIDO_FORM}/{pedidoId}") { backStackEntry ->
            val pedidoId = backStackEntry.arguments
                ?.getString("pedidoId")
                ?.toLongOrNull()

            PedidoFormScreen(
                pedidoId = pedidoId,
                clientes = clienteViewModel.clientes,
                onGuardarClick = { pedido ->
                    pedidoViewModel.guardarPedido(pedido)
                    navController.popBackStack()
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable("${Routes.PEDIDO_DETAIL}/{pedidoId}") { backStackEntry ->
            val pedidoId = backStackEntry.arguments
                ?.getString("pedidoId")
                ?.toLongOrNull()

            val pedido = pedidoViewModel.buscarPedidoPorId(pedidoId)

            if (pedido != null) {
                PedidoDetailScreen(
                    pedido = pedido,
                    onBackClick = {
                        navController.popBackStack()
                    },
                    onEditarClick = { id ->
                        navController.navigate("${Routes.PEDIDO_FORM}/$id")
                    },
                    onEliminarClick = { id ->
                        pedidoViewModel.eliminarPedido(id)
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}