package io.genry.template.presenter.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.genry.template.domain.models.ItemModel

@Composable
 fun Item(
    modifier: Modifier = Modifier,
    item: ItemModel,
    onDelete: () -> Unit,
    onUpdate: () -> Unit
) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Green.copy(0.1f),
        ), border = BorderStroke(1.dp, Color.Black)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = item.id.toString(),
                    modifier.padding(start = 10.dp, end = 16.dp),
                    color = Color.Black,
                    fontSize = 25.sp
                )
                Column(
                    Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = item.title, color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = item.description, color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Start
                    )
                }
                Column(
                    Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    FloatingActionButton(shape = CircleShape,
                        modifier = Modifier.padding(8.dp),
                        containerColor = Color.Red,
                        onClick = {
                            onDelete()
                        }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                    FloatingActionButton(
                        shape = CircleShape,
                        modifier = Modifier.padding(8.dp),
                        containerColor = Color.Yellow,
                        onClick = {
                            onUpdate()
                        }) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = null,
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }
}
