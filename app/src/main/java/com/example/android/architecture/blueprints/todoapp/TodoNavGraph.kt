package com.example.messages

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.messages.TodoDestinationsArgs.TASK_ID_ARG
import com.example.messages.TodoDestinationsArgs.TITLE_ARG
import com.example.messages.TodoDestinationsArgs.USER_MESSAGE_ARG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TodoNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = TodoDestinations.TASKS_ROUTE,
    navActions: TodoNavigationActions = remember(navController) { TodoNavigationActions(navController) }
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(
            TodoDestinations.TASKS_ROUTE,
            arguments = listOf(navArgument(USER_MESSAGE_ARG) { defaultValue = 0 })
        ) { entry ->
            TasksScreen(
                userMessage = entry.arguments?.getInt(USER_MESSAGE_ARG) ?: 0,
                onUserMessageDisplayed = { entry.arguments?.putInt(USER_MESSAGE_ARG, 0) },
                onAddTask = { navActions.navigateToAddEditTask(R.string.add_task, null) },
                onTaskClick = { task -> navActions.navigateToTaskDetail(task.id) }
            )
        }

        composable(TodoDestinations.STATISTICS_ROUTE) {
            StatisticsScreen()
        }

        composable(
            TodoDestinations.ADD_EDIT_TASK_ROUTE,
            arguments = listOf(
                navArgument(TITLE_ARG) {},
                navArgument(TASK_ID_ARG) { nullable = true }
            )
        ) { entry ->
            val taskId = entry.arguments?.getString(TASK_ID_ARG)
            AddEditTaskScreen(
                topBarTitle = entry.arguments?.getInt(TITLE_ARG) ?: 0,
                onTaskUpdate = {
                    navActions.navigateToTasks(if (taskId == null) ADD_EDIT_RESULT_OK else EDIT_RESULT_OK)
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(TodoDestinations.TASK_DETAIL_ROUTE) {
            TaskDetailScreen(
                onEditTask = { taskId -> navActions.navigateToAddEditTask(R.string.edit_task, taskId) },
                onBack = { navController.popBackStack() },
                onDeleteTask = { navActions.navigateToTasks(DELETE_RESULT_OK) }
            )
        }
    }
}

const val ADD_EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 1
const val DELETE_RESULT_OK = Activity.RESULT_FIRST_USER + 2
const val EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 3