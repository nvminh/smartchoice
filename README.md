# Compile and run

## Compile all the project:

Change dir to root folder of the project and run the following command:

`mvn clean install`

## Compile and start the prices-service:

Change dir to prices-service subfolder and run the following command:

`mvn compile exec:java -Dexec.mainClass=com.smartchoice.prices.PricesApplication`

## Compile and start the product-service:

`mvn compile exec:java -Dexec.mainClass=com.smartchoice.product.ProductApplication`

# Project structure
