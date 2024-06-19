package com.yyliu.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yyliu.compose.module.Conversation
import com.yyliu.compose.ui.theme.LearnComposeTheme
import com.yyliu.compose.utils.MockData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //单独的一个卡片组件，相当于helloWorld
//                    Greeting("Android")
                    val messages = MockData.getMsgList()
                    Conversation(messages = messages)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(all = 8.dp)) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Text(
            text = "Hello $name!",
            modifier = modifier
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnComposeTheme {
        Greeting("Android")
    }
}