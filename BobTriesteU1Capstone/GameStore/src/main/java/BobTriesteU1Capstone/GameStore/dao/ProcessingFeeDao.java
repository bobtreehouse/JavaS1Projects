package BobTriesteU1Capstone.GameStore.dao;
import BobTriesteU1Capstone.GameStore.model.ProcessingFee;
import java.util.List;

public interface ProcessingFeeDao {




    ProcessingFee getProcessingFee(int id);

    List<ProcessingFee> getAllProcessingFees();

    void updateProcessingFee(ProcessingFee game);

    void deleteProcessingFee(int id);


}
