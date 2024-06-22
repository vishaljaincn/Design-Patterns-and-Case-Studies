package org.example.designpatterns.facade.services;


import org.example.designpatterns.facade.models.PreprocessedData;
import org.example.designpatterns.facade.models.PreprocessingOptions;

import java.util.List;

public class DataPreprocessingService {

    public PreprocessedData preprocessData(List<Object> rawData, PreprocessingOptions preprocessingOptions) {
        // Simulate data preprocessing process
        return new PreprocessedData();
    }
}