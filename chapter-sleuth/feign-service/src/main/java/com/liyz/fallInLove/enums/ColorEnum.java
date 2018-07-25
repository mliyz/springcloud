package com.liyz.fallInLove.enums;

import org.apache.commons.lang.StringUtils;

/**
 * Created by lianghaoguan on 2017/10/25.
 */
public enum ColorEnum {

    white("white","白","白色"),
    black("black","黑","黑色"),
    red("red","红","红色"),
    orange("orange","橙","橙色"),
    brown("brown","棕","棕色"),
    gold("gold","金","金色"),
    gray("gray","灰","灰色"),
    silver("silver","银","银色"),
    blue("blue","蓝","蓝色"),
    green("green","绿","绿色"),
    yellow("yellow","黄","黄色"),
    purple("purple","紫","紫色"),
    pink("pink","粉","粉色");

    private String colorCode;
    private String colorName;
    private String colorDesc;

    ColorEnum(String colorCode, String colorName,String colorDesc) {
        this.colorCode = colorCode;
        this.colorName = colorName;
        this.colorDesc = colorDesc;
    }

    public static ColorEnum getColorEnum(String color){
        if(StringUtils.isBlank(color)){
            return null;
        }
        ColorEnum[] colorEnum = ColorEnum.values();
        for (ColorEnum temp : colorEnum) {
            if(color.contains(temp.colorName)){
                return temp;
            }
        }
        return null;
    }

    public static String getColorDesc(String color){
        if(StringUtils.isBlank(color)){
            return null;
        }
        ColorEnum[] colorEnum = ColorEnum.values();
        for (ColorEnum temp : colorEnum) {
            if(color.equals(temp.getColorCode())){
                return temp.getColorDesc();
            }
        }
        return null;
    }

    public String getColorCode() {
        return colorCode;
    }

    public String getColorName() {
        return colorName;
    }

    public String getColorDesc() {
        return colorDesc;
    }
}
