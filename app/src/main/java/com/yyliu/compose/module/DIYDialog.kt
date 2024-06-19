package com.yyliu.compose.module

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

/**
 *    author : LIU YANG
 *    date   : 2024/6/19
 *    desc   : 关于自定义dialog
 */
@Composable
fun CustomDialog(onDismissRequest: () -> Unit, content: @Composable () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest }) {
        Box(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp, 16.dp, 16.dp)
        ) {
            content()
        }
    }
}

@Composable
fun ScreenWithCustomDialog(showDialog: Boolean, onDismissRequest: () -> Unit) {
//    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        CustomDialog(onDismissRequest = { onDismissRequest.invoke() }) {
            Column(
                modifier = Modifier
                    .padding(16.dp, 16.dp, 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Custom Dialog Title", style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Custom Dialog Content")
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = { onDismissRequest.invoke() }) {
                        Text(text = "Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
//                    TextButton(onClick = { onDismissRequest.invoke() }) {
                    TextButton(onClick = onDismissRequest) {
//                        Text(text = "ok")
                        Text("ok")
                    }
                }

            }
        }
    }
}



