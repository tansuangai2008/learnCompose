package com.yyliu.compose.utils

import com.yyliu.compose.model.Message

/**
 *    author : LIU YANG
 *    date   : 2024/6/18
 *    desc   : 主要用于mock 相关数据的
 */
object MockData {
    fun getMsgList(): MutableList<Message> {
        var msg = Message(
            "钢铁是怎么炼成的", "结庐在人境，而无车马喧。\n" +
                    "问君何能尔？心远地自偏。\n" +
                    "采菊东篱下，悠然见南山。\n" +
                    "山气日夕佳，飞鸟相与还。\n" +
                    "此中有真意，欲辨已忘言。", false
        )
        var msg1 = Message(
            "十万个为什么", "结庐在人境，而无车马喧。\n" +
                    "问君何能尔？心远地自偏。\n" +
                    "采菊东篱下，悠然见南山。\n" +
                    "山气日夕佳，飞鸟相与还。\n" +
                    "此中有真意，欲辨已忘言。", false
        )
        var msg2 = Message(
            "傲慢与偏见", "结庐在人境，而无车马喧。\n" +
                    "问君何能尔？心远地自偏。\n" +
                    "采菊东篱下，悠然见南山。\n" +
                    "山气日夕佳，飞鸟相与还。\n" +
                    "此中有真意，欲辨已忘言。", false
        )
        var msg3 = Message(
            "海底两万里", "结庐在人境，而无车马喧。\n" +
                    "问君何能尔？心远地自偏。\n" +
                    "采菊东篱下，悠然见南山。\n" +
                    "山气日夕佳，飞鸟相与还。\n" +
                    "此中有真意，欲辨已忘言。", false
        )
        var messages = mutableListOf<Message>()
        messages.add(msg)
        messages.add(msg1)
        messages.add(msg2)
        messages.add(msg3)
        return messages
    }
}