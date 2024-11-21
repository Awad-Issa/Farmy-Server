
package com.farmy.project.farmy.project.service.RamService;


import com.farmy.project.farmy.project.model.entity.Ram;
import com.farmy.project.farmy.project.model.repository.RamRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ImplRamService implements IRamService {

    private final RamRepo ramRepo;

//    @Override
//    public List<Ram> getAllRams() {
//        return ramRepo.findAll();
//    }

    @Override
    public Ram addNewRam(Ram ram) {
        return ramRepo.save(ram);
    }

//    @Override
//    public Ram editRam(Ram ram, long id) {
//        return null;
//    }
//
//    @Override
//    public Ram editRam(long id, Ram ram) {
//        Optional<Ram> existingRam = ramRepo.findById(id);
//        if (existingRam.isPresent()) {
//            Ram updateRam = existingRam.get();
//            updateRam.setNum(ram.getNum());
//            updateRam.setAge(ram.getAge());
//            updateRam.setGender(ram.getGender());
//            updateRam.setBirthDay(ram.getBirthDay());
//            updateRam.setWeight(ram.getWeight());
//            return ramRepo.save(updateRam);
//        }
//        return null;
//    }
//
//    @Override
//    public Ram getRamById(long id) {
//        return ramRepo.findById(id).orElse(null);
//    }

}
