/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bean;

import com.DAO.ShareDAO;
import com.entity.Share;
import java.util.List;

/**
 *
 * @author LongXuyen
 */
public class ShareBean {
    public List<Share> getShare() throws Exception {
        return new ShareDAO().getShare();
    }
}
