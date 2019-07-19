package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.*;
import BobTriesteU1Capstone.GameStore.viewmodel.*;

import java.util.ArrayList;
import java.util.List;
import BobTriesteU1Capstone.GameStore.dao.TshirtDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TshirtService {


    TshirtDao tshirtDao;

    @Autowired
    public TshirtService(TshirtDao tshirtDao) {

        this.tshirtDao = tshirtDao;


    }
    public TshirtViewModel saveTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());

        tshirt.setQuantity(tshirtViewModel.getQuantity());
        tshirt = tshirtDao.addTshirt(tshirt);

        tshirtViewModel.setTshirtId(tshirt.getTshirtId());
        return tshirtViewModel;
    }


    public void updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());

        tshirtDao.updateTshirt(tshirt);
    }


    private static TshirtViewModel buildTshirtViewModel(Tshirt tshirt) {

        TshirtViewModel tshirtViewModel = new TshirtViewModel();

        tshirt.setSize(tshirt.getSize());
        tshirt.setColor(tshirt.getColor());
        tshirt.setDescription(tshirt.getDescription());
        tshirt.setPrice(tshirt.getPrice());

        tshirt.setQuantity(tshirt.getQuantity());
        return tshirtViewModel;
    }

    public TshirtViewModel getTshirtByColor(int id) {
        Tshirt tshirt = tshirtDao.getTshirt(id);
        if (tshirt == null)
            return null;
        else
            return buildTshirtViewModel(tshirt);
    }


    public void removeTshirt(int id) {
        tshirtDao.deleteTshirt(id);
    }




}
