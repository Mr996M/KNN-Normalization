## KNN-Normalization
This resource repository stores java code to explore the influence of normalization on the accuracy of KNN classification algorithm. The datasets used for analysis come from the network, and the results data of the experimental test are recorded in the test.xlsx file. The script files in the MATLAB folder are used to draw visualizations to analyze the data.
### KNN
The java code in the KNN folder is the experimental code to implement the KNN classification algorithm, and the KNN package is the most original functional implementation code, which only supports the classification of Double type datasets and cannot identify strings, while the code in the KNN_String package can read the strings in the dataset and complete the type conversion of digital data from String type to Double type, and the code in the KNN_Normalization package implements normalization of the data in the dataset.
### Copy of KNN

### MATLAB
Each .m file in the MATLAB folder is the image drawing of the data in the test.xlsx file in the KNN-normalization directory, which is used to analyze the effect of KNN classification algorithm using three distances to calculate, and horizontally compares the relationship between the error rates calculated by different distance formulas. The effect of whether the data set is normalized or not on the error rate is compared longitudinally. The scatter line chart of the function of the error rate and k value change and the fitting curve of part of the interval are plotted in each file.
