package liusiyu.uti;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import liusiyu.exception.SystemException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/blogdemo";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    private static volatile DataSource DS;

    private static DataSource getDataSource(){
        if (DS == null) {
            synchronized (DBUtil.class){
                if(DS == null){
                    DS = new MysqlDataSource();
                    ((MysqlDataSource) DS).setUrl(URL);
                    ((MysqlDataSource) DS).setUser(USERNAME);
                    ((MysqlDataSource) DS).setPassword(PASSWORD);
                }
            }
        }
        return DS;
    }

    // 获取数据库连接
    public static Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException("000","获取数据库连接失败",e);
        }
    }

    // 释放资源
    // 提供插入 删除 不需要释放结果集的对象
    public static void close(Connection c, Statement s){
        close(c,s,null);
    }

    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if(c != null){
                c.close();
            }

            if(s != null){
                s.close();
            }

            if(r != null){
                r.close();
            }
        } catch (SQLException e) {
            throw new SystemException("000","释放数据资源失败",e);
        }
    }


}
