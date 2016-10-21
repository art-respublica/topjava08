package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.repository.JpaUtil;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;

/**
 * Created by Respublica on 21.10.2016.
 */
public abstract class AbstractJpaUserServiceTest extends AbstractUserServiceTest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected JpaUtil jpaUtil;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        jpaUtil.clear2ndLevelHibernateCache();
    }
}
