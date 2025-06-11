package com.uab.taller.store.usecases.profile.usecases;

import com.uab.taller.store.service.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfileUseCase {
    @Autowired
    IProfileService profileService;

    public void execute(Long profileId) {
        profileService.deleteById(profileId);
    }
}
