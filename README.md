# Compile and run

## Compile all the project:

Change dir to root folder of the project and run the following command:

`mvn clean install`

## Compile and run the prices-service:

Change dir to prices-service subfolder and run the following command:

`mvn compile exec:java -Dspring.profiles.active=dev -Dexec.mainClass=com.smartchoice.prices.PricesApplication`

## Compile and run the product-service:

Change dir to product-service subfolder and run the following command:

`mvn compile exec:java -Dspring.profiles.active=dev -Dexec.mainClass=com.smartchoice.product.ProductApplication`

## Compile and run the audit-logs-consumer-service:

Change dir to audit-logs-consumer-service subfolder and run the following command:

`mvn compile exec:java -Dspring.profiles.active=dev -Dexec.mainClass=com.smartchoice.consumer.AuditLogsConsumerApplication`

# Project structure

# Test samples

Add products:

`curl -X POST "http://localhost:8080/api/admin/products/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"images\": [ \"https://cdn.tgdd.vn/Products/Images/42/225380/iphone-mini-do-new-600x600-600x600.jpg\", \"https://cdn.tgdd.vn/Products/Images/42/225380/iphone-mini-trang-new-600x600-200x200.jpg\" ], \"name\": \"iPhone 12 mini 64GB\"}"`

`curl -X POST "http://localhost:8080/api/admin/products/" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"images\": [ \"https://cdn.tgdd.vn/Products/Images/42/226099/samsung-galaxy-z-fold-2-vang-dong-200x200.jpg\", \"https://cdn.tgdd.vn/Products/Images/42/226099/samsung-galaxy-z-fold-2-den-200x200.jpg\" ], \"name\": \"Samsung Galaxy Z Fold2 5G\"}"`

Search products:

`curl -X POST "http://localhost:8080/api/products/search" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"productName\": \"iphone\"}"`

Get product details:

`curl -X GET "http://localhost:8080/api/products/1" -H "accept: */*"`

Get Prices (internal call from Product Service to Prices Service)

`curl -X GET "http://localhost:8081/api/prices?productId=1" -H "accept: */*"`

Get Audit Logs 

`curl -X GET "http://localhost:8082/api/logs" -H "accept: */*"`
