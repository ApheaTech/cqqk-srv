/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.aphea.cqqksrv.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

//	private T result;
//
//	public T getresult() {
//		return this.result;
//	}
//
//	public void setresult(T result) {
//		this.result = result;
//	}

	public R() {
		put("returnCode", "000000");
		put("returnMsg", "成功");
	}

	public <T> T getResult(String info, TypeReference<T> tTypeReference) {
		Object result = get(info);
		String s = JSON.toJSONString(result);
		T t = JSON.parseObject(s, tTypeReference);

		return t;
	}

	public R setResult(Object result) {
		put("result", result);
		return this;
	}

	public static R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static R error(String returnMsg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, returnMsg);
	}
	
	public static R error(int returnCode, String returnMsg) {
		R r = new R();
		r.put("returnCode", returnCode);
		r.put("returnMsg", returnMsg);
		return r;
	}

	public static R ok(String returnMsg) {
		R r = new R();
		r.put("returnMsg", returnMsg);
		return r;
	}
	
	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}
	
	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}

	public Integer getreturnCode() {
		return (Integer) this.get("returnCode");
	}
}
