package com.liyz.common.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.*;
import com.liyz.common.util.exception.BzException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>类名称：</b>JacksonUtil <br/>
 * <b>类描述：</b>json工具转换类<br/>
 * <b>创建人：</b>jiayu<br/>
 * <b>修改人：</b><br/>
 * <b>修改时间：</b>2015年11月2日 下午2:34:39<br/>
 * <b>修改备注：</b><br/>
 * <b>版本信息：</b>v1.0.0<br/>
 */
public class JacksonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static Logger logger = LoggerFactory.getLogger(JacksonUtil.class);
    
    private JacksonUtil() {}
    static {
    	 // 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //key可以不带双引号
        objectMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        //key value 可以是单引号
        objectMapper.configure(Feature.ALLOW_SINGLE_QUOTES, true) ;
        //允许出现特殊字符和转义符
        objectMapper.configure(Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    }
    /**
     *
     * @Title getInstance
     * @Description 获取单例模式ObjectMapper
     * @return
     * ObjectMapper
     * @author jiayu
     * @date 2015年11月2日-下午2:39:08
     * @update
     * @throws
     */
    public static ObjectMapper getInstance() {
        return objectMapper;
    }
    
    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
    /**
     * 转换成集合
     * @Title getObjectFromJson
     * @Description TODO
     * @param json
     * @param collectionClass
     * @param elementClasses
     * @return Object
     * @author jiayu
     * @date 2015年11月2日-下午3:28:26
     * @update
     * @throws
     */
    public static Object getObjectFromJson(String json,Class<?> collectionClass,Class<?>... elementClasses){
    	JavaType javaType=getCollectionType(collectionClass,elementClasses);
    	try {
			return  objectMapper.readValue(json, javaType);
		} catch (JsonParseException e) {
			logger.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }
    /**
     * 返回指定类型的LIST集合
     * @Title getListFromJson
     * @Description TODO
     * @param json
     * @param objectClass
     * @return
     * List<T>
     * @author jiayu
     * @date 2016年1月15日-下午6:57:19
     * @update
     * @throws
     */
    public static <T>  List<T> getListFromJson(String json,Class<T> objectClass){
    	ObjectMapper mapper = JacksonUtil.getInstance();
		JavaType javaType = JacksonUtil.getCollectionType(ArrayList.class,objectClass);
			try {
				return mapper.readValue(json,javaType);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
    	return null;
    }
    /**
     * json转换为java对象
     * @param json  字符串
     * @param clazz  对象的class
     * @return  返回对象
     */
    public static <T> T fromJsonToObject(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            throw new BzException("解析json错误");
        }
    }
  
    /**
     * java对象转换为json字符串
     * @param object java对象
     * @return json字符串
     */
    public static String fromObjectToJson(Object object) {
        try {
        	//objectMapper.setDateFormat(DateUtil.getFormat(DateUtil.Y_H_M));
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            throw new RuntimeException("解析对象错误");
        }
    }
   /**
    *
    * @Title jsonQuote
    * @Description 处理json字符串特殊字符
    * @param string
    * @return
    * String
    * @author jiayu
    * @date 2015年12月28日-下午5:48:42
    * @update
    * @throws
    */
    public static String jsonQuote(String string) {
        if (string == null || string.length() == 0) {
            return "\"\"";
        }

        char b;
        char c = 0;
        int i;
        int len = string.length();
        StringBuilder sb = new StringBuilder(len + 4);
        String t;

        sb.append('"');
        for (i = 0; i < len; i += 1) {
            b = c;
            c = string.charAt(i);
            switch (c) {
            case '\\':
            case '"':
                sb.append('\\');
                sb.append(c);
                break;
            case '/':
                if (b == '<') {
                    sb.append('\\');
                }
                sb.append(c);
                break;
            case '\b':
                sb.append("\\b");
                break;
            case '\t':
                sb.append("\\t");
                break;
            case '\n':
                sb.append("\\n");
                break;
            case '\f':
                sb.append("\\f");
                break;
            case '\r':
                sb.append("\\r");
                break;
            default:
                if (c < ' ' || (c >= '\u0080' && c < '\u00a0')
                        || (c >= '\u2000' && c < '\u2100')) {
                    t = "000" + Integer.toHexString(c);
                    sb.append("\\u").append(t.substring(t.length() - 4));
                } else {
                    sb.append(c);
                }
            }
        }
        sb.append('"');
        return sb.toString();
    }

    /**
	 * 处理字符串，让符合json的标准格式
	 * @Title processColumns
	 * @param options 待处理字符串
	 * @return
	 * String
	 * @author jiayu
	 * @date 2016年2月9日-下午3:47:15
	 * @update
	 */
	public static String processColumns(String options) {
		Pattern pp=Pattern.compile("(?<=formatter).*?(?=,|})");
		Matcher match=pp.matcher(options);
		while(match.find()){
			String value=match.group();
			String[] keyValue=value.split(":");
			String newValue=keyValue[0]+":'"+keyValue[1]+"'";
			options=options.replace(value, newValue);
		}
		return options;
	}
	/**
	 * 处理json中formatter去掉双引号
	 * @Title processColumnsFormatter
	 * @param options
	 * @return
	 * String
	 * @author jiayu
	 * @date 2016年4月21日-上午11:36:28
	 * @update
	 */
	public static String processColumnsFormatter(String options){
		Pattern pp=Pattern.compile("(?<=\"formatter\").*?(?=,|})");
		Matcher match=pp.matcher(options);
//		int count=match.groupCount();
		while(match.find()){
			String value=match.group();
			String[] keyValue=value.split(":");
			String newValue=keyValue[0]+":"+keyValue[1].replace("\"", "");
			options=options.replace(value, newValue);
		}
		return options;
	}
}
