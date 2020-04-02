package cn.qianshu.oauth2.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.qianshu.oauth2.dao.SPermissionDao;
import cn.qianshu.oauth2.dao.SRoleDao;
import cn.qianshu.oauth2.dao.SUserDao;
import cn.qianshu.oauth2.entity.SPermission;
import cn.qianshu.oauth2.entity.SRole;
import cn.qianshu.oauth2.entity.SUser;
import cn.qianshu.oauth2.entity.VUserDetails;

@Service
public class VUserDetailsService implements UserDetailsService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired  
    private SUserDao sUserDao;  
    @Autowired  
    private SRoleDao sRoleDao;  
    @Autowired  
    private SPermissionDao sPermissionDao;  
  
    public SUser findSUserByName(String name) {  
        return sUserDao.findSUserByName(name);  
    }  
  
    public List<SRole> findSRoleListBySUserId(int sUserId) {  
        return sRoleDao.findSRoleListBySUserId(sUserId);  
    }  
  
    public List<SRole> findSRoleListBySPermissionUrl(String sPermissionUrl) {  
        return sRoleDao.findSRoleListBySPermissionUrl(sPermissionUrl);  
    }  
  
    public List<SPermission> findSPermissionListBySUserId(int sUserId) {  
        return sPermissionDao.findSPermissionListBySUserId(sUserId);  
    }  
  
    public List<SPermission> findSPermissionListBySPermissionUrl(String sPermissionUrl) {  
        return sPermissionDao.findSPermissionListBySPermissionUrl(sPermissionUrl);  
    } 
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		SUser sUser = findSUserByName(username);
        if(sUser ==null) {
        	logger.info("用户不存在！");
        }
        //用户角色列表  
        List<SRole> sRoleList = findSRoleListBySUserId(sUser.getId());  
        //用户资源权限列表  
        List<SPermission> sPermissionList = findSPermissionListBySUserId(sUser.getId());  
        return new VUserDetails(sUser, sRoleList, sPermissionList);
	}

}
