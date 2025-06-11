package com.uab.taller.store.usecases.profile.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfileUseCase {

    @Autowired
    IProfileService profileService;

    public Profile execute(Long profileId, ProfileRequest request) {
        Profile existing = profileService.getById(profileId);
        if (existing == null) return null;

        existing.setName(request.getName());
        existing.setLastName(request.getLastname());
        existing.setCi(request.getCi());
        existing.setMobile(request.getMobile());
        existing.setAddress(request.getAddress());
        existing.setStatus(request.getStatus());

        return profileService.save(existing);
    }
}
