package org.example.homeworks.hw_15_12_24.service.impl;

import org.example.homeworks.hw_15_12_24.dao.CrudDao;
import org.example.homeworks.hw_15_12_24.dao.impl.CrudDocumentDriverDaoImpl;
import org.example.homeworks.hw_15_12_24.domain.DocumentDriver;

import java.util.List;

public class CrudDocumentDriverServiceImpl implements org.example.homeworks.hw_15_12_24.service.CrudService<DocumentDriver> {

    private final CrudDao<DocumentDriver> dao = new CrudDocumentDriverDaoImpl();

    @Override
    public void add(DocumentDriver documentDriver) {
        dao.add(documentDriver);
    }

    @Override
    public void update(DocumentDriver documentDriver) {
        dao.update(documentDriver);
    }

    @Override
    public void deleteById(String value) {
        dao.deleteById(value);
    }

    @Override
    public List<DocumentDriver> getAll() {
        return dao.getAll();
    }

    @Override
    public DocumentDriver getById(String value) {
        return null;
    }
}
