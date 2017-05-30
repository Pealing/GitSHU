package org.gitshu.utils.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by Lodour on 17/5/29 22:33.
 * DAO助手
 */
public class DAOSupport {
    protected SessionFactory sessionFactory;

    protected DAOSupport ( SessionFactory sessionFactory ) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession () {
        return this.sessionFactory.getCurrentSession();
    }

}
