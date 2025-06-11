package com.uab.taller.store.service;

import com.uab.taller.store.domain.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> getAll();
    Rol getById(Long id);
    void deleteById(Long id);
    Rol save(Rol rol);
    Rol update(Long id, Rol rol);
}
