package org.example.designpatterns.facade;

import org.example.designpatterns.facade.models.*;
import org.example.designpatterns.facade.services.AnalysisAlgorithmService;
import org.example.designpatterns.facade.services.DataCollectionService;
import org.example.designpatterns.facade.services.DataPreprocessingService;
import org.example.designpatterns.facade.services.VisualizationService;

public class DataAnalysisProcessor {

    private DataCollectionService dataCollectionService;
    private DataPreprocessingService dataPreprocessingService;
    private AnalysisAlgorithmService analysisAlgorithmService;
    private VisualizationService visualizationService;

    public DataAnalysisProcessor(DataCollectionService dataCollectionService,
                                 DataPreprocessingService dataPreprocessingService,
                                 AnalysisAlgorithmService analysisAlgorithmService,
                                 VisualizationService visualizationService) {
        this.dataCollectionService = dataCollectionService;
        this.dataPreprocessingService = dataPreprocessingService;
        this.analysisAlgorithmService = analysisAlgorithmService;
        this.visualizationService = visualizationService;
    }

    public AnalysisResult process(DataCollectionParams collectionParams,
                                  PreprocessingOptions preprocessingOptions,
                                  AnalysisAlgorithmConfig algorithmConfig) {
        // Step 1: Collect data
        DataCollectionResult collectionResult = dataCollectionService.collectData(collectionParams);

        // Step 2: Preprocess data
        PreprocessedData preprocessedData = dataPreprocessingService.preprocessData(collectionResult.getData(), preprocessingOptions);

        // Step 3: Apply analysis algorithms
        AnalysisResult analysisResult = analysisAlgorithmService.applyAnalysisAlgorithms(preprocessedData, algorithmConfig);

        // Step 4: Visualize results
        visualizationService.visualizeResults(analysisResult);

        return analysisResult;
    }

}
