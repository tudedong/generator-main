package com.td.generator.utils;

import com.github.pagehelper.PageInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tudedong
 * @description
 * @date 2019-12-30 14:50:27
 */
public class ParamsData<T extends Base.Query,B extends Base.Order> {

    private List<T> querys=new ArrayList();

    private PageInfo pageInfo=new PageInfo();

    private List<B> orders=new ArrayList();


    public ParamsData() {
    }

    public void addQuerys(T query){
        querys.add(query);
    }

    public void addOrders(B order){
        orders.add(order);
    }

    public List<B> getOrders() {
        return orders;
    }

    public void setOrders(List<B> orders) {
        for(B order:orders){
            Base.Order Border = order.newInstance();
            Border.setName(order.getName());
            Border.setType(order.getType());
            this.orders.add((B)Border);
        }
    }

    public List<T>   getQuerys() {
        return querys;
    }

    public void setQuerys(List<T>  querys) {
        for(T query:querys){
            Base.Query Tquery = query.newInstance();
            Tquery.setName(query.getName());
            Tquery.setOpt(query.getOpt());
            Tquery.setValue(query.getValue());
            this.querys.add((T)Tquery);
        }
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }
}
