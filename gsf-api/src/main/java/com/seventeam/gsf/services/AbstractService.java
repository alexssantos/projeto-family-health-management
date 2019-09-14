package com.seventeam.gsf.services;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<
        E,
        D extends JpaRepository<E, Integer>
>
{

    private D dao;

    public AbstractService(D dao) {
        this.dao = dao;
    }

    public D getDao() {
        return dao;
    }
}
