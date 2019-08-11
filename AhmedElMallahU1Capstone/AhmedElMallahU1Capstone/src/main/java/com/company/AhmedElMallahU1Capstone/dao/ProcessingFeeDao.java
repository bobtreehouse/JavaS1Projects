package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.ProcessingFee;

public interface ProcessingFeeDao {
    ProcessingFee getByItemType(String itemType);
}
