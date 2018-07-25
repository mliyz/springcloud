package com.liyz.fallInLove.dto.user;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @Description:
 * @Author: Created by lizhongxin on 2018/5/23 18:16.
 */
public class UserDTO implements Serializable {
	private static final long serialVersionUID = -5672869902409244586L;
	
	private long id; //编号
    private long organizationId; //所属公司
    private String username; //用户名
    private String password; //密码
    private String salt; //加密密码的盐
    private List<Long> roleIds; //拥有的角色列表
    private Boolean locked = Boolean.FALSE;
    private SimpleAuthorizationInfo simpleAuthorizationInfo;
//    private List<EmployeesData> employeesDataList;//当前员工的所有下一级员工
//    private List<EmployeesData> employeesParentList;//当前员工的直接上级

    private String departmentId;//行政部门id
    private String departmentName;//行政部门名称
    private String cnName;//中文名称
    private String employeesNumber;//员工编号

    private String decision_inner_channel_id;//决策内部渠道id
    private String decision_outer_channel_id;//决策外部渠道id
    private String clue_inner_channel_id;//线索内部渠道id
    private String clue_outer_channel_id;//线索外部渠道id
    private String business_department_id;//业务部门id
    private String decision_inner_channel_name;//决策内部渠道name
    private String decision_outer_channel_name;//决策外部渠道name
    private String clue_inner_channel_name;//线索内部渠道name
    private String clue_outer_channel_name;//线索外部渠道name
    private String business_department_name;//业务部门name

    private String manager_department_ids;//当前用户管理的行政部门id串，以逗号分隔
    private String manager_business_department_ids;//当前用户管理的业务部门id串，以逗号分隔
    private String next_all_Level_department_ids;//所属行政部门以及下面所有的部门id串，以逗号分隔



    public String getNext_all_Level_department_ids() {
        return next_all_Level_department_ids;
    }

    public void setNext_all_Level_department_ids(
            String next_all_Level_department_ids) {
        this.next_all_Level_department_ids = next_all_Level_department_ids;
    }

    public String getBusiness_department_id() {
        return business_department_id;
    }

    public void setBusiness_department_id(String business_department_id) {
        this.business_department_id = business_department_id;
    }

    public String getBusiness_department_name() {
        return business_department_name;
    }

    public void setBusiness_department_name(String business_department_name) {
        this.business_department_name = business_department_name;
    }

    public String getDecision_inner_channel_name() {
        return decision_inner_channel_name;
    }

    public void setDecision_inner_channel_name(String decision_inner_channel_name) {
        this.decision_inner_channel_name = decision_inner_channel_name;
    }

    public String getDecision_outer_channel_name() {
        return decision_outer_channel_name;
    }

    public void setDecision_outer_channel_name(String decision_outer_channel_name) {
        this.decision_outer_channel_name = decision_outer_channel_name;
    }

    public String getClue_inner_channel_name() {
        return clue_inner_channel_name;
    }

    public void setClue_inner_channel_name(String clue_inner_channel_name) {
        this.clue_inner_channel_name = clue_inner_channel_name;
    }

    public String getClue_outer_channel_name() {
        return clue_outer_channel_name;
    }

    public void setClue_outer_channel_name(String clue_outer_channel_name) {
        this.clue_outer_channel_name = clue_outer_channel_name;
    }

    public String getDecision_inner_channel_id() {
        return decision_inner_channel_id;
    }

    public void setDecision_inner_channel_id(String decision_inner_channel_id) {
        this.decision_inner_channel_id = decision_inner_channel_id;
    }

    public String getDecision_outer_channel_id() {
        return decision_outer_channel_id;
    }

    public void setDecision_outer_channel_id(String decision_outer_channel_id) {
        this.decision_outer_channel_id = decision_outer_channel_id;
    }

    public String getClue_inner_channel_id() {
        return clue_inner_channel_id;
    }

    public void setClue_inner_channel_id(String clue_inner_channel_id) {
        this.clue_inner_channel_id = clue_inner_channel_id;
    }

    public String getClue_outer_channel_id() {
        return clue_outer_channel_id;
    }

    public void setClue_outer_channel_id(String clue_outer_channel_id) {
        this.clue_outer_channel_id = clue_outer_channel_id;
    }

    public String getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(String employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public SimpleAuthorizationInfo getSimpleAuthorizationInfo() {
        return simpleAuthorizationInfo;
    }

    public void setSimpleAuthorizationInfo(SimpleAuthorizationInfo simpleAuthorizationInfo) {
        this.simpleAuthorizationInfo = simpleAuthorizationInfo;
    }

    public UserDTO() {
    }

    public UserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(long organizationId) {
        this.organizationId = organizationId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @JsonIgnore
    public String getCredentialsSalt() {
        return username + salt;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getManager_department_ids() {
        return manager_department_ids;
    }

    public void setManager_department_ids(String manager_department_ids) {
        this.manager_department_ids = manager_department_ids;
    }

    public String getManager_business_department_ids() {
        return manager_business_department_ids;
    }

    public void setManager_business_department_ids(
            String manager_business_department_ids) {
        this.manager_business_department_ids = manager_business_department_ids;
    }
}

