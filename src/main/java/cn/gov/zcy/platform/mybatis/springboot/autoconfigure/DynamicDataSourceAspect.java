package cn.gov.zcy.platform.mybatis.springboot.autoconfigure;

import cn.gov.zcy.platform.dao.mybatis3.annotation.DataSource;
import cn.gov.zcy.platform.dao.mybatis3.multidatasource.DynamicDataSourceContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chenyun on 2017/4/21.
 */
@Aspect
public class DynamicDataSourceAspect {


    @Pointcut("@annotation(dataSource)")
    public void dsPointCut(DataSource dataSource) {

    }


    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before( value = "dsPointCut(ds)")
    public void changeDataSource(JoinPoint point, DataSource ds) throws Throwable {
        //DataSource ds = point.getTarget().getClass().getAnnotation(DataSource.class);
        String dsId = ds.value();
        if (!DynamicDataSourceContextHolder.contain(dsId)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value(), point.getSignature());
        } else {
            logger.debug("Use DataSource : {} > {}", ds.value(), point.getSignature());
            DynamicDataSourceContextHolder.setDs(ds.value());
        }
    }

    @After(value = "dsPointCut(ds)")
    public void restoreDataSource(JoinPoint point,DataSource ds) {
        logger.debug("Revert DataSource : {} > {}", ds.value(), point.getSignature());
        DynamicDataSourceContextHolder.clearDs();
    }

}
