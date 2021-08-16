/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.DAO.InformationDAO;
import com.entity.Information;

/**
 *
 * @author LongXuyen
 */
public class InformationBean {
    public Information getInfomation() throws Exception {
        return new InformationDAO().getInfomation();
    }
}
