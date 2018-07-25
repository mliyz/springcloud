package com.liyz.fallInLove.auth;

import com.yixin.common.utils.YxCurrentUserDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.session.Session;

import java.util.Set;

/**
 * 能够直接获取当前用户 当前用户的角色， 当前用户的权限， 当前用户的部门id、部门名称 当前用户的中文名称 当前用户的域账号 当前用户的用户编号
 *
 * @author zhangyiqing 2016年4月15日11:01:42
 */
public final class CurrentUser {

	/**
	 * 获取用户域账号
	 *
	 * @return
	 */
	public static String getUsername() {
		Session session = getSession();
		return (String) session.getAttribute("username_shiro");
	}

	/**
	 * 获取用户中文名称
	 *
	 * @return
	 */
	public static String getCnName() {
		Session session = getSession();
		return (String) session.getAttribute("cnName_shiro");
	}

	/**
	 * 获取用户id
	 *
	 * @return
	 */
	public static String getUserId() {
		Session session = getSession();
		return "" + session.getAttribute("userId_shiro");
	}

	/**
	 * 获取部门id
	 *
	 * @return
	 */
	public static String getDepartmentId() {
		Session session = getSession();
		return (String) session.getAttribute("departmentId_shiro");
	}

	/**
	 * 获取部门名称
	 *
	 * @return
	 */
	public static String getDepartmentName() {
		Session session = getSession();
		return (String) session.getAttribute("departmentName_shiro");
	}

	/**
	 * 获取员工编号
	 *
	 * @return
	 */
	public static String getEmployeeNumber() {
		Session session = getSession();
		return (String) session.getAttribute("employeeNumber_shiro");
	}

	/**
	 * 获取权限列表
	 *
	 * @return
	 */
	public static Iterable<String> getPermissions() {
		return getInfo() != null ? getInfo().getStringPermissions() : null;
	}

	/**
	 * 获取角色列表
	 *
	 * @return
	 */
	public static Iterable<String> getRoles() {
		return getInfo() != null ? getInfo().getRoles() : null;
	}

	private static AuthorizationInfo getInfo() {
		Session session = getSession();
		return (AuthorizationInfo) session.getAttribute("userInfo_shiro");
	}

	// 获取session
	private static Session getSession() {
		return SecurityUtils.getSubject().getSession();
	}

	/**
	 * 获取业务部门id
	 *
	 * @return
	 */
	public static String getBusiness_department_id() {
		Session session = getSession();
		return (String) session.getAttribute("business_department_id");
	}

	/**
	 * 获取业务部门name
	 *
	 * @return
	 */
	public static String getBusiness_department_name() {
		Session session = getSession();
		return (String) session.getAttribute("business_department_name");
	}

	/**
	 * 获取决策内部渠道name
	 *
	 * @return
	 */
	public static String getDecision_inner_channel_name() {
		Session session = getSession();
		return (String) session.getAttribute("decision_inner_channel_name");
	}

	/**
	 * 获取决策外部渠道name
	 *
	 * @return
	 */
	public static String getDecision_outer_channel_name() {
		Session session = getSession();
		return (String) session.getAttribute("decision_outer_channel_name");
	}

	/**
	 * 获取索引内部渠道name
	 *
	 * @return
	 */
	public static String getClue_inner_channel_name() {
		Session session = getSession();
		return (String) session.getAttribute("clue_inner_channel_name");
	}

	/**
	 * 获取索引外部渠道name
	 *
	 * @return
	 */
	public static String getClue_outer_channel_name() {
		Session session = getSession();
		return (String) session.getAttribute("clue_outer_channel_name");
	}

	/**
	 * 获取决策内部渠道id
	 *
	 * @return
	 */
	public static String getDecision_inner_channel_id() {
		Session session = getSession();
		return (String) session.getAttribute("decision_inner_channel_id");
	}

	/**
	 * 获取决策外部渠道id
	 *
	 * @return
	 */
	public static String getDecision_outer_channel_id() {
		Session session = getSession();
		return (String) session.getAttribute("decision_outer_channel_id");
	}

	/**
	 * 获取索引内部渠道id
	 *
	 * @return
	 */
	public static String getClue_inner_channel_id() {
		Session session = getSession();
		return (String) session.getAttribute("clue_inner_channel_id");
	}

	/**
	 * 获取索引外部渠道id
	 *
	 * @return
	 */
	public static String getClue_outer_channel_id() {
		Session session = getSession();
		return (String) session.getAttribute("clue_outer_channel_id");
	}

	/**
	 * //当前人管理的行政部门id串，以逗号分隔
	 *
	 * @return
	 */
	public static String getManager_department_ids() {
		Session session = getSession();
		return (String) session.getAttribute("manager_department_ids");
	}

	/**
	 * //当前人管理的业务部门id串，以逗号分隔
	 *
	 * @return
	 */
	public static String getManager_business_department_ids() {
		Session session = getSession();
		return (String) session.getAttribute("manager_business_department_ids");
	}
	
	/**
	 * 获取体验店ID
	 *
	 * @return
	 */
	public static String getShop_id() {
		Session session = getSession();
		return (String) session.getAttribute("shop_id");
	}

	/**
	 * 获取体验店名称
	 *
	 * @return
	 */
	public static String getShop_Name() {
		Session session = getSession();
		return (String) session.getAttribute("shop_name");
	}


	/**
	 * 获取用户角色信息
	 *
	 * @return
	 */
	public static Set<String> getUserRoles(){
		Session session = getSession();
		AuthorizationInfo authorizationInfo = (AuthorizationInfo) session.getAttribute("userInfo_shiro");
		if(authorizationInfo!=null){
			return (Set<String>) authorizationInfo.getRoles();
		}else {
			return null;
		}
	}

	public static YxCurrentUserDTO getCurrentUserDTO() {
		YxCurrentUserDTO yxCurrentUserDTO = new YxCurrentUserDTO();
		yxCurrentUserDTO.setId(getUserId());
		yxCurrentUserDTO.setUserName(getCnName());
		yxCurrentUserDTO.setUserAccount(getUsername());
		yxCurrentUserDTO.setDepartmentId(getDepartmentId());
		yxCurrentUserDTO.setPermissions((Set<String>) getPermissions());
		yxCurrentUserDTO.setRoles((Set<String>) getRoles());
		return yxCurrentUserDTO;
	}
}