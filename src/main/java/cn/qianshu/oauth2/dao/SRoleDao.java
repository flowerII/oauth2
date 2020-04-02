package cn.qianshu.oauth2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.oauth2.entity.SRole;

@Mapper
public interface SRoleDao {
	
	/** 
     * 根据用户ID获取角色列表 
     * @param sUserId 
     * @return 
     */  
    @Select(value=" SELECT sr.* FROM tb_role sr " +   
                    " LEFT JOIN tb_user_role sur ON sr.id = sur.role_id " +   
                    " LEFT JOIN tb_user su ON sur.user_id = su.id " +   
                    " WHERE su.id = #{sUserId} ")  
    public List<SRole> findSRoleListBySUserId(int sUserId);  
  
    /** 
     * 根据资源路径获取角色列表 
     * @param sPermissionUrl 
     * @return 
     */  
    @Select(value=" SELECT sr.* FROM tb_role sr " +   
                    " LEFT JOIN tb_role_permission srp ON sr.id = srp.role_id " +   
                    " LEFT JOIN tb_permission sp ON srp.permission_id = sp.id " +   
                    " WHERE sp.url = #{sPermissionUrl} ")  
    public List<SRole> findSRoleListBySPermissionUrl(String sPermissionUrl);

}
