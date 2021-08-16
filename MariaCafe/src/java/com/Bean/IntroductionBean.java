/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.DAO.IntroductionDAO;
import com.entity.Introduction;

/**
 *
 * @author LongXuyen
 */
public class IntroductionBean {
    public Introduction getIntroduction() throws Exception {
        return new IntroductionDAO().getIntroduction();
    }
}
