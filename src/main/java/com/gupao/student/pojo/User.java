package com.gupao.student.pojo;

import java.util.Date;
import java.util.List;

public class User extends BaseEntity{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

    private String name;

    private String password;

    private String enterpriseId;

    private String phone;

    private String mobilephone;

    private String fax;

    private String email;

    private String address;

    private String remark;

    private String userId;

    private Long stopSign;

    private String createUser;

    private Date createTime;

    private String supplierId;

    private String departmentId;


    private String signUser;

    private String enterpriseName;

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getStopSign() {
        return stopSign;
    }

    public void setStopSign(Long stopSign) {
        this.stopSign = stopSign;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }


    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }



    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEnterpriseId() == null ? other.getEnterpriseId() == null : this.getEnterpriseId().equals(other.getEnterpriseId()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getMobilephone() == null ? other.getMobilephone() == null : this.getMobilephone().equals(other.getMobilephone()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getStopSign() == null ? other.getStopSign() == null : this.getStopSign().equals(other.getStopSign()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getSupplierId() == null ? other.getSupplierId() == null : this.getSupplierId().equals(other.getSupplierId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEnterpriseId() == null) ? 0 : getEnterpriseId().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getMobilephone() == null) ? 0 : getMobilephone().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStopSign() == null) ? 0 : getStopSign().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getSupplierId() == null) ? 0 : getSupplierId().hashCode());
        return result;
    }

    public User(String code, String name, String password, String enterpriseId, String phone, String mobilephone, String fax, String email, String address, String remark, String userId, Long stopSign, String createUser, Date createTime, String supplierId, String departmentId, String signUser, String enterpriseName) {
        this.code = code;
        this.name = name;
        this.password = password;
        this.enterpriseId = enterpriseId;
        this.phone = phone;
        this.mobilephone = mobilephone;
        this.fax = fax;
        this.email = email;
        this.address = address;
        this.remark = remark;
        this.userId = userId;
        this.stopSign = stopSign;
        this.createUser = createUser;
        this.createTime = createTime;
        this.supplierId = supplierId;
        this.departmentId = departmentId;
        this.signUser = signUser;
        this.enterpriseName = enterpriseName;
    }

   /* @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", enterpriseId='" + enterpriseId + '\'' +
                ", phone='" + phone + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                ", userId='" + userId + '\'' +
                ", stopSign=" + stopSign +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", supplierId='" + supplierId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", signUser='" + signUser + '\'' +
                ", enterpriseName='" + enterpriseName + '\'' +
                '}';
    }*/

    public User() {
    }

}