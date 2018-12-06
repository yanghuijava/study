package com.yanghui.study.constant;
/**
 * 车辆状况
 * @author think
 *1：无 2:全款 3：按揭 4：押证 5：押车',
 */
public enum VehicleCondiEnum {
	
	NON(1,"无"),
	QK(2,"全款"),
	AJ(3,"按揭"),
	YZ(4,"押证"),
	YC(4,"押车"),
	;
	
	private int type;
	private String name;
	private VehicleCondiEnum(int type, String name) {
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
	
	public VehicleCondiEnum get(int type) {
		for(VehicleCondiEnum se : VehicleCondiEnum.values()) {
			if(type == se.type) {
				return se;
			}
		}
		return null;
	}

}
