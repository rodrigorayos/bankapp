package com.uab.taller.store.service.imp;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.repository.ProfileRepository;
import com.uab.taller.store.service.IProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImp implements IProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImp(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        profileRepository.deleteById(id);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Long id, Profile profile) {
        Profile existing = profileRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(profile.getName());
            existing.setLastName(profile.getLastName());
            existing.setCi(profile.getCi());
            existing.setMobile(profile.getMobile());
            existing.setAddress(profile.getAddress());
            existing.setStatus(profile.getStatus());
            return profileRepository.save(existing);
        }
        return null;
    }
}
