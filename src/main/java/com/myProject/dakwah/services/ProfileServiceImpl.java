package com.myProject.dakwah.services;

import com.myProject.dakwah.exception.EntityExistException;
import com.myProject.dakwah.exception.NotFoundException;
import com.myProject.dakwah.models.Gender;
import com.myProject.dakwah.models.Profile;
import com.myProject.dakwah.models.User;
import com.myProject.dakwah.repositories.GenderRepository;
import com.myProject.dakwah.repositories.ProfileRepository;
import com.myProject.dakwah.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {
    private ProfileRepository profileRepository;
    private GenderRepository genderRepository;
    private UserRepository userRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository, GenderRepository genderRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.genderRepository = genderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Profile findById(Integer id) throws Exception {
            Optional<Profile> profile = profileRepository.getByIdQuery(id);

            if (profile.isEmpty()) {
                throw new NotFoundException("Data Profile Tidak Ada");
            }

            return profile.get();
    }

    @Transactional
    @Override
    public Profile createProfile(Profile profile) {
            Optional<Profile> profileCheck = profileRepository.findByUserId(profile.getUser().getUserId());

            if(!profileCheck.isEmpty()){
                throw new EntityExistException("Data sudah ada");
            }

            Gender gender = genderRepository.findById(profile.getGender().getGenderId()).get();
            User user = userRepository.findById(profile.getUser().getUserId()).get();

            profile.setGender(gender);
            profile.setUser(user);

            return profileRepository.save(profile);
    }

    @Transactional
    @Override
    public Profile deleteProfile(Integer id) {
        try {
            Profile profile = findById(id);
            profileRepository.deleteById(id);
            return profile;
        } catch (Exception e) {
            throw new RuntimeException("Profile gagal dihapus " + e.getMessage() );
        }
    }

    @Transactional
    @Override
    public Profile updateProfile(Profile profile) throws Exception {
        Profile profileCheck= findById(profile.getProfileId());

        if(profile.getName() == null){
            profile.setName(profileCheck.getName());
        }

        if(profile.getPhone() == null){
            profile.setPhone(profileCheck.getPhone());
        }

        if(profile.getDateBirth() == null){
            profile.setDateBirth(profileCheck.getDateBirth());
        }

        if(profile.getPlaceBirth() == null){
            profile.setPlaceBirth(profileCheck.getPlaceBirth());
        }

        if(profile.getGender() == null){
            profile.setGender(profileCheck.getGender());
        }

        profile.setProfileId(profileCheck.getProfileId());
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAllProfile() throws Exception{
            List<Profile> profiles = profileRepository.getAllQuery();

            if(profiles.isEmpty()){
                throw new NotFoundException("Data Profile Tidak Tersedia");
            }

            return profiles;

    }
}
