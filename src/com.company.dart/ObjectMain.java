package com.company.dart;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ObjectMain {

    public static void main(String[] args) {
        WeakReference<Object> a = new WeakReference<Object>("aa");
//        Object a = new Object();
        Object b = a;
        Object c = a;
        System.out.println(a);
        a = null;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
