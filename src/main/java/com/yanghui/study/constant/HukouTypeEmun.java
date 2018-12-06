package com.yanghui.study.constant;
/**
 * 地址类别
 * @author think
 *
 */
public enum HukouTypeEmun {
	
	ZIZHI(1,"自置"),
	QINSHU(2,"亲属房"),
	ZULIN(3,"租赁"),
	;
	
	private int type;
	private String name;
	private HukouTypeEmun(int type, String name) {
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
	
	public HukouTypeEmun get(int type) {
		for(HukouTypeEmun se : HukouTypeEmun.values()) {
			if(type == se.type) {
				return se;
			}
		}
		return null;
	}
}
