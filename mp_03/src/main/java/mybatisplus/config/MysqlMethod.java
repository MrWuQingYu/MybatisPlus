package mybatisplus.config;

/**
 * @author ：wuqy
 * @date ：Created in 2019/6/21 16:20
 * @description：
 * @modified By：
 * @version:
 */
public enum MysqlMethod {

    DELETE_ALL("deleteAll", "清空表数据", "<script>\nDELETE FROM  %s %s\n</script>");
    private final String method;
    private final String desc;
    private final String sql;

    MysqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }
}
