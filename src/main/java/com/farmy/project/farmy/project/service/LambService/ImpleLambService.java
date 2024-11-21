package com.farmy.project.farmy.project.service.LambService;


import com.farmy.project.farmy.project.model.entity.Lamb;
import com.farmy.project.farmy.project.model.mapper.SheepMapper;
import com.farmy.project.farmy.project.model.repository.LambRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ImpleLambService implements ILambService {


    private final LambRepo lambRepo;

    private SheepMapper sheepMapper;

//    @Override
//    public List<Lamb> getAllLambs() {
//        return lambRepo.findAll();
//    }

    @Override
    public Lamb addNewLamb(Lamb lamb) {
        return lambRepo.save(lamb);
    }

//    @Override
//    public Lamb removeLamb(long id) {
//        Optional<Lamb> lamb = lambRepo.findById(id);
//        if (lamb.isPresent()) {
//            lambRepo.delete(lamb.get());
//            return lamb.get();
//        }
//        return null;
//    }



//    @Override
//    public Lamb editLamb(long id, Lamb lamb) {
//        Optional<Lamb> existingLamb = lambRepo.findById(id);
//        if (existingLamb.isPresent()) {
//            Lamb updateLamb = existingLamb.get();
//            updateLamb.setNum(lamb.getNum());
//            updateLamb.setAge(lamb.getAge());
//            updateLamb.setGender(lamb.getGender());
//            updateLamb.setBirthDay(lamb.getBirthDay());
//            updateLamb.setWeight(lamb.getWeight());
//            return lambRepo.save(updateLamb);
//        }
//        return null;
//    }
//
//    @Override
//    public Lamb getLambById(long id) {
//        return lambRepo.findById(id).orElse(null);
//    }
}
