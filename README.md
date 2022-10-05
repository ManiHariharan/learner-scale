# Learner Scale - Purchase (Java Spring Boot)

SAVE
-----------
1) SAVE using PathVariable
* http://127.0.0.1:4444/api/purchase/save3/103/503/ABCD3/553
-----------
2) SAVE using RequestParam
* http://127.0.0.1:4444/api/purchase/save4?userId=104&courseId=504&title=ABCD4&price=554
-----------
3) SAVE using RequestParam with name attribute
* http://127.0.0.1:4444/api/purchase/save5?user_id=105&course_id=505&title=ABCD5&price=555

-----------
4) SAVE using RequestParam with name and default attribute
* http://127.0.0.1:4444/api/purchase/save6?user_id=106&course_id=506&title=ABCD6
* http://127.0.0.1:4444/api/purchase/save6?user_id=106&course_id=506&title=ABCD6&price=556
* http://127.0.0.1:4444/api/purchase/save6?user_id=106&course_id=506 - ERROR

----------------

GET - LOAD
-----------
1) GET using PathVariable
* http://127.0.0.1:4444/api/purchase/get1/104
-----------
2) GET using RequestParam
* http://127.0.0.1:4444/api/purchase/get2?userId=105
* http://127.0.0.1:4444/api/purchase/get3?user_id=105
-----------
