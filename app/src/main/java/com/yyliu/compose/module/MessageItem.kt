package com.yyliu.compose.module

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.yyliu.compose.R
import com.yyliu.compose.model.Message

/**
 *    author : LIU YANG
 *    date   : 2024/6/18
 *    desc   :
 */
@Composable
fun MessageCard(
    msg: Message,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    var isExpanded by remember { mutableStateOf(msg.selected) } // 创建一个能够检测卡片是否被展开的变量
    Column(
        modifier = Modifier
            .padding(all = 8.dp)
//        fun Modifier.clickable(
//            enabled: Boolean = true,
//            onClickLabel: String? = null,
//            role: Role? = null,
//            onClick: () -> Unit
//        )
//        {
            //添加一个新的Modifier 扩展方法，可以让元素具有点击的效果
//          isExpanded = !isExpanded
//        }
//            .clickable(onClick = onClick.apply { isExpanded = !isExpanded })
            .clickable(onClick = {
                onClick.invoke()
                isExpanded = !isExpanded
            })
//            .clickable(onClickLabel = null, role = null, onClick = onClick.apply { isExpanded = !isExpanded })
    ) {
        Text(
            text = "Hello ${msg.author}!",
            modifier = modifier
        )
        Text(
            text = "content ${msg.body}!",
            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
            modifier = modifier//.animateContentSize { initialValue, targetValue ->  }
        )
        Spacer(Modifier.padding(vertical = 8.dp)) //添加一个空的控件来填充水平间距，设置padding为8.dp
        Row {
            Image(
                painterResource(id = R.mipmap.cash_in_right_7d),
                contentDescription = "profile picture",
                modifier = Modifier
                    .size(50.dp) //改变Image 元素的大小
                    .clip(CircleShape)//将图片裁成圆形
                    .border(0.5.dp, MaterialTheme.colorScheme.secondary, shape = CircleShape)//添加边框

            )
        }
    }
}
//@Composable
//fun MessageCard(
//    msg: Message,
//    modifier: Modifier = Modifier,
//    isExpanded: Boolean,
//    onClick: () -> Unit
//) {
////    var isExpanded by remember { mutableStateOf(false) } // 创建一个能够检测卡片是否被展开的变量
//    Column(
//        modifier = Modifier
//            .padding(all = 8.dp)
////        fun Modifier.clickable(
////            enabled: Boolean = true,
////            onClickLabel: String? = null,
////            role: Role? = null,
////            onClick: () -> Unit
////        )
////        {
//            //添加一个新的Modifier 扩展方法，可以让元素具有点击的效果
////          isExpanded = !isExpanded
////        }
//            .clickable(onClickLabel = null, role = null, onClick = onClick.apply {  })
//    ) {
//        Text(
//            text = "Hello ${msg.author}!",
//            modifier = modifier
//        )
//        Text(
//            text = "content ${msg.body}!",
//            maxLines = if (isExpanded) Int.MAX_VALUE else 1,
//            modifier = modifier//.animateContentSize { initialValue, targetValue ->  }
//        )
//        Spacer(Modifier.padding(vertical = 8.dp)) //添加一个空的控件来填充水平间距，设置padding为8.dp
//        Row {
//            Image(
//                painterResource(id = R.mipmap.cash_in_right_7d),
//                contentDescription = "profile picture",
//                modifier = Modifier
//                    .size(50.dp) //改变Image 元素的大小
//                    .clip(CircleShape)//将图片裁成圆形
//                    .border(0.5.dp, MaterialTheme.colorScheme.secondary, shape = CircleShape)//添加边框
//
//            )
//        }
//    }
//}

@Composable
fun Conversation(messages: List<Message>) {
    var openDialog by remember { mutableStateOf(false) }
    var selectedData by remember { mutableStateOf<Message?>(null) }
    if (openDialog) {
        //使用AlertDialog
//        AlertDialog(
//            onDismissRequest = { openDialog = false },
//            title = { selectedData?.author?.let { Text(text = it) } },
//            text = { selectedData?.body?.let { Text(text = it) } },
//            confirmButton = {
//                TextButton(onClick = { openDialog = false }) {
//                    Text("OK")
//                }
//            }
//        )
        //使用自定义dialog
        ScreenWithCustomDialog(openDialog, onDismissRequest = {
            openDialog = false
        })
    }
    LazyColumn {
        items(messages) { message ->
            Log.e("MessageCard", "循环迭代===")
            MessageCard(msg = message, onClick = {
                //todo 调用普通弹框
                openDialog = true
                selectedData = message
            })
//            MessageCard(msg = message, isExpanded = isExpanded, onClick = {
//                isExpanded = !isExpanded
//                //todo 调用普通弹框
//                openDialog = true
//            })
        }
    }
}

