package com.java.study.javastudy.javawithpattern;


import java.util.Hashtable;
import java.util.Properties;

/**
 * 里氏代换原则
 */
public abstract class LiskovSubstitutionPrincipleLSP {

	abstract void  methodA();
	abstract void  methodB();

}


class Sub extends LiskovSubstitutionPrincipleLSP{

	Properties properties = new Properties();
	Hashtable hashtable = new Hashtable();

	@Override
	void methodA() {

	}

	@Override
	void methodB() {

	}
}