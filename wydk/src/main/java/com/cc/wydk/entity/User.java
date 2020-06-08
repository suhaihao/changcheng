package com.cc.wydk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("用户表")
@TableName("user")
public class User implements UserDetails, Serializable {

    @ApiModelProperty("唯一id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("昵称")
    @TableField(value = "nickname")
    private String nickname;

    @ApiModelProperty("姓名")
    @TableField(value = "fullname")
    private String fullname;

    @ApiModelProperty("手机号")
    @TableField(value = "phone")
    private String phone;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("生日")
    @TableField(value = "born_date")
    private LocalDateTime bornDate;

    @ApiModelProperty("性别")
    @TableField(value = "sex")
    private String sex;

    @ApiModelProperty("年龄")
    @TableField(value = "grade")
    private String grade;

    @ApiModelProperty("地址")
    @TableField(value = "address")
    private String address;

    @ApiModelProperty("头像")
    @TableField(value = "head_img")
    private String headImg;

    @ApiModelProperty("积分")
    @TableField(value = "integral")
    private Integer integral;

    @ApiModelProperty("队伍id")
    @TableField(value = "team")
    private String team;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    @TableField(value = "create_by")
    private Integer createBy;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("修改时间")
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("修改人")
    @TableField(value = "update_by")
    private Integer updateBy;

    @ApiModelProperty("密码")
    @TableField(value = "password")
    private String password;

    @ApiModelProperty("权限集合")
    @TableField(exist = false)
    private Set<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
