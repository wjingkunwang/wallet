package db_pool;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 连接
 */
@Data
@AllArgsConstructor
public class PooledConnection {
    //封装连接
    private Connection conn;
    //连接是否被占用
    private boolean isBusy = false;

    //释放连接
    public void close() {
        this.isBusy = false;
    }

    public ResultSet queryBySql(String sql) {
        ResultSet rs = null;
        Statement sm = null;
        try {
            sm = conn.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("执行出现异常： " + e.getMessage());
        }
        return rs;
    }
}
