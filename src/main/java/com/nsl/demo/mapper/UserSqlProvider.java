package com.nsl.demo.mapper;

import com.nsl.demo.model.User;
import org.apache.ibatis.jdbc.SQL;

public class UserSqlProvider {

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("system_user");
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=CHAR}");
        }
        
        if (record.getEnabled() != null) {
            sql.VALUES("enabled", "#{enabled,jdbcType=BIT}");
        }
        
        if (record.getLocked() != null) {
            sql.VALUES("locked", "#{locked,jdbcType=BIT}");
        }
        
        if (record.getAccountExpire() != null) {
            sql.VALUES("account_expire", "#{accountExpire,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCredentialExpire() != null) {
            sql.VALUES("credential_expire", "#{credentialExpire,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.VALUES("created_time", "#{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifiedTime() != null) {
            sql.VALUES("modified_time", "#{modifiedTime,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("system_user");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=CHAR}");
        }
        
        if (record.getEnabled() != null) {
            sql.SET("enabled = #{enabled,jdbcType=BIT}");
        }
        
        if (record.getLocked() != null) {
            sql.SET("locked = #{locked,jdbcType=BIT}");
        }
        
        if (record.getAccountExpire() != null) {
            sql.SET("account_expire = #{accountExpire,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCredentialExpire() != null) {
            sql.SET("credential_expire = #{credentialExpire,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreatedTime() != null) {
            sql.SET("created_time = #{createdTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifiedTime() != null) {
            sql.SET("modified_time = #{modifiedTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=DECIMAL}");
        
        return sql.toString();
    }
}