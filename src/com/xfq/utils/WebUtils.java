package com.xfq.utils;

import com.xfq.pojo.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class WebUtils {

            public static int parseInt(String str,int defaltvalue){
                if (str==null|str==""){
                    return defaltvalue;
                }
            return Integer.parseInt(str)    ;
            }


            public static <T> T CopyParameterToBean(Map value,T baen ){
                try {
                    BeanUtils.populate(baen,value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                return baen;
            }
}
