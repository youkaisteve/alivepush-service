package cn.sm.alivepush.common.utils;


import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by youkai on 2017/8/21.
 */
public class JacksonMapper {
    private static final ObjectMapper mapper = new ObjectMapper();

    private JacksonMapper() {
    }

    public static ObjectMapper getInstance() {
        return mapper;
    }
}
