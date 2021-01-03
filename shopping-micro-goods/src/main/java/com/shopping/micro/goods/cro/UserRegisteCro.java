package com.shopping.micro.goods.cro;

import com.shopping.micro.goods.cro.base.BaseCro;
import com.shopping.micro.goods.dto.UserDto;

/**
 * @Author Gao
 * @Date 2020/11/22 21:19
 * @Version 1.0
 */
public class UserRegisteCro extends BaseCro {

    private String userName;
    private String password;
    private String mobileNum;
    private String verificationCode;

    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
        userDto.setMobileNum(mobileNum);
        userDto.setPassword(password);
        return userDto;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
