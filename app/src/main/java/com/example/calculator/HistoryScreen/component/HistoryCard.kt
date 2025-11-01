package com.example.calculator.HistoryScreen.component

import android.graphics.Color
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.stylusHoverIcon
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.HomeScreen.Room.Model.History

@Composable
fun HistoryItem(item : History, onDelete :() -> Unit , onStateUpdate:() -> Unit) {
    OutlinedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            4.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = item.expression,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.End,
                color =  MaterialTheme.colorScheme.primary,

                )
            Text(
                text = item.result,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.End,
                color =  MaterialTheme.colorScheme.primary
            )
            HorizontalDivider(Modifier.fillMaxWidth())
            
            Row(){

                IconButton(
                    onClick = onDelete

                ) {
                    Icon(
                        Icons.Default.DeleteForever,
                        contentDescription = null

                    )
                }
                IconButton(
                    onClick = onStateUpdate
                ) {
                    Icon(
                        Icons.Default.Calculate,
                        contentDescription = null

                    )
                }


            }



        }


    }
}
