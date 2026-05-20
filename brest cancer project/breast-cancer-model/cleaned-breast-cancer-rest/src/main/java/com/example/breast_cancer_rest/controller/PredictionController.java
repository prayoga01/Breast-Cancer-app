// PredictionController.java
package com.example.breast_cancer_rest.controller;

import com.example.breast_cancer_rest.model.InputData;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import java.io.InputStream;
import java.io.ObjectInputStream;
import weka.classifiers.Classifier;

@RestController
@RequestMapping("/api/prediction")
@CrossOrigin(origins = "*")
public class PredictionController {

    private Classifier model;
    private Instances dataStructure;

    public PredictionController() {
        try {
            // Load model
            InputStream modelStream = getClass().getClassLoader().getResourceAsStream("breastcancer.model");
            ObjectInputStream ois = new ObjectInputStream(modelStream);
            model = (Classifier) ois.readObject();
            ois.close();

            // Load ARFF structure (no data, just structure)
            InputStream arffStream = getClass().getClassLoader().getResourceAsStream("dataset-breastcancer.arff");
            DataSource source = new DataSource(arffStream);
            dataStructure = source.getStructure();
            dataStructure.setClassIndex(0); // 16 = "Resiko Kanker"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/predict")
    public ResponseEntity<Map<String, Object>> predict(@RequestBody InputData inputData) {
        try {
            // Validate input data
            if (inputData == null) {
                return ResponseEntity.badRequest()
                    .body(createErrorResponse("Input data is required"));
            }

            if (inputData.getBenjolanDiPayudara() == null || inputData.getBenjolanDiPayudara().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(createErrorResponse("Benjolan di Payudara is required"));
            }

            String[] features = convertInputToFeatures(inputData);
            double[] confidenceOut = new double[1];
            String predictionResult = performPrediction(features, confidenceOut);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("prediction", predictionResult);
            response.put("confidence", confidenceOut[0]);
            response.put("timestamp", System.currentTimeMillis());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("Error in prediction: " + e.getMessage());
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(createErrorResponse("Internal server error: " + e.getMessage()));
        }
    }

    private String[] convertInputToFeatures(InputData inputData) {
        return new String[] {
            "0", // No.
            "0", // No.RM
            inputData.getFaktorRisiko(),
            inputData.getBenjolanDiPayudara(),
            inputData.getKecepatanTumbuh(),
            inputData.getNippleDischarge(),
            inputData.getRetraksiPutingSusu(),
            inputData.getKrusta(),
            inputData.getDimpling(),
            inputData.getPeauDOrange(),
            inputData.getUlserasi(),
            inputData.getVenektasi(),
            inputData.getBenjolanKetiak(),
            inputData.getEdemaLengan(),
            inputData.getNyeriTulang(),
            inputData.getSesak()
        };
    }

    private String performPrediction(String[] features, double[] confidenceOut) {
        try {
            Instance instance = new weka.core.DenseInstance(dataStructure.numAttributes());
            instance.setDataset(dataStructure);

            for (int i = 0; i < features.length; i++) {
                if (i == 0 || i == 1) { // No. dan No.RM numerik
                    instance.setValue(i, Double.parseDouble(features[i]));
                } else {
                    instance.setValue(i, features[i]);
                }
            }

            // Predict Resiko Kanker
            dataStructure.setClassIndex(16);
            double result = model.classifyInstance(instance);
            String prediction = dataStructure.classAttribute().value((int) result);

            double[] distribution = model.distributionForInstance(instance);
            confidenceOut[0] = distribution[(int) result];

            return prediction;
        } catch (Exception e) {
            e.printStackTrace();
            return "prediction error";
        }
    }

    private Map<String, Object> createErrorResponse(String message) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", "error");
        error.put("message", message);
        error.put("timestamp", System.currentTimeMillis());
        return error;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "healthy");
        response.put("service", "breast-cancer-prediction");
        return ResponseEntity.ok(response);
    }
}
