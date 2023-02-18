package com.example.demo.Constant;

public class SystemConstant {

    // Mapper
    public static final String MAPPER_PACKAGE = "com.example.demo.generator.mapper";
    // Controller
    public static final String CONTROLLER_PACKAGE = "com.example.demo.Controller";
    // 请求头token字段名称
    public static final String HEADERS_TOKEN_NAME = "token";
    // redis 用户信息key字段存储前缀
    public static final String REDIS_JWT_SUFFIX = "WEB:";
    // jwt有效时长
    public static final Long JWT_EFFICIENT_TIME = 24 * 60 * 60 * 1000L;// 60 * 60 *1000  一个小时
    // jwt加密密匙明文
    // 不能有字符 “_”
    public static final String JWT_CURRENT_KEY = "web";
    // jwt加密签名签发者
    public static final String JWT_PUBLISHER = "web";
    // jwt加密算法
    public static final String JWT_ENCRYPTION_ALGORITHM = "AES";
    // fastjson字符编码格式
    //US-ASCII    ISO-8859-1    UTF-8   UTF-16BE   UTF-16LE   UTF-16
    public static final String FASTJSON_CHARSET = "UTF-8";

}
