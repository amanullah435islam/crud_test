
Customexception Use :

Controller
   │
   │ Exception হলে
   ▼
GlobalExceptionHandler
   │
   ▼
Common Error Response



Using Swagger/OpenAPI & data show:
http://localhost:8080/v3/api-docs


*. This link are click that open browser all api show
http://localhost:8080/swagger-ui/index.html



process: 

POST /api/auth/login       (use postman)

Request:

{
    "email":"aman@gmail.com",
    "password":"123456"
}

Response:

{
    "accessToken":"eyJhbGciOiJIUzI1NiJ9..."
}

Copy only the token:

eyJhbGciOiJIUzI1NiJ9...



*. again after commit try
Request URL
http://localhost:8080/

its main url but it not work that now. it solve than after commit






Our learning plan from here

I suggest we continue in this order:

Step	            Topic	                                    Status

1	            Swagger/OpenAPI basics	                        ✅ Done

2	            Swagger + JWT Authorize button	                Next

3	            DTO documentation with @Schema	                Next

4	            Global Exception Handling	                    Next

5	            Validation (@Valid, @NotBlank, etc.)	        Next

6	            Refresh Token	                                Next

7	            Unit Testing (JUnit & Mockito)	                Next

8	            Docker	                                        Next

9	            Redis	                                        Next

10	            GitHub Actions (CI/CD)	                        Next

11	            AWS Deployment	                                Final



