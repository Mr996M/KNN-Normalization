## KNN-Normalization
This resource repository stores java code to explore the influence of normalization on the accuracy of KNN classification algorithm. The datasets used for analysis come from the network, and the results data of the experimental test are recorded in the test.xlsx file. The script files in the MATLAB folder are used to draw visualizations to analyze the data.
### KNN
The java code in the KNN folder is the experimental code to implement the KNN classification algorithm, and the KNN package is the most original functional implementation code, which only supports the classification of Double type datasets and cannot identify strings, while the code in the KNN_String package can read the strings in the dataset and complete the type conversion of digital data from String type to Double type, and the code in the KNN_Normalization package implements normalization of the data in the dataset. The experiment mainly uses the code in KNN_String package and KNN_Normalization package to test the classification effect of three distance calculation methods under different k values, which is expressed by the classification error rate. The verification method is used to test the classification accuracy of KNN classification algorithm, that is, 90% of the data in the dataset is put into the train_data file in the package as the training sample, and 10% of the data is used as the test sample and classified by the algorithm, and then the error rate is calculated by comparing with the real classification in the test_data file. To read different data sets, we need to change the relevant code statement according to the separator of each row in the dataset, changing the parameter of the split function as shown in the following figure:
![图片](https://github.com/Mr996M/KNN-Normalization/assets/126217198/5600331f-f9f4-43ad-b9bd-7b49073c2a2e)     
The running process of the java code in the KNN folder is to enter a k value first, and then there will be an input prompt on the console to select the distance calculation method. Input the corresponding characters according to the prompt to select one method, and the classification result and calculation error rate will be returned after the press of Enter. The console status is shown in the following figures:
![图片](https://github.com/Mr996M/KNN-Normalization/assets/126217198/4489124e-10a7-46cb-a4ea-fb3498433ea7)
![图片](https://github.com/Mr996M/KNN-Normalization/assets/126217198/d97b964d-bb55-4faf-a7b9-0fe911abbf19)
### Copy of KNN

### MATLAB
Each .m file in the MATLAB folder is the image drawing of the data in the test.xlsx file in the KNN-normalization directory, which is used to analyze the effect of KNN classification algorithm using three distances to calculate, and horizontally compares the relationship between the error rates calculated by different distance formulas. The effect of whether the data set is normalized or not on the error rate is compared longitudinally. The scatter line chart of the function of the error rate and k value change and the fitting curve of part of the interval are plotted in each file.
### datingTestSet.txt
This file is the dataset of Helen's dating case, and you can download it from https://download.csdn.net/download/weixin_38570459/16203592?utm_medium=notify.im.downloadSource.20230810.a&username=qq_53467315 in China Software Developer Network. The first three columns of data in the file represent the classification features，and the last column of data represents the classification. Classification features as well as classification are separated by "\t", and the values of the classification features in each column differ greatly. Therefore, this dataset is a good choice for studying normalization.
### datingTestSet2.txt
This file stores the remainder of the datingTestSet.txt file without the lines classified as didntLike, and the results data for classifying the dataset in datingTestSet2.txt file is recorded in Sheet2 of the test.xlsx file.
### fruit_data.txt
You can download this file from https://download.csdn.net/download/u012965373/11875201?utm_medium=notify.im.downloadSource.20230810.a&username=qq_53467315 in China Software Developer Network. This is a simple classification dataset, and there is little difference in the values of the classification features. The classification features and classification of this dataset are separated by ",".
