package com.java.study.javastudy;

public interface SimpleTestInterface {

    @MyMethodLog
    Object my(Object... param);

    @MyMethodLog
    void my2(Object... param);

    Object noAnno(Object... param);

}
