package com.lucius.business.enums;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/28
 * @Emial Lucius.li@ixiaoshuidi.com
 */
public enum HardwareElectricitySwitchStatus {
    ON("通电"),OFF("断电");

    // 枚举说明
    private String value;

    private HardwareElectricitySwitchStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
