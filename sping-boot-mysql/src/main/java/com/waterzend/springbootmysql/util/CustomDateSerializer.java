package com.waterzend.springbootmysql.util;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/***
 * java日期对象经过Jackson库转换成JSON日期格式化自定义类 
 * @author xuxiaoming
 *
 */
public class CustomDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date arg0, JsonGenerator arg1, SerializerProvider arg2) throws IOException {

        arg1.writeString(DateTool.formatDate(arg0, ""));
    }

}
