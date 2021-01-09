package com.rookie;

import jdk.nashorn.api.scripting.ClassFilter;
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MyClassFilterTest {
    class MyCF implements ClassFilter {
        @Override
        public boolean exposeToScripts(String s) {
            if (s.compareTo("java.io.File") == 0) return false;
            return true;
        }
    }

    public void testClassFilter() {

        final String script =
                "print(java.lang.System.getProperty(\"java.home\"));" +
                        "print(\"Create file variable\");" +
                        "var File = Java.type(\"java.io.File\");";

        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();

        ScriptEngine engine = factory.getScriptEngine(
                new MyClassFilterTest.MyCF());
        try {
            engine.eval(script);
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.toString());
        }
    }

    public static void main(String[] args) {
//        MyClassFilterTest myApp = new MyClassFilterTest();
//        myApp.testClassFilter();
/*        Path path = Paths.get("");
        System.out.println(path.getRoot());
        System.out.println(path.getFileSystem());
        System.out.println(path.getFileName());*/
        try {
            Path path = Files.createTempDirectory("abc");
            System.out.println(path);
            List<Number> numberList = new ArrayList<>();
            List<Integer> integerList = new ArrayList<>();
            if ((args.length == 1)) {
                System.out.println(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
