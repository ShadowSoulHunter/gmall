package com.atguigu.gmall.bean;

public class UserAddress {
    private String id;
    private String userAddress;
    private String useId;
    private String consignee;
    private String phoneNum;
    private String isDefault;

    public UserAddress() {
    }

    public UserAddress(String id, String userAddress, String useId, String consignee, String phoneNum, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.useId = useId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUseId() {
        return useId;
    }

    public void setUseId(String useId) {
        this.useId = useId;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
