package com.shopping.micro.goods.cro;

import com.shopping.micro.goods.cro.base.BaseCro;
import com.shopping.micro.goods.dto.UserDto;

public class UserLoginCro extends BaseCro {

    private String userName;

    private String password;

    public UserDto toDto(){
        UserDto userDto = new UserDto();
        userDto.setUserName(userName);
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
}
