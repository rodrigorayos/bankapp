package com.uab.taller.store.service.imp;

import com.uab.taller.store.domain.Rol;
import com.uab.taller.store.repository.RolRepository;
import com.uab.taller.store.service.IRolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImp implements IRolService {

    private final RolRepository rolRepository;

    public RolServiceImp(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        rolRepository.deleteById(id);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Long id, Rol rol) {
        Rol existing = rolRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(rol.getName());
            existing.setDescription(rol.getDescription());
            return rolRepository.save(existing);
        }
        return null;
    }
}
