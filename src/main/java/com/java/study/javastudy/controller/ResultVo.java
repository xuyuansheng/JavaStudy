package com.java.study.javastudy.controller;

import lombok.Data;

/**
 * @program: api-docconfig
 * @description: 结果类
 * @author: Mr.Xu
 * @create: 2019-05-29 11:13
 **/
@Data
public class ResultVo<T> {
	/** 是否成功获取到结果 */
	private boolean ifSuccess;
	/** 如果失败时的提示信息 */
	private String message;
	/** 结果数据 */
	private T data;


	public ResultVo(boolean ifSuccess, String message, T data) {
		this.ifSuccess = ifSuccess;
		this.message = message;
		this.data = data;
	}

	public static <T>ResultVo <T>  getSuccess(T data){
		return new <T>ResultVo(true, "success", data);
	}

	public static <T>ResultVo<T>  getFailed(String message,T data){
		return new <T>ResultVo(false, message, data);
	}
}
