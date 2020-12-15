curl -i http://localhost:8080/success

curl -i --header "Content-Type: application/json" \
       --request POST \
       --data '{"username":"radoslaw","password":"majdan"}' \
       http://localhost:8080/login

curl -H "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJyYWRvc2xhdyIsImV4cCI6MTYwMjQ1NTQ4Mn0.KYg9PdkzfKtbUIX5uC5Bc5pfYh69xpN-Vkny2F6XsxlHtrX8eR7fgFxZc7odVpKW79HK8BhGrFhzAMuNUfuKyg" http://localhost:8080/success
