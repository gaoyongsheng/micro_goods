package com.shopping.micro.goods.entity;


import com.shopping.micro.goods.dto.UserDto;
import com.shopping.micro.goods.entity.base.BaseModel;

/**
 * @Author Gao
 * @Date 2020/10/21 22:55
 * @Version 1.0
 */

public class User extends BaseModel<UserDto> {

    private String userName;

    private String trueName;

    private String password;

    private String email;

    private String mobileNum;

    private String avatarAddress;

    private String sex;

    private String addTime;

    private String userRole;


    public User(){}

    public User(UserDto userDto){
        this.id = userDto.getId();
        this.userName = userDto.getUserName();
        this.trueName = userDto.getTrueName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.mobileNum = userDto.getMobileNum();
        this.avatarAddress = userDto.getAvatarAddress();
        this.sex = userDto.getSex();
        this.addTime = userDto.getAddTime();
        this.userRole = userDto.getUserRole();

    }


    @Override
    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setUserName(userName);
        userDto.setTrueName(trueName);
        userDto.setPassword(password);
        userDto.setMobileNum(mobileNum);
        userDto.setAddTime(addTime);
        userDto.setAvatarAddress(avatarAddress);
        userDto.setEmail(email);
        userDto.setSex(sex);
        userDto.setUserRole(userRole);
        return userDto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id +
                ",userName='" + userName +
                ", trueName='" + trueName +
                ", password='" + password +
                ", email='" + email +
                ", mobileNum='" + mobileNum +
                ", avatarAddress='" + avatarAddress +
                ", sex='" + sex +
                ", addTime='" + addTime +
                ", userRole='" + userRole +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
