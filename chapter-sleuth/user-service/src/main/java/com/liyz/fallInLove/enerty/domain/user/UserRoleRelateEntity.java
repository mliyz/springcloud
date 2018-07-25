package com.liyz.fallInLove.enerty.domain.user;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: UserRoleRelateEntity
 * @Description 用户和角色关联表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_user_role_relate")
public class UserRoleRelateEntity extends BZBaseEntiy{

    private static final long serialVersionUID = 9164526030421623456L;

    /**
     * 角色id
     */
    @Column(name = "role_id",length = 50)
    private String roleId;

    /**
     * 用户id
     */
    @Column(name = "userinfo_id",length = 50)
    private String userinfoId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId;
    }
}
