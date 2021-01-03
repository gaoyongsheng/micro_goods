package com.shopping.micro.goods.cro;

import com.shopping.micro.goods.cro.base.BaseCro;
import com.shopping.micro.goods.dto.UserDto;

public class UserEditCro extends BaseCro {

    private Long id;

    private String userName;

    private String trueName;

    private String email;

    private String mobileNum;

    private String sex;

    private String userRole;

    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUserName(userName);
        userDto.setTrueName(trueName);
        userDto.setMobileNum(mobileNum);
        userDto.setEmail(email);
        userDto.setSex(sex);
        userDto.setUserRole(userRole);
        return userDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
