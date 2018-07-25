package com.liyz.fallInLove.enerty.domain.source;

import com.yixin.common.system.domain.BZBaseEntiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @ClassName: UserRoleRelateEntity
 * @Description 资源和角色中间表
 * @author  YixinCapital -- lianghaoguan
 * @date  2018年5月18日 下午6:45:03
 *
 */
@Entity
@Table(name = "ba_source_role_relate")
public class SourceRoleRelateEntity extends BZBaseEntiy {

    private static final long serialVersionUID = 9164526030425593456L;

    /**
     * 资源表ID
     */
    @Column(name = "source_id",length = 50)
    private String sourceId;

    /**
     * 角色表ID
     */
    @Column(name = "role_id",length = 50)
    private String roleId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
