package liusiyu.uti;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {

    private static volatile ObjectMapper MAPPER;
    public static ObjectMapper get(){
        // 双重校验锁完成线程安全模式的单例
        if(MAPPER == null){
            synchronized (JSONUtil.class){
                if(MAPPER == null){
                    MAPPER = new ObjectMapper();
                }
            }
        }
        return MAPPER;
    }

    // java对象序列化为json字符串  o对象   json 字符串
    public static String serialize(Object o){
        try {
            return get().writeValueAsString(o);
        } catch (JsonProcessingException e) {
            // 将编译时异常转换为运行时异常  编译不处理
            throw new RuntimeException("JSON序列化失败,对象为"+o,e);
        }
    }

    // 将json字符串反序列化为java对象
    public static <T> T deserialize(String json,Class<T> clazz){
        try {
            return get().readValue(json,clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败,json字符串为"+json,e);
        }
    }

    public static <T> T deserialize(InputStream is, Class<T> clazz){
        try {
            return get().readValue(is,clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反序列化失败",e);
        }
    }
}
