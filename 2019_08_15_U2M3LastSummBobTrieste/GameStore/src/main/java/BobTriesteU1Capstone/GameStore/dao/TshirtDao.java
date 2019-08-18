package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.Tshirt;
import java.util.List;

public interface TshirtDao {


    Tshirt addTshirt(Tshirt tshirt);

    Tshirt getTshirt(int id);

    List<Tshirt> getAllTshirts();

    List<Tshirt> getTshirtBySize(String size);

    void updateTshirt(Tshirt tshirt);

    void deleteTshirt(int id);

    List<Tshirt> getTShirtByColor(String color);
}
