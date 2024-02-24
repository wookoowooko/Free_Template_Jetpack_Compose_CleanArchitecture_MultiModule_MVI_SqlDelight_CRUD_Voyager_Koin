package io.genry.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import io.genry.template.presenter.screens.YourStartScreen
import io.genry.template.presenter.ui.theme.Template_Jetpack_Compose_CleanArchitecture_MultiModule_MVI_SqlDelight_CRUD_Voyager_Koin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Template_Jetpack_Compose_CleanArchitecture_MultiModule_MVI_SqlDelight_CRUD_Voyager_Koin {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigator(YourStartScreen())
                }
            }
        }
    }
}
