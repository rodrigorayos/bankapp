package com.uab.taller.store.usecases.profile.usecases;

import com.uab.taller.store.domain.Profile;
import com.uab.taller.store.domain.dto.request.ProfileRequest;
import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateProfileUseCase {

    @Autowired
    IProfileService profileService;

    public Profile execute(ProfileRequest request) {
        Profile profile = new Profile();
        profile.setName(request.getName());
        profile.setLastName(request.getLastname());
        profile.setAddress(request.getAddress());
        profile.setCi(request.getCi());
        profile.setMobile(request.getMobile());
        profile.setStatus(request.getStatus());
        return profileService.save(profile);
    }
}
