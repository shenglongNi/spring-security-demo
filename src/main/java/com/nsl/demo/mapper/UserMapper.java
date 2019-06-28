package com.nsl.demo.mapper;

import com.nsl.demo.model.User;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from system_user",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int deleteByPrimaryKey(BigDecimal id);

    @Insert({
        "insert into system_user (username, password, ",
        "enabled, locked, account_expire, ",
        "credential_expire, created_time, ",
        "modified_time)",
        "values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=CHAR}, ",
        "#{enabled,jdbcType=BIT}, #{locked,jdbcType=BIT}, #{accountExpire,jdbcType=TIMESTAMP}, ",
        "#{credentialExpire,jdbcType=TIMESTAMP}, #{createdTime,jdbcType=TIMESTAMP}, ",
        "#{modifiedTime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=BigDecimal.class)
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=BigDecimal.class)
    int insertSelective(User record);

    @Select({
        "select",
        "id, username, password, enabled, locked, account_expire, credential_expire, ",
        "created_time, modified_time",
        "from system_user",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.DECIMAL, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.CHAR),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="locked", property="locked", jdbcType=JdbcType.BIT),
        @Result(column="account_expire", property="accountExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="credential_expire", property="credentialExpire", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_time", property="createdTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modified_time", property="modifiedTime", jdbcType=JdbcType.TIMESTAMP)
    })
    User selectByPrimaryKey(BigDecimal id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update system_user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=CHAR},",
          "enabled = #{enabled,jdbcType=BIT},",
          "locked = #{locked,jdbcType=BIT},",
          "account_expire = #{accountExpire,jdbcType=TIMESTAMP},",
          "credential_expire = #{credentialExpire,jdbcType=TIMESTAMP},",
          "created_time = #{createdTime,jdbcType=TIMESTAMP},",
          "modified_time = #{modifiedTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=DECIMAL}"
    })
    int updateByPrimaryKey(User record);
}