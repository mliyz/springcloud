package com.liyz.fallInLove.enerty.domain.role;


import com.liyz.fallInLove.enerty.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: RoleEntiy
 * @Description 角色表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_role")
public class RoleEntiy extends BZBaseEntiy
{

    private static final long serialVersionUID = 9164526030421603456L;

    /**
     * 角色名称
     */
    @Column(name = "role_name",length = 50)
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
