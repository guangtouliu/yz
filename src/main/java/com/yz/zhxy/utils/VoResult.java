package com.yz.zhxy.utils;

import java.util.HashMap;
import java.util.Map;

import com.yz.zhxy.utils.enums.ResultEnums;

/**
 * 返回结果类,如有其他状态可自行添加
 * @author caojian
 * @date 2018-6-25
 */
public class VoResult {

	private Integer resultCode;
	
	private String resultMsg;
	
	private Map<String,Object> resultData = new HashMap<String,Object>();
	
	public Map<String, Object> getResultData() {
		return resultData;
	}

	public void setResultData(Map<String, Object> resultData) {
		this.resultData = resultData;
	}
	
	/**
	 * 数据已存在
	 * @author caojian
	 * @date 2018年9月3日 下午4:43:04
	 * @editer caojian
	 * @editdate 2018年9月3日 下午4:43:04
	 * @remark
	 */
	public static VoResult dataExists(){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_424.getCode());
		result.setResultMsg(ResultEnums.FALSE_424.getMessage());
		return result;
	}
	
	/**
	 * 数据已存在带参数
	 * @author caojian
	 * @date 2018年11月28日 下午12:49:53
	 * @editer caojian
	 * @editdate 2018年11月28日 下午12:49:53
	 * @remark
	 */
	public static VoResult dataExists(String msg){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_424.getCode());
		result.setResultMsg(msg);
		return result;
	}

	/**
	 * 数据不存在
	 * @author caojian
	 * @date 2018年9月3日 下午4:42:02
	 * @editer caojian
	 * @editdate 2018年9月3日 下午4:42:02
	 * @remark
	 */
	public static VoResult dataNotExists(){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_423.getCode());
		result.setResultMsg(ResultEnums.FALSE_423.getMessage());
		return result;
	}
	
	/**
	 * 数据不存在
	 * @author caojian
	 * @date 2018年9月3日 下午4:42:02
	 * @editer caojian
	 * @editdate 2018年9月3日 下午4:42:02
	 * @remark
	 */
	public static VoResult dataNotExists(String msg){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_423.getCode());
		result.setResultMsg(msg);
		return result;
	}
	
	/**
	 * 成功
	 * @author caojian
	 * @date 2018年6月25日 下午2:24:10
	 * @editer caojian
	 * @editdate 2018年6月25日 下午2:24:10
	 * @remark ResultEnums.TRUE_200
	 */
	public static VoResult success(){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.TRUE_200.getCode());
		result.setResultMsg(ResultEnums.TRUE_200.getMessage());
		return result;
	}
	
	/**
	 * 失败
	 * @author caojian
	 * @date 2018年6月25日 下午2:24:10
	 * @editer caojian
	 * @editdate 2018年6月25日 下午2:24:10
	 * @remark ResultEnums.FALSE_300
	 */
	public static VoResult fail(){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_300.getCode());
		result.setResultMsg(ResultEnums.FALSE_300.getMessage());
		return result;
	}
	
	/**
	 * 内部错误(参数错误)
	 * @author caojian
	 * @date 2018年6月25日 下午2:24:10
	 * @editer caojian
	 * @editdate 2018年6月25日 下午2:24:10
	 * @remark ResultEnums.FALSE_400
	 */
	public static VoResult errorParam(){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_400.getCode());
		result.setResultMsg(ResultEnums.FALSE_400.getMessage());
		return result;
	}
	
	/**
	 * 如需自定义错误信息,请使用该方法
	 * @author caojian
	 * @date 2018年6月25日 下午12:06:39
	 * @editer caojian
	 * @editdate 2018年6月25日 下午12:06:39
	 * @remark
	 */
	public static VoResult errorParam(String msg){
		VoResult result = new VoResult();
		result.setResultCode(ResultEnums.FALSE_400.getCode());
		result.setResultMsg(msg);
		return result;
	}
	
	public VoResult add(String key,Object value){
		this.getResultData().put(key, value);
		return this;
	}
	
	public VoResult(){
		
	}

	public VoResult(Integer resultCode, String resultMsg, Map<String,Object> resultData) {
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.resultData = resultData;
	}

	public Integer getResultCode() {
		return resultCode;
	}

	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

}
