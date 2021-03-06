package org.tangsi.order.dao.mapper;

import org.tangsi.order.entity.Order;

import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Tue Jul 07 15:02:42 CST 2015
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Tue Jul 07 15:02:42 CST 2015
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Tue Jul 07 15:02:42 CST 2015
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Tue Jul 07 15:02:42 CST 2015
     */
    Order selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Tue Jul 07 15:02:42 CST 2015
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated Tue Jul 07 15:02:42 CST 2015
     */
    int updateByPrimaryKey(Order record);

    /**
     * 根据用户id查询用户的订单
     * @param userId
     * @return
     */
    List<Order> getListByUserId(long userId);
}