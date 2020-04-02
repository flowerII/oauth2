package cn.qianshu.oauth2.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.oauth2.entity.SUser;


@Mapper
public interface SUserDao {

	/** 
     * 根据用户名获取用户 
     *  
     * @param name 
     * @return 
     */
	@Select(value = " SELECT su.* FROM tb_user su WHERE su.username = #{name} ")  
    public SUser findSUserByName(String name);
}
