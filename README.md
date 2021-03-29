# TEST_Task

Task1 Description palindrom

0. Create MySQL Database named ==palindrom==   
   take sql from 01_DATABASE_MYSQL   folder
2. Start Service Registry - Eurica - port 8088
http://localhost:8088/
2. Start Service 1

EndPoint ===genString====  - will generate new String and Save it in ---JSONString.json---   file
http://localhost:8085/genString

EndPoint ===readString===  - read String from  ---JSONString.json---   file
http://localhost:8085/readString 


3. Start Service 2 

EndPoint ===palindrom====  - take all palindroms from Database
http://localhost:8086/palindrom

EndPoint ===palindrom/currentpalindrom====  - receive palindrom from Service1 and save it in  Database
http://localhost:8086/palindrom/currentpalindrom

EndPoint ===palindrom/longestpalindrom====  -get longest palindrom from  Database
http://localhost:8086/palindrom/longestpalindrom




