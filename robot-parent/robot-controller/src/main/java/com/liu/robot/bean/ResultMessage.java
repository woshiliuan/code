package com.liu.robot.bean;
/**
* @author 作者 :ANLIU
* @version 创建时间:2016年7月2日
* 类说明
*/
public class ResultMessage <T>
{
	private int retCode;
	private String retErrorMsg;
	private T data;
	public int getRetCode()
	{
		return retCode;
	}
	public void setRetCode(int retCode)
	{
		this.retCode = retCode;
	}
	public String getRetErrorMsg()
	{
		return retErrorMsg;
	}
	public void setRetErrorMsg(String retErrorMsg)
	{
		this.retErrorMsg = retErrorMsg;
	}
	public T getData()
	{
		return data;
	}
	public void setData(T data)
	{
		this.data = data;
	}
}
