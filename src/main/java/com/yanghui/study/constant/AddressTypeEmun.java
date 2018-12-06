package com.yanghui.study.constant;
/**
 * 户口类别
 * @author think
 *
 */
public enum AddressTypeEmun {
	
	SHENHU(1,"深户"),
	GUANGDONG(2,"广东"),
	WAIDI(3,"外地"),
	;
	
	private int type;
	private String name;
	private AddressTypeEmun(int type, String name) {
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
	
	public AddressTypeEmun get(int type) {
		for(AddressTypeEmun se : AddressTypeEmun.values()) {
			if(type == se.type) {
				return se;
			}
		}
		return null;
	}
}
