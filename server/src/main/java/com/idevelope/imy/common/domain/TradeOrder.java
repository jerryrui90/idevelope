package com.idevelope.imy.common.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * 交易订单表
 *
 * Created by dk on 2015/5/20.
 */
@Entity
@Table(name = "trade_order")
public class TradeOrder
{
    private Long orderId;
    
    private String orderNo;
    
    private int state;
    
    private int platform;
    
    private Date crateTime;
    
    private Date updateTime;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getOrderId()
    {
        return orderId;
    }
    
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }
    
    public String getOrderNo()
    {
        return orderNo;
    }
    
    public void setOrderNo(String orderNo)
    {
        this.orderNo = orderNo;
    }
    
    public int getState()
    {
        return state;
    }
    
    public void setState(int state)
    {
        this.state = state;
    }
    
    public int getPlatform()
    {
        return platform;
    }
    
    public void setPlatform(int platform)
    {
        this.platform = platform;
    }
    
    public Date getCrateTime()
    {
        return crateTime;
    }
    
    public void setCrateTime(Date crateTime)
    {
        this.crateTime = crateTime;
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
}
