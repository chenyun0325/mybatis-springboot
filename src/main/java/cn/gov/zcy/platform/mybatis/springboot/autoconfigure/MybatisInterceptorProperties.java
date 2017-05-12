package cn.gov.zcy.platform.mybatis.springboot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

import static cn.gov.zcy.platform.mybatis.springboot.autoconfigure.MybatisInterceptorProperties.MYBATIS_INTERCEPTOR_PREFIX;

/**
 * Created by chenyun on 2017/4/25.
 */
@ConfigurationProperties(prefix = MYBATIS_INTERCEPTOR_PREFIX)
public class MybatisInterceptorProperties {
    public static final String MYBATIS_INTERCEPTOR_PREFIX = "mybatis.interceptor";

    private String pageMapper;

    private String pageVarName;

    private String pagConverFactory;

    private String idFieldName;

    private String vFieldName;


    public static String getMybatisInterceptorPrefix() {
        return MYBATIS_INTERCEPTOR_PREFIX;
    }

    public String getPageMapper() {
        return pageMapper;
    }

    public void setPageMapper(String pageMapper) {
        this.pageMapper = pageMapper;
    }

    public String getPageVarName() {
        return pageVarName;
    }

    public void setPageVarName(String pageVarName) {
        this.pageVarName = pageVarName;
    }

    public String getPagConverFactory() {
        return pagConverFactory;
    }

    public void setPagConverFactory(String pagConverFactory) {
        this.pagConverFactory = pagConverFactory;
    }

    public String getIdFieldName() {
        return idFieldName;
    }

    public void setIdFieldName(String idFieldName) {
        this.idFieldName = idFieldName;
    }

    public String getvFieldName() {
        return vFieldName;
    }

    public void setvFieldName(String vFieldName) {
        this.vFieldName = vFieldName;
    }
}
