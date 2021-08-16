/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.DAO.CakeDAO;
import com.entity.Cake;
import java.util.List;

/**
 *
 * @author LongXuyen
 */
public class CakeBean {
    
    int cakeID = 0;
    int page, pageSize;

    public CakeBean() {
        page = 1;
        pageSize = 3;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public void setCakeID(int cakeID) {
        this.cakeID = cakeID;
    }
    
    public List<Cake> getTop2() throws Exception {
        return new CakeDAO().getTop2();
    }
    
    public Cake getCakeDetail() throws Exception {
        return new CakeDAO().getCakeDetail(cakeID);
    }
    
    public List<Cake> getAllCakes() throws Exception {
        return new CakeDAO().getAllCakes(page, pageSize);
    }
    
    public int getTotalPages() throws Exception {
        return new CakeDAO().getTotalPages(pageSize);
    }
}
