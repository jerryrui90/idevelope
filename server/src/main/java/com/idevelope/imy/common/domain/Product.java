package com.idevelope.imy.common.domain;

import java.util.Date;

import javax.persistence.*;

/**
 * 商品表
 *
 * Created by dk on 2015/5/20.
 */
@Entity
@Table(name = "product")
public class Product
{
    /**
     * 商品ID
     */
    private int productId;
    
    /**
     * 商品名称
     */
    private String productName;
    
    /**
     * 商品描述
     */
    private String productDesc;
    
    /**
     * 商品价格(以分为单位)
     */
    private int amount;
    
    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 更新时间
     */
    private Date updateTime;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getProductId()
    {
        return productId;
    }
    
    public void setProductId(int productId)
    {
        this.productId = productId;
    }
    
    public String getProductName()
    {
        return productName;
    }
    
    public void setProductName(String productName)
    {
        this.productName = productName;
    }
    
    public String getProductDesc()
    {
        return productDesc;
    }
    
    public void setProductDesc(String productDesc)
    {
        this.productDesc = productDesc;
    }
    
    public int getAmount()
    {
        return amount;
    }
    
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    
    public Date getUpdateTime()
    {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }
    
    public Date getCreateTime()
    {
        return createTime;
    }
    
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
}
