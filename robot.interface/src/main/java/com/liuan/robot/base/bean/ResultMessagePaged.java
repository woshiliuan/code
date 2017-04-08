package com.liuan.robot.base.bean;
/**
* @author 作者 :ANLIU
* @version 创建时间:2016年7月2日
* 类说明
*/
public class ResultMessagePaged <T> extends ResultMessage<T>
{
	private int pageCurrent = 1 ; 
	
	private int pageTotal;
	
	private int dataCount;
	
	private int pageSize = 10;
	
	public int getPageCurrent()
	{
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent)
	{
		this.pageCurrent = pageCurrent;
	}

	public int getPageTotal()
	{
		return pageTotal;
	}

	public void setPageTotal(int pageTotal)
	{
		this.pageTotal = pageTotal;
	}

	public int getDataCount()
	{
		return dataCount;
	}

	public void setDataCount(int dataCount)
	{
		this.dataCount = dataCount;
	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

}
