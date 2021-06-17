package com.company.dart

/**
 * https://juejin.cn/post/6974593090354937893/
 */
object 理解hashMap {

    @JvmStatic
    fun main(args: Array<String>) {
        hashmaptest()
//        hashcodetest()
//        Stringhashcodetest()
    }

    private fun hashmaptest() {
//        val map = HashMap<HPBean, Int>();
        val hpBean = HPBean()
        println("hpBean.hashcode 第一次 ${hpBean.hashCode()}")
        println("hpBean.hashcode 第二次 ${hpBean.hashCode()}")
//        map[hpBean] = 1;
//        map[hpBean] = 2;
//        println(map[hpBean])
        println("修改bean内容")
        hpBean.name = "b"
        println("hpBean.hashcode 第三次 ${hpBean.hashCode()}")

        val hpBean2 = HPBean()
        hpBean2.name = "b"
        println("hpBean2.hashcode  ${hpBean2.hashCode()}")

//        println(map[hpBean])
    }

    /**
     * 默认2个对象的hashcode是不同的，自然对象也是不相等的
     * 而且其hashcode是根据地址转成int的，所以你在对象创建之后修改其内容，但他的hashcode值是不变的
     */
    private fun hashcodetest() {
        val hpBean1 = HPBean1()
        val hpBean2 = HPBean1()

        println(hpBean1.hashCode())
        println(hpBean2.hashCode())
        println(hpBean1 == hpBean2)

        hpBean1.name = "c"
        println("修改后 "+hpBean1.hashCode())
    }

    private fun Stringhashcodetest() {
        val s1 = "123"
        val s2 = "123"

        println(s1.hashCode())
        println(s2.hashCode())
        println(s1 === s2)
    }


    class HPBean1 {
        var name: String = "a";
    }

    class HPBean {
        var name = "a";

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as HPBean

            if (name != other.name) return false

            return true
        }

        override fun hashCode(): Int {
            return name.hashCode()
        }

    }
}