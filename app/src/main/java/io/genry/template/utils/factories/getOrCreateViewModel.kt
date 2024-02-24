
package io.genry.template.utils.factories

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
inline fun <reified T : ViewModel> getOrCreateViewModel(): T {
    return koinViewModel()
}
