package com.farmy.project.farmy.project.service.EweService;


import com.farmy.project.farmy.project.model.entity.Ewe;
import com.farmy.project.farmy.project.model.repository.EweRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ImplEweService implements IEweService {

    private final EweRepo eweRepo;

    @Override
    public List<Ewe> getAllEwes(){
        return eweRepo.findAll();
    }

    @Override
    public Ewe addNewEwe(Ewe ewe){
        return eweRepo.save(ewe);
    }

    @Override
    public Ewe removeEwe(long id){
        Optional<Ewe> ewe = eweRepo.findById(id);
        if(ewe.isPresent()){
            eweRepo.delete(ewe.get());
            return ewe.get();
        }
        return null;
    }

    @Override
    public Ewe editEwe(Ewe ewe, long id) {
        return null;
    }

    @Override
    public Ewe editEwe(long id, Ewe ewe){
        Optional<Ewe> existingEwe = eweRepo.findById(id);
        if ((existingEwe.isPresent())){
            Ewe updateEwe = existingEwe.get();
            updateEwe.setNum(ewe.getNum());
            updateEwe.setAge(ewe.getAge());
            updateEwe.setGender(ewe.getGender());
            updateEwe.setBirthDay(ewe.getBirthDay());
            updateEwe.setWeight(ewe.getWeight());
            return eweRepo.save(updateEwe);
        }
        return null;
    }

    @Override
    public Ewe getEweById(long id){
        return eweRepo.findById(id).orElse(null);
    }

}
