package com.java.study.javastudy.controller;

import com.xuyuansheng.demospringbootstarter.PropertiesConfig;
import com.xuyuansheng.demospringbootstarter.StarterAutoConfigure;
import com.xuyuansheng.demospringbootstarter.StarterService;
import io.github.yedaxia.apidocs.ApiDoc;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	StarterService  starterService;

	@Autowired
	StarterAutoConfigure  starterAutoConfigure;

	@Autowired
	PropertiesConfig propertiesConfig;

	/**
	 * 获取java,api的描述
	 * @param name 参数 name
	 * @return 返回一个String
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
	public String  getObject(List<String> name){
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
	public NeiObject  getObjectNNN(MyObject name){
		System.out.println(name);
		return null;
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
		return null;
	}

}

class MyObject{
	private String name;
	private int intp;
	private long longp;
	private Integer nameI;
	private List list;
	private NeiObject neiObject;
}

class NeiObject{
	private String ns;
	private int a;
	private MyObject myObject;
}

class AAAA extends MyObject{
	private String my;
	private AAAA aaa;
}