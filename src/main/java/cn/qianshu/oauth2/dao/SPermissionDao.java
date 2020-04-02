package cn.qianshu.oauth2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import cn.qianshu.oauth2.entity.SPermission;

@Mapper  
public interface SPermissionDao {  
    /** 
     * 根据用户ID获取资源权限列表 
     * @param sUserId 
     * @return 
     */  
    @Select(value=" SELECT * FROM tb_permission sp " +   
            " LEFT JOIN tb_role_permission srp ON sp.id = srp.permission_id " +   
            " LEFT JOIN tb_role sr ON srp.role_id = sr.id " +   
            " LEFT JOIN tb_user_role sur ON sr.id = sur.role_id " +   
            " LEFT JOIN tb_user su ON sur.user_id = su.id " +   
            " WHERE su.id = #{sUserId} ")  
    public List<SPermission> findSPermissionListBySUserId(int sUserId);  
      
    /** 
     * 根据资源路径获取资源权限列表 
     * @param sPermissionUrl 
     * @return 
     */  
    @Select(value=" SELECT * FROM tb_permission sp WHERE sp.url = #{sUserId} ")  
    public List<SPermission> findSPermissionListBySPermissionUrl(String sPermissionUrl);  
}

