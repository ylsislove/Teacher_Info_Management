package com.ylsislove.dao;

import com.ylsislove.model.research.Patent;
import com.ylsislove.utils.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * TODO
 *
 * @author Apple_Coco
 * @version V1.0 2019/10/6 13:51
 */
public class PatentDao {

    public List getPatentPage(int pageNo, int pageSize) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from patent limit ?, ?";
        return r.query(sql, new BeanListHandler<Patent>(Patent.class), (pageNo-1)*pageSize, pageSize);
    }

    public Patent selectPatentPageById(int id) throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select * from patent where id = ?";
        return r.query(sql, new BeanHandler<Patent>(Patent.class), id);
    }

    public int selectPatentCount() throws SQLException {
        QueryRunner r = new QueryRunner(DBUtil.getDataSource());
        String sql = "select count(*) from patent";
        return r.query(sql, new ScalarHandler<Long>()).intValue();
    }

}
