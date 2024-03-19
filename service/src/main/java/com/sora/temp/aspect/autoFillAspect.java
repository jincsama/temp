package com.sora.temp.aspect;


import com.sora.temp.annotation.AutoFill;
import com.sora.temp.constant.AutoFillConstant;
import com.sora.temp.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class autoFillAspect {
    /**
     * 切入点
     */
    @Pointcut("execution(* com.sora.temp.mapper.*.*(..)) && @annotation(com.sora.temp.annotation.AutoFill)")
    public  void autoFillPointCut(){}

    /**
     * 前置通知，公共字段赋值
     */
    @Before("autoFillPointCut()")
    public  void autoFill(JoinPoint joinPoint){
        //获取操作类型
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill autoFill = signature.getMethod().getAnnotation(AutoFill.class);
        OperationType operationType = autoFill.value();

        //获取实体
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        Object entity = args[0];

        //准备数据
        LocalDateTime now = LocalDateTime.now();

        //赋值
        if (operationType == OperationType.INSERT) {
            try {
                Method setCreateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_CREATE_TIME, LocalDateTime.class);
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);

                setCreateTime.invoke(entity,now);
                setUpdateTime.invoke(entity,now);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if (operationType == OperationType.UPDATE) {
            try {
                Method setUpdateTime = entity.getClass().getDeclaredMethod(AutoFillConstant.SET_UPDATE_TIME, LocalDateTime.class);
                setUpdateTime.invoke(entity,now);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
