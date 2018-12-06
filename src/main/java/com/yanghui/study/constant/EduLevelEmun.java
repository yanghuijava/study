package com.yanghui.study.constant;
/**
 * 学历
 * @author think
 *
 */
public enum EduLevelEmun {
	
	BENKE(1,"本科及以上"),
	DAZHUAN(2,"大专"),
	GAOZHONG(3,"高中"),
	CHUZHONG(4,"初中及以下"),
	;
	
	private int type;
	private String name;
	private EduLevelEmun(int type, String name) {
		this.type = type;
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public EduLevelEmun get(int type) {
		for(EduLevelEmun se : EduLevelEmun.values()) {
			if(type == se.type) {
				return se;
			}
		}
		return null;
	}
}
