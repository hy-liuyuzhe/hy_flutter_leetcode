package com.company.dart

import kotlin.jvm.JvmStatic
import com.company.dart.Orange3
import com.company.dart.Fruit3
import com.company.dart.Apple3
import java.util.ArrayList

object Fruit_kotlin {
    @JvmStatic
    fun main(args: Array<String>) {
        val orange3s = ArrayList<Orange3>()
//        addApple(orange3s);//kotlin 是类型安全的
    }

    //PECS
    fun addApple(fruits: ArrayList<in Fruit3>) { //out 是进入方法传（产生）
        fruits.add(Apple3()) //in 这是消费行为
    }
}

open class Fruit3
class Orange3 : Fruit3()
class Apple3 : Fruit3()