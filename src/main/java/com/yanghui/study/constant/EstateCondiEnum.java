package com.yanghui.study.constant;
/**
 * 房产状况
 * @author think
 *
 */
public enum EstateCondiEnum {
	
	NON(1,"无"),
	SZSPF(2,"深圳商品房"),
	SZXCQF(3,"深圳小产权房"),
	FSZSPF(4,"非深商品房"),
	;
	
	private int type;
	private String name;
	private EstateCondiEnum(int type, String name) {
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
	
	public EstateCondiEnum get(int type) {
		for(EstateCondiEnum se : EstateCondiEnum.values()) {
			if(type == se.type) {
				return se;
			}
		}
		return null;
	}
}
