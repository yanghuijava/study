package com.yanghui.study.constant;
/**
 * 婚姻状况
 * @author think
 *
 */
public enum MarriageStatusEnum {
	
	UNMARRIED(1,"未婚"),
	MARRIED(2,"已婚"),
	DIVORCE(3,"离异"),
	NONE(4,"未知");
	
	
	private int status;
	private String name;
	
	private MarriageStatusEnum(int status, String name){
		this.status = status;
        this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static MarriageStatusEnum get(int status){
		for(MarriageStatusEnum m : MarriageStatusEnum.values()){
			if(m.getStatus() == status){
				return m;
			}
		}
		return NONE;
	}
}
