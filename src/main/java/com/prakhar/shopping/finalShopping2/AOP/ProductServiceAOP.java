package com.prakhar.shopping.finalShopping2.AOP;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ProductServiceAOP {

        private Logger myLogger = Logger.getLogger(getClass().getName());

        @Pointcut("execution(* com.prakhar.shopping.finalShopping.controller.*.*(..))")
        private void forControllerPackage(){
        }

        @Pointcut("execution(* com.prakhar.shopping.finalShopping.service.*.*(..))")
        private void forServicePackage(){
        }
//    @Pointcut("execution(* com.app.inventorymanagerapp.dao.*.*(..))")
//    private void forDaoPackage(){
//    }
    @Pointcut("forControllerPackage() || forServicePackage()")
    public void forAppFlow(){
    }



        @Before("forAppFlow()")
        public void beforeC(JoinPoint jp){
            String method = jp.getSignature().toShortString();
            myLogger.info("=====>> in @Before: calling method: "+method);

            Object[] args = jp.getArgs();

            for(Object tempArg : args){
                myLogger.info("=====>> argument: "+tempArg);
            }
        }

        @AfterReturning(
                pointcut = "forAppFlow()",
                returning = "theResult"
        )
        public void afterReturning(JoinPoint jp, Object theResult){
            String method = jp.getSignature().toShortString();
            myLogger.info("=====>> in @AfterReturning: from method: "+method);
            myLogger.info("=====>> result: "+theResult);
        }
    }
