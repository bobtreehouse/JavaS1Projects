package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.model.*;
import BobTriesteU1Capstone.GameStore.model.Tshirt;
import BobTriesteU1Capstone.GameStore.viewmodel.*;

import java.util.ArrayList;
import java.util.List;
import BobTriesteU1Capstone.GameStore.dao.TshirtDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TshirtService {


    TshirtDao tshirtDao;

    @Autowired
    public TshirtService(TshirtDao tshirtDao) {

        this.tshirtDao = tshirtDao;


    }
    public TshirtViewModel findTShirt(int id){
        Tshirt tShirt = tshirtDao.getTshirt(id);
        return buildTshirtViewModel(tShirt);
    }

    public List<TshirtViewModel> findAllTShirts(){
        List<Tshirt> tShirts = tshirtDao.getAllTshirts();
        List<TshirtViewModel> tvmList = new ArrayList<>();
        tShirts.stream().forEach(tShirt -> {
            TshirtViewModel tvm = buildTshirtViewModel(tShirt);
            tvmList.add(tvm);
        });

        return tvmList;
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


    public TshirtViewModel updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setTshirtId(tshirtViewModel.getTshirtId());
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());

        tshirtDao.updateTshirt(tshirt);

        return buildTshirtViewModel(tshirt);
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

    public List<TshirtViewModel> findTShirtsBySize(String size){
        List<Tshirt> tShirts = tshirtDao.getTshirtBySize(size);
        List<TshirtViewModel> tvmList = new ArrayList<>();
        tShirts.stream().forEach(tShirt -> {
            TshirtViewModel tvm = buildTshirtViewModel(tShirt);
            tvmList.add(tvm);
        });

        return tvmList;
    }
    public List<TshirtViewModel> findTShirtsByColor(String color){
        List<Tshirt> tShirts = tshirtDao.getTShirtByColor(color);
        List<TshirtViewModel> tvmList = new ArrayList<>();
        tShirts.stream().forEach(tShirt -> {
            TshirtViewModel tvm = buildTshirtViewModel(tShirt);
            tvmList.add(tvm);
        });

        return tvmList;
    }


    public String removeTshirt(int id) {
        tshirtDao.deleteTshirt(id);
        return "T-Shirt ["+id+"] was deleted successfully.";
    }



}
