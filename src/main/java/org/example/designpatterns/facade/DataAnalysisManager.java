package org.example.designpatterns.facade;

import org.example.designpatterns.facade.models.AnalysisAlgorithmConfig;
import org.example.designpatterns.facade.models.AnalysisResult;
import org.example.designpatterns.facade.models.DataCollectionParams;
import org.example.designpatterns.facade.models.PreprocessingOptions;
import org.example.designpatterns.facade.services.AnalysisAlgorithmService;
import org.example.designpatterns.facade.services.DataCollectionService;
import org.example.designpatterns.facade.services.DataPreprocessingService;
import org.example.designpatterns.facade.services.VisualizationService;

public class DataAnalysisManager {

    private DataAnalysisProcessor dataAnalysisProcessor;

    public DataAnalysisManager(DataCollectionService dataCollectionService,
                               DataPreprocessingService dataPreprocessingService,
                               AnalysisAlgorithmService analysisAlgorithmService,
                               VisualizationService visualizationService) {
        dataAnalysisProcessor = new DataAnalysisProcessor(dataCollectionService, dataPreprocessingService, analysisAlgorithmService, visualizationService);
    }

    public AnalysisResult performFullAnalysis(DataCollectionParams collectionParams,
                                              PreprocessingOptions preprocessingOptions,
                                              AnalysisAlgorithmConfig algorithmConfig) {
        return dataAnalysisProcessor.process(collectionParams, preprocessingOptions, algorithmConfig);
    }

}
