package com.java.study.javastudy.controller;

import io.github.yedaxia.apidocs.ApiDoc;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: java-study
 * @description: jApiDoc的示例controller
 * @author: Mr.Xu
 * @create: 2019-04-26 21:51
 **/

@RestController
@RequestMapping("javaApiDocController")
public class JavaApiDocController {

	/**
	 *   获取gestring
	 * @param  name 姓名
	 * @deprecated   xys
	 * @date 2019/4/26
	 */
	@ApiDoc(String.class)
	@PostMapping("/getString")
	public String  getString(@RequestParam(required = false,value = "a") String name){
		System.out.println(name);
		return "";
	}


	/**
	 *   getObject
	 * @param  name 姓名
	 * @deprecated   xys
	 * @date 2019/4/26
	 */
	@ApiDoc(MyObject.class)
	@PostMapping("/getObject")
	public String  getObject( List<String> name){
		System.out.println(name);
		return "";
	}

	/**
	 *   getObjectNNN
	 * @param  name 姓名
	 * @deprecated   xys
	 * @date 2019/4/26
	 */
	@ApiDoc(NeiObject.class)
	@PostMapping("/getObjectNNN")
	public String  getObjectNNN(MyObject name){
		System.out.println(name);
		return "";
	}

	/**
	 *
	 *
	 * @see com.java.study.javastudy.annotations.MethodLogAspect
	 *   getObjectExtends
	 * @param  name 姓名
	 * @deprecated   xys
	 * @date 2019/4/26
	 */
	@ApiDoc(AAAA.class)
	@PostMapping("/getObjectExtends")
	public String  getObjectExtends(MyObject name){
		System.out.println(name);
		return "";
	}

}

class MyObject{
	private String name;
	private int intp;
	private long longp;
	private Integer nameI;
	private List list;
}

class NeiObject{
	private String ns;
	private int a;
	private MyObject myObject;
}

class AAAA extends MyObject{
	private String my;
}