package com.liyz.fallInLove.dto.address;

/**
 *
 * @ClassName: AddressDTO
 * @Description 省市信息DTO
 * @author YixinCapital -- mjj
 * @date 2018年6月6日 上午10:58:50
 *
 */
public class AddressDTO {
    
    /**
     * 源ID
     */
    private String sid;

    /**
     * 源类型
     */
    private String stype;

    /**
     * 父节点ID
     */
    private String parentId;

    /**
     * 城市名称
     */
    private String name;

    /**
     * 城市拼写
     */
    private String spell;

    /**
     * 地区全名
     */
    private String fullName;

    /*
     * 地区级别（1：省，2：市）
     */
    private String level;

    /**
     * 排序号
     */
    private String orderNumber;

    /**
     * 城市code
     */
    private String regionId;

    /**
     * 首字母
     */
    private String spellFirst;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getSpellFirst() {
        return spellFirst;
    }

    public void setSpellFirst(String spellFirst) {
        this.spellFirst = spellFirst;
    }

}

