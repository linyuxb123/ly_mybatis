package xyz.linyuxb.aop;

import xyz.linyuxb.annotation.LyInsert;
import xyz.linyuxb.annotation.LyParam;
import xyz.linyuxb.annotation.LySelect;
import xyz.linyuxb.util.JDBCUtils;
import xyz.linyuxb.util.SQLUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Desc:
 * @Author: linyuxb
 * @Date: 2020/1/5 下午3:39
 */
public class MyInvocationHandlerMbatis implements InvocationHandler {
    private Object object;

    public MyInvocationHandlerMbatis(Object object) {
        this.object = object;
    }

    /**
     * proxy 代理对象 method拦截方法 args方法上的参数值
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("使用动态代理技术拦截接口方法开始");
        // 1. 判断方法上是否存在@ExtInsert
        LyInsert extInsert = method.getDeclaredAnnotation(LyInsert.class);
        if (extInsert != null) {
            return this.extInsert(extInsert, method, args);
        }
        // 2. 判断方法上是否存@LySelect
        LySelect extSelect = method.getDeclaredAnnotation(LySelect.class);
        if (extSelect != null) {
            return this.extSelect(extSelect, method, args);
        }
        return null;
    }

    /**
     * 执行插入
     *
     * @param extInsert
     * @param method
     * @param args
     * @return
     */
    private Object extInsert(LyInsert extInsert, Method method, Object[] args) {
        // 1. 方法上存在@ExtInsert,获取他的SQL语句
        // 2. 获取SQL语句,获取注解Insert语句
        String insertSql = extInsert.value();
        // 3. 获取方法的参数和SQL参数进行匹配
        // 定一个Map集合 KEY为@ExtParamValue,Value 结果为参数值
        ConcurrentHashMap<Object, Object> paramsMap = this.paramsMap(method, args);
        // 存放sql执行的参数---参数绑定过程
        String[] sqlInsertParameter = SQLUtils.sqlInsertParameter(insertSql);
        // 设置事务的提交方式
        List<Object> sqlParams = this.sqlParams(sqlInsertParameter, paramsMap);
        // 4. 根据参数替换参数变为?
        String newSQL = SQLUtils.parameQuestion(insertSql, sqlInsertParameter);
        System.out.println("newSQL:" + newSQL + ",sqlParams:" + sqlParams.toString());
        // 5. 调用jdbc底层代码执行语句
        return JDBCUtils.insert(newSQL, false, sqlParams);
    }

    /**
     * 执行插入
     *
     * @param extSelect
     * @param method
     * @param args
     * @return
     */
    private Object extSelect(LySelect extSelect, Method method, Object[] args) throws Throwable {
        // 1. 获取注解上查询的SQL语句
        String selectSQL = extSelect.value();
        // 2. 获取方法上的参数,绑定在一起
        ConcurrentHashMap<Object, Object> paramsMap = paramsMap(method, args);
        // 3. 参数替换？传递方式
        List<String> sqlSelectParameter = SQLUtils.sqlSelectParameter(selectSQL);
        // 4.传递参数
        List<Object> sqlParams = new ArrayList<>();
        for (String parameterName : sqlSelectParameter) {
            Object parameterValue = paramsMap.get(parameterName);
            sqlParams.add(parameterValue);
        }
        // 5.将sql语句替换成?
        String newSql = SQLUtils.parameQuestion(selectSQL, sqlSelectParameter);
        System.out.println("newSQL:" + newSql + ",sqlParams:" + sqlParams.toString());

        // 6.调用jdbc代码底层执行sql语句
        ResultSet res = JDBCUtils.query(newSql, sqlParams);
        // 判断是否存在值
        if (!res.next()) {
            return null;
        }
        // 下标往上移动移位
        res.previous();
        // 7.使用反射机制实例对象### 获取方法返回的类型，进行实例化
        Class<?> returnType = method.getReturnType();
        Object object = returnType.newInstance();
        while (res.next()) {
            // 获取当前所有的属性
            Field[] declaredFields = returnType.getDeclaredFields();
            for (Field field : declaredFields) {
                String fieldName = field.getName();
                if (!"serialVersionUID".equals(fieldName)) {
                    Object fieldValue = res.getObject(fieldName);
                    field.setAccessible(true);
                    field.set(object, fieldValue);
                }
            }
        }
        return object;
    }

    /**
     * 根据sql语句配置参数的排序匹配方法参数
     *
     * @param sqlInsertParameter
     * @param paramsMap
     * @return
     */
    private List<Object> sqlParams(String[] sqlInsertParameter, ConcurrentHashMap<Object, Object> paramsMap) {
        List<Object> sqlParams = new ArrayList<>();
        for (String paramName : sqlInsertParameter) {
            Object paramValue = paramsMap.get(paramName);
            sqlParams.add(paramValue);
        }
        return sqlParams;
    }

    /**
     * 解析参数
     *
     * @param method
     * @param args
     * @return
     */
    private ConcurrentHashMap<Object, Object> paramsMap(Method method, Object[] args) {
        ConcurrentHashMap<Object, Object> paramsMap = new ConcurrentHashMap<>();
        // 获取方法上的参数
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            LyParam extParam = parameter.getDeclaredAnnotation(LyParam.class);
            if (extParam != null) {
                // 参数名称
                String paramName = extParam.value();
                Object paramValue = args[i];
                paramsMap.put(paramName, paramValue);
            }
        }
        return paramsMap;
    }

}
